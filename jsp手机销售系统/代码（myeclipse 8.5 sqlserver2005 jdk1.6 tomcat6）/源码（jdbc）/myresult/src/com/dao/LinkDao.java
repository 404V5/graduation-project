

package com.dao;

import com.domain.LinkForm;
import com.tool.JDBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LinkDao
{

    private Connection connection;
    private PreparedStatement ps;
    private JDBConnection jdbc;

    public LinkDao()
    {
        connection = null;
        ps = null;
        jdbc = null;
        jdbc = new JDBConnection();
        connection = jdbc.connection;
    }

    public void deleteLink(Integer id)
    {
        try
        {
            ps = connection.prepareStatement("delete from tb_link where id=?");
            ps.setInt(1, id.intValue());
            ps.executeUpdate();
            ps.close();
        }
        catch(SQLException ex) { }
    }

    public void insertLink(LinkForm form)
    {
        try
        {
            ps = connection.prepareStatement("insert into tb_link values (?,?,?,getDate())");
            ps.setString(1, form.getLinkName());
            ps.setString(2, form.getLinkAddress());
            ps.setString(3, form.getLinkPicture());
            ps.executeUpdate();
            ps.close();
        }
        catch(SQLException ex) { }
    }

    public LinkForm selectOneLink(Integer id)
    {
        LinkForm link = null;
        try
        {
            ps = connection.prepareStatement("select * from tb_link where id=?");
            ps.setInt(1, id.intValue());
            for(ResultSet rs = ps.executeQuery(); rs.next(); link.setLinkTime(rs.getString(5)))
            {
                link = new LinkForm();
                link.setId(Integer.valueOf(rs.getString(1)));
                link.setLinkName(rs.getString(2));
                link.setLinkAddress(rs.getString(3));
                link.setLinkPicture(rs.getString(4));
            }

        }
        catch(SQLException ex) { }
        return link;
    }

    public LinkForm selectOneAddress(String address)
    {
        LinkForm link = null;
        try
        {
            ps = connection.prepareStatement("select * from tb_link where linkAddress=?");
            ps.setString(1, address);
            for(ResultSet rs = ps.executeQuery(); rs.next(); link.setLinkTime(rs.getString(5)))
            {
                link = new LinkForm();
                link.setId(Integer.valueOf(rs.getString(1)));
                link.setLinkName(rs.getString(2));
                link.setLinkAddress(rs.getString(3));
                link.setLinkPicture(rs.getString(4));
            }

        }
        catch(SQLException ex) { }
        return link;
    }

    public LinkForm selectOneName(String name)
    {
        LinkForm link = null;
        try
        {
            ps = connection.prepareStatement("select * from tb_link where linkName=?");
            ps.setString(1, name);
            for(ResultSet rs = ps.executeQuery(); rs.next(); link.setLinkTime(rs.getString(5)))
            {
                link = new LinkForm();
                link.setId(Integer.valueOf(rs.getString(1)));
                link.setLinkName(rs.getString(2));
                link.setLinkAddress(rs.getString(3));
                link.setLinkPicture(rs.getString(4));
            }

        }
        catch(SQLException ex) { }
        return link;
    }

    public List selectLink()
    {
        List list = new ArrayList();
        LinkForm link = null;
        try
        {
            ps = connection.prepareStatement("select * from tb_link order by id DESC");
            for(ResultSet rs = ps.executeQuery(); rs.next(); list.add(link))
            {
                link = new LinkForm();
                link.setId(Integer.valueOf(rs.getString(1)));
                link.setLinkName(rs.getString(2));
                link.setLinkAddress(rs.getString(3));
                link.setLinkPicture(rs.getString(4));
                link.setLinkTime(rs.getString(5));
            }

        }
        catch(SQLException ex) { }
        return list;
    }
}
