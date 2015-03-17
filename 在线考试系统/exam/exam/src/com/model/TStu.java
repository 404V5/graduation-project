package com.model;

/**
 * TStu generated by MyEclipse Persistence Tools
 */

public class TStu implements java.io.Serializable
{

	// Fields

	private Integer stuId;

	private String stuXuehao;

	private String stuRealname;

	private String stuSex;

	private String stuAge;

	private String stuCard;

	private String stuZhengzhimianmao;

	private String loginName;

	private String loginPw;

	private String del;

	// Constructors

	/** default constructor */
	public TStu()
	{
	}

	/** full constructor */
	public TStu(String stuXuehao, String stuRealname, String stuSex,
			String stuAge, String stuCard, String stuZhengzhimianmao,
			String loginName, String loginPw, String del)
	{
		this.stuXuehao = stuXuehao;
		this.stuRealname = stuRealname;
		this.stuSex = stuSex;
		this.stuAge = stuAge;
		this.stuCard = stuCard;
		this.stuZhengzhimianmao = stuZhengzhimianmao;
		this.loginName = loginName;
		this.loginPw = loginPw;
		this.del = del;
	}

	// Property accessors

	public Integer getStuId()
	{
		return this.stuId;
	}

	public void setStuId(Integer stuId)
	{
		this.stuId = stuId;
	}

	public String getStuXuehao()
	{
		return this.stuXuehao;
	}

	public void setStuXuehao(String stuXuehao)
	{
		this.stuXuehao = stuXuehao;
	}

	public String getStuRealname()
	{
		return this.stuRealname;
	}

	public void setStuRealname(String stuRealname)
	{
		this.stuRealname = stuRealname;
	}

	public String getStuSex()
	{
		return this.stuSex;
	}

	public void setStuSex(String stuSex)
	{
		this.stuSex = stuSex;
	}

	public String getStuAge()
	{
		return this.stuAge;
	}

	public void setStuAge(String stuAge)
	{
		this.stuAge = stuAge;
	}

	public String getStuCard()
	{
		return this.stuCard;
	}

	public void setStuCard(String stuCard)
	{
		this.stuCard = stuCard;
	}

	public String getStuZhengzhimianmao()
	{
		return this.stuZhengzhimianmao;
	}

	public void setStuZhengzhimianmao(String stuZhengzhimianmao)
	{
		this.stuZhengzhimianmao = stuZhengzhimianmao;
	}

	public String getLoginName()
	{
		return this.loginName;
	}

	public void setLoginName(String loginName)
	{
		this.loginName = loginName;
	}

	public String getLoginPw()
	{
		return this.loginPw;
	}

	public void setLoginPw(String loginPw)
	{
		this.loginPw = loginPw;
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