package com.model;

/**
 * TShiti generated by MyEclipse Persistence Tools
 */

public class TShiti implements java.io.Serializable
{

	// Fields

	private Integer shitiId;

	private String shitiName;

	private String shitiJieshao;
	
	private String shitiShijian;

	private String del;

	// Constructors

	/** default constructor */
	public TShiti()
	{
	}

	/** full constructor */
	public TShiti(String shitiName, String shitiJieshao, String del)
	{
		this.shitiName = shitiName;
		this.shitiJieshao = shitiJieshao;
		this.del = del;
	}

	// Property accessors

	public Integer getShitiId()
	{
		return this.shitiId;
	}

	public void setShitiId(Integer shitiId)
	{
		this.shitiId = shitiId;
	}

	public String getShitiName()
	{
		return this.shitiName;
	}

	public void setShitiName(String shitiName)
	{
		this.shitiName = shitiName;
	}

	public String getShitiJieshao()
	{
		return this.shitiJieshao;
	}

	public String getShitiShijian()
	{
		return shitiShijian;
	}

	public void setShitiShijian(String shitiShijian)
	{
		this.shitiShijian = shitiShijian;
	}

	public void setShitiJieshao(String shitiJieshao)
	{
		this.shitiJieshao = shitiJieshao;
	}

	public String getDel()
	{
		return this.del;
	}

	public void setDel(String del)
	{
		this.del = del;
	}

}