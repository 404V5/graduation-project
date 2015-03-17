package com.bdglxt.service;

import java.sql.ResultSet;

import com.bdglxt.dao.DB;

public class JcxxlxService {
	public String getJcxxlxName(String leixing){
		String name = "";
		String sql="select mingcheng from t_jcxxlx where id=?";
		Object[] params={Integer.parseInt(leixing)};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				name = rs.getString("mingcheng");
			}
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return name;
	}
}
