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
import com.bdglxt.orm.Yuangong;
import com.bdglxt.orm.baodan;
import com.bdglxt.orm.bdlx;
import com.bdglxt.orm.jcxx;
import com.bdglxt.util.DateUtils;

public class bdgl_servlet extends HttpServlet{
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException 
	{
		String type=req.getParameter("type");
		
		if(type.endsWith("toAdd"))
		{
			toAdd(req, res);
		}
		if(type.endsWith("bdglAdd")){
			bdglAdd(req, res);
		}
		if(type.endsWith("bdglMana")){
			bdglMana(req, res);
		}
		if(type.endsWith("bdglSearch")){
			bdglSearch(req, res);
		}
		if(type.endsWith("bdglBrowse")){
			bdglBrowse(req, res);
		}
		if(type.endsWith("bdglBrowseSearch")){
			bdglBrowseSearch(req, res);
		}
	}
	
	public void bdglBrowseSearch(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{
		String sql = "select * from " +
					 "(select id,bianhao," +
					 "(select lxmc from t_baodanleixing tb where tb.id=leixing) leixing," +
					 "(select xingming from t_kehu tc where tc.id=kehu)strkehu," +
					 "(select mingcheng from t_jcxx td where td.id=jfsx)jfsx," +
					 "jine,tbrq,shouyiren,shouyirenxb,guanxi,shouyirensfz, " +
					 "(select name from t_yuangong te where te.id=yuangong)yuangong "+
					 "from t_baodan)tempbd " +
					 "where tempbd.strkehu like '%"+req.getParameter("xingming").trim()+"%' order by tempbd.tbrq";
		Yuangong yuangong = (Yuangong) req.getSession().getAttribute("userinfo");
		if(yuangong==null){
			req.setAttribute("message", "µÇÂ¼³¬Ê±£¬ÇëÖØÐÂµÇÂ¼!");
			req.setAttribute("path", "/login.jsp");
			
	        String targetURL = "/success.jsp";
			dispatch(targetURL, req, res);
		}
		else{
			List bdList=new ArrayList();
			Object[] params={yuangong.getId()};
			DB mydb=new DB();
			try
			{
				mydb.doPstm(sql, params);
				ResultSet rs=mydb.getRs();
				while(rs.next())
				{
					baodan bd=new baodan();
					bd.setId(rs.getInt("id"));
					bd.setBianhao(rs.getString("bianhao"));
					bd.setStrLx(rs.getString("leixing"));
					bd.setStrKh(rs.getString("strkehu"));
					bd.setStrJfsx(rs.getString("jfsx"));
					bd.setJine(rs.getString("jine"));
					bd.setTbrq(rs.getString("tbrq"));
					bd.setShouyiren(rs.getString("shouyiren"));
					bd.setShouyirenxb(rs.getString("shouyirenxb"));
					bd.setGuanxi(rs.getString("guanxi"));
					bd.setShouyirensfz(rs.getString("shouyirensfz"));
					bd.setStrYuangong(rs.getString("yuangong"));
					bdList.add(bd);
				}
				rs.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			mydb.closed();
			
			req.setAttribute("xingming", req.getParameter("xingming").trim());
			req.setAttribute("bdList", bdList);
			req.getRequestDispatcher("/bdgl/bdglBrowse.jsp").forward(req, res);
		}
	}
	public void bdglBrowse(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{
		String sql = "select id,bianhao," +
					 "(select lxmc from t_baodanleixing tb where tb.id=leixing) leixing," +
					 "(select xingming from t_kehu tc where tc.id=kehu)kehu," +
					 "(select mingcheng from t_jcxx td where td.id=jfsx)jfsx,jine," +
					 "tbrq,shouyiren,shouyirenxb,guanxi,shouyirensfz ," +
					 "(select name from t_yuangong te where te.id=yuangong)yuangong "+
					 "from t_baodan order by tbrq";
		List bdList=new ArrayList();
		Object[] params={};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				baodan bd=new baodan();
				bd.setId(rs.getInt("id"));
				bd.setBianhao(rs.getString("bianhao"));
				bd.setStrLx(rs.getString("leixing"));
				bd.setStrKh(rs.getString("kehu"));
				bd.setStrJfsx(rs.getString("jfsx"));
				bd.setJine(rs.getString("jine"));
				bd.setTbrq(rs.getString("tbrq"));
				bd.setShouyiren(rs.getString("shouyiren"));
				bd.setShouyirenxb(rs.getString("shouyirenxb"));
				bd.setGuanxi(rs.getString("guanxi"));
				bd.setShouyirensfz(rs.getString("shouyirensfz"));
				bd.setStrYuangong(rs.getString("yuangong"));
				bdList.add(bd);
			}
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		req.setAttribute("bdList", bdList);
		req.getRequestDispatcher("/bdgl/bdglBrowse.jsp").forward(req, res);
	}
	public void bdglSearch(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{
		String sql = "select * from " +
					 "(select id,bianhao," +
					 "(select lxmc from t_baodanleixing tb where tb.id=leixing) leixing," +
					 "(select xingming from t_kehu tc where tc.id=kehu)strkehu," +
					 "(select mingcheng from t_jcxx td where td.id=jfsx)jfsx," +
					 "jine,tbrq,shouyiren,shouyirenxb,guanxi,shouyirensfz from t_baodan where yuangong=?)tempbd " +
					 "where tempbd.strkehu like '%"+req.getParameter("xingming").trim()+"%' order by tempbd.tbrq";
		Yuangong yuangong = (Yuangong) req.getSession().getAttribute("userinfo");
		if(yuangong==null){
			req.setAttribute("message", "µÇÂ¼³¬Ê±£¬ÇëÖØÐÂµÇÂ¼!");
			req.setAttribute("path", "/login.jsp");
			
	        String targetURL = "/success.jsp";
			dispatch(targetURL, req, res);
		}
		else{
			List bdList=new ArrayList();
			Object[] params={yuangong.getId()};
			DB mydb=new DB();
			try
			{
				mydb.doPstm(sql, params);
				ResultSet rs=mydb.getRs();
				while(rs.next())
				{
					baodan bd=new baodan();
					bd.setId(rs.getInt("id"));
					bd.setBianhao(rs.getString("bianhao"));
					bd.setStrLx(rs.getString("leixing"));
					bd.setStrKh(rs.getString("strkehu"));
					bd.setStrJfsx(rs.getString("jfsx"));
					bd.setJine(rs.getString("jine"));
					bd.setTbrq(rs.getString("tbrq"));
					bd.setShouyiren(rs.getString("shouyiren"));
					bd.setShouyirenxb(rs.getString("shouyirenxb"));
					bd.setGuanxi(rs.getString("guanxi"));
					bd.setShouyirensfz(rs.getString("shouyirensfz"));
					bdList.add(bd);
				}
				rs.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			mydb.closed();
			
			req.setAttribute("xingming", req.getParameter("xingming").trim());
			req.setAttribute("bdList", bdList);
			req.getRequestDispatcher("/bdgl/bdglMana.jsp").forward(req, res);
		}
	}
	public void bdglMana(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{
		String sql = "select id,bianhao," +
					 "(select lxmc from t_baodanleixing tb where tb.id=leixing) leixing," +
					 "(select xingming from t_kehu tc where tc.id=kehu)kehu," +
					 "(select mingcheng from t_jcxx td where td.id=jfsx)jfsx,jine," +
					 "tbrq,shouyiren,shouyirenxb,guanxi,shouyirensfz from t_baodan where yuangong=? order by tbrq";
		Yuangong yuangong = (Yuangong) req.getSession().getAttribute("userinfo");
		if(yuangong==null){
			req.setAttribute("message", "µÇÂ¼³¬Ê±£¬ÇëÖØÐÂµÇÂ¼!");
			req.setAttribute("path", "/login.jsp");
			
	        String targetURL = "/success.jsp";
			dispatch(targetURL, req, res);
		}
		else{
			List bdList=new ArrayList();
			Object[] params={yuangong.getId()};
			DB mydb=new DB();
			try
			{
				mydb.doPstm(sql, params);
				ResultSet rs=mydb.getRs();
				while(rs.next())
				{
					baodan bd=new baodan();
					bd.setId(rs.getInt("id"));
					bd.setBianhao(rs.getString("bianhao"));
					bd.setStrLx(rs.getString("leixing"));
					bd.setStrKh(rs.getString("kehu"));
					bd.setStrJfsx(rs.getString("jfsx"));
					bd.setJine(rs.getString("jine"));
					bd.setTbrq(rs.getString("tbrq"));
					bd.setShouyiren(rs.getString("shouyiren"));
					bd.setShouyirenxb(rs.getString("shouyirenxb"));
					bd.setGuanxi(rs.getString("guanxi"));
					bd.setShouyirensfz(rs.getString("shouyirensfz"));
					bdList.add(bd);
				}
				rs.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			mydb.closed();
			
			req.setAttribute("bdList", bdList);
			req.getRequestDispatcher("/bdgl/bdglMana.jsp").forward(req, res);
		}
	}
	public void bdglAdd(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{
		String bianhao = req.getParameter("bianhao");
		int kehu = Integer.parseInt(req.getParameter("kehu"));
		int leixing = Integer.parseInt(req.getParameter("leixing"));
		int jfsx = Integer.parseInt(req.getParameter("jfsx"));
		int jffs = Integer.parseInt(req.getParameter("jffs"));
		String jine = req.getParameter("jine");
		String shouyiren = req.getParameter("shouyiren");
		String tbrq = DateUtils.getShortStrDate();
		String shouyirenxb = req.getParameter("shouyirenxb");
		String guanxi = req.getParameter("guanxi");
		String shouyirensfz = req.getParameter("shouyirenxfz");
		
		Yuangong yuangong = (Yuangong) req.getSession().getAttribute("userinfo");
		if(yuangong==null){
			req.setAttribute("message", "µÇÂ¼³¬Ê±£¬ÇëÖØÐÂµÇÂ¼!");
			req.setAttribute("path", "/login.jsp");
			
	        String targetURL = "/success.jsp";
			dispatch(targetURL, req, res);
		}
		else{
			try{
				String sql = "insert into t_baodan values('"+bianhao+"',"+leixing+","+kehu+","+jfsx+",'"+jine+"'" +
							 ",'"+tbrq+"','"+shouyiren+"','"+shouyirenxb+"','"+guanxi+"','"+shouyirensfz+"'," +
							 		""+yuangong.getId()+")";
				
				Object[] params={};
				DB mydb=new DB();
				int bdid = mydb.doPstmGetId(sql, params);
				sql = "insert into t_jiaofei values("+bdid+",'"+tbrq+"','"+jine+"',"+jffs+")";
				mydb.doUpdate(sql, params);
				mydb.closed();
			}catch(Exception e){
				e.printStackTrace();
			}
			
			req.setAttribute("message", "²Ù×÷³É¹¦");
			req.setAttribute("path", "bdgl?type=bdglMana");
			
	        String targetURL = "/success.jsp";
			dispatch(targetURL, req, res);

		}
		
	}
	public void toAdd(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{
		List bdlxList=new ArrayList();
		List jfsxList=new ArrayList();
		List jffsList=new ArrayList();
		String sql = "select id,lxmc from t_baodanleixing where del=0";
		
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
				bdlxList.add(bdlx);
			}
			rs.close();
			
			sql = "select id,mingcheng from t_jcxx where leixing=2 and del=0";
			
			mydb.doPstm(sql, params);
			rs=mydb.getRs();
			while(rs.next())
			{
				jcxx jcxx=new jcxx();
				jcxx.setId(rs.getInt("id"));
				jcxx.setMingcheng(rs.getString("mingcheng"));
				jfsxList.add(jcxx);
			}
			
			sql = "select id,mingcheng from t_jcxx where leixing=1 and del=0";
			
			mydb.doPstm(sql, params);
			rs=mydb.getRs();
			while(rs.next())
			{
				jcxx jcxx=new jcxx();
				jcxx.setId(rs.getInt("id"));
				jcxx.setMingcheng(rs.getString("mingcheng"));
				jffsList.add(jcxx);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		req.setAttribute("bh", "ZB-"+DateUtils.getBhDate());
		req.setAttribute("jfsxList", jfsxList);
		req.setAttribute("jffsList", jffsList);
		req.setAttribute("bdlxList", bdlxList);
		req.getRequestDispatcher("/bdgl/bdglAdd.jsp").forward(req, res);
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
