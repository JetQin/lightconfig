package com.callcenter.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;

import com.callcenter.domain.Province;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class SettingService extends ActionSupport
{

    private ActionContext context = ActionContext.getContext();
    private final String GROUP = "GROUP";
    private final String PROVINCE = "PROVINCE";
    private final String CITY = "CITY";

    private ProvinceService provinceService;
    private List<Province> provinces;
    private String operation;
    private final static int ZERO = 0;

    public String setting()
    {
        setProvinces(provinceService.getGroups());
        return SUCCESS;
    }

    public String saveSetting()
    {

        HttpServletRequest request = (HttpServletRequest) context.get(ServletActionContext.HTTP_REQUEST);

        String region = request.getParameter("region");
        String groupProvince = request.getParameter("group");
        String provinceName = request.getParameter("province");
        String cities = request.getParameter("cityName");

        // saveProvince(groupProvince, provinceName, region);
        // saveCity(provinceName, cities);
        Province province = null;
        if ( null != groupProvince && !"".endsWith(groupProvince) )
        {
            if ( null == provinceService.getProvinceInfo(groupProvince) )
            {
                province = new Province();
                province.setProvinceName(groupProvince);
                province.setChildren(provinceName);
                province.setRegion(region);
                province.setType(GROUP);
                provinceService.saveProvince(province);
                province = null;
            }
        }

        if ( null != provinceName && !"".endsWith(provinceName) )
        {
            if ( null == provinceService.getProvinceInfo(provinceName) )
            {
                province = new Province();
                province.setProvinceName(provinceName);
                province.setChildren(cities);
                province.setRegion(region);
                province.setType(PROVINCE);
                provinceService.saveProvince(province);
                province = null;
            }
        }

        if ( null != cities && !"".equals(cities) )
        {
            for ( String str : cities.split(" ") )
            {
                if ( null == provinceService.getProvinceInfo(str) )
                {
                    province = new Province();
                    province.setProvinceName(str);
                    province.setRegion(region);
                    province.setType(CITY);
                    provinceService.saveProvince(province);
                    province = null;
                }
            }
        }

        setOperation("操作成功!");

        return SUCCESS;
    }

    private void saveProvince(String group, String provinceNames, String region)
    {
        if ( null != group && !"".equals(group) )
        {
            Province province = new Province();
            province.setProvinceName(group);
            province.setChildren(provinceNames);
            province.setRegion(region);
            province.setType(GROUP);
            provinceService.saveProvince(province);
        }
        if ( null != provinceNames && !"".equals(provinceNames) )
        {
            Province province = new Province();
            String[] names = provinceNames.split(" ");
            for ( String name : names )
            {
                province = new Province();
                province.setProvinceName(name);
                province.setRegion(region);
                province.setType(PROVINCE);
                provinceService.saveProvince(province);
            }
        }
    }

    private void saveCity(String provinceName, String cities)
    {
        Province province = null;
        String[] cityName = null;
        if ( null != cities && !"".equals(cities) )
        {
            cityName = cities.split(" ");
        }

        if ( null != provinceName && !"".equals(provinceName) )
        {
            province = provinceService.getProvinceInfo(provinceName);
            if ( null == province )
            {
                province = new Province();
                province.setProvinceName(provinceName);
            }
        }
        if ( null != cityName && cityName.length > ZERO )
        {
            for ( String name : cityName )
            {
                if ( null != name && !"".equals(name) )
                {
//                    City city = new City();
//                    city.setCityName(name);
//                    city.setProvince(province);
//                    cityService.saveCity(city);
                }
            }
        }
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
    public ProvinceService getProvinceService()
    {
        return provinceService;
    }

    @JSON(serialize = false)
    public void setProvinceService(ProvinceService provinceService)
    {
        this.provinceService = provinceService;
    }

    @JSON(serialize = false)
    public void setOperation(String operation)
    {
        this.operation = operation;
    }

    public String getOperation()
    {
        return operation;
    }

}
