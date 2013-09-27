package com.callcenter.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import junit.framework.TestCase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.callcenter.domain.Province;

public class testService extends TestCase
{
    ApplicationContext ctx = null;
    ProvinceService service = null;
//    CityService cityService = null;

    @Override
    protected void setUp() throws Exception
    {
        ctx = new ClassPathXmlApplicationContext("beans.xml");
        service = (ProvinceService) ctx.getBean("provinceService");
//        cityService = (CityService) ctx.getBean("cityService");
    }

    public void testSaveCity()
    {
        Province province = new Province();
        province.setProvinceName("湖北");

//        City city = new City();
//        city.setCityName("襄樊");
//        city.setProvince(province);

//        cityService.saveCity(city);

    }

    public void testSaveProvince()
    {
        String custom = "客服一部";
        String p = "湖北";
        String cities = "武汉 武昌";

        Province province = new Province();
        province.setProvinceName(custom);
        province.setChildren(p);
        province.setRegion("N");
        province.setType("GROUP");
        service.saveProvince(province);

        province = new Province();
        province.setProvinceName(p);
        province.setChildren(cities);
        province.setRegion("N");
        province.setType("PROVINCE");
        service.saveProvince(province);

        for ( String str : cities.split(" ") )
        {
            province = new Province();
            province.setProvinceName(str);
            province.setRegion("N");
            province.setType("CITY");
            service.saveProvince(province);
        }
    }

    public void testGetProvince()
    {
        List<Province> dataProvince = new ArrayList<Province>();
        List<Province> groupProvince = service.getListGroups("N", "GROUP");
        Map<String, Province> singleProvince = service.getMapGroups("N", "PROVINCE");

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
        Iterator iterator = singleProvince.keySet().iterator();
        while ( iterator.hasNext() )
        {
            System.out.println("Hello");
            Map.Entry<String, Province> map = (Entry<String, Province>) iterator.next();
            Object key = map.getKey();
            Province value = map.getValue();
            dataProvince.add(value);
        }

        for ( Province province : dataProvince )
        {
            System.out.println(province);
        }
    }

    public void testGetCity()
    {
        List<Province> dataProvince = new ArrayList<Province>();
        List<Province> groupProvince = service.getListGroups("N", "GROUP");
        Map<String, Province> singleProvince = service.getMapGroups("N", "PROVINCE");
        Map<String, Province> cityProvince = service.getMapGroups("N", "CITY");

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

        for ( Province province : dataProvince )
        {
            System.out.println(province);
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

    public void testProvince()
    {

        // for ( Province province : service.getGroups("N", "YES") )
        // {
        // System.out.println(province.getProvinceName());
        // }

    }
}
