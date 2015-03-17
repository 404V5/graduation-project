
package com.dao;

import com.domain.SmallTypeForm;
import com.tool.JDBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SmallTypeDao
{

    private Connection connection;
    private PreparedStatement ps;
    private JDBConnection jdbc;

    public SmallTypeDao()
    {
        connection = null;
        ps = null;
        jdbc = null;
        jdbc = new JDBConnection();
        connection = jdbc.connection;
    }

    public List selectOneBigId(Integer bigId)
    {
        List list = new ArrayList();
        SmallTypeForm small = null;
        try
        {
            ps = connection.prepareStatement("select * from tb_smallType where bigId=?");
            ps.setString(1, bigId.toString());
            for(ResultSet rs = ps.executeQuery(); rs.next(); list.add(small))
            {
                small = new SmallTypeForm();
                small.setId(Integer.valueOf(rs.getString(1)));
                small.setBigId(Integer.valueOf(rs.getString(2)));
                small.setSmallName(rs.getString(3));
                small.setCreaTime(rs.getString(4));
            }

        }
        catch(SQLException ex) { }
        return list;
    }

    public String selectName(Integer id)
    {
        String name = null;
        try
        {
            ps = connection.prepareStatement("select * from tb_smallType where id=?");
            ps.setString(1, id.toString());
            for(ResultSet rs = ps.executeQuery(); rs.next();)
                name = rs.getString("smallName");

        }
        catch(SQLException ex) { }
        return name;
    }

    public boolean deleteSmall(Integer id) throws SQLException
    {
        ps = connection.prepareStatement("delete from tb_smallType where id=?");
        ps.setString(1, id.toString());
        ps.executeUpdate();
        ps.close();
        return true;
    }

    public void updateSmall(SmallTypeForm form)
    {
        try
        {
            ps = connection.prepareStatement("update tb_smallType set bigId=?,smallName=? where id=?");
            ps.setString(1, form.getBigId().toString());
            ps.setString(2, form.getSmallName());
            ps.setString(3, form.getId().toString());
            ps.executeUpdate();
            ps.close();
        }
        catch(SQLException ex) { }
    }

    public void insertSmall(SmallTypeForm form)
    {
        try
        {
            ps = connection.prepareStatement("insert into tb_smallType values (?,?,getDate())");
            ps.setString(1, form.getBigId().toString());
            ps.setString(2, form.getSmallName());
            ps.executeUpdate();
            ps.close();
        }
        catch(SQLException ex) { }
    }

    public SmallTypeForm selectOneBig(Integer id)
    {
        SmallTypeForm small = null;
        try
        {
            ps = connection.prepareStatement("select * from tb_smallType where id=?");
            ps.setString(1, id.toString());
            for(ResultSet rs = ps.executeQuery(); rs.next(); small.setCreaTime(rs.getString(4)))
            {
                small = new SmallTypeForm();
                small.setId(Integer.valueOf(rs.getString(1)));
                small.setBigId(Integer.valueOf(rs.getString(2)));
                small.setSmallName(rs.getString(3));
            }

        }
        catch(SQLException ex) { }
        return small;
    }

    public List selectSmall()
    {
        List list = new ArrayList();
        SmallTypeForm small = null;
        try
        {
            ps = connection.prepareStatement("select * from tb_smallType order by id DESC");
            for(ResultSet rs = ps.executeQuery(); rs.next(); list.add(small))
            {
                small = new SmallTypeForm();
                small.setId(Integer.valueOf(rs.getString(1)));
                small.setBigId(Integer.valueOf(rs.getString(2)));
                small.setSmallName(rs.getString(3));
                small.setCreaTime(rs.getString(4));
            }

        }
        catch(SQLException ex) { }
        return list;
    }
}
