

package com.webtier;

import com.dao.BigTypeDao;
import com.domain.BigTypeForm;
import com.tool.Chinese;

import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.*;

public class BigTypeAction extends Action
{

    private int action;
    private BigTypeDao dao;

    public BigTypeAction()
    {
        dao = null;
    }

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws NumberFormatException, SQLException
    {
        dao = new BigTypeDao();
        action = Integer.parseInt(request.getParameter("action"));
        switch(action)
        {
        case 0: // '\0'
            return bigTypeSelect(mapping, form, request, response);

        case 1: // '\001'
            return bigTypeForward(mapping, form, request, response);

        case 2: // '\002'
            return bigTypeInsert(mapping, form, request, response);

        case 3: // '\003'
            return bigTypeDelete(mapping, form, request, response);

        case 4: // '\004'
            return bigTypeSelectOne(mapping, form, request, response);

        case 5: // '\005'
            return bigTypeUpdate(mapping, form, request, response);
        }
        throw new UnsupportedOperationException("Method $execute() not yet implemented.");
    }

    public ActionForward bigTypeUpdate(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    {
        BigTypeForm bigTypeForm = (BigTypeForm)form;
        bigTypeForm.setBigName(Chinese.chinese(request.getParameter("name")));
        bigTypeForm.setId(Integer.valueOf(request.getParameter("id")));
        dao.updateBig(bigTypeForm);
        request.setAttribute("success", "修改大类别信息成功");
        return mapping.findForward("bigTypeOperation");
    }

    public ActionForward bigTypeSelectOne(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    {
        request.setAttribute("bigType", dao.selectOneBig(Integer.valueOf(request.getParameter("id"))));
        return mapping.findForward("bigTypeSelectOne");
    }

    public ActionForward bigTypeDelete(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws NumberFormatException, SQLException
    {
        if(dao.deleteBig(Integer.valueOf(request.getParameter("id"))))
            request.setAttribute("success", "删除大类别信息成功");
        else
            request.setAttribute("success", "小类别还存在此信息，请先删除小类别信息");
        return mapping.findForward("bigTypeOperation");
    }

    public ActionForward bigTypeInsert(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    {
        dao.insertBig(Chinese.chinese(request.getParameter("name")));
        request.setAttribute("success", "添加大类别信息成功");
        return mapping.findForward("bigTypeOperation");
    }

    public ActionForward bigTypeForward(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    {
        return mapping.findForward("bigTypeForward");
    }

    public ActionForward bigTypeSelect(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    {
        List list = dao.selectBig();
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
        return mapping.findForward("bigTypeSelect");
    }
}
