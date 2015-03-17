

package com.dao;

import com.domain.AfficheForm;
import com.tool.JDBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AfficheDao
{

    private Connection connection;
    private PreparedStatement ps;
    private JDBConnection jdbc;

    public AfficheDao()
    {
        connection = null;
        ps = null;
        jdbc = null;
        jdbc = new JDBConnection();
        connection = jdbc.connection;
    }

    public void deleteAffiche(Integer id)
    {
        try
        {
            ps = connection.prepareStatement("delete from tb_affiche where id=?");
            ps.setInt(1, id.intValue());
            ps.executeUpdate();
            ps.close();
        }
        catch(SQLException ex) { }
    }

    public void updateAffiche(AfficheForm form)
    {
        try
        {
            ps = connection.prepareStatement("update tb_affiche set name=?,content=? where id=?");
            ps.setString(1, form.getName());
            ps.setString(2, form.getContent());
            ps.setInt(3, form.getId().intValue());
            ps.executeUpdate();
            ps.close();
        }
        catch(SQLException ex) { }
    }

    public void insertAffiche(AfficheForm form)
    {
        try
        {
            ps = connection.prepareStatement("insert into tb_affiche values (?,?,getDate())");
            ps.setString(1, form.getName());
            ps.setString(2, form.getContent());
            ps.executeUpdate();
            ps.close();
        }
        catch(SQLException ex) { }
    }

    public AfficheForm selectOneAffiche(Integer id)
    {
        AfficheForm affiche = null;
        try
        {
            ps = connection.prepareStatement("select * from tb_affiche where id=?");
            ps.setInt(1, id.intValue());
            for(ResultSet rs = ps.executeQuery(); rs.next(); affiche.setIssueTime(rs.getString(4)))
            {
                affiche = new AfficheForm();
                affiche.setId(Integer.valueOf(rs.getString(1)));
                affiche.setName(rs.getString(2));
                affiche.setContent(rs.getString(3));
            }

        }
        catch(SQLException ex) { }
        return affiche;
    }

    public List selectAffiche()
    {
        List list = new ArrayList();
        AfficheForm affiche = null;
        try
        {
            ps = connection.prepareStatement("select * from tb_affiche order by id DESC");
            for(ResultSet rs = ps.executeQuery(); rs.next(); list.add(affiche))
            {
                affiche = new AfficheForm();
                affiche.setId(Integer.valueOf(rs.getString(1)));
                affiche.setName(rs.getString(2));
                affiche.setContent(rs.getString(3));
                affiche.setIssueTime(rs.getString(4));
            }

        }
        catch(SQLException ex) { }
        return list;
    }
}
