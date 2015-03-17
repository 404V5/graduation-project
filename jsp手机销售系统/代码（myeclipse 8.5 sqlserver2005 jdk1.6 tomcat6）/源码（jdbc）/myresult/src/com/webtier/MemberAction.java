

package com.webtier;

import com.dao.MemberDao;
import com.domain.MemberForm;
import com.tool.*;

import java.sql.SQLException;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;

public class MemberAction extends Action
{

    private int action;
    private MemberDao dao;
    private HttpSession session;

    public MemberAction()
    {
        dao = null;
        session = null;
    }

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws NumberFormatException, SQLException
    {
        dao = new MemberDao();
        action = Integer.parseInt(request.getParameter("action"));
        switch(action)
        {
        case 0: // '\0'
            return insertMember(mapping, form, request, response);

        case 1: // '\001'
            return checkMember(mapping, form, request, response);

        case 2: // '\002'
            return selectMember(mapping, form, request, response);

        case 3: // '\003'
            return selectOneMember(mapping, form, request, response);

        case 4: // '\004'
            return deleteMember(mapping, form, request, response);

        case 5: // '\005'
            return selectOneMemberHead(mapping, form, request, response);

        case 6: // '\006'
            return updateMemberHead(mapping, form, request, response);
        }
        throw new UnsupportedOperationException("Method $execute() not yet implemented.");
    }

    public ActionForward updateMemberHead(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    {
        MemberForm memberForm = (MemberForm)form;
        String name = Chinese.chinese(request.getParameter("name")).trim();
        memberForm.setId(Integer.valueOf(request.getParameter("id")));
        memberForm.setName(name);
        memberForm.setPassword(Chinese.chinese(request.getParameter("password")).trim());
        memberForm.setAge(Integer.valueOf(request.getParameter("age").trim()));
        memberForm.setEmail(request.getParameter("email"));
        memberForm.setReallyName(Chinese.chinese(request.getParameter("reallyName")).trim());
        memberForm.setProfession(Chinese.chinese(request.getParameter("profession")).trim());
        memberForm.setQuestion(Chinese.chinese(request.getParameter("question")).trim());
        memberForm.setResult(Chinese.chinese(request.getParameter("result")).trim());
        dao.updateMember(memberForm);
        request.setAttribute("success", "修改成功");
        return mapping.findForward("operationMember");
    }

    public ActionForward selectOneMemberHead(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    {
        request.setAttribute("form", dao.selectOneMember(Integer.valueOf(request.getParameter("id"))));
        return mapping.findForward("selectOneMemberHead");
    }

    public ActionForward deleteMember(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws NumberFormatException, SQLException
    {
        if(dao.deleteMember(Integer.valueOf(request.getParameter("id"))))
            request.setAttribute("success", "删除会员信息成功！！！");
        else
            request.setAttribute("success", "删除失败，请先删除子表中的内容！！！");
        return mapping.findForward("deleteMember");
    }

    public ActionForward selectOneMember(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    {
        request.setAttribute("form", dao.selectOneMember(Integer.valueOf(request.getParameter("id"))));
        return mapping.findForward("selectOneMember");
    }

    public ActionForward selectMember(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    {
        List list = dao.selectMember();
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
        return mapping.findForward("selectMember");
    }

    public ActionForward checkMember(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    {
        String name = Chinese.chinese(request.getParameter("name"));
        String password = dao.selectPassword(name.trim());
        boolean flag = true;
        session = request.getSession();
        MemberList member = MemberList.getInstance();
        Vector vc = member.getList();
        MemberForm memberForm = dao.selectMemberForm(name);
        if(!vc.isEmpty() && vc != null)
        {
            Enumeration en = vc.elements();
            do
            {
                if(!en.hasMoreElements())
                    break;
                MemberForm admin = (MemberForm)en.nextElement();
                if(admin.getName().equals(name))
                    flag = false;
            } while(true);
        } else
        {
            flag = true;
        }
        if(password.equals(""))
            request.setAttribute("result", "不存在此会员，请重新登录！！！");
        else
        if(!password.equals(Chinese.chinese(request.getParameter("password").trim())))
            request.setAttribute("result", "密码错误，请重新登录！！！");
        else
        if(!flag)
        {
            request.setAttribute("result", "该会员已经登录！！！");
        } else
        {
            int id = memberForm.getId().intValue();
            ManagerTrace managerTrace = new ManagerTrace();
            managerTrace.setId(id);
            member.addMember(memberForm);
            session.setAttribute("managerTrace", managerTrace);
            session.setAttribute("id", String.valueOf(id));
            request.setAttribute("id", String.valueOf(id));
            request.setAttribute("memberForm", memberForm);
        }
        return mapping.findForward("checkMember");
    }

    public ActionForward insertMember(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    {
        MemberForm memberForm = (MemberForm)form;
        String name = Chinese.chinese(request.getParameter("name")).trim();
        if(dao.selectPassword(name) == null || dao.selectPassword(name).equals(""))
        {
            memberForm.setName(name);
            memberForm.setPassword(Chinese.chinese(request.getParameter("password")).trim());
            memberForm.setAge(Integer.valueOf(request.getParameter("age").trim()));
            memberForm.setEmail(request.getParameter("email"));
            memberForm.setReallyName(Chinese.chinese(request.getParameter("reallyName")).trim());
            memberForm.setProfession(Chinese.chinese(request.getParameter("profession")).trim());
            memberForm.setQuestion(Chinese.chinese(request.getParameter("question")).trim());
            memberForm.setResult(Chinese.chinese(request.getParameter("result")).trim());
            dao.insertMember(memberForm);
            request.setAttribute("success", "注册成功");
        } else
        {
            request.setAttribute("success", "该会员名称已经存在！！！");
        }
        return mapping.findForward("operationMember");
    }
}
