<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %> 
<%
String path = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<link rel="stylesheet" type="text/css" href="<%=path %>/css/base.css" />
        <script language="javascript">
           function jcxxDel(id,lxtype)
           {
               if(confirm('您确定删除吗？'))
               {
                   window.location.href="<%=path %>/jcxx?type=jcxxDel&id="+id+"&lxtype="+lxtype;
               }
           }
       </script>
	</head>

	<body leftmargin="2" topmargin="2" background='<%=path %>/img/allbg.gif'>
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="3" background="<%=path %>/img/tbg.gif">&nbsp;${requestScope.lxmingcheng }管理&nbsp;</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td width="15%">名称</td>
					<td width="15%">描述</td>
					<td width="10%">操作</td>
		        </tr>	
				<c:forEach items="${requestScope.jcxxList}" var="jcxx">
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">
						${jcxx.mingcheng}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${jcxx.miaoshu}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<form action="<%=path %>/jcxx/jcxxEditPre.jsp" method="post">
						        <input type="hidden" name="id" value="${jcxx.id}"/>
						        <input type="hidden" name="mingcheng" value="${jcxx.mingcheng}"/>
						        <input type="hidden" name="miaoshu" value="${jcxx.miaoshu}"/>
						        <input type="hidden" name="lxtype" value="${requestScope.lxtype}"/>
						        <input type="hidden" name="lxmingcheng" value="${requestScope.lxmingcheng}"/>
						    <input type="submit" value="编辑"/>
						     <input type="button" onclick="jcxxDel(${jcxx.id},${requestScope.lxtype})" value="删除"/>
						</form>
					</td>
				</tr>
				</c:forEach>
			</table>
			
			<table width='98%'  border='0'style="margin-top:8px;margin-left: 5px;">
			  <tr>
			    <td>
			    	<form action="<%=path %>/jcxx/jcxxAdd.jsp" method="post">
			     	 <input type="hidden" name="hidlxtype" value="${requestScope.lxtype}"/>
			     	 <input type="hidden" name="hidlxmingcheng" value="${requestScope.lxmingcheng}"/>
			     	 <input type="submit" value="添加" style="width: 80px;" />
			     	</form> 
			    </td>
			  </tr>
		    </table>
	</body>
</html>
