package com.bdglxt.action;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bdglxt.dao.DB;
import com.bdglxt.orm.bdlx;
import com.bdglxt.orm.bdlx;

public class bdlx_servlet extends HttpServlet{
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException 
	{
		String type=req.getParameter("type");
		
		if(type.endsWith("bdlxAdd"))
		{
			bdlxAdd(req, res);
		}
		if(type.endsWith("bdlxMana"))
		{
			bdlxMana(req, res);
		}
		if(type.endsWith("bdlxDel"))
		{
			bdlxDel(req, res);
		}
		if(type.endsWith("bdlxEdit"))
		{
			bdlxEdit(req, res);
		}
		if(type.endsWith("bdlxSearch"))
		{
			bdlxSearch(req, res);
		}
	}
	
	public void bdlxAdd(HttpServletRequest req,HttpServletResponse res){
		String lxmc=req.getParameter("lxmc");
		String lxms=req.getParameter("lxms");
		String tbnx=req.getParameter("tbnx");
		
		String sql="insert into t_baodanleixing values(?,?,?,?)";
		Object[] params={lxmc,lxms,tbnx,0};
		DB mydb=new DB();
		mydb.doUpdate(sql, params);
		mydb.closed();
		
		req.setAttribute("message", "操作成功");
		req.setAttribute("path", "bdlx?type=bdlxMana");
		
        String targetURL = "/success.jsp";
		dispatch(targetURL, req, res);
	}
	public void bdlxMana(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{
		List bdlxList=new ArrayList();
		String sql="select id,lxmc,lxms,tbnx from t_baodanleixing where del=0";
		Object[] params={};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				bdlx bdlx=new bdlx();
				bdlx.setId(rs.getInt("id"));
				bdlx.setLxmc(rs.getString("lxmc"));
				bdlx.setLxms(rs.getString("lxms"));
				bdlx.setTbnx(rs.getInt("tbnx"));
				bdlxList.add(bdlx);
			}
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		req.setAttribute("bdlxList", bdlxList);
		req.getRequestDispatcher("/bdlx/bdlxMana.jsp").forward(req, res);
	}
	
	public void bdlxSearch(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{
		List bdlxList=new ArrayList();
		String sql="select id,lxmc,lxms,tbnx from t_baodanleixing where del=0 " +
				   "and lxmc like '%"+req.getParameter("lxmc").trim()+"%'";
		Object[] params={};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				bdlx bdlx=new bdlx();
				bdlx.setId(rs.getInt("id"));
				bdlx.setLxmc(rs.getString("lxmc"));
				bdlx.setLxms(rs.getString("lxms"));
				bdlx.setTbnx(rs.getInt("tbnx"));
				bdlxList.add(bdlx);
			}
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		req.setAttribute("bdlxList", bdlxList);
		req.getRequestDispatcher("/bdlx/bdlxMana.jsp").forward(req, res);
	}
	public void bdlxEdit(HttpServletRequest req,HttpServletResponse res){
		int id = Integer.parseInt(req.getParameter("id"));
		String lxmc=req.getParameter("lxmc");
		String lxms=req.getParameter("lxms");
		String tbnx=req.getParameter("tbnx");
		
		String sql="update t_baodanleixing set lxmc=?,lxms=?,tbnx=? where id=?";
		Object[] params={lxmc,lxms,tbnx,id};
		DB mydb=new DB();
		mydb.doUpdate(sql, params);
		mydb.closed();
		
		req.setAttribute("message", "操作成功");
		req.setAttribute("path", "bdlx?type=bdlxMana");
		
        String targetURL = "/success.jsp";
		dispatch(targetURL, req, res);
	}
	public void bdlxDel(HttpServletRequest req,HttpServletResponse res){
		int id=Integer.parseInt(req.getParameter("id"));
		
		String sql="update t_baodanleixing set del=1 where id=?";
		Object[] params={id};
		DB mydb=new DB();
		mydb.doUpdate(sql, params);
		mydb.closed();
		
		req.setAttribute("message", "操作成功");
		req.setAttribute("path", "bdlx?type=bdlxMana");
		
        String targetURL = "/success.jsp";
		dispatch(targetURL, req, res);
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
}
