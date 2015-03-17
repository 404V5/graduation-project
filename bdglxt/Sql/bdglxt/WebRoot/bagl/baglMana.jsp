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
	</head>

	<body leftmargin="2" topmargin="2" background='<%=path %>/img/allbg.gif'>
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="5" background="<%=path %>/img/tbg.gif">&nbsp;报案管理&nbsp;</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td width="15%">客户</td>
					<td width="15%">标题</td>
					<td width="10%">日期</td>
					<td width="10%">地点</td>
					<td width="10%">内容</td>
		        </tr>	
				<c:forEach items="${requestScope.baList}" var="baxx">
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">
						${baxx.strKehu}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${baxx.biaoti}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${baxx.riqi}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${baxx.didian}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${baxx.neirong}
					</td>
				</tr>
				</c:forEach>
			</table>
			
			<table width='98%'  border='0'style="margin-top:8px;margin-left: 5px;">
			  <tr>
			    <td>
			    	<form action="<%=path %>/bagl/baglAdd.jsp" method="post">
			     	 <input type="submit" value="添加" style="width: 80px;" />
			     	</form> 
			    </td>
			  </tr>
		    </table>
	</body>
</html>
