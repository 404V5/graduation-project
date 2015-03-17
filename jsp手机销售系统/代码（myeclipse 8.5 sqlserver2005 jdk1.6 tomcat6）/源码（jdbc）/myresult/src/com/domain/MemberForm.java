

package com.domain;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.*;

public class MemberForm extends ActionForm
{

    private Integer age;
    private String email;
    private Integer id;
    private String name;
    private String password;
    private String profession;
    private String question;
    private String reallyName;
    private String result;

    public MemberForm()
    {
        age = Integer.valueOf("-1");
        email = "";
        id = Integer.valueOf("-1");
        name = "";
        password = "";
        profession = "";
        question = "";
        reallyName = "";
        result = "";
    }

    public Integer getAge()
    {
        return age;
    }

    public void setAge(Integer age)
    {
        this.age = age;
    }

    public void setResult(String result)
    {
        this.result = result;
    }

    public void setReallyName(String reallyName)
    {
        this.reallyName = reallyName;
    }

    public void setQuestion(String question)
    {
        this.question = question;
    }

    public void setProfession(String profession)
    {
        this.profession = profession;
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

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getEmail()
    {
        return email;
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

    public String getProfession()
    {
        return profession;
    }

    public String getQuestion()
    {
        return question;
    }

    public String getReallyName()
    {
        return reallyName;
    }

    public String getResult()
    {
        return result;
    }

    public ActionErrors validate(ActionMapping actionMapping, HttpServletRequest httpServletRequest)
    {
        return null;
    }

    public void reset(ActionMapping actionmapping, HttpServletRequest httpservletrequest)
    {
    }
}
