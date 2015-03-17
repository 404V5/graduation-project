

package com.dao;

import com.domain.BigTypeForm;
import com.tool.JDBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BigTypeDao
{

    private Connection connection;
    private PreparedStatement ps;
    private JDBConnection jdbc;

    public BigTypeDao()
    {
        connection = null;
        ps = null;
        jdbc = null;
        jdbc = new JDBConnection();
        connection = jdbc.connection;
    }

    public String selectName(Integer id)
    {
        String name = null;
        try
        {
            ps = connection.prepareStatement("select * from tb_bigType where id=?");
            ps.setString(1, id.toString());
            for(ResultSet rs = ps.executeQuery(); rs.next();)
                name = rs.getString("bigName");

        }
        catch(SQLException ex) { }
        return name;
    }

    public boolean deleteBig(Integer id) throws SQLException
    {
        ps = connection.prepareStatement("delete from tb_bigType where id=?");
        ps.setString(1, id.toString());
        ps.executeUpdate();
        ps.close();
        return true;
    }

    public void updateBig(BigTypeForm form)
    {
        try
        {
            ps = connection.prepareStatement("update tb_bigType set bigName=? where id=?");
            ps.setString(1, form.getBigName());
            ps.setString(2, form.getId().toString());
            ps.executeUpdate();
            ps.close();
        }
        catch(SQLException ex) { }
    }

    public void insertBig(String name)
    {
        try
        {
            ps = connection.prepareStatement("insert into tb_bigType values (?,getDate())");
            ps.setString(1, name);
            ps.executeUpdate();
            ps.close();
        }
        catch(SQLException ex) { }
    }

    public BigTypeForm selectOneBig(Integer id)
    {
        BigTypeForm big = null;
        try
        {
            ps = connection.prepareStatement("select * from tb_bigType where id=?");
            ps.setString(1, id.toString());
            for(ResultSet rs = ps.executeQuery(); rs.next(); big.setCreaTime(rs.getString(3)))
            {
                big = new BigTypeForm();
                big.setId(Integer.valueOf(rs.getString(1)));
                big.setBigName(rs.getString(2));
            }

        }
        catch(SQLException ex) { }
        return big;
    }

    public List selectBig()
    {
        List list = new ArrayList();
        BigTypeForm big = null;
        try
        {
            ps = connection.prepareStatement("select * from tb_bigType order by id DESC");
            for(ResultSet rs = ps.executeQuery(); rs.next(); list.add(big))
            {
                big = new BigTypeForm();
                big.setId(Integer.valueOf(rs.getString(1)));
                big.setBigName(rs.getString(2));
                big.setCreaTime(rs.getString(3));
            }

        }
        catch(SQLException ex) { }
        return list;
    }
}
