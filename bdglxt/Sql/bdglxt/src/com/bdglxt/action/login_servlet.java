package com.bdglxt.action;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bdglxt.dao.DB;
import com.bdglxt.orm.Yuangong;

public class login_servlet extends HttpServlet{
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException 
	{
		String type=req.getParameter("type");
		
		if(type.endsWith("yuangong"))
		{
			yuangongLoing(req, res);
		}
		if(type.endsWith("admin"))
		{
			adminLogin(req, res);
		}
		if(type.endsWith("userpw"))
		{
			userpw(req, res);
		}
		
	}
	
	public void userpw(HttpServletRequest req,HttpServletResponse res){
		String oldPass = req.getParameter("userPw");
		String newpass = req.getParameter("userPw1");
		
		Yuangong yuangong = (Yuangong) req.getSession().getAttribute("userinfo");
		
		if(oldPass.equals(yuangong.getLoginPw())){
			String id = req.getParameter("id");
			String qx = req.getParameter("qx");
			String sql;
			if("2".equals(qx)){
				//管理员密码修改
				sql = "update t_admin set userPw='"+newpass+"'";
			}else{
				//普通员工密码修改
				sql = "update t_yuangong set loginPw='"+newpass+"' where id="+id;
			}
			
			Object[] params={};
			DB mydb=new DB();
			mydb.doUpdate(sql, params);
			mydb.closed();
			
			req.setAttribute("message", "操作成功!");
			req.setAttribute("path", "userPw.jsp");
			yuangong.setLoginPw(newpass);
			req.getSession().setAttribute("userinfo", yuangong);
	        String targetURL = "/success.jsp";
			dispatch(targetURL, req, res);
		}else{
			req.setAttribute("message", "旧密码错误!");
			req.setAttribute("path", "userPw.jsp");
			
	        String targetURL = "/success.jsp";
			dispatch(targetURL, req, res);
		}
	}
	public void yuangongLoing(HttpServletRequest req,HttpServletResponse res){
		String username = req.getParameter("userName");
		String password = req.getParameter("userPw");
		
		String sql = "select id,name,quanxian from t_yuangong where loginName=? and loginPw=? and del=0";
		
		Object[] params={username,password};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			if(rs.next())
			{
				Yuangong yg = new Yuangong();
				yg.setId(rs.getInt("id"));
				yg.setName(rs.getString("name"));
				yg.setLoginName(username);
				yg.setLoginPw(password);
				yg.setQuanxian(rs.getInt("quanxian"));
				
				req.getSession().setAttribute("userinfo", yg);
				
				req.getRequestDispatcher("index.jsp").forward(req, res);
			}
			else{
				req.setAttribute("message", "用户名或密码错误!");
				req.setAttribute("path", "login.jsp");
				
		        String targetURL = "/success.jsp";
				dispatch(targetURL, req, res);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void adminLogin(HttpServletRequest req,HttpServletResponse res){
		String username = req.getParameter("userName");
		String password = req.getParameter("userPw");
		
		String sql = "select count(1)num from t_admin where userName=? and userPw=?";
		Object[] params={username,password};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			rs.next();
			int num = rs.getInt("num");
			rs.close();
			if(num==0)
			{
				req.setAttribute("message", "用户名或密码错误!");
				req.setAttribute("path", "adminLogin.jsp");
				
		        String targetURL = "/success.jsp";
				dispatch(targetURL, req, res);
			}
			else{
				Yuangong yg = new Yuangong();
				yg.setName("超级管理员");
				yg.setLoginName(username);
				yg.setLoginPw(password);
				yg.setQuanxian(2);
				
				req.getSession().setAttribute("userinfo", yg);
				
				req.getRequestDispatcher("index.jsp").forward(req, res);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
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
