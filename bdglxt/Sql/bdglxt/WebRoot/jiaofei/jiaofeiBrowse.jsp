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
           function subVal()
           {
               if(document.getElementById("jine").value=="")
               {
               		alert("缴费金额不能为空!");
               		return false;
               }
               
               return true;
           }
       </script>		
	</head>

	<body leftmargin="2" topmargin="2" background='<%=path %>/img/allbg.gif'>
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="3" background="<%=path %>/img/tbg.gif">&nbsp;保单信息&nbsp;</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td width="15%">编号</td>
					<td width="15%">客户姓名</td>
					<td width="15%">保单类型</td>
		        </tr>
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">
						${requestScope.bdinfo.bianhao}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${requestScope.bdinfo.strKh}
					</td>
					<td bgcolor="#FFFFFF" align="center">
					    ${requestScope.bdinfo.strLx}
					</td>
				</tr>		        
		        </table>	
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="3" background="<%=path %>/img/tbg.gif">&nbsp;缴费信息&nbsp;</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td width="50%">缴费日期</td>
					<td width="20%">缴费金额(元)</td>
					<td width="30%">缴费方式</td>
		        </tr>	
				<c:forEach items="${requestScope.jfxxList}" var="jfxx">
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">
						${jfxx.jfrq}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${jfxx.jfje}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${jfxx.strJffs}
					</td>
				</tr>
				</c:forEach>
			</table>
	</body>
</html>
