
package com.domain;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.*;

public class AfficheForm extends ActionForm
{

    private String content;
    private Integer id;
    private String issueTime;
    private String name;

    public AfficheForm()
    {
        content = "";
        id = new Integer(-1);
        issueTime = "";
        name = "";
    }

    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setIssueTime(String issueTime)
    {
        this.issueTime = issueTime;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Integer getId()
    {
        return id;
    }

    public String getIssueTime()
    {
        return issueTime;
    }

    public String getName()
    {
        return name;
    }

    public ActionErrors validate(ActionMapping actionMapping, HttpServletRequest httpServletRequest)
    {
        return null;
    }

    public void reset(ActionMapping actionmapping, HttpServletRequest httpservletrequest)
    {
    }
}
