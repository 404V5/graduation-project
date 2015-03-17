
package com.dao;

import com.domain.GoodsForm;
import com.tool.JDBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GoodsDao
{

    private Connection connection;
    private PreparedStatement ps;
    private JDBConnection jdbc;

    public GoodsDao()
    {
        connection = null;
        ps = null;
        jdbc = null;
        jdbc = new JDBConnection();
        connection = jdbc.connection;
    }

    public void updateGoodsNumber(int number, Integer id)
    {
        try
        {
            ps = connection.prepareStatement("update tb_goods set number=number+? where id=?");
            ps.setInt(1, number);
            ps.setInt(2, id.intValue());
            ps.executeUpdate();
            ps.close();
        }
        catch(SQLException ex) { }
    }

    public void managerPrice(GoodsForm form)
    {
        try
        {
            ps = connection.prepareStatement("update tb_goods set freePrice=?,mark=? where id=?");
            ps.setFloat(1, form.getFreePrice().floatValue());
            ps.setInt(2, form.getMark().intValue());
            ps.setInt(3, form.getId().intValue());
            ps.executeUpdate();
            ps.close();
        }
        catch(SQLException ex) { }
    }

    public List selectMark(Integer mark)
    {
        List list = new ArrayList();
        GoodsForm goods = null;
        try
        {
            ps = connection.prepareStatement("select * from tb_goods where mark=? order by id DESC");
            ps.setInt(1, mark.intValue());
            for(ResultSet rs = ps.executeQuery(); rs.next(); list.add(goods))
            {
                goods = new GoodsForm();
                goods.setId(Integer.valueOf(rs.getString(1)));
                goods.setBig(Integer.valueOf(rs.getString(2)));
                goods.setSmall(Integer.valueOf(rs.getString(3)));
                goods.setName(rs.getString(4));
                goods.setFrom(rs.getString(5));
                goods.setIntroduce(rs.getString(6));
                goods.setCreaTime(rs.getString(7));
                goods.setNowPrice(Float.valueOf(rs.getString(8)));
                goods.setFreePrice(Float.valueOf(rs.getString(9)));
                goods.setNumber(Integer.valueOf(rs.getString(10)));
                goods.setPriture(rs.getString(11));
                goods.setMark(Integer.valueOf(rs.getString(12)));
            }

        }
        catch(SQLException ex) { }
        return list;
    }

    public void insertGoods(GoodsForm form)
    {
        try
        {
            ps = connection.prepareStatement("insert into tb_goods values (?,?,?,?,?,getDate(),?,?,?,?,?)");
            ps.setInt(1, form.getBig().intValue());
            ps.setInt(2, form.getSmall().intValue());
            ps.setString(3, form.getName());
            ps.setString(4, form.getFrom());
            ps.setString(5, form.getIntroduce());
            ps.setFloat(6, form.getNowPrice().floatValue());
            ps.setFloat(7, form.getFreePrice().floatValue());
            ps.setInt(8, 0);
            ps.setString(9, form.getPicture());
            ps.setInt(10, 0);
            ps.executeUpdate();
            ps.close();
        }
        catch(SQLException ex) { }
    }

    public void deleteGoods(Integer id)
    {
        try
        {
            ps = connection.prepareStatement("delete from tb_goods where id=?");
            ps.setInt(1, id.intValue());
            ps.executeUpdate();
            ps.close();
        }
        catch(SQLException ex) { }
    }

    public GoodsForm selectOneGoods(Integer id)
    {
        GoodsForm goods = null;
        try
        {
            ps = connection.prepareStatement("select * from tb_goods where id=? order by id DESC");
            ps.setInt(1, id.intValue());
            for(ResultSet rs = ps.executeQuery(); rs.next(); goods.setMark(Integer.valueOf(rs.getString(12))))
            {
                goods = new GoodsForm();
                goods.setId(Integer.valueOf(rs.getString(1)));
                goods.setBig(Integer.valueOf(rs.getString(2)));
                goods.setSmall(Integer.valueOf(rs.getString(3)));
                goods.setName(rs.getString(4));
                goods.setFrom(rs.getString(5));
                goods.setIntroduce(rs.getString(6));
                goods.setCreaTime(rs.getString(7));
                goods.setNowPrice(Float.valueOf(rs.getString(8)));
                goods.setFreePrice(Float.valueOf(rs.getString(9)));
                goods.setNumber(Integer.valueOf(rs.getString(10)));
                goods.setPriture(rs.getString(11));
            }

        }
        catch(SQLException ex) { }
        return goods;
    }

    public List selectSmall(Integer small)
    {
        List list = new ArrayList();
        GoodsForm goods = null;
        try
        {
            ps = connection.prepareStatement("select * from tb_goods where smallId=? order by id DESC");
            ps.setInt(1, small.intValue());
            for(ResultSet rs = ps.executeQuery(); rs.next(); list.add(goods))
            {
                goods = new GoodsForm();
                goods.setId(Integer.valueOf(rs.getString(1)));
                goods.setBig(Integer.valueOf(rs.getString(2)));
                goods.setSmall(Integer.valueOf(rs.getString(3)));
                goods.setName(rs.getString(4));
                goods.setFrom(rs.getString(5));
                goods.setIntroduce(rs.getString(6));
                goods.setCreaTime(rs.getString(7));
                goods.setNowPrice(Float.valueOf(rs.getString(8)));
                goods.setFreePrice(Float.valueOf(rs.getString(9)));
                goods.setNumber(Integer.valueOf(rs.getString(10)));
                goods.setPriture(rs.getString(11));
                goods.setMark(Integer.valueOf(rs.getString(12)));
            }

        }
        catch(SQLException ex) { }
        return list;
    }

    public List selectBig(Integer big)
    {
        List list = new ArrayList();
        GoodsForm goods = null;
        try
        {
            ps = connection.prepareStatement("select * from tb_goods where bigId=? order by id DESC");
            ps.setInt(1, big.intValue());
            for(ResultSet rs = ps.executeQuery(); rs.next(); list.add(goods))
            {
                goods = new GoodsForm();
                goods.setId(Integer.valueOf(rs.getString(1)));
                goods.setBig(Integer.valueOf(rs.getString(2)));
                goods.setSmall(Integer.valueOf(rs.getString(3)));
                goods.setName(rs.getString(4));
                goods.setFrom(rs.getString(5));
                goods.setIntroduce(rs.getString(6));
                goods.setCreaTime(rs.getString(7));
                goods.setNowPrice(Float.valueOf(rs.getString(8)));
                goods.setFreePrice(Float.valueOf(rs.getString(9)));
                goods.setNumber(Integer.valueOf(rs.getString(10)));
                goods.setPriture(rs.getString(11));
                goods.setMark(Integer.valueOf(rs.getString(12)));
            }

        }
        catch(SQLException ex) { }
        return list;
    }

    public List selectGoods()
    {
        List list = new ArrayList();
        GoodsForm goods = null;
        try
        {
            ps = connection.prepareStatement("select * from tb_goods order by id DESC");
            for(ResultSet rs = ps.executeQuery(); rs.next(); list.add(goods))
            {
                goods = new GoodsForm();
                goods.setId(Integer.valueOf(rs.getString(1)));
                goods.setBig(Integer.valueOf(rs.getString(2)));
                goods.setSmall(Integer.valueOf(rs.getString(3)));
                goods.setName(rs.getString(4));
                goods.setFrom(rs.getString(5));
                goods.setIntroduce(rs.getString(6));
                goods.setCreaTime(rs.getString(7));
                goods.setNowPrice(Float.valueOf(rs.getString(8)));
                goods.setFreePrice(Float.valueOf(rs.getString(9)));
                goods.setNumber(Integer.valueOf(rs.getString(10)));
                goods.setPriture(rs.getString(11));
                goods.setMark(Integer.valueOf(rs.getString(12)));
            }

        }
        catch(SQLException ex) { }
        return list;
    }

    public List selectGoodsNumber()
    {
        List list = new ArrayList();
        GoodsForm goods = null;
        try
        {
            ps = connection.prepareStatement("select * from tb_goods order by number DESC");
            for(ResultSet rs = ps.executeQuery(); rs.next(); list.add(goods))
            {
                goods = new GoodsForm();
                goods.setId(Integer.valueOf(rs.getString(1)));
                goods.setBig(Integer.valueOf(rs.getString(2)));
                goods.setSmall(Integer.valueOf(rs.getString(3)));
                goods.setName(rs.getString(4));
                goods.setFrom(rs.getString(5));
                goods.setIntroduce(rs.getString(6));
                goods.setCreaTime(rs.getString(7));
                goods.setNowPrice(Float.valueOf(rs.getString(8)));
                goods.setFreePrice(Float.valueOf(rs.getString(9)));
                goods.setNumber(Integer.valueOf(rs.getString(10)));
                goods.setPriture(rs.getString(11));
                goods.setMark(Integer.valueOf(rs.getString(12)));
            }

        }
        catch(SQLException ex) { }
        return list;
    }
}
