package com.callcenter.domain;

import java.util.List;

public class Province
{

    private int provinceID;
    private String provinceName;
    private String provinceDescp;
    private String region;
    private String type;
    private String children;
    private double connectAlarmRate;
    private double connectErrorRate;
    private double connectShortAlarmRate;
    private double connectShortErrorRate;
    private double queueNo;
    private double outboundTime;
    private double inboundTime;
    private double desktopTime;
    private double abandonRate;
    private double inboundNo;
    private double requestNo;
    private double serviceNo;
    private double ivrFixNo;

    public int getProvinceID()
    {
        return provinceID;
    }

    public void setProvinceID(int provinceID)
    {
        this.provinceID = provinceID;
    }

    public String getProvinceName()
    {
        return provinceName;
    }

    public void setProvinceName(String provinceName)
    {
        this.provinceName = provinceName;
    }

    public String getProvinceDescp()
    {
        return provinceDescp;
    }

    public void setProvinceDescp(String provinceDescp)
    {
        this.provinceDescp = provinceDescp;
    }

    public double getConnectAlarmRate()
    {
        return connectAlarmRate;
    }

    public void setConnectAlarmRate(double connectAlarmRate)
    {
        this.connectAlarmRate = connectAlarmRate;
    }

    public double getConnectErrorRate()
    {
        return connectErrorRate;
    }

    public void setConnectErrorRate(double connectErrorRate)
    {
        this.connectErrorRate = connectErrorRate;
    }

    public double getConnectShortAlarmRate()
    {
        return connectShortAlarmRate;
    }

    public void setConnectShortAlarmRate(double connectShortAlarmRate)
    {
        this.connectShortAlarmRate = connectShortAlarmRate;
    }

    public double getConnectShortErrorRate()
    {
        return connectShortErrorRate;
    }

    public void setConnectShortErrorRate(double connectShortErrorRate)
    {
        this.connectShortErrorRate = connectShortErrorRate;
    }

    public double getQueueNo()
    {
        return queueNo;
    }

    public void setQueueNo(double queueNo)
    {
        this.queueNo = queueNo;
    }

    public double getOutboundTime()
    {
        return outboundTime;
    }

    public void setOutboundTime(double outboundTime)
    {
        this.outboundTime = outboundTime;
    }

    public double getInboundTime()
    {
        return inboundTime;
    }

    public void setInboundTime(double inboundTime)
    {
        this.inboundTime = inboundTime;
    }

    public double getDesktopTime()
    {
        return desktopTime;
    }

    public void setDesktopTime(double desktopTime)
    {
        this.desktopTime = desktopTime;
    }

    public double getAbandonRate()
    {
        return abandonRate;
    }

    public void setAbandonRate(double abandonRate)
    {
        this.abandonRate = abandonRate;
    }

    public void setRegion(String region)
    {
        this.region = region;
    }

    public String getRegion()
    {
        return region;
    }

    public String getChildren()
    {
        return children;
    }

    public void setChildren(String children)
    {
        this.children = children;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public double getInboundNo()
    {
        return inboundNo;
    }

    public void setInboundNo(double inboundNo)
    {
        this.inboundNo = inboundNo;
    }

    public double getRequestNo()
    {
        return requestNo;
    }

    public void setRequestNo(double requestNo)
    {
        this.requestNo = requestNo;
    }

    public double getServiceNo()
    {
        return serviceNo;
    }

    public void setServiceNo(double serviceNo)
    {
        this.serviceNo = serviceNo;
    }

    public double getIvrFixNo()
    {
        return ivrFixNo;
    }

    public void setIvrFixNo(double ivrFixNo)
    {
        this.ivrFixNo = ivrFixNo;
    }

    public void parseData(String attr, double value)
    {
        if ( "connectAlarmRate".equals(attr) )
        {
            setConnectAlarmRate(value);
        }
        if ( "connectErrorRate".equals(attr) )
        {
            setConnectErrorRate(value);
        }
        if ( "connectShortAlarmRate".equals(attr) )
        {
            setConnectShortAlarmRate(value);
        }
        if ( "connectShortErrorRate".equals(attr) )
        {
            setConnectShortErrorRate(value);
        }
        if ( "queueNo".equals(attr) )
        {
            setQueueNo(value);
        }
        if ( "outboundTime".equals(attr) )
        {
            setOutboundTime(value);
        }
        if ( "inboundTime".equals(attr) )
        {
            setInboundTime(value);
        }
        if ( "desktopTime".equals(attr) )
        {
            setDesktopTime(value);
        }
        if ( "abandonRate".equals(attr) )
        {
            setAbandonRate(value);
        }
        if ( "inboundNo".equals(attr) )
        {
            setInboundNo(value);
        }
        if ( "requestNo".equals(attr) )
        {
            setRequestNo(value);
        }
        if ( "serviceNo".equals(attr) )
        {
            setServiceNo(value);
        }
        if ( "ivrFixNo".equals(attr) )
        {
            setIvrFixNo(value);
        }
    }

    @Override
    public String toString()
    {
        return provinceName;
    }

}
