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
import com.bdglxt.orm.baoan;
import com.bdglxt.orm.lipei;

public class lipei_servlet  extends HttpServlet{
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException 
	{
		String type=req.getParameter("type");
		
		if(type.endsWith("lpglToAdd")){
			lpglToAdd(req, res);
		}
		if(type.endsWith("lpglToShow")){
			lpglToShow(req, res);
		}
		if(type.endsWith("lpglAdd")){
			lpglAdd(req, res);
		}
		if(type.endsWith("lpglMana")){
			lpglMana(req, res);
		}
	}
	public void lpglToAdd(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{
		int baid = Integer.parseInt(req.getParameter("baid"));
		baoan ba=new baoan();
		String sql = "select id,(select xingming from t_kehu tb where tb.id=kehu)kehu," +
		 			 "biaoti,riqi,didian,neirong from t_baoan where id=?";
		
		Object[] params={baid};
		DB mydb=new DB();
		try
		{
		mydb.doPstm(sql, params);
		ResultSet rs=mydb.getRs();
		while(rs.next())
		{
			ba.setId(rs.getInt("id"));
			ba.setStrKehu(rs.getString("kehu"));
			ba.setBiaoti(rs.getString("biaoti"));
			ba.setRiqi(rs.getString("riqi"));
			ba.setDidian(rs.getString("didian"));
			ba.setNeirong(rs.getString("neirong"));
		}
		rs.close();
		}
		catch(Exception e)
		{
		e.printStackTrace();
		}
		mydb.closed();
		
		req.setAttribute("baxx", ba);
		req.getRequestDispatcher("/lpgl/lpglAdd.jsp").forward(req, res);
		
	}
	public void lpglToShow(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{
		int baid = Integer.parseInt(req.getParameter("baid"));
		baoan ba=new baoan();
		String sql = "select id,(select xingming from t_kehu tb where tb.id=kehu)kehu," +
		 			 "biaoti,riqi,didian,neirong from t_baoan where id=?";

		Object[] params={baid};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				ba.setId(rs.getInt("id"));
				ba.setStrKehu(rs.getString("kehu"));
				ba.setBiaoti(rs.getString("biaoti"));
				ba.setRiqi(rs.getString("riqi"));
				ba.setDidian(rs.getString("didian"));
				ba.setNeirong(rs.getString("neirong"));
			}
			
			rs.close();
			
			sql = "select riqi,neirong,chuli,jine from t_lipei where baid=?";
			mydb.doPstm(sql, params);
			rs=mydb.getRs();
			while(rs.next())
			{
				lipei lp = new lipei();
				lp.setRiqi(rs.getString("riqi"));
				lp.setNeirong(rs.getString("neirong"));
				lp.setChuli(rs.getString("chuli"));
				lp.setJine(rs.getString("jine"));
				
				ba.setLpInfo(lp);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		req.setAttribute("baxx", ba);
		req.getRequestDispatcher("/lpgl/lpglShow.jsp").forward(req, res);
	}
	public void lpglAdd(HttpServletRequest req,HttpServletResponse res){
		int baid = Integer.parseInt(req.getParameter("baid"));
		String riqi = req.getParameter("riqi");
		String neirong = req.getParameter("neirong");
		String chuli = req.getParameter("chuli");
		String jine = req.getParameter("jine");
		
		String sql="insert into t_lipei values(?,?,?,?,?)";
		Object[] params={baid,riqi,neirong,chuli,jine};
		DB mydb=new DB();
		mydb.doUpdate(sql, params);
		mydb.closed();
		
		req.setAttribute("message", "²Ù×÷³É¹¦");
		req.setAttribute("path", "lpgl?type=lpglMana");
		
        String targetURL = "/success.jsp";
		dispatch(targetURL, req, res);
	}
	public void lpglMana(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{
		String sql = "select id,(select xingming from t_kehu tb where tb.id=kehu)kehu," +
		 			 "biaoti,riqi,didian,neirong," +
		 			 "(select count(1) from t_lipei tc where tc.baid=ta.id)state from t_baoan ta";

		List baList=new ArrayList();
		Object[] params={};
		DB mydb=new DB();
		try
		{
		mydb.doPstm(sql, params);
		ResultSet rs=mydb.getRs();
		while(rs.next())
		{
			baoan ba=new baoan();
			ba.setId(rs.getInt("id"));
			ba.setStrKehu(rs.getString("kehu"));
			ba.setBiaoti(rs.getString("biaoti"));
			ba.setRiqi(rs.getString("riqi"));
			ba.setDidian(rs.getString("didian"));
			ba.setNeirong(rs.getString("neirong"));
			ba.setState(rs.getInt("state"));
			baList.add(ba);
		}
		rs.close();
		}
		catch(Exception e)
		{
		e.printStackTrace();
		}
		mydb.closed();
		
		req.setAttribute("baList", baList);
		req.getRequestDispatcher("/lpgl/lpglMana.jsp").forward(req, res);

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
