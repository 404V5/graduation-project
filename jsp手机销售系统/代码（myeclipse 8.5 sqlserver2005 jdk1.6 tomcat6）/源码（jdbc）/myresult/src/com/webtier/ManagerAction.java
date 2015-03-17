

package com.webtier;

import com.dao.ManagerDao;
import com.domain.ManagerForm;
import com.tool.*;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;

public class ManagerAction extends Action
{

    private ManagerDao dao;
    private int action;
    private HttpSession session;

    public ManagerAction()
    {
        dao = null;
        session = null;
    }

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    {
        dao = new ManagerDao();
        action = Integer.parseInt(request.getParameter("action"));
        switch(action)
        {
        case 0: // '\0'
            return managerCheck(mapping, form, request, response);

        case 1: // '\001'
            return managerSelect(mapping, form, request, response);

        case 2: // '\002'
            return managerForwardInsert(mapping, form, request, response);

        case 3: // '\003'
            return managerInsert(mapping, form, request, response);

        case 4: // '\004'
            return managerDelete(mapping, form, request, response);

        case 5: // '\005'
            return managerSelectContent(mapping, form, request, response);

        case 6: // '\006'
            return managerUpdate(mapping, form, request, response);

        case 7: // '\007'
            return managerForwardPassword(mapping, form, request, response);

        case 8: // '\b'
            return managerUpdatePassword(mapping, form, request, response);
        }
        throw new UnsupportedOperationException("Method $execute() not yet implemented.");
    }

    public ActionForward managerUpdatePassword(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    {
        ManagerForm managerForm = (ManagerForm)form;
        managerForm.setAccount(request.getParameter("account"));
        managerForm.setPassword(request.getParameter("password"));
        dao.updateManagerPassword(managerForm);
        request.setAttribute("success", "修改后台管理员密码成功！！！");
        return mapping.findForward("managerOperation");
    }

    public ActionForward managerForwardPassword(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    {
        return mapping.findForward("managerForwardPassword");
    }

    public ActionForward managerUpdate(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    {
        ManagerForm managerForm = (ManagerForm)form;
        managerForm.setAccount(request.getParameter("account"));
        managerForm.setPassword(request.getParameter("password"));
        managerForm.setName(Chinese.chinese(request.getParameter("name")));
        managerForm.setId(Integer.valueOf(request.getParameter("id")));
        dao.updateManager(managerForm);
        request.setAttribute("success", "修改后台管理员信息成功！！！");
        return mapping.findForward("managerOperation");
    }

    public ActionForward managerSelectContent(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    {
        request.setAttribute("manager", dao.selectOne(request.getParameter("account")));
        return mapping.findForward("managerSelectContent");
    }

    public ActionForward managerDelete(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    {
        dao.deleteManager(Integer.valueOf(request.getParameter("id")));
        request.setAttribute("success", "删除后台管理员信息成功！！！");
        return mapping.findForward("managerOperation");
    }

    public ActionForward managerInsert(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    {
        ManagerForm managerForm = (ManagerForm)form;
        String account = request.getParameter("account");
        ManagerForm manager = dao.selectOne(account);
        if(manager == null || manager.equals(""))
        {
            managerForm.setAccount(account);
            managerForm.setPassword(request.getParameter("password"));
            managerForm.setName(Chinese.chinese(request.getParameter("name")));
            dao.insertManager(managerForm);
            request.setAttribute("success", "添加后台管理员信息成功！！！");
        } else
        {
            request.setAttribute("success", "此用户名已经存在！！！");
        }
        return mapping.findForward("managerOperation");
    }

    public ActionForward managerForwardInsert(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    {
        return mapping.findForward("managerForwardInsert");
    }

    public ActionForward managerSelect(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    {
        List list = dao.selectManager();
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
        return mapping.findForward("managerSelect");
    }

    public ActionForward managerCheck(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    {
        String account = Chinese.chinese(request.getParameter("account"));
        String password = dao.selectPassword(account);
        boolean flag = true;
        session = request.getSession();
        ManagerList manger = ManagerList.getInstance();
        Vector vc = manger.getList();
        ManagerForm manager = dao.selectOne(account);
        if(!vc.isEmpty() && vc != null)
        {
            Enumeration en = vc.elements();
            do
            {
                if(!en.hasMoreElements())
                    break;
                ManagerForm admin = (ManagerForm)en.nextElement();
                if(admin.getAccount().equals(account))
                    flag = false;
            } while(true);
        } else
        {
            flag = true;
        }
        if(password.equals("") || password == null)
        {
            request.setAttribute("result", "您输入的账号和密码不存在！！！");
            return mapping.findForward("checkResult");
        }
        if(!password.equals(Chinese.chinese(request.getParameter("password"))))
        {
            request.setAttribute("result", "您输入的密码不存在！！！");
            return mapping.findForward("checkResult");
        }
        if(!flag)
        {
            request.setAttribute("result", "您输入的用户名正在使用中！！！");
            return mapping.findForward("checkResult");
        } else
        {
            int id = manager.getId().intValue();
            ManagerTrace managerTrace = new ManagerTrace();
            managerTrace.setId(id);
            manger.addManager(manager);
            session.setAttribute("managerTrace", managerTrace);
            session.setAttribute("id", String.valueOf(id));
            request.setAttribute("manager", manager);
            return mapping.findForward("checkResult");
        }
    }
}
