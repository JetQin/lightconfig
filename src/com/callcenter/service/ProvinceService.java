package com.callcenter.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.callcenter.domain.Province;

public class ProvinceService extends AbstractService
{
    private final String Location = "N";
    private final String TYPE = "GROUP";

    public void saveData(String name, String attribute, double value)
    {
        Session session = null;
        Transaction tx = null;
        try
        {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            Query query = session.createQuery("from Province where provinceName = :name");
            query.setString("name", name);
            if ( null != query && null != query.list() && query.list().size() > ZERO )
            {
                Province province = (Province) query.list().get(ZERO);
                province.parseData(attribute, value);
                session.update(province);
            }
        }
        catch ( HibernateException e )
        {
            if ( tx != null )
            {
                tx = null;
            }
            e.printStackTrace();
        }
        finally
        {
            tx.commit();
            session.close();
        }
    }

    public void saveProvince(Province province)
    {
        Session session = null;
        Transaction tx = null;
        try
        {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            session.save(province);
        }
        catch ( HibernateException e )
        {
            if ( tx != null )
            {
                tx = null;
            }
            e.printStackTrace();
        }
        finally
        {
            tx.commit();
            session.close();
        }
    }

    public Province getProvinceInfo(String name)
    {
        Session session = null;
        Transaction tx = null;
        try
        {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            Query query = session.createQuery("from Province where provinceName = :name");
            query.setString("name", name);
            if ( null != query && null != query.list() && query.list().size() > ZERO )
            {
                return (Province) query.list().get(ZERO);
            }
            else
            {
                return null;
            }

        }
        catch ( HibernateException e )
        {
            if ( tx != null )
            {
                tx = null;
            }
            e.printStackTrace();
            return null;
        }
        finally
        {
            tx.commit();
            session.close();
        }
    }

    public Map<String, Province> getAllProvince( )
    {
        Map<String, Province> provinceMap = new HashMap<String, Province>();
        Session session = null;
        Transaction tx = null;
        try
        {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            Query query = session.createQuery("from Province");
            if ( null != query && null != query.list() && query.list().size() > ZERO )
            {
                for ( Object data : query.list() )
                {
                    Province province = (Province) data;
                    provinceMap.put(province.getProvinceName(), province);
                }
                return provinceMap;
            }
            else
            {
                return null;
            }

        }
        catch ( HibernateException e )
        {
            if ( tx != null )
            {
                tx = null;
            }
            e.printStackTrace();
            return null;
        }
        finally
        {
            tx.commit();
            session.close();
        }
    }
    
    public Map<String, Province> getMapGroups(String region, String type)
    {
        Map<String, Province> provinceMap = new HashMap<String, Province>();
        Session session = null;
        Transaction tx = null;
        try
        {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            Query query = session.createQuery("from Province where region = :region and type = :type");
            if ( null != region && !"".equals(region) )
            {
                query.setString("region", region);
            }
            else
            {
                query.setString("region", Location);
            }
            if ( null != type && !"".equals(type) )
            {
                query.setString("type", type);
            }
            else
            {
                query.setString("type", TYPE);
            }
            
            if ( null != query && null != query.list() && query.list().size() > ZERO )
            {
                for ( Object data : query.list() )
                {
                    Province province = (Province) data;
                    provinceMap.put(province.getProvinceName(), province);
                }
                return provinceMap;
            }
            else
            {
                return null;
            }
            
        }
        catch ( HibernateException e )
        {
            if ( tx != null )
            {
                tx = null;
            }
            e.printStackTrace();
            return null;
        }
        finally
        {
            tx.commit();
            session.close();
        }
    }

    public List<Province> getListGroups(String region, String type)
    {
        List<Province> Infos = new ArrayList<Province>();
        Session session = null;
        Transaction tx = null;
        try
        {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            Query query = session.createQuery("from Province where region = :region and type = :type");
            if ( null != region && !"".equals(region) )
            {
                query.setString("region", region);
            }
            else
            {
                query.setString("region", Location);
            }
            if ( null != type && !"".equals(type) )
            {
                query.setString("type", type);
            }
            else
            {
                query.setString("type", TYPE);
            }
            if ( null != query && null != query.list() && query.list().size() > ZERO )
            {
                Infos = query.list();
                return Infos;
            }
            else
            {
                return null;
            }

        }
        catch ( HibernateException e )
        {
            if ( tx != null )
            {
                tx = null;
            }
            e.printStackTrace();
            return null;
        }
        finally
        {
            tx.commit();
            session.close();
        }
    }

    public List<Province> getGroups()
    {
        List<Province> Infos = new ArrayList<Province>();
        Session session = null;
        Transaction tx = null;
        try
        {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            Query query = session.createQuery("from Province");
            return query.list();

        }
        catch ( HibernateException e )
        {
            if ( tx != null )
            {
                tx = null;
            }
            e.printStackTrace();
            return null;
        }
        finally
        {
            tx.commit();
            session.close();
        }
    }
}
