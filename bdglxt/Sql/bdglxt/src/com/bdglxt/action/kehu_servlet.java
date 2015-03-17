package com.bdglxt.action;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bdglxt.dao.DB;
import com.bdglxt.orm.kehu;

public class kehu_servlet extends HttpServlet
{ 
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException 
	{
		String type=req.getParameter("type");
		
		if(type.endsWith("kehuAdd"))
		{
			kehuAdd(req, res);
		}
		if(type.endsWith("kehuMana"))
		{
			kehuMana(req, res);
		}
		if(type.endsWith("kehuDel"))
		{
			kehuDel(req, res);
		}
		if(type.endsWith("kehuEdit"))
		{
			kehuEdit(req, res);
		}
		if(type.endsWith("kehuSearch"))
		{
			kehuSearch(req, res);
		}
		if(type.endsWith("kehuXinxi"))
		{
			kehuXinxi(req, res);
		}
		if(type.endsWith("kehuChoose"))
		{
			kehuChoose(req, res);
		}
		if(type.endsWith("kehuChooseSearch"))
		{
			kehuChooseSearch(req, res);
		}
	}
	
	public void kehuAdd(HttpServletRequest req,HttpServletResponse res)
	{
		String xingming=req.getParameter("xingming");
		String xingbie=req.getParameter("xingbie");
		String shenri=req.getParameter("shenri");
		String sfzhm=req.getParameter("sfzhm");
		String guhua=req.getParameter("guhua");
		String shouji=req.getParameter("shouji");
		String zhuzhi=req.getParameter("zhuzhi");
		
		String sql="insert into t_kehu values(?,?,?,?,?,?,?,?)";
		Object[] params={xingming,xingbie,sfzhm,shenri,guhua,shouji,zhuzhi,0};
		DB mydb=new DB();
		mydb.doUpdate(sql, params);
		mydb.closed();
		
		req.setAttribute("message", "操作成功");
		req.setAttribute("path", "kehu?type=kehuMana");
		
        String targetURL = "/success.jsp";
		dispatch(targetURL, req, res);
	}
	public void kehuDel(HttpServletRequest req,HttpServletResponse res)
	{
		int id=Integer.parseInt(req.getParameter("id"));
		
		String sql="update t_kehu set del=1 where id=?";
		Object[] params={id};
		DB mydb=new DB();
		mydb.doUpdate(sql, params);
		mydb.closed();
		
		req.setAttribute("message", "操作成功");
		req.setAttribute("path", "kehu?type=kehuMana");
		
        String targetURL = "/success.jsp";
		dispatch(targetURL, req, res);
	}
	public void kehuMana(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		List kehuList=new ArrayList();
		String sql="select id,xingming,xingbie,sfzhm,shengri,zhuzhi,guhua,shouji from t_kehu where del=0";
		Object[] params={};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				kehu kehu=new kehu();
				kehu.setId(rs.getInt("id"));
				kehu.setXingming(rs.getString("xingming"));
				kehu.setXingbie(rs.getString("xingbie"));
				kehu.setSfzhm(rs.getString("sfzhm"));
				kehu.setShengri(rs.getString("shengri"));
				kehu.setZhuzhi(rs.getString("zhuzhi"));
				kehu.setGuhua(rs.getString("guhua"));
				kehu.setShouji(rs.getString("shouji"));
				kehuList.add(kehu);
			}
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		req.setAttribute("kehuList", kehuList);
		req.getRequestDispatcher("/kehu/kehuMana.jsp").forward(req, res);
	}
	
	public void kehuChoose(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		List kehuList=new ArrayList();
		String sql="select id,xingming,xingbie,sfzhm,shengri,zhuzhi,guhua,shouji from t_kehu where del=0";
		Object[] params={};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				kehu kehu=new kehu();
				kehu.setId(rs.getInt("id"));
				kehu.setXingming(rs.getString("xingming"));
				kehu.setXingbie(rs.getString("xingbie"));
				kehu.setSfzhm(rs.getString("sfzhm"));
				kehu.setShengri(rs.getString("shengri"));
				kehu.setZhuzhi(rs.getString("zhuzhi"));
				kehu.setGuhua(rs.getString("guhua"));
				kehu.setShouji(rs.getString("shouji"));
				kehuList.add(kehu);
			}
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		req.setAttribute("kehuList", kehuList);
		req.getRequestDispatcher("/bdgl/kehuChoose.jsp").forward(req, res);
	}
	
	public void kehuChooseSearch(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		List kehuList=new ArrayList();
		String sql="select id,xingming,xingbie,sfzhm,shengri,zhuzhi,guhua,shouji from t_kehu where del=0 " +
					"and xingming like '%"+req.getParameter("xingming").trim()+"%'";
		Object[] params={};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				kehu kehu=new kehu();
				kehu.setId(rs.getInt("id"));
				kehu.setXingming(rs.getString("xingming"));
				kehu.setXingbie(rs.getString("xingbie"));
				kehu.setSfzhm(rs.getString("sfzhm"));
				kehu.setShengri(rs.getString("shengri"));
				kehu.setZhuzhi(rs.getString("zhuzhi"));
				kehu.setGuhua(rs.getString("guhua"));
				kehu.setShouji(rs.getString("shouji"));
				kehuList.add(kehu);
			}
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		req.setAttribute("sName", req.getParameter("xingming").trim());
		req.setAttribute("kehuList", kehuList);
		req.getRequestDispatcher("/bdgl/kehuChoose.jsp").forward(req, res);
	}
	
	public void kehuXinxi(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
/*		List kehuList=new ArrayList();
		String sql="select * from t_kehu where type='kehu' and id=?";
		Object[] params={Integer.parseInt(req.getParameter("kehu_id"))};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				kehu kehu=new kehu();
				kehu.setId(rs.getInt("id"));
				kehu.setMingcheng(rs.getString("mingcheng"));
				kehu.setDizhi(rs.getString("dizhi"));
				kehu.setLianxiren(rs.getString("lianxiren"));
				kehu.setDianhua(rs.getString("dianhua"));
				kehu.setYoubian(rs.getString("youbian"));
				kehu.setChuanzhen(rs.getString("chuanzhen"));
				kehu.setYouxiang(rs.getString("youxiang"));
				kehuList.add(kehu);
			}
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		req.setAttribute("kehuList", kehuList);
		req.getRequestDispatcher("admin/kehu/kehuXinxi.jsp").forward(req, res);*/
	}
	
	
	
	public void kehuEdit(HttpServletRequest req,HttpServletResponse res)
	{
		int id = Integer.parseInt(req.getParameter("id"));
		String xingming=req.getParameter("xingming");
		String xingbie=req.getParameter("xingbie");
		String shenri=req.getParameter("shenri");
		String sfzhm=req.getParameter("sfzhm");
		String guhua=req.getParameter("guhua");
		String shouji=req.getParameter("shouji");
		String zhuzhi=req.getParameter("zhuzhi");
		
		String sql="update t_kehu set xingming=?,xingbie=?,sfzhm=?,shengri=?,guhua=?,shouji=?,zhuzhi=? where id=?";
		Object[] params={xingming,xingbie,sfzhm,shenri,guhua,shouji,zhuzhi,id};
		DB mydb=new DB();
		mydb.doUpdate(sql, params);
		mydb.closed();
		
		req.setAttribute("message", "操作成功");
		req.setAttribute("path", "kehu?type=kehuMana");
		
        String targetURL = "/success.jsp";
		dispatch(targetURL, req, res);
	}
	
	public void kehuSearch(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		List kehuList=new ArrayList();
		String sql="select id,xingming,xingbie,sfzhm,shengri,zhuzhi,guhua,shouji from t_kehu where del=0 " +
					"and xingming like '%"+req.getParameter("xingming").trim()+"%'";
		Object[] params={};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				kehu kehu=new kehu();
				kehu.setId(rs.getInt("id"));
				kehu.setXingming(rs.getString("xingming"));
				kehu.setXingbie(rs.getString("xingbie"));
				kehu.setSfzhm(rs.getString("sfzhm"));
				kehu.setShengri(rs.getString("shengri"));
				kehu.setZhuzhi(rs.getString("zhuzhi"));
				kehu.setGuhua(rs.getString("guhua"));
				kehu.setShouji(rs.getString("shouji"));
				kehuList.add(kehu);
			}
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		req.setAttribute("kehuList", kehuList);
		req.getRequestDispatcher("/kehu/kehuMana.jsp").forward(req, res);
	}
	
	
	public void dispatch(String targetURI,HttpServletRequest request,HttpServletResponse response) 
	{
		RequestDispatcher dispatch = getServletContext().getRequestDispatcher(targetURI);
		try 
		{
		    dispatch.forward(request, response);
		    return;
		} 
		catch (ServletException e) 
		{
                    e.printStackTrace();
		} 
		catch (IOException e) 
		{
			
		    e.printStackTrace();
		}
	}
	public void init(ServletConfig config) throws ServletException 
	{
		super.init(config);
	}
	
	public void destroy() 
	{
		
	}
}
