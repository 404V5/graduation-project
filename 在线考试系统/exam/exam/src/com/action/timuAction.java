package com.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.dao.TJiaoyuanDAO;
import com.dao.TTimuDAO;
import com.dao.TTimuShitiDAO;
import com.model.TStu;
import com.model.TTimu;
import com.model.TTimuShiti;
import com.opensymphony.xwork2.ActionSupport;

public class timuAction extends ActionSupport
{
	private int timuId;
	private String timuName;
	private String timuXuanxianga;
	private String timuXuanxiangb;
	private String timuXuanxiangc;
	private String timuXuanxiangd;
	private String timuDaan;
	private int timuFenshu;
	private String timuLeixing;
	private int kechengId;
	private String message;
	private String path;
	
	private TTimuDAO timuDAO;
	private TTimuShitiDAO timuShitiDAO;
	private TJiaoyuanDAO jiaoyuanDAO;
	
	private int shitiId;
	
	public String timu_danxuan_Add()
	{
		TTimu timu=new TTimu();
		timu.setTimuName(timuName);
		timu.setTimuXuanxianga(timuXuanxianga);
		timu.setTimuXuanxiangb(timuXuanxiangb);
		timu.setTimuXuanxiangc(timuXuanxiangc);
		timu.setTimuXuanxiangd(timuXuanxiangd);
		timu.setTimuDaan(timuDaan.trim());
		timu.setTimuFenshu(timuFenshu);
		timu.setTimuLeixing(timuLeixing);
		timu.setKechengId(kechengId);
		timu.setDel("no");
		timuDAO.save(timu);
		this.setMessage("�����ɹ�");
		this.setPath("admin/timu/timuLeixing.jsp");
		return "succeed";
	}
	
	public String timu_duoxuan_Add()
	{
		TTimu timu=new TTimu();
		timu.setTimuName(timuName);
		timu.setTimuXuanxianga(timuXuanxianga);
		timu.setTimuXuanxiangb(timuXuanxiangb);
		timu.setTimuXuanxiangc(timuXuanxiangc);
		timu.setTimuXuanxiangd(timuXuanxiangd);
		timu.setTimuDaan(timuDaan.trim());
		timu.setTimuFenshu(timuFenshu);
		timu.setTimuLeixing(timuLeixing);
		timu.setKechengId(kechengId);
		timu.setDel("no");
		timuDAO.save(timu);
		this.setMessage("�����ɹ�");
		this.setPath("admin/timu/timuLeixing.jsp");
		return "succeed";
	}
	public String timu_panduan_Add()
	{
		TTimu timu=new TTimu();
		timu.setTimuName(timuName);
		timu.setTimuXuanxianga(timuXuanxianga);
		timu.setTimuXuanxiangb(timuXuanxiangb);
		timu.setTimuDaan(timuDaan.trim());
		timu.setTimuFenshu(timuFenshu);
		timu.setTimuLeixing(timuLeixing);
		timu.setKechengId(kechengId);
		timu.setDel("no");
		timuDAO.save(timu);
		this.setMessage("�����ɹ�");
		this.setPath("admin/timu/timuLeixing.jsp");
		return "succeed";
	}
	public String timu_jianda_Add()
	{
		TTimu timu=new TTimu();
		timu.setTimuName(timuName);
		timu.setTimuDaan(timuDaan.trim());
		timu.setTimuFenshu(timuFenshu);
		timu.setTimuLeixing(timuLeixing);
		timu.setKechengId(kechengId);
		timu.setDel("no");
		timuDAO.save(timu);
		this.setMessage("�����ɹ�");
		this.setPath("admin/timu/timuLeixing.jsp");
		return "succeed";
	}
	
	
	
	public String timuDel()
	{
		TTimu timu=timuDAO.findById(timuId);
		timu.setDel("yes");
		timuDAO.attachDirty(timu);
		this.setMessage("�����ɹ�");
		System.out.println(timu.getKechengId()+"&&&");
		this.setPath("timuByKecheng.action?kechengId="+timu.getKechengId());
		return "succeed";
	}

	public String timuByKecheng()
	{
		String sql="from TTimu where del='no' and kechengId="+kechengId+" order by timuLeixing";
		List timuList=timuDAO.getHibernateTemplate().find(sql);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("timuList", timuList);
		return ActionSupport.SUCCESS;
	}
	
	public String timuByKecheng1()
	{
		String sql="from TTimu where del='no' and kechengId="+kechengId+" order by timuLeixing";
		List timuList=timuDAO.getHibernateTemplate().find(sql);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("timuList", timuList);
		request.put("shitiId", shitiId);
		return ActionSupport.SUCCESS;
	}
	
