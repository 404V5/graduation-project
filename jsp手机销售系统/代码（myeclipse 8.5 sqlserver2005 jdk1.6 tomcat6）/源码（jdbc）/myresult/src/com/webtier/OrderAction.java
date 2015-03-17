

package com.webtier;

import com.dao.OrderDao;
import com.dao.OrderDetailDao;
import com.domain.OrderForm;

import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.*;

public class OrderAction extends Action
{

    private int action;
    private OrderDao order;
    private OrderDetailDao orderDetail;

    public OrderAction()
    {
        order = null;
        orderDetail = null;
    }

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws SQLException
    {
        action = Integer.parseInt(request.getParameter("action"));
        order = new OrderDao();
        orderDetail = new OrderDetailDao();
        switch(action)
        {
        case 0: // '\0'
            return selectOrder(mapping, form, request, response);

        case 1: // '\001'
            return selectOrderSend(mapping, form, request, response);

        case 2: // '\002'
            return deleteOrder(mapping, form, request, response);

        case 3: // '\003'
            return selectOneOrder(mapping, form, request, response);
        }
        OrderForm orderForm = (OrderForm)form;
        throw new UnsupportedOperationException("Method $execute() not yet implemented.");
    }

    public ActionForward selectOneOrder(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    {
        String number = request.getParameter("number");
        request.setAttribute("orderForm", order.selectOrderNumber(number));
        request.setAttribute("orderDetailList", orderDetail.selectOrderDetailNumber(number));
        return mapping.findForward("selectOneOrder");
    }

    public ActionForward deleteOrder(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws SQLException
    {
        String number = request.getParameter("number");
        orderDetail.deleteOrderDetail(number);
        if(order.deleteOrder(number))
            request.setAttribute("success", "删除信息成功！！！");
        else
            request.setAttribute("success", "删除信息失败！！！");
        return mapping.findForward("operationOrder");
    }

    public ActionForward selectOrderSend(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    {
        order.updateSignOrder(request.getParameter("number"));
        request.setAttribute("success", "出货成功！！！");
        return mapping.findForward("operationOrder");
    }

    public ActionForward selectOrder(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    {
        Integer sign = null;
        if(request.getParameter("sign") != null)
            sign = Integer.valueOf(request.getParameter("sign"));
        List list = order.selectOrderSign(sign);
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
        return mapping.findForward("selectOrder");
    }
}
