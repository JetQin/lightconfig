package com.callcenter.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;

import com.callcenter.domain.Province;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CommonService extends ActionSupport
{
    private static final int ZERO = 0;
    private final String GROUP = "GROUP";
    private final String PROVINCE = "PROVINCE";
    private final String NORTH = "N";
    private final String SOUTH = "S";

    private String REGION = "N";
    private String location = "";
    private boolean isShow = true;

    private String[] staticsHeader = new String[]
    {
    "阈值有效范围", "接通率告警", "接通率严重告警", "20S接通率告警", "20S接通率严重告警", "排队数", "外呼时长", "呼入时长", "案头时长", "放弃率"
    };
    private String[] countHeader = new String[]
    {
    "阈值有效范围", "话务接入量", "人工请求量", "人工服务量", "IVR报修业务量"
    };

    private ActionContext context = ActionContext.getContext();
    private ProvinceService provinceService;

    private List<Province> provinces;
    private List<Province> cities;

    public String configData()
    {
        HttpServletRequest request = (HttpServletRequest) context.get(ServletActionContext.HTTP_REQUEST);
        String region = request.getParameter("region");
        if ( null != region && !"".equals(region) )
        {
            setLocation(region);
            setShow(NORTH.equals(region) || SOUTH.equals(region));
            if ( NORTH.equals(region) || SOUTH.equals(region) )
            {
                setProvinces(getProvinceInfo(region));
            }
            else
            {
                setCities(getCityInfo());
            }
        }
        else
        {
            setProvinces(getProvinceInfo(REGION));
        }
        return SUCCESS;
    }

    private List<Province> getCityInfo()
    {
        List<Province> dataProvince = new ArrayList<Province>();
        getCityData(dataProvince,NORTH);
        getCityData(dataProvince,SOUTH);

        return dataProvince;
    }

    private void getCityData(List<Province> dataProvince,String region)
    {
        List<Province> groupProvince = provinceService.getListGroups(region, "GROUP");
        Map<String, Province> singleProvince = provinceService.getMapGroups(region, "PROVINCE");
        Map<String, Province> cityProvince = provinceService.getMapGroups(region, "CITY");

        for ( Province province : groupProvince )
        {
            Province temp = province;
            dataProvince.add(temp);

            String children = temp.getChildren();
            if ( null != children && !"".equals(children) )
            {
                String[] childProvince = children.split(" ");
                
                for ( String child : childProvince )
                {
                    if(null!=child && !"".equals(child))
                    {
                        dataProvince.add(singleProvince.get(child));
                        dataProvince.addAll(parseProvince(singleProvince.get(child),cityProvince));
                    }
                }
            }
        }
    }
    
    private List<Province> parseProvince(Province province, Map<String, Province> map)
    {
        List<Province> data = new ArrayList<Province>();
        if ( null != province )
        {
            String children = province.getChildren();
            if ( null != children && !"".equals(children) )
            {
                for ( String child : children.split(" ") )
                {
                    if ( null != map.get(child) )
                    {
                        data.add(map.get(child));
                        map.remove(child);
                    }
                }
            }
        }
        return data;
    }

    private List<Province> getProvinceInfo(String region)
    {
        List<Province> dataProvince = new ArrayList<Province>();
        List<Province> groupProvince = provinceService.getListGroups(region, GROUP);
        Map<String, Province> singleProvince = provinceService.getMapGroups(region, PROVINCE);
        if ( null != groupProvince && groupProvince.size() > ZERO )
        {
            for ( Province province : groupProvince )
            {
                dataProvince.add(province);
                if ( null != province.getChildren() && !"".equals(province.getChildren()) )
                {
                    String[] children = province.getChildren().split(" ");
                    for ( String child : children )
                    {
                        if ( null != singleProvince && singleProvince.size() > 0 )
                        {
                            dataProvince.add(singleProvince.get(child));
                            singleProvince.remove(child);
                        }
                    }
                }

            }
        }
        if ( null != singleProvince && singleProvince.size() > ZERO )
        {
            Iterator iterator = singleProvince.keySet().iterator();
            while ( iterator.hasNext() )
            {
                @SuppressWarnings("unchecked")
                Map.Entry<String, Province> map = (Entry<String, Province>) iterator.next();
                Province value = map.getValue();
                dataProvince.add(value);
            }
        }
        return dataProvince;
    }

    public String saveProvinceData()
    {

        HttpServletRequest request = (HttpServletRequest) context.get(ServletActionContext.HTTP_REQUEST);
        String name = request.getParameter("pk");
        String attribute = request.getParameter("name");
        double value = 0.0;
        if ( null != request.getParameter("value") )
        {
            value = Double.valueOf(request.getParameter("value"));
        }

        if ( null != name && null != attribute )
        {
            provinceService.saveData(name, attribute, value);
        }
        return SUCCESS;
    }

    public String saveCityData()
    {

        HttpServletRequest request = (HttpServletRequest) context.get(ServletActionContext.HTTP_REQUEST);
        String name = request.getParameter("pk");
        String attribute = request.getParameter("name");
        double value = 0.0;
        if ( null != request.getParameter("value") )
        {
            value = Double.valueOf(request.getParameter("value"));
        }

        if ( null != name && null != attribute )
        {
//            cityService.saveData(name, attribute, value);
        }
        return SUCCESS;
    }

    @JSON(serialize = false)
    public void setProvinceService(ProvinceService provinceService)
    {
        this.provinceService = provinceService;
    }

    @JSON(serialize = false)
    public ProvinceService getProvinceService()
    {
        return provinceService;
    }


    @JSON(serialize = false)
    public List<Province> getProvinces()
    {
        return provinces;
    }

    @JSON(serialize = false)
    public void setProvinces(List<Province> provinces)
    {
        this.provinces = provinces;
    }

    @JSON(serialize = false)
    public List<Province> getCities()
    {
        return cities;
    }

    public void setCities(List<Province> cities)
    {
        this.cities = cities;
    }

    public String[] getStaticsHeader()
    {
        return staticsHeader;
    }

    public String[] getCountHeader()
    {
        return countHeader;
    }

    public boolean isShow()
    {
        return isShow;
    }

    public void setShow(boolean isShow)
    {
        this.isShow = isShow;
    }

    @JSON(serialize = false)
    public void setLocation(String local)
    {
        location = local;
    }

    @JSON(serialize = false)
    public String getLocation()
    {
        return location;
    }
}
