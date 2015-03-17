

package com.webtier;

import com.dao.LinkDao;
import com.domain.LinkForm;
import com.tool.Chinese;
import java.io.UnsupportedEncodingException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.*;

public class LinkAction extends Action
{

    private LinkDao dao;
    private int action;

    public LinkAction()
    {
        dao = null;
    }

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
        throws UnsupportedEncodingException
    {
        request.setCharacterEncoding("gb2312");
        action = Integer.parseInt(request.getParameter("action"));
        dao = new LinkDao();
        switch(action)
        {
        case 0: // '\0'
            return linkSelect(mapping, form, request, response);

        case 1: // '\001'
            return linkForward(mapping, form, request, response);

        case 2: // '\002'
            return linkInsertForwardOne(mapping, form, request, response);

        case 3: // '\003'
            return linkInsert(mapping, form, request, response);

        case 4: // '\004'
            return linkDelete(mapping, form, request, response);
        }
        throw new UnsupportedOperationException("Method $execute() not yet implemented.");
    }

    public ActionForward linkDelete(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    {
        String path = request.getParameter("path");
        dao.deleteLink(Integer.valueOf(request.getParameter("id")));
        request.setAttribute("success", "删除连接网站信息成功");
        return mapping.findForward("linkOperation");
    }

    public ActionForward linkInsert(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    {
        LinkForm linkForm = (LinkForm)form;
        linkForm.setLinkAddress(Chinese.chinese(request.getParameter("address")));
        linkForm.setLinkName(Chinese.chinese(request.getParameter("name")));
        linkForm.setLinkPicture(Chinese.chinese(request.getParameter("path")));
        dao.insertLink(linkForm);
        request.setAttribute("success", "添加连接网站信息成功");
        return mapping.findForward("linkOperation");
    }

    public ActionForward linkInsertForwardOne(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    {
        String name = Chinese.chinese(request.getParameter("name"));
        String address = Chinese.chinese(request.getParameter("address"));
        LinkForm linkName = dao.selectOneName(name);
        LinkForm linkAddress = dao.selectOneAddress(address);
        if(linkName != null)
            request.setAttribute("result", "此网站的名称已经存在");
        else
        if(linkAddress != null)
            request.setAttribute("result", "此网站的地址已经存在");
        return mapping.findForward("linkInsertForwardOne");
    }

    public ActionForward linkSelect(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    {
        List list = dao.selectLink();
        int pageNumber = list.size();
        int maxPage = pageNumber;
        String number = request.getParameter("i");
        if(maxPage % 7 == 0)
            maxPage /= 7;
        else
            maxPage = maxPage / 7 + 1;
        if(number == null)
            number = "0";
        request.setAttribute("number", String.valueOf(number));
        request.setAttribute("maxPage", String.valueOf(maxPage));
        request.setAttribute("pageNumber", String.valueOf(pageNumber));
        request.setAttribute("list", list);
        return mapping.findForward("linkSelect");
    }

    public ActionForward linkForward(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    {
        return mapping.findForward("linkForward");
    }
}
