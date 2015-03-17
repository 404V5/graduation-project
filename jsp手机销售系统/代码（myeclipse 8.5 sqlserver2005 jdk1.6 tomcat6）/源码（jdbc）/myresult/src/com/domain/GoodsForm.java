

package com.domain;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.*;

public class GoodsForm extends ActionForm
{

    private Integer big;
    private String creaTime;
    private Float freePrice;
    private String from;
    private Integer id;
    private String introduce;
    private String name;
    private Float nowPrice;
    private Integer number;
    private Integer small;
    private String priture;
    private Integer mark;

    public GoodsForm()
    {
    }

    public Integer getBig()
    {
        return big;
    }

    public Integer getMark()
    {
        return mark;
    }

    public void setBig(Integer big)
    {
        this.big = big;
    }

    public void setMark(Integer mark)
    {
        this.mark = mark;
    }

    public void setSmall(Integer small)
    {
        this.small = small;
    }

    public void setPriture(String priture)
    {
        this.priture = priture;
    }

    public void setNumber(Integer number)
    {
        this.number = number;
    }

    public void setNowPrice(Float nowPrice)
    {
        this.nowPrice = nowPrice;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setIntroduce(String introduce)
    {
        this.introduce = introduce;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public void setFrom(String from)
    {
        this.from = from;
    }

    public void setFreePrice(Float freePrice)
    {
        this.freePrice = freePrice;
    }

    public void setCreaTime(String creaTime)
    {
        this.creaTime = creaTime;
    }

    public String getCreaTime()
    {
        return creaTime;
    }

    public Float getFreePrice()
    {
        return freePrice;
    }

    public String getPicture()
    {
        return priture;
    }

    public String getFrom()
    {
        return from;
    }

    public Integer getId()
    {
        return id;
    }

    public String getIntroduce()
    {
        return introduce;
    }

    public String getName()
    {
        return name;
    }

    public Float getNowPrice()
    {
        return nowPrice;
    }

    public Integer getNumber()
    {
        return number;
    }

    public Integer getSmall()
    {
        return small;
    }

    public ActionErrors validate(ActionMapping actionMapping, HttpServletRequest httpServletRequest)
    {
        return null;
    }

    public void reset(ActionMapping actionmapping, HttpServletRequest httpservletrequest)
    {
    }
}
