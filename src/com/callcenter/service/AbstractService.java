package com.callcenter.service;

import org.hibernate.SessionFactory;

public abstract class AbstractService
{
    protected SessionFactory sessionFactory;
    protected static final int ZERO = 0;
    
    public void setSessionFactory(SessionFactory sessionFactory)
    {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory()
    {
        return sessionFactory;
    }
}
