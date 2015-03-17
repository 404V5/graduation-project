<%@ page contentType="text/html; charset=gb2312" %>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link href="css/css.css" rel="stylesheet" type="text/css">


<%if(session.getAttribute("id")==null||session.getAttribute("form")==null){%>
<style type="text/css">
<!--
.STYLE1 {
	font-size: 10pt;
	font-weight: bold;
	color: #330066;
}
.STYLE2 {font-size: 10pt}
-->
</style>
<table width="97%" height="30"  border="0" align="center" cellpadding="0" cellspacing="0" >
      <tr align="center" >
        <td width="117" height="25" class="linkWhite"><a href="index.jsp" ><span class="STYLE2">首页</span><br>
        </a></td>
        <td width="117" class="linkWhite"><a href="sell_resultTen.jsp"><span class="STYLE2">销售排行</span><br>
        </a></td>
        <td width="117" class="linkWhite"><a href="goodsAction.do?action=14&mark=0"><span class="STYLE2">新品上架</span><br>
        </a></td>
        <td width="117" class="linkWhite"><a href="goodsAction.do?action=15&mark=1" ><span class="STYLE2">特价商品</span><br>
        </a></td>
        <td width="117" class="linkWhite"><a href="connection.jsp" ><span class="STYLE2">查看订单</span><br>
        </a></td>
        <td width="117" class="linkWhite"><a href="connection.jsp" ><span class="STYLE2">查看购物车</span><br>
        </a></td>
        <td width="117" class="linkWhite"><a href="connection.jsp" ><span class="STYLE2">会员修改</span><br>
        </a></td>
        <td width="117" class="linkWhite"><a href="#" onclick="this.style.behavior='url(#default#homepage)';this.sethomepage('http://www.mingrisoft.com')" class="linkBlack"><span class="STYLE2">设为首页</span><br>
        </a></td>
      </tr>
</table>
<%}else{%>
<table width="97%" height="30"  border="0" align="center" cellpadding="0" cellspacing="0">
      <tr align="center">
        <td width="117" height="39" class="linkWhite"><a href="index.jsp"><span class="STYLE1">首页</span><br>
        </a></td>
        <td width="117" class="linkWhite"><a href="sell_resultTen.jsp"><span class="STYLE1">销售排行</span><br>
        </a></td>
        <td width="117" class="linkWhite"><a href="goodsAction.do?action=14&mark=0"><span class="STYLE1">新品上架</span><br>
        </a></td>
        <td width="117" class="linkWhite"><a href="goodsAction.do?action=15&mark=1"><span class="STYLE1">特价商品</span><br>
        </a></td>
        <td width="117" class="linkWhite"><a href="cart_detail.jsp"><span class="STYLE1">查看订单</span><br>
        </a></td>
        <td width="117" class="linkWhite"><a href="cart_see.jsp"><span class="STYLE1">查看购物车</span><br>
        </a></td>
        <td width="117" class="linkWhite"><a href="memberAction.do?action=5&id=<%=session.getAttribute("id")%>"><span class="STYLE1">会员修改</span><br>
        </a></td>
        <td width="117" class="linkWhite"><a href="#" onclick="this.style.behavior='url(#default#homepage)';this.sethomepage('http://www.sohu.com')"><span class="STYLE1">设为首页</span><br>
        </a></td>
      </tr>
</table>
<%}%>
