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
import com.bdglxt.orm.jcxx;
import com.bdglxt.service.JcxxlxService;

public class jcxx_servlet extends HttpServlet{
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException 
	{
		String type=req.getParameter("type");
		
		if(type.endsWith("lxglMana")){
			lxglMana(req, res);
		}
		if(type.endsWith("jcxxAdd")){
			jcxxAdd(req, res);
		}
		if(type.endsWith("jcxxEdit")){
			jcxxEdit(req, res);
		}
		if(type.endsWith("jcxxDel")){
			jcxxDel(req, res);
		}
	}
	
	public void jcxxDel(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{
		String id = req.getParameter("id");
		String lxtype = req.getParameter("lxtype");
		System.out.println(lxtype+"....");
		String sql = "update t_jcxx set del=? where id=?";
		
		try{			
			Object[] params={1,Integer.parseInt(id)};
			DB mydb=new DB();
			mydb.doUpdate(sql, params);
			mydb.closed();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		req.setAttribute("message", "操作成功");
		req.setAttribute("path", "jcxx?type=lxglMana&leixing="+lxtype);
		
        String targetURL = "/success.jsp";
		dispatch(targetURL, req, res);
	}
	public void jcxxEdit(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{
		String id = req.getParameter("id");
		String lxtype = req.getParameter("lxtype");
		String lxmc = req.getParameter("lxmc");
		String lxms = req.getParameter("lxms");
		
		String sql = "update t_jcxx set mingcheng=?,miaoshu=? where id=?";
		
		try{			
			Object[] params={lxmc,lxms,Integer.parseInt(id)};
			DB mydb=new DB();
			mydb.doUpdate(sql, params);
			mydb.closed();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		req.setAttribute("message", "操作成功");
		req.setAttribute("path", "jcxx?type=lxglMana&leixing="+lxtype);
		
        String targetURL = "/success.jsp";
		dispatch(targetURL, req, res);
	}
	public void jcxxAdd(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{
		String lxtype = req.getParameter("hidlxtype");
		String lxmc = req.getParameter("lxmc");
		String lxms = req.getParameter("lxms");
		
		String sql = "insert into t_jcxx values (?,?,?,?)";
		try{			
			Object[] params={lxmc,lxms,Integer.parseInt(lxtype),0};
			DB mydb=new DB();
			mydb.doUpdate(sql, params);
			mydb.closed();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		req.setAttribute("message", "操作成功");
		req.setAttribute("path", "jcxx?type=lxglMana&leixing="+lxtype);
		
        String targetURL = "/success.jsp";
		dispatch(targetURL, req, res);
	}
	public void lxglMana(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{
		String lxtype = req.getParameter("leixing");
		List jcxxList=new ArrayList();
		String sql = "select id,mingcheng,miaoshu from t_jcxx where leixing=? and del=?";
		Object[] params={Integer.parseInt(lxtype),0};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				jcxx jcxx=new jcxx();
				jcxx.setId(rs.getInt("id"));
				jcxx.setMingcheng(rs.getString("mingcheng"));
				jcxx.setMiaoshu(rs.getString("miaoshu"));
				jcxxList.add(jcxx);
			}
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		req.setAttribute("lxtype", lxtype);
		req.setAttribute("lxmingcheng", new JcxxlxService().getJcxxlxName(lxtype));
		req.setAttribute("jcxxList", jcxxList);
		req.getRequestDispatcher("/jcxx/jcxxMana.jsp").forward(req, res);
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
