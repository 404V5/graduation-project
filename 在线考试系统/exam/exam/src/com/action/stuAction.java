package com.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.dao.TAdminDAO;
import com.dao.TShitiDAO;
import com.dao.TStuDAO;
import com.model.TAdmin;
import com.model.TStu;
import com.opensymphony.xwork2.ActionSupport;
import com.util.Pagination;

public class stuAction extends ActionSupport
{
	private int stuId;
	private String stuXuehao;
	private String stuRealname;
	private String stuSex;
	private String stuAge;
	private String stuZhengzhimianmao;
	private String stuCard;
	 
	private String message;
	private String path;
	private TStuDAO stuDAO;
	private TShitiDAO shitiDAO;
	
	public String stuAdd()
	{
		TStu stu=new TStu();
		stu.setStuXuehao(stuXuehao);
		stu.setStuRealname(stuRealname);
		stu.setStuSex(stuSex);
		stu.setStuAge(stuAge);
		stu.setStuZhengzhimianmao(stuZhengzhimianmao);
		stu.setStuCard(stuCard);
		stu.setDel("no");
		stuDAO.save(stu);
		this.setMessage("操作成功");
		this.setPath("stuMana.action");
		return "succeed";
	}
	
	
	public String stuDel()
	{
		TStu stu=stuDAO.findById(stuId);
		stu.setDel("yes");
		stuDAO.attachDirty(stu);
		this.setMessage("删除成功");
		this.setPath("stuMana.action");
		return "succeed";
	}
	
	public String stuMana()
	{
		List stuList=stuDAO.getHibernateTemplate().find("from TStu where del='no'");
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("stuList", stuList);
		
		return ActionSupport.SUCCESS;
	}

	public String stuAll()
	{
		List stuList=stuDAO.getHibernateTemplate().find("from TStu where del='no'");
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("stuList", stuList);
		
		String sql="from TShiti where del='no'";
		List shitiList=shitiDAO.getHibernateTemplate().find(sql);
		request.put("shitiList", shitiList);
		return ActionSupport.SUCCESS;
	}


	public String getMessage()
	{
		return message;
	}



	public void setMessage(String message)
	{
		this.message = message;
	}



	public String getPath()
	{
		return path;
	}



	public TShitiDAO getShitiDAO()
	{
		return shitiDAO;
	}


	public void setShitiDAO(TShitiDAO shitiDAO)
	{
		this.shitiDAO = shitiDAO;
	}


	public TStuDAO getStuDAO()
	{
		return stuDAO;
	}



	public void setStuDAO(TStuDAO stuDAO)
	{
		this.stuDAO = stuDAO;
	}



	public void setPath(String path)
	{
		this.path = path;
	}



	public String getStuAge()
	{
		return stuAge;
	}



	public void setStuAge(String stuAge)
	{
		this.stuAge = stuAge;
	}



	public String getStuCard()
	{
		return stuCard;
	}



	public void setStuCard(String stuCard)
	{
		this.stuCard = stuCard;
	}



	public int getStuId()
	{
		return stuId;
	}



	public void setStuId(int stuId)
	{
		this.stuId = stuId;
	}



	public String getStuRealname()
	{
		return stuRealname;
	}



	public void setStuRealname(String stuRealname)
	{
		this.stuRealname = stuRealname;
	}



	public String getStuSex()
	{
		return stuSex;
	}



	public void setStuSex(String stuSex)
	{
		this.stuSex = stuSex;
	}



	public String getStuXuehao()
	{
		return stuXuehao;
	}



	public void setStuXuehao(String stuXuehao)
	{
		this.stuXuehao = stuXuehao;
	}



	public String getStuZhengzhimianmao()
	{
		return stuZhengzhimianmao;
	}



	public void setStuZhengzhimianmao(String stuZhengzhimianmao)
	{
		this.stuZhengzhimianmao = stuZhengzhimianmao;
	}
	
}
