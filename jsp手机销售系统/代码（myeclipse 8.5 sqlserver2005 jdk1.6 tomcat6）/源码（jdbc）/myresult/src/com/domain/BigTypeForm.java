

package com.domain;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.*;

public class BigTypeForm extends ActionForm
{

    private String bigName;
    private String creaTime;
    private Integer id;

    public BigTypeForm()
    {
        bigName = "";
        creaTime = "";
        id = Integer.valueOf("-1");
    }

    public String getBigName()
    {
        return bigName;
    }

    public void setBigName(String bigName)
    {
        this.bigName = bigName;
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

    public ActionErrors validate(ActionMapping actionMapping, HttpServletRequest httpServletRequest)
    {
        return null;
    }

    public void reset(ActionMapping actionmapping, HttpServletRequest httpservletrequest)
    {
    }
}
