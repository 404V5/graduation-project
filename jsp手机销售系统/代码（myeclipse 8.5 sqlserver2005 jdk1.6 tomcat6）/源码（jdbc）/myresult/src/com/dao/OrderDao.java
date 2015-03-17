
package com.dao;

import com.domain.OrderForm;
import com.tool.JDBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDao
{

    private Connection connection;
    private PreparedStatement ps;
    private JDBConnection jdbc;

    public OrderDao()
    {
        connection = null;
        ps = null;
        jdbc = null;
        jdbc = new JDBConnection();
        connection = jdbc.connection;
    }

    public List selectOrderHead(String name)
    {
        List list = new ArrayList();
        OrderForm order = null;
        try
        {
            ps = connection.prepareStatement("select * from tb_order where name=?");
            ps.setString(1, name);
            for(ResultSet rs = ps.executeQuery(); rs.next(); list.add(order))
            {
                order = new OrderForm();
                order.setId(Integer.valueOf(rs.getString(1)));
                order.setNumber(rs.getString(2));
                order.setName(rs.getString(3));
                order.setReallyName(rs.getString(4));
                order.setAddress(rs.getString(5));
                order.setTel(rs.getString(6));
                order.setSetMoney(rs.getString(7));
                order.setPost(rs.getString(8));
                order.setBz(rs.getString(9));
                order.setSign(rs.getString(10));
                order.setCreaTime(rs.getString(11));
            }

        }
        catch(SQLException ex) { }
        return list;
    }

    public OrderForm selectOrderNumber(String number)
    {
        OrderForm order = null;
        try
        {
            ps = connection.prepareStatement("select * from tb_order where number=?");
            ps.setString(1, number);
            for(ResultSet rs = ps.executeQuery(); rs.next(); order.setCreaTime(rs.getString(11)))
            {
                order = new OrderForm();
                order.setId(Integer.valueOf(rs.getString(1)));
                order.setNumber(rs.getString(2));
                order.setName(rs.getString(3));
                order.setReallyName(rs.getString(4));
                order.setAddress(rs.getString(5));
                order.setTel(rs.getString(6));
                order.setSetMoney(rs.getString(7));
                order.setPost(rs.getString(8));
                order.setBz(rs.getString(9));
                order.setSign(rs.getString(10));
            }

        }
        catch(SQLException ex) { }
        return order;
    }

    public void updateSignOrder(String number)
    {
        try
        {
            ps = connection.prepareStatement("update tb_order set sign=1 where number=?");
            ps.setString(1, number);
            ps.executeUpdate();
            ps.close();
        }
        catch(SQLException ex) { }
    }

    public boolean deleteOrder(String number) throws SQLException
    {
        ps = connection.prepareStatement("delete from tb_order where number=?");
        ps.setString(1, number);
        ps.executeUpdate();
        ps.close();
        return true;
    }

    public List selectOrderSign(Integer id)
    {
        List list = new ArrayList();
        OrderForm order = null;
        try
        {
            if(id == null)
            {
                ps = connection.prepareStatement("select * from tb_order order by id DESC");
            } else
            {
                ps = connection.prepareStatement("select * from tb_order where sign=? order by id DESC");
                ps.setInt(1, id.intValue());
            }
            for(ResultSet rs = ps.executeQuery(); rs.next(); list.add(order))
            {
                order = new OrderForm();
                order.setId(Integer.valueOf(rs.getString(1)));
                order.setNumber(rs.getString(2));
                order.setName(rs.getString(3));
                order.setReallyName(rs.getString(4));
                order.setAddress(rs.getString(5));
                order.setTel(rs.getString(6));
                order.setSetMoney(rs.getString(7));
                order.setPost(rs.getString(8));
                order.setBz(rs.getString(9));
                order.setSign(rs.getString(10));
                order.setCreaTime(rs.getString(11));
            }

        }
        catch(SQLException ex) { }
        return list;
    }

    public void insertOrderDetail(OrderForm form)
    {
        try
        {
            ps = connection.prepareStatement("insert into tb_order values (?,?,?,?,?,?,?,?,?,getDate())");
            ps.setString(1, form.getNumber());
            ps.setString(2, form.getName());
            ps.setString(3, form.getReallyName());
            ps.setString(4, form.getAddress());
            ps.setString(5, form.getTel());
            ps.setString(6, form.getSetMoney());
            ps.setString(7, form.getPost());
            ps.setString(8, form.getBz());
            ps.setString(9, form.getSign());
            ps.executeUpdate();
            ps.close();
        }
        catch(SQLException ex) { }
    }
}
