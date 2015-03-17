<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %> 
<%
String path = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<base target="_self"></base>
	<head>
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<link rel="stylesheet" type="text/css" href="<%=path %>/css/base.css" />
		<script type="text/javascript" src="<%=path%>/bdgl/bdglBus.js"></script>
	</head>

	<body leftmargin="2" topmargin="2" background='<%=path %>/img/allbg.gif'>
			<table width='98%'  border='0'style="margin-top:8px;margin-left: 5px;">
			  <tr>
			    <td>
			        <form action="<%=path %>/kehu?type=kehuChooseSearch" name="formAdd" method="post">
			          客户姓名： <input type="text" name="xingming" value="${requestScope.sName}"/>
			           &nbsp;
			           <input type="submit" value="查询"/>
			        </form>
			    </td>
			  </tr>
		    </table>
			
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="6" background="<%=path %>/img/tbg.gif">&nbsp;客户信息&nbsp;</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td width="5%">&nbsp;</td>
					<td width="15%">客户姓名</td>
					<td width="15%">姓别</td>
					<td width="15%">出生日期</td>
					<td width="15%">身份证号码</td>
					<td width="10%">家庭住址</td>
		        </tr>	
				<c:forEach items="${requestScope.kehuList}" var="kehu">
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center"><input type="radio" name="id" value="${kehu.id}"/></td>
					<td bgcolor="#FFFFFF" align="center">
						<input type="hidden"  id="hid_name_${kehu.id}" value="${kehu.xingming}"/>
						${kehu.xingming}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${kehu.xingbie}
					</td>
					<td bgcolor="#FFFFFF" align="center">
					    ${kehu.shengri}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${kehu.sfzhm}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${kehu.zhuzhi}
					</td>
				</tr>
				</c:forEach>
			</table>
			
			<table width='98%'  border='0'style="margin-top:8px;margin-left: 5px;">
			  <tr>
			    <td>
			      <input type="button" value="添加" style="width: 80px;" onclick="kehuAdd()" />
			    </td>
			  </tr>
		    </table>
	</body>
</html>
