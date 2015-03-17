

package com.domain;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.*;

public class LinkForm extends ActionForm
{

    private Integer id;
    private String linkAddress;
    private String linkName;
    private String linkPicture;
    private String linkTime;

    public LinkForm()
    {
        id = Integer.valueOf("-1");
        linkAddress = "";
        linkName = "";
        linkPicture = "";
        linkTime = "";
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public void setLinkTime(String linkTime)
    {
        this.linkTime = linkTime;
    }

    public void setLinkPicture(String linkPicture)
    {
        this.linkPicture = linkPicture;
    }

    public void setLinkName(String linkName)
    {
        this.linkName = linkName;
    }

    public void setLinkAddress(String linkAddress)
    {
        this.linkAddress = linkAddress;
    }

    public String getLinkAddress()
    {
        return linkAddress;
    }

    public String getLinkName()
    {
        return linkName;
    }

    public String getLinkPicture()
    {
        return linkPicture;
    }

    public String getLinkTime()
    {
        return linkTime;
    }

    public ActionErrors validate(ActionMapping actionMapping, HttpServletRequest httpServletRequest)
    {
        return null;
    }

    public void reset(ActionMapping actionmapping, HttpServletRequest httpservletrequest)
    {
    }
}