	public String timuByShiti()
	{
		List timuList=new ArrayList();
		Map request=(Map)ServletActionContext.getContext().get("request");
		String sql="from TTimuShiti where shitiId=?";
		Object con[]={shitiId};
		List timuShitiList=timuShitiDAO.getHibernateTemplate().find(sql,con);
		for(int i=0;i<timuShitiList.size();i++)
		{
			TTimuShiti timuShiti=(TTimuShiti)timuShitiList.get(i);
			TTimu timu=timuDAO.findById(timuShiti.getTimuId());
			timuList.add(timu);
		}
		request.put("timuList", timuList);
		request.put("shitiId", shitiId);
		return ActionSupport.SUCCESS;
	}
	
	
	public String timuByShiti_kaoshi()
	{
		Map request=(Map)ServletActionContext.getContext().get("request");
		Map session= ServletActionContext.getContext().getSession();
		TStu stu=(TStu)session.get("stu");
		
		String sqlk="from TJiaoyuan where stuId=? and shitiId=?";
		Object conk[]={stu.getStuId(),shitiId};
		List list=jiaoyuanDAO.getHibernateTemplate().find(sqlk,conk);
		if(list.size()>0)
		{
			request.put("err", "���Ѿ��μӹ��˿��ԡ��벻Ҫ�ظ�����");
			return ActionSupport.ERROR;
		}
		
		List timuList=new ArrayList();
		String sql="from TTimuShiti where shitiId=?";
		Object con[]={shitiId};
		List timuShitiList=timuShitiDAO.getHibernateTemplate().find(sql,con);
		for(int i=0;i<timuShitiList.size();i++)
		{
			TTimuShiti timuShiti=(TTimuShiti)timuShitiList.get(i);
			TTimu timu=timuDAO.findById(timuShiti.getTimuId());
			timuList.add(timu);
		}
		request.put("timuList", timuList);
		request.put("shitiId", shitiId);
		return ActionSupport.SUCCESS;
	}


	public int getKechengId()
	{
		return kechengId;
	}

	public void setKechengId(int kechengId)
	{
		this.kechengId = kechengId;
	}

	public void setTimuLeixing(String timuLeixing)
	{
		this.timuLeixing = timuLeixing;
	}

	public String getMessage()
	{
		return message;
	}

	public int getShitiId()
	{
		return shitiId;
	}

	public void setShitiId(int shitiId)
	{
		this.shitiId = shitiId;
	}

	public void setMessage(String message)
	{
		this.message = message;
	}

	public String getPath()
	{
		return path;
	}

	public void setPath(String path)
	{
		this.path = path;
	}

	public String getTimuDaan()
	{
		return timuDaan;
	}

	public void setTimuDaan(String timuDaan)
	{
		this.timuDaan = timuDaan;
	}

	public TTimuDAO getTimuDAO()
	{
		return timuDAO;
	}

	public void setTimuDAO(TTimuDAO timuDAO)
	{
		this.timuDAO = timuDAO;
	}

	public int getTimuFenshu()
	{
		return timuFenshu;
	}

	public void setTimuFenshu(int timuFenshu)
	{
		this.timuFenshu = timuFenshu;
	}

	public int getTimuId()
	{
		return timuId;
	}

	public void setTimuId(int timuId)
	{
		this.timuId = timuId;
	}


	public String getTimuLeixing()
	{
		return timuLeixing;
	}

	public String getTimuName()
	{
		return timuName;
	}

	public void setTimuName(String timuName)
	{
		this.timuName = timuName;
	}

	public String getTimuXuanxianga()
	{
		return timuXuanxianga;
	}

	public void setTimuXuanxianga(String timuXuanxianga)
	{
		this.timuXuanxianga = timuXuanxianga;
	}

	public String getTimuXuanxiangb()
	{
		return timuXuanxiangb;
	}

	public TTimuShitiDAO getTimuShitiDAO()
	{
		return timuShitiDAO;
	}

	public void setTimuShitiDAO(TTimuShitiDAO timuShitiDAO)
	{
		this.timuShitiDAO = timuShitiDAO;
	}

	public void setTimuXuanxiangb(String timuXuanxiangb)
	{
		this.timuXuanxiangb = timuXuanxiangb;
	}

	public String getTimuXuanxiangc()
	{
		return timuXuanxiangc;
	}

	public void setTimuXuanxiangc(String timuXuanxiangc)
	{
		this.timuXuanxiangc = timuXuanxiangc;
	}

	public String getTimuXuanxiangd()
	{
		return timuXuanxiangd;
	}

	public void setTimuXuanxiangd(String timuXuanxiangd)
	{
		this.timuXuanxiangd = timuXuanxiangd;
	}

	public TJiaoyuanDAO getJiaoyuanDAO()
	{
		return jiaoyuanDAO;
	}

	public void setJiaoyuanDAO(TJiaoyuanDAO jiaoyuanDAO)
	{
		this.jiaoyuanDAO = jiaoyuanDAO;
	}
	
}
