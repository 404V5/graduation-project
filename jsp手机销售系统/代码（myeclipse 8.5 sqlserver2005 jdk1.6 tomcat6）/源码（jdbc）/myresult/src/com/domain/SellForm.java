

package com.domain;

import org.apache.struts.action.ActionForm;

public class SellForm extends ActionForm
{

    private Integer id;
    private Integer goodId;
    private Integer memberId;
    private float price;
    private int number;
    private int sign;

    public SellForm()
    {
    }

    public Integer getId()
    {
        return id;
    }

    public Integer getGoodId()
    {
        return goodId;
    }

    public Integer getMemberId()
    {
        return memberId;
    }

    public float getPrice()
    {
        return price;
    }

    public int getNumber()
    {
        return number;
    }

    public int getSign()
    {
        return sign;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public void setGoodId(Integer goodId)
    {
        this.goodId = goodId;
    }

    public void setMemberId(Integer memberId)
    {
        this.memberId = memberId;
    }

    public void setPrice(float price)
    {
        this.price = price;
    }

    public void setNumber(int number)
    {
        this.number = number;
    }

    public void setSign(int sign)
    {
        this.sign = sign;
    }
}
