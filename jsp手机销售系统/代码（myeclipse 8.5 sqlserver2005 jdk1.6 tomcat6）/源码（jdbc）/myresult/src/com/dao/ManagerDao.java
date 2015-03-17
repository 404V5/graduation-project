

package com.dao;

import com.domain.ManagerForm;
import com.tool.JDBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ManagerDao
{

    private Connection connection;
    private PreparedStatement ps;
    private JDBConnection jdbc;

    public ManagerDao()
    {
        connection = null;
        ps = null;
        jdbc = null;
        jdbc = new JDBConnection();
        connection = jdbc.connection;
    }

    public void insertManager(ManagerForm form)
    {
        try
        {
            ps = connection.prepareStatement("insert into tb_manager values (?,?,?,?)");
            ps.setString(1, form.getAccount());
            ps.setString(2, form.getPassword());
            ps.setString(3, form.getName());
            ps.setInt(4, 0);
            ps.executeUpdate();
            ps.close();
        }
        catch(SQLException ex) { }
    }

    public void updateManagerPassword(ManagerForm form)
    {
        try
        {
            ps = connection.prepareStatement("update tb_manager set password=? where account=?");
            ps.setString(1, form.getPassword());
            ps.setString(2, form.getAccount());
            ps.executeUpdate();
            ps.close();
        }
        catch(SQLException ex) { }
    }

    public void updateManager(ManagerForm form)
    {
        try
        {
            ps = connection.prepareStatement("update tb_manager set account=?,password=?,name=? where id=?");
            ps.setString(1, form.getAccount());
            ps.setString(2, form.getPassword());
            ps.setString(3, form.getName());
            ps.setInt(4, form.getId().intValue());
            ps.executeUpdate();
            ps.close();
        }
        catch(SQLException ex) { }
    }

    public void deleteManager(Integer id)
    {
        try
        {
            ps = connection.prepareStatement("delete from tb_manager where id=?");
            ps.setInt(1, id.intValue());
            ps.executeUpdate();
            ps.close();
        }
        catch(SQLException ex) { }
    }

    public List selectManager()
    {
        List list = new ArrayList();
        ManagerForm manager = null;
        try
        {
            ps = connection.prepareStatement("select * from tb_manager order by id DESC");
            for(ResultSet rs = ps.executeQuery(); rs.next(); list.add(manager))
            {
                manager = new ManagerForm();
                manager.setId(Integer.valueOf(rs.getString(1)));
                manager.setAccount(rs.getString(2));
                manager.setPassword(rs.getString(3));
                manager.setName(rs.getString(4));
                manager.setSigh(Integer.valueOf(rs.getString(5)));
            }

        }
        catch(SQLException ex) { }
        return list;
    }

    public ManagerForm selectOne(String account)
    {
        ManagerForm manager = null;
        try
        {
            ps = connection.prepareStatement("select * from tb_manager where account=?");
            ps.setString(1, account);
            for(ResultSet rs = ps.executeQuery(); rs.next(); manager.setSigh(Integer.valueOf(rs.getString(5))))
            {
                manager = new ManagerForm();
                manager.setId(Integer.valueOf(rs.getString(1)));
                manager.setAccount(rs.getString(2));
                manager.setPassword(rs.getString(3));
                manager.setName(rs.getString(4));
            }

        }
        catch(SQLException ex) { }
        return manager;
    }

    public String selectPassword(String account)
    {
        String password = "";
        try
        {
            ps = connection.prepareStatement("select * from tb_manager where account=?");
            ps.setString(1, account);
            for(ResultSet rs = ps.executeQuery(); rs.next(); ps.close())
                password = rs.getString("password");

        }
        catch(SQLException ex) { }
        return password;
    }
}
