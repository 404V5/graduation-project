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
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />
		<link rel="stylesheet" type="text/css" href="<%=path %>/css/base.css" />
       <script language="javascript">
           function bdglAdd()
           {
               	var url="<%=path %>/bdgl?type=toAdd";
		 		window.location.href=url;
           }
       </script>		
	</head>

	<body leftmargin="2" topmargin="2" background='<%=path %>/img/allbg.gif'>
			<table width='98%'  border='0'style="margin-top:8px;margin-left: 5px;">
			  <tr>
			    <td>
			        <form action="<%=path %>/bdgl?type=bdglSearch" name="formAdd" method="post">
			          客户姓名： <input type="text" name="xingming" value="${requestScope.xingming}"/>
			           &nbsp;
			           <input type="submit" value="查询"/>
			        </form>
			    </td>
			  </tr>
		    </table>
			
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="7" background="<%=path %>/img/tbg.gif">&nbsp;保单管理&nbsp;</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td width="15%">编号</td>
					<td width="15%">客户姓名</td>
					<td width="15%">保单类型</td>
					<td width="15%">缴费时限</td>
					<td width="10%">投保日期</td>
					<td width="10%">受益人</td>
					<td width="10%">操作</td>
		        </tr>	
				<c:forEach items="${requestScope.bdList}" var="bd">
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">
						${bd.bianhao}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${bd.strKh}
					</td>
					<td bgcolor="#FFFFFF" align="center">
					    ${bd.strLx}
					</td>
					<td bgcolor="#FFFFFF" align="center">
					    ${bd.strJfsx}
					</td>
					<td bgcolor="#FFFFFF" align="center">
					    ${bd.tbrq}
					</td>
					<td bgcolor="#FFFFFF" align="center">
					    ${bd.shouyirensfz}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<form action="<%=path %>/jfxx?type=jfglMana" method="post">
						    <input type="hidden" name="bdid" value="${bd.id}"/>
						    <input type="submit" value="缴费查看"/>
						</form>
					</td>
				</tr>
				</c:forEach>
			</table>
			
			<table width='98%'  border='0'style="margin-top:8px;margin-left: 5px;">
			  <tr>
			    <td>
			      <input type="button" value="添加" style="width: 80px;" onclick="bdglAdd()" />
			    </td>
			  </tr>
		    </table>
	</body>
</html>
