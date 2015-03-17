

package com.domain;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.*;

public class SmallTypeForm extends ActionForm
{

    private Integer bigId;
    private String creaTime;
    private Integer id;
    private String smallName;

    public SmallTypeForm()
    {
        bigId = Integer.valueOf("-1");
        creaTime = "";
        id = Integer.valueOf("-1");
        smallName = "";
    }

    public Integer getBigId()
    {
        return bigId;
    }

    public void setBigId(Integer bigId)
    {
        this.bigId = bigId;
    }

    public void setSmallName(String smallName)
    {
        this.smallName = smallName;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public void setCreaTime(String creaTime)
    {
        this.creaTime = creaTime;
    }

    public String getCreaTime()
    {
        return creaTime;
    }

    public Integer getId()
    {
        return id;
    }

    public String getSmallName()
    {
        return smallName;
    }

    public ActionErrors validate(ActionMapping actionMapping, HttpServletRequest httpServletRequest)
    {
        return null;
    }

    public void reset(ActionMapping actionmapping, HttpServletRequest httpservletrequest)
    {
    }
}
