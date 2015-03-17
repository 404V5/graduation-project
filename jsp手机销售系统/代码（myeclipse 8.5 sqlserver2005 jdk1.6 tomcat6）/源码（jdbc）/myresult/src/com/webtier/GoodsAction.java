

package com.webtier;

import com.dao.GoodsDao;
import com.dao.SmallTypeDao;
import com.domain.GoodsForm;
import java.io.UnsupportedEncodingException;
import java.util.List;
import javax.servlet.http.*;
import org.apache.struts.action.*;

public class GoodsAction extends Action
{

    private int action;
    private GoodsDao dao;
    private SmallTypeDao small;
    private HttpSession session;

    public GoodsAction()
    {
        dao = null;
        small = null;
        session = null;
    }

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
        throws UnsupportedEncodingException
    {
        request.setCharacterEncoding("gb2312");
        dao = new GoodsDao();
        small = new SmallTypeDao();
        action = Integer.parseInt(request.getParameter("action"));
        session = request.getSession();
        switch(action)
        {
        case 0: // '\0'
            return goodSelect(mapping, form, request, response);

        case 1: // '\001'
            return goodForward(mapping, form, request, response);

        case 2: // '\002'
            return selectSmallName(mapping, form, request, response);

        case 3: // '\003'
            return saveGoods(mapping, form, request, response);

        case 4: // '\004'
            return insertGoods(mapping, form, request, response);

        case 5: // '\005'
            return selectOneGoods(mapping, form, request, response);

        case 6: // '\006'
            return deleteGoods(mapping, form, request, response);

        case 7: // '\007'
            return goodSelectMark(mapping, form, request, response);

        case 8: // '\b'
            return goodSelectSmall(mapping, form, request, response);

        case 9: // '\t'
            return goodSelectBig(mapping, form, request, response);

        case 10: // '\n'
            return managerFreePirceForward(mapping, form, request, response);

        case 11: // '\013'
            return managerFreePirce(mapping, form, request, response);

        case 12: // '\f'
            return goodSelectBigHead(mapping, form, request, response);

        case 13: // '\r'
            return goodSelectSmallHead(mapping, form, request, response);

        case 14: // '\016'
            return goodSelectNewHead(mapping, form, request, response);

        case 15: // '\017'
            return goodSelectFreeHead(mapping, form, request, response);

        case 16: // '\020'
            return goodSelectOneHead(mapping, form, request, response);
        }
        GoodsForm goodsForm = (GoodsForm)form;
        throw new UnsupportedOperationException("Method $execute() not yet implemented.");
    }

