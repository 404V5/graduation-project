<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
        <script type="text/javascript" src="<%=path %>/commutil.js"></script>
        <script type="text/javascript" src="<%=path %>/datepicker/WdatePicker.js"></script>        
        <script type="text/javascript" src="<%=path %>/bagl/baglBus.js"></script>
        <script language="javascript">
        </script>
	</head>

	<body leftmargin="2" topmargin="9" background='<%=path %>/img/allbg.gif'>
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="5" background="<%=path %>/img/tbg.gif">&nbsp;报案信息&nbsp;</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td width="15%">客户</td>
					<td width="15%">标题</td>
					<td width="10%">日期</td>
					<td width="10%">地点</td>
					<td width="10%">内容</td>
		        </tr>	
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">
						${requestScope.baxx.strKehu}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${requestScope.baxx.biaoti}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${requestScope.baxx.riqi}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${requestScope.baxx.didian}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${requestScope.baxx.neirong}
					</td>
				</tr>
			</table>	
			<br />
			<form action="<%=path %>/lpgl?type=lpglAdd" name="formAdd" method="post">
			     <table width="98%" align="center" border="0" cellpadding="4" cellspacing="1" bgcolor="#CBD8AC" style="margin-bottom:8px">
					<tr bgcolor="#EEF4EA">
				        <td colspan="3" background="<%=path %>/img/wbg.gif" class='title'><span>理赔信息查看</span></td>
				    </tr>
					<tr align='center' bgcolor="#FFFFFF" height="22">
						<td width="25%" bgcolor="#FFFFFF" align="right">
							实际内容：
						</td>
						<td width="75%" bgcolor="#FFFFFF" align="left">
							${requestScope.baxx.lpInfo.neirong}
						</td>
					</tr>					
					<tr align='center' bgcolor="#FFFFFF" height="22">
						<td width="25%" bgcolor="#FFFFFF" align="right">
							理赔时间：
						</td>
						<td width="75%" bgcolor="#FFFFFF" align="left">
						        ${requestScope.baxx.lpInfo.riqi}
						</td>
					</tr>					
					<tr align='center' bgcolor="#FFFFFF" height="22">
						<td width="25%" bgcolor="#FFFFFF" align="right">
							理赔内容：
						</td>
						<td width="75%" bgcolor="#FFFFFF" align="left">
							${requestScope.baxx.lpInfo.chuli}
						</td>
					</tr>
					<tr align='center' bgcolor="#FFFFFF" height="22">
						<td width="25%" bgcolor="#FFFFFF" align="right">
							理赔金额：
						</td>
						<td width="75%" bgcolor="#FFFFFF" align="left">
							${requestScope.baxx.lpInfo.jine}
						</td>
					</tr>											
					<tr align='center' bgcolor="#FFFFFF" height="22">
					    <td width="25%" bgcolor="#FFFFFF" align="right">
					        &nbsp;
					    </td>
					    <td width="75%" bgcolor="#FFFFFF" align="left">
					       <input type="reset" value="返回" onclick="javascript:history.back()"/>&nbsp;
					    </td>
					</tr>
				 </table>
			</form>
   </body>
</html>
