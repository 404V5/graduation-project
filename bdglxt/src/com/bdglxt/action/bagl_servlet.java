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
import com.bdglxt.orm.baodan;

public class bagl_servlet  extends HttpServlet{
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException 
	{
		String type=req.getParameter("type");
		
		if(type.endsWith("baglAdd")){
			bdglAdd(req, res);
		}
		if(type.endsWith("baglMana")){
			bdglMana(req, res);
		}
	}
	public void bdglAdd(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{
		int kehu = Integer.parseInt(req.getParameter("kehu"));
		String biaoti = req.getParameter("biaoti");
		String riqi = req.getParameter("riqi");
		String didian = req.getParameter("didian");
		String neirong = req.getParameter("neirong");
		
		String sql="insert into t_baoan values(?,?,?,?,?)";
		Object[] params={kehu,biaoti,riqi,didian,neirong};
		DB mydb=new DB();
		mydb.doUpdate(sql, params);
		mydb.closed();
		
		req.setAttribute("message", "²Ù×÷³É¹¦");
		req.setAttribute("path", "bagl?type=baglMana");
		
        String targetURL = "/success.jsp";
		dispatch(targetURL, req, res);
	}
	public void bdglMana(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{
		String sql = "select (select xingming from t_kehu tb where tb.id=kehu)kehu," +
					 "biaoti,riqi,didian,neirong from t_baoan";
		
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
				//ba.setId(rs.getInt("id"));
				ba.setStrKehu(rs.getString("kehu"));
				ba.setBiaoti(rs.getString("biaoti"));
				ba.setRiqi(rs.getString("riqi"));
				ba.setDidian(rs.getString("didian"));
				ba.setNeirong(rs.getString("neirong"));
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
		req.getRequestDispatcher("/bagl/baglMana.jsp").forward(req, res);
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
