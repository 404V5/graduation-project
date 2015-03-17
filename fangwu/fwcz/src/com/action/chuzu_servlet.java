package com.action;

import java.io.IOException;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.DB;
import com.orm.TAdmin;
import com.orm.Tchuzu;
import com.orm.Tgonggao;
import com.orm.Tuser;

public class chuzu_servlet extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException 
	{
        String type=req.getParameter("type");
		
		
        if(type.endsWith("chuzuAdd"))
        {
        	chuzuAdd(req, res);
        }
        if(type.endsWith("chuzuMine"))
		{
			chuzuMine(req, res);
		}
		if(type.endsWith("chuzuDel"))
		{
			chuzuDel(req, res);
		}
		
		if(type.endsWith("chuzuMana"))
		{
			chuzuMana(req, res);
		}
		
		
		if(type.endsWith("chuzuAll"))
		{
			chuzuAll(req, res);
		}
		if(type.endsWith("chuzuDetailQian"))
		{
			chuzuDetailQian(req, res);
		}
		if(type.endsWith("chuzuRes"))
		{
			chuzuRes(req, res);
		}
		if(type.endsWith("chuzuNew"))
		{
			chuzuNew(req, res);
		}
	}
	
	
	public void chuzuAdd(HttpServletRequest req,HttpServletResponse res)
	{
		HttpSession session=req.getSession();
		Tuser user=(Tuser)session.getAttribute("user");
		
		String huxing=req.getParameter("huxing");
		int minaji=Integer.parseInt(req.getParameter("mianji"));
		int jiage=Integer.parseInt(req.getParameter("jiage"));
		String beizhu=req.getParameter("beizhu");
		
		String dizhi=req.getParameter("dizhi");
		String lianxiren=req.getParameter("lianxiren");
		String lianxihua=req.getParameter("lianxihua");
		String fabushijian=new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		
		String fujian=req.getParameter("fujian");
		int user_id=user.getId();
		
		
		String sql="insert into t_chuzu values(?,?,?,?,?,?,?,?,?,?)";
		Object[] params={huxing,minaji,jiage,beizhu,dizhi,lianxiren,lianxihua,fabushijian,fujian,user_id};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		mydb.closed();
		
		req.setAttribute("msg", "信息添加完毕");
		String targetURL = "/common/msg.jsp";
		dispatch(targetURL, req, res);
		
	}
	public void chuzuMine(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		List chuzuList=new ArrayList();
		String sql="select * from t_chuzu";
		Object[] params={};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				Tchuzu chuzu=new Tchuzu();
				
				chuzu.setId(rs.getInt("id"));
				chuzu.setHuxing(rs.getString("huxing"));
				chuzu.setMianji(rs.getInt("mianji"));
				chuzu.setJiage(rs.getInt("jiage"));
				
				chuzu.setBeizhu(rs.getString("beizhu"));
				chuzu.setDizhi(rs.getString("dizhi"));
				chuzu.setLianxiren(rs.getString("lianxiren"));
				chuzu.setLianxihua(rs.getString("lianxihua"));
				
				chuzu.setFabushijian(rs.getString("fabushijian"));
				chuzu.setFujian(rs.getString("fujian"));
				chuzu.setUser_id(rs.getInt("user_id"));
				
				chuzuList.add(chuzu);
		    }
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		req.setAttribute("chuzuList", chuzuList);
		req.getRequestDispatcher("auser/chuzu/chuzuMine.jsp").forward(req, res);
	}
	
	
	public void chuzuDel(HttpServletRequest req,HttpServletResponse res)
	{
		String id=req.getParameter("id");
		
		String sql="delete from t_chuzu where id=?";
		Object[] params={id};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		mydb.closed();
		
		req.setAttribute("msg", "信息删除完毕");
		String targetURL = "/common/msg.jsp";
		dispatch(targetURL, req, res);
	}
	public void chuzuMana(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		List chuzuList=new ArrayList();
		String sql="select * from t_chuzu";
		Object[] params={};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				Tchuzu chuzu=new Tchuzu();
				
				chuzu.setId(rs.getInt("id"));
				chuzu.setHuxing(rs.getString("huxing"));
				chuzu.setMianji(rs.getInt("mianji"));
				chuzu.setJiage(rs.getInt("jiage"));
				
				chuzu.setBeizhu(rs.getString("beizhu"));
				chuzu.setDizhi(rs.getString("dizhi"));
				chuzu.setLianxiren(rs.getString("lianxiren"));
				chuzu.setLianxihua(rs.getString("lianxihua"));
				
				chuzu.setFabushijian(rs.getString("fabushijian"));
				chuzu.setFujian(rs.getString("fujian"));
				chuzu.setUser_id(rs.getInt("user_id"));
				
				chuzuList.add(chuzu);
		    }
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		req.setAttribute("chuzuList", chuzuList);
		req.getRequestDispatcher("admin/chuzu/chuzuMana.jsp").forward(req, res);
	}
	
	public void chuzuAll(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		List chuzuList=new ArrayList();
		String sql="select * from t_chuzu order by fabushijian desc";
		Object[] params={};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				Tchuzu chuzu=new Tchuzu();
				
				chuzu.setId(rs.getInt("id"));
				chuzu.setHuxing(rs.getString("huxing"));
				chuzu.setMianji(rs.getInt("mianji"));
				chuzu.setJiage(rs.getInt("jiage"));
				
				chuzu.setBeizhu(rs.getString("beizhu"));
				chuzu.setDizhi(rs.getString("dizhi"));
				chuzu.setLianxiren(rs.getString("lianxiren"));
				chuzu.setLianxihua(rs.getString("lianxihua"));
				
				chuzu.setFabushijian(rs.getString("fabushijian"));
				chuzu.setFujian(rs.getString("fujian"));
				chuzu.setUser_id(rs.getInt("user_id"));
				
				chuzuList.add(chuzu);
		    }
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		
		
        req.setAttribute("chuzuList", chuzuList);
		req.getRequestDispatcher("qiantai/chuzu/chuzuAll.jsp").forward(req, res);
	}
	
	
	public void chuzuDetailQian(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		String id=req.getParameter("id");
		Tchuzu chuzu=new Tchuzu();
		
		String sql="select * from t_chuzu where id=?";
		Object[] params={id};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			rs.next();
			
			chuzu.setId(rs.getInt("id"));
			chuzu.setHuxing(rs.getString("huxing"));
			chuzu.setMianji(rs.getInt("mianji"));
			chuzu.setJiage(rs.getInt("jiage"));
			
			chuzu.setBeizhu(rs.getString("beizhu"));
			chuzu.setDizhi(rs.getString("dizhi"));
			chuzu.setLianxiren(rs.getString("lianxiren"));
			chuzu.setLianxihua(rs.getString("lianxihua"));
			
			chuzu.setFabushijian(rs.getString("fabushijian"));
			chuzu.setFujian(rs.getString("fujian"));
			chuzu.setUser_id(rs.getInt("user_id"));
			
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		req.setAttribute("chuzu", chuzu);
		req.getRequestDispatcher("/qiantai/chuzu/chuzuDetailQian.jsp").forward(req, res);
	}
	
	
	public void chuzuRes(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		String huxing=req.getParameter("huxing").trim();
		String dizhi=req.getParameter("dizhi").trim();
		
		List chuzuList=new ArrayList();
		
		StringBuffer sql=new StringBuffer("select * from t_chuzu where 1=1");
		sql.append(" and huxing like '%"+huxing+"%'");
		sql.append(" and dizhi like '%"+dizhi+"%'");
		
		
		Object[] params={};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql.toString(), params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				Tchuzu chuzu=new Tchuzu();
				
				chuzu.setId(rs.getInt("id"));
				chuzu.setHuxing(rs.getString("huxing"));
				chuzu.setMianji(rs.getInt("mianji"));
				chuzu.setJiage(rs.getInt("jiage"));
				
				chuzu.setBeizhu(rs.getString("beizhu"));
				chuzu.setDizhi(rs.getString("dizhi"));
				chuzu.setLianxiren(rs.getString("lianxiren"));
				chuzu.setLianxihua(rs.getString("lianxihua"));
				
				chuzu.setFabushijian(rs.getString("fabushijian"));
				chuzu.setFujian(rs.getString("fujian"));
				chuzu.setUser_id(rs.getInt("user_id"));
				
				chuzuList.add(chuzu);
		    }
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		
		
        req.setAttribute("chuzuList", chuzuList);
		req.getRequestDispatcher("qiantai/chuzu/chuzuAll.jsp").forward(req, res);
	}
	
	
	public void chuzuNew(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		List chuzuList=new ArrayList();
		String sql="select * from t_chuzu order by fabushijian desc";
		Object[] params={};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				Tchuzu chuzu=new Tchuzu();
				
				chuzu.setId(rs.getInt("id"));
				chuzu.setHuxing(rs.getString("huxing"));
				chuzu.setMianji(rs.getInt("mianji"));
				chuzu.setJiage(rs.getInt("jiage"));
				
				chuzu.setBeizhu(rs.getString("beizhu"));
				chuzu.setDizhi(rs.getString("dizhi"));
				chuzu.setLianxiren(rs.getString("lianxiren"));
				chuzu.setLianxihua(rs.getString("lianxihua"));
				
				chuzu.setFabushijian(rs.getString("fabushijian"));
				chuzu.setFujian(rs.getString("fujian"));
				chuzu.setUser_id(rs.getInt("user_id"));
				
				chuzuList.add(chuzu);
		    }
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		if(chuzuList.size()>4)
		{
			chuzuList=chuzuList.subList(0, 4);
		}
		
        req.setAttribute("chuzuList", chuzuList);
		req.getRequestDispatcher("qiantai/chuzu/chuzuNew.jsp").forward(req, res);
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