    public ActionForward goodSelectOneHead(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    {
        request.setAttribute("form", dao.selectOneGoods(Integer.valueOf(request.getParameter("id"))));
        return mapping.findForward("goodSelectOneHead");
    }

    public ActionForward goodSelectFreeHead(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    {
        List list = null;
        String mark = request.getParameter("mark");
        list = dao.selectMark(Integer.valueOf(mark));
        int pageNumber = list.size();
        int maxPage = pageNumber;
        String number = request.getParameter("i");
        if(maxPage % 4 == 0)
            maxPage /= 4;
        else
            maxPage = maxPage / 4 + 1;
        if(number == null)
            number = "0";
        request.setAttribute("number", String.valueOf(number));
        request.setAttribute("maxPage", String.valueOf(maxPage));
        request.setAttribute("pageNumber", String.valueOf(pageNumber));
        request.setAttribute("list", list);
        return mapping.findForward("goodSelectFreeHead");
    }

    public ActionForward goodSelectNewHead(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    {
        List list = null;
        String mark = request.getParameter("mark");
        list = dao.selectMark(Integer.valueOf(mark));
        request.setAttribute("list", list);
        return mapping.findForward("goodSelectNewHead");
    }

    public ActionForward goodSelectSmallHead(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    {
        List list = null;
        list = dao.selectSmall(Integer.valueOf(request.getParameter("small")));
        int pageNumber = list.size();
        int maxPage = pageNumber;
        String number = request.getParameter("i");
        if(maxPage % 4 == 0)
            maxPage /= 4;
        else
            maxPage = maxPage / 4 + 1;
        if(number == null)
            number = "0";
        request.setAttribute("number", String.valueOf(number));
        request.setAttribute("maxPage", String.valueOf(maxPage));
        request.setAttribute("pageNumber", String.valueOf(pageNumber));
        request.setAttribute("list", list);
        request.setAttribute("smallList", small.selectOneBigId(Integer.valueOf(request.getParameter("big"))));
        return mapping.findForward("goodSelectSmallHead");
    }

    public ActionForward goodSelectBigHead(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    {
        List list = null;
        list = dao.selectBig(Integer.valueOf(request.getParameter("big")));
        int pageNumber = list.size();
        int maxPage = pageNumber;
        String number = request.getParameter("i");
        if(maxPage % 4 == 0)
            maxPage /= 4;
        else
            maxPage = maxPage / 4 + 1;
        if(number == null)
            number = "0";
        request.setAttribute("number", String.valueOf(number));
        request.setAttribute("maxPage", String.valueOf(maxPage));
        request.setAttribute("pageNumber", String.valueOf(pageNumber));
        request.setAttribute("list", list);
        request.setAttribute("smallList", small.selectOneBigId(Integer.valueOf(request.getParameter("big"))));
        return mapping.findForward("goodSelectBigHead");
    }

    public ActionForward managerFreePirce(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    {
        GoodsForm goodsForm = (GoodsForm)form;
        String mark = request.getParameter("mark").trim();
        String id = request.getParameter("id").trim();
        if(mark.equals("0"))
        {
            goodsForm.setFreePrice(Float.valueOf("0"));
            goodsForm.setMark(Integer.valueOf("0"));
            goodsForm.setId(Integer.valueOf(id));
            dao.managerPrice(goodsForm);
            request.setAttribute("success", "删除特价成功！！");
        } else
        {
            String free = request.getParameter("free").trim();
            goodsForm.setFreePrice(Float.valueOf(free));
            goodsForm.setMark(Integer.valueOf(mark));
            goodsForm.setId(Integer.valueOf(id));
            dao.managerPrice(goodsForm);
            request.setAttribute("success", "设置特价成功！！");
        }
        return mapping.findForward("goodsOperation");
    }

    public ActionForward managerFreePirceForward(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    {
        request.setAttribute("form", dao.selectOneGoods(Integer.valueOf(request.getParameter("id"))));
        return mapping.findForward("managerFreePirce");
    }

    public ActionForward goodSelectBig(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    {
        List list = null;
        list = dao.selectBig(Integer.valueOf(request.getParameter("big")));
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
        return mapping.findForward("goodSelectBig");
    }

    public ActionForward goodSelectSmall(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    {
        List list = null;
        list = dao.selectSmall(Integer.valueOf(request.getParameter("small")));
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
        return mapping.findForward("goodSelectSmall");
    }

    public ActionForward goodSelectMark(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    {
        List list = null;
        list = dao.selectMark(Integer.valueOf(request.getParameter("mark")));
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
        return mapping.findForward("goodSelectMark");
    }

    public ActionForward deleteGoods(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    {
        dao.deleteGoods(Integer.valueOf(request.getParameter("id")));
        request.setAttribute("success", "删除商品信息成功");
        return mapping.findForward("goodsOperation");
    }

    public ActionForward selectOneGoods(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    {
        request.setAttribute("form", dao.selectOneGoods(Integer.valueOf(request.getParameter("id"))));
        return mapping.findForward("selectContent");
    }

    public ActionForward insertGoods(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    {
        GoodsForm goodsForm = (GoodsForm)form;
        GoodsForm goods = (GoodsForm)session.getAttribute("goods");
        goodsForm.setBig(goods.getBig());
        goodsForm.setSmall(goods.getSmall());
        goodsForm.setName(goods.getName());
        goodsForm.setFrom(goods.getFrom());
        goodsForm.setNowPrice(goods.getNowPrice());
        goodsForm.setFreePrice(goods.getFreePrice());
        goodsForm.setIntroduce(goods.getIntroduce());
        goodsForm.setPriture(request.getParameter("path"));
        dao.insertGoods(goodsForm);
        request.setAttribute("success", "添加商品信息成功");
        return mapping.findForward("goodsOperation");
    }

    public ActionForward saveGoods(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    {
        GoodsForm goodsForm = (GoodsForm)form;
        goodsForm.setBig(Integer.valueOf(request.getParameter("big")));
        goodsForm.setSmall(Integer.valueOf(request.getParameter("small")));
        goodsForm.setName(request.getParameter("name"));
        goodsForm.setFrom(request.getParameter("from"));
        goodsForm.setNowPrice(Float.valueOf(request.getParameter("nowPirce")));
        goodsForm.setFreePrice(Float.valueOf(request.getParameter("freePirce")));
        goodsForm.setIntroduce(request.getParameter("introduce"));
        request.setAttribute("goods", goodsForm);
        session.setAttribute("goods", goodsForm);
        return mapping.findForward("goodsInsertPicture");
    }

    public ActionForward selectSmallName(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    {
        request.setAttribute("bigId", request.getParameter("bigId"));
        return mapping.findForward("goodForward");
    }

    public ActionForward goodForward(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    {
        return mapping.findForward("goodForward");
    }

    public ActionForward goodSelect(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    {
        List list = null;
        list = dao.selectGoods();
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
        return mapping.findForward("goodSelect");
    }
}
