

package com.webtier;

import com.dao.SmallTypeDao;
import com.domain.SmallTypeForm;
import com.tool.Chinese;

import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.*;

public class SmallTypeAction extends Action
{

    private int action;
    private SmallTypeDao dao;

    public SmallTypeAction()
    {
        dao = null;
    }

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws NumberFormatException, SQLException
    {
        action = Integer.parseInt(request.getParameter("action"));
        dao = new SmallTypeDao();
        switch(action)
        {
        case 0: // '\0'
            return smallTypeSelect(mapping, form, request, response);

        case 1: // '\001'
            return smallTypeForward(mapping, form, request, response);

        case 2: // '\002'
            return smallTypeInsert(mapping, form, request, response);

        case 3: // '\003'
            return smallTypeDelete(mapping, form, request, response);

        case 4: // '\004'
            return smallTypeSelectOne(mapping, form, request, response);

        case 5: // '\005'
            return smallTypeUpdate(mapping, form, request, response);

        case 6: // '\006'
            return smallTypeSelectBigId(mapping, form, request, response);
        }
        SmallTypeForm smallTypeForm = (SmallTypeForm)form;
        throw new UnsupportedOperationException("Method $execute() not yet implemented.");
    }

    public ActionForward smallTypeSelectBigId(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    {
        List list = dao.selectOneBigId(Integer.valueOf(request.getParameter("bigId")));
        int pageNumber = list.size();
        int maxPage = pageNumber;
        String number = request.getParameter("i");
        if(maxPage % 6 == 0)
            maxPage /= 6;
        else
            maxPage = maxPage / 6 + 1;
        if(number == null)
            number = "0";
        request.setAttribute("number", String.valueOf(number));
        request.setAttribute("maxPage", String.valueOf(maxPage));
        request.setAttribute("pageNumber", String.valueOf(pageNumber));
        request.setAttribute("list", list);
        return mapping.findForward("smallTypeSelect");
    }

    public ActionForward smallTypeUpdate(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    {
        SmallTypeForm smallTypeForm = (SmallTypeForm)form;
        smallTypeForm.setBigId(Integer.valueOf(request.getParameter("bigId")));
        smallTypeForm.setId(Integer.valueOf(request.getParameter("id")));
        smallTypeForm.setSmallName(Chinese.chinese(request.getParameter("name")));
        dao.updateSmall(smallTypeForm);
        request.setAttribute("success", "修改小类别信息成功");
        return mapping.findForward("smallTypeOperation");
    }

    public ActionForward smallTypeSelectOne(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    {
        request.setAttribute("small", dao.selectOneBig(Integer.valueOf(request.getParameter("id"))));
        return mapping.findForward("smallTypeSelectOne");
    }

    public ActionForward smallTypeDelete(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws NumberFormatException, SQLException
    {
        if(dao.deleteSmall(Integer.valueOf(request.getParameter("id"))))
            request.setAttribute("success", "删除小类别信息成功！");
        else
            request.setAttribute("success", "商品信息还存在此类别，请先删除商品信息！！！");
        return mapping.findForward("smallTypeOperation");
    }

    public ActionForward smallTypeInsert(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    {
        SmallTypeForm smallTypeForm = (SmallTypeForm)form;
        smallTypeForm.setBigId(Integer.valueOf(request.getParameter("bigId")));
        smallTypeForm.setSmallName(Chinese.chinese(request.getParameter("name")));
        dao.insertSmall(smallTypeForm);
        request.setAttribute("success", "添加小类别信息成功");
        return mapping.findForward("smallTypeOperation");
    }

    public ActionForward smallTypeForward(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    {
        return mapping.findForward("smallTypeForward");
    }

    public ActionForward smallTypeSelect(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    {
        List list = dao.selectSmall();
        int pageNumber = list.size();
        int maxPage = pageNumber;
        String number = request.getParameter("i");
        if(maxPage % 6 == 0)
            maxPage /= 6;
        else
            maxPage = maxPage / 6 + 1;
        if(number == null)
            number = "0";
        request.setAttribute("number", String.valueOf(number));
        request.setAttribute("maxPage", String.valueOf(maxPage));
        request.setAttribute("pageNumber", String.valueOf(pageNumber));
        request.setAttribute("list", list);
        return mapping.findForward("smallTypeSelect");
    }
}
