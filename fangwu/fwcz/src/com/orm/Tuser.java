package com.orm;

public class Tuser
{
	private int id;
	private String loginname;
	private String loginpw;
	private String xingming;
	
	private String xingbie;
	private int nianling;
	private String zhuzhi;
	private String zhiye;
	
	private String del;
	
	public String getLoginname()
	{
		return loginname;
	}
	public void setLoginname(String loginname)
	{
		this.loginname = loginname;
	}
	public String getLoginpw()
	{
		return loginpw;
	}
	public void setLoginpw(String loginpw)
	{
		this.loginpw = loginpw;
	}
	public String getXingming()
	{
		return xingming;
	}
	public void setXingming(String xingming)
	{
		this.xingming = xingming;
	}
	public String getXingbie()
	{
		return xingbie;
	}
	public void setXingbie(String xingbie)
	{
		this.xingbie = xingbie;
	}
	public int getNianling()
	{
		return nianling;
	}
	public void setNianling(int nianling)
	{
		this.nianling = nianling;
	}
	public String getZhuzhi()
	{
		return zhuzhi;
	}
	public void setZhuzhi(String zhuzhi)
	{
		this.zhuzhi = zhuzhi;
	}
	public String getZhiye()
	{
		return zhiye;
	}
	
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getDel()
	{
		return del;
	}
	public void setDel(String del)
	{
		this.del = del;
	}
	public void setZhiye(String zhiye)
	{
		this.zhiye = zhiye;
	}
	
}
