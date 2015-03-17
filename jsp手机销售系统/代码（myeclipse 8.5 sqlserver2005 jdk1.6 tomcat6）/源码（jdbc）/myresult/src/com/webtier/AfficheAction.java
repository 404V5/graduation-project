

package com.webtier;

import com.dao.AfficheDao;
import com.domain.AfficheForm;
import com.tool.Chinese;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.*;

public class AfficheAction extends Action
{

    private AfficheDao dao;
    private int action;

    public AfficheAction()
    {
        dao = null;
    }

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    {
        dao = new AfficheDao();
        action = Integer.parseInt(request.getParameter("action"));
        switch(action)
        {
        case 0: // '\0'
            return afficheSelect(mapping, form, request, response);

        case 1: // '\001'
            return afficheForward(mapping, form, request, response);

        case 2: // '\002'
            return afficheInsert(mapping, form, request, response);

        case 3: // '\003'
            return afficheDelete(mapping, form, request, response);

        case 4: // '\004'
            return afficheSelectOne(mapping, form, request, response);

        case 5: // '\005'
            return afficheUpdate(mapping, form, request, response);

        case 6: // '\006'
            return afficheContent(mapping, form, request, response);
        }
        throw new UnsupportedOperationException("Method $execute() not yet implemented.");
    }

    public ActionForward afficheContent(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    {
        request.setAttribute("affiche", dao.selectOneAffiche(Integer.valueOf(request.getParameter("id"))));
        return mapping.findForward("afficheContent");
    }

    public ActionForward afficheSelectOne(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    {
        request.setAttribute("affiche", dao.selectOneAffiche(Integer.valueOf(request.getParameter("id"))));
        return mapping.findForward("afficheSelectOne");
    }

    public ActionForward afficheUpdate(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    {
        AfficheForm afficheForm = (AfficheForm)form;
        afficheForm.setName(Chinese.chinese(request.getParameter("name")));
        afficheForm.setContent(Chinese.chinese(request.getParameter("content")));
        afficheForm.setId(Integer.valueOf(request.getParameter("id")));
        dao.updateAffiche(afficheForm);
        request.setAttribute("success", "修改公告信息成功！！！");
        return mapping.findForward("afficheOperation");
    }

    public ActionForward afficheSelect(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    {
        List list = dao.selectAffiche();
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
        return mapping.findForward("afficheSelect");
    }

    public ActionForward afficheForward(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    {
        return mapping.findForward("afficheForward");
    }

    public ActionForward afficheInsert(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    {
        AfficheForm afficheForm = (AfficheForm)form;
        afficheForm.setName(Chinese.chinese(request.getParameter("name")));
        afficheForm.setContent(Chinese.chinese(request.getParameter("content")));
        dao.insertAffiche(afficheForm);
        request.setAttribute("success", "添加公告信息成功！！！");
        return mapping.findForward("afficheOperation");
    }

    public ActionForward afficheDelete(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    {
        dao.deleteAffiche(Integer.valueOf(request.getParameter("id")));
        request.setAttribute("success", "删除公告信息成功");
        return mapping.findForward("afficheOperation");
    }
}
