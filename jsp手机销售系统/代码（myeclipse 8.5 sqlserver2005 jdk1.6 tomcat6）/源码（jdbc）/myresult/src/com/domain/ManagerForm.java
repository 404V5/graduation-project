

package com.domain;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.*;

public class ManagerForm extends ActionForm
{

    private String account;
    private Integer id;
    private String name;
    private String password;
    private Integer sigh;

    public ManagerForm()
    {
        account = "";
        id = Integer.valueOf("-1");
        name = "";
        password = "";
        sigh = Integer.valueOf("-1");
    }

    public String getAccount()
    {
        return account;
    }

    public void setAccount(String account)
    {
        this.account = account;
    }

    public void setSigh(Integer sigh)
    {
        this.sigh = sigh;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Integer getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public String getPassword()
    {
        return password;
    }

    public Integer getSigh()
    {
        return sigh;
    }

    public ActionErrors validate(ActionMapping actionMapping, HttpServletRequest httpServletRequest)
    {
        return null;
    }

    public void reset(ActionMapping actionmapping, HttpServletRequest httpservletrequest)
    {
    }
}
