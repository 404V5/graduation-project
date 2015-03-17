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
import com.bdglxt.orm.baodan;
import com.bdglxt.orm.jcxx;
import com.bdglxt.orm.jiaofei;
import com.bdglxt.util.DateUtils;

public class jiaofei_servlet extends HttpServlet{
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException 
	{
		String type=req.getParameter("type");
		
		if(type.endsWith("jfglMana")){
			jfglMana(req, res);
		}
		if(type.endsWith("jfglBrowse")){
			jfglBrowse(req, res);
		}
		if(type.endsWith("jfglAdd")){
			jfglAdd(req, res);
		}
	}
	public void jfglAdd(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{
		String bdid = req.getParameter("bdid");
		String jine = req.getParameter("jine");
		String jfrq = DateUtils.getShortStrDate();
		String jffs = req.getParameter("jffs");
		
		String sql = "insert into t_jiaofei values (?,?,?,?)";
		Object[] params={Integer.parseInt(bdid),jfrq,jine,Integer.parseInt(jffs)};
		DB mydb=new DB();
		mydb.doUpdate(sql, params);
		mydb.closed();
		
		req.setAttribute("message", "操作成功");
		req.setAttribute("path", "jfxx?type=jfglMana&bdid="+bdid);
        String targetURL = "/success.jsp";
		dispatch(targetURL, req, res);
	}
	
	public void jfglBrowse(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{
		String strBdid = req.getParameter("bdid");
		if(strBdid==null || "".equals(strBdid)){
			req.setAttribute("message", "参数错误!");
			req.setAttribute("path", "bdgl?type=bdglMana");
			
	        String targetURL = "/success.jsp";
			dispatch(targetURL, req, res);
		}
		else{
			String sql = "select jfrq,jfje," +
						 "(select mingcheng from t_jcxx tb where tb.id=jffs)jffs"+
						 " from t_jiaofei where bdid=? order by jfrq desc";
			
			List jfxxList=new ArrayList();
			Object[] params={Integer.parseInt(strBdid)};
			DB mydb=new DB();
			try
			{
				mydb.doPstm(sql, params);
				ResultSet rs=mydb.getRs();
				while(rs.next())
				{
					jiaofei jf=new jiaofei();
					jf.setJfrq(rs.getString("jfrq"));
					jf.setJfje(rs.getString("jfje"));
					jf.setStrJffs(rs.getString("jffs"));
					jfxxList.add(jf);
				}
				rs.close();
				
				sql = "select bianhao," +
					  "(select lxmc from t_baodanleixing tb where tb.id=leixing) leixing," +
					  "(select xingming from t_kehu tc where tc.id=tb.kehu)strkehu " +
					  "from t_baodan tb where id=?";
				
				mydb.doPstm(sql, params);
				rs=mydb.getRs();
				rs.next();
				baodan bd=new baodan();
				bd.setBianhao(rs.getString("bianhao"));
				bd.setStrLx(rs.getString("leixing"));
				bd.setStrKh(rs.getString("strkehu"));
				rs.close();
				
				req.setAttribute("bdinfo", bd);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			mydb.closed();
			
			req.setAttribute("bdid", strBdid);
			req.setAttribute("jfxxList", jfxxList);
			req.getRequestDispatcher("/jiaofei/jiaofeiBrowse.jsp").forward(req, res);
		}
	}
	public void jfglMana(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{
		List jffsList=new ArrayList();
		String strBdid = req.getParameter("bdid");
		if(strBdid==null || "".equals(strBdid)){
			req.setAttribute("message", "参数错误!");
			req.setAttribute("path", "bdgl?type=bdglMana");
			
	        String targetURL = "/success.jsp";
			dispatch(targetURL, req, res);
		}
		else{
			String sql = "select jfrq,jfje," +
						 "(select mingcheng from t_jcxx tb where tb.id=jffs)jffs"+
						 " from t_jiaofei where bdid=? order by jfrq desc";
			
			List jfxxList=new ArrayList();
			Object[] params={Integer.parseInt(strBdid)};
			DB mydb=new DB();
			try
			{
				mydb.doPstm(sql, params);
				ResultSet rs=mydb.getRs();
				while(rs.next())
				{
					jiaofei jf=new jiaofei();
					jf.setJfrq(rs.getString("jfrq"));
					jf.setJfje(rs.getString("jfje"));
					jf.setStrJffs(rs.getString("jffs"));
					jfxxList.add(jf);
				}
				rs.close();
				
				sql = "select bianhao," +
					  "(select lxmc from t_baodanleixing tb where tb.id=leixing) leixing," +
					  "(select xingming from t_kehu tc where tc.id=tb.kehu)strkehu " +
					  "from t_baodan tb where id=?";
				
				mydb.doPstm(sql, params);
				rs=mydb.getRs();
				rs.next();
				baodan bd=new baodan();
				bd.setBianhao(rs.getString("bianhao"));
				bd.setStrLx(rs.getString("leixing"));
				bd.setStrKh(rs.getString("strkehu"));
				rs.close();
				
				req.setAttribute("bdinfo", bd);
				
				Object[] params1={};
				sql = "select id,mingcheng from t_jcxx where leixing=1 and del=0";
				
				mydb.doPstm(sql, params1);
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
			
			req.setAttribute("bdid", strBdid);
			req.setAttribute("jffsList", jffsList);
			req.setAttribute("jfxxList", jfxxList);
			req.getRequestDispatcher("/jiaofei/jiaofeiMana.jsp").forward(req, res);
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
