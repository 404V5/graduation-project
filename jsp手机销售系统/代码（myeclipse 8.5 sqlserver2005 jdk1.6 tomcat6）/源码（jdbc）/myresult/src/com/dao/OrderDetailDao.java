

package com.dao;

import com.domain.OrderDetailForm;
import com.tool.JDBConnection;
import java.io.PrintStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDetailDao
{

    private Connection connection;
    private PreparedStatement ps;
    private JDBConnection jdbc;

    public OrderDetailDao()
    {
        connection = null;
        ps = null;
        jdbc = null;
        jdbc = new JDBConnection();
        connection = jdbc.connection;
    }

    public List selectOrderDetailNumber(String number)
    {
        List list = new ArrayList();
        OrderDetailForm orderDetail = null;
        try
        {
            ps = connection.prepareStatement("select * from tb_orderDetail where orderNumber=?");
            ps.setString(1, number);
            for(ResultSet rs = ps.executeQuery(); rs.next(); list.add(orderDetail))
            {
                orderDetail = new OrderDetailForm();
                orderDetail.setId(Integer.valueOf(rs.getString(1)));
                orderDetail.setOrderNumber(rs.getString(2));
                orderDetail.setGoodsId(Integer.valueOf(rs.getString(3)));
                orderDetail.setPrice(Float.parseFloat(rs.getString(4)));
                orderDetail.setNumber(Integer.parseInt(rs.getString(5)));
            }

        }
        catch(SQLException ex) { }
        return list;
    }

    public void insertOrderDetail(OrderDetailForm form)
    {
        try
        {
            ps = connection.prepareStatement("insert into tb_orderDetail values (?,?,?,?)");
            ps.setString(1, form.getOrderNumber());
            ps.setString(2, form.getGoodsId().toString());
            ps.setFloat(3, form.getPrice());
            ps.setInt(4, form.getNumber());
            ps.executeUpdate();
            ps.close();
        }
        catch(SQLException ex) { }
    }

    public void deleteOrderDetail(String number)
    {
        try
        {
            ps = connection.prepareStatement("delete from tb_orderDetail where orderNumber=?");
            System.out.println(number + "+3231+");
            ps.setString(1, number);
            ps.executeUpdate();
            ps.close();
        }
        catch(SQLException ex) { }
    }
}
