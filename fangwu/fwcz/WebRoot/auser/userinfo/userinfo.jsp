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
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />
        
        <link rel="stylesheet" type="text/css" href="<%=path %>/css/base.css" />
		
		<script type='text/javascript' src='<%=path %>/dwr/interface/loginService.js'></script>
        <script type='text/javascript' src='<%=path %>/dwr/engine.js'></script>
        <script type='text/javascript' src='<%=path %>/dwr/util.js'></script>
		
        <script language="javascript">
		    function check1()
		    {
		        if(document.form1.loginname.value=="")
		        {
		            alert("请输入账号");
		            return false;
		        }
		        if(document.form1.loginpw.value=="")
		        {
		            alert("请输入密码");
		            return false;
		        }
		        if(document.form1.xingming.value=="")
		        {
		            alert("请输入姓名");
		            return false;
		        }
		        
		        document.form1.submit();
		    }
        </script>
	</head>

	<body leftmargin="2" topmargin="9" background='<%=path %>/img/allbg.gif'>
			<form action="<%=path %>/user?type=userEdit" name="form1" method="post">
							       <table align="left" border="0" cellpadding="5" cellspacing="5">
										<tr align='center'>
											<td style="width: 50px;" align="center">
												账号：										    
											</td>
											<td align="left">
												<input name="loginname" type="text" style="width: 227px;" value="${sessionScope.user.loginname }"/>
												(账号只读)
											</td>
										</tr>
										<tr align='center'>
											<td style="width: 50px;" align="center">
												密码：										    
											</td>
											<td align="left">
												<input name="loginpw" type="password" style="width: 227px;" value="${sessionScope.user.loginpw }"/>
											</td>
										</tr>
										<tr align='center'>
											<td style="width: 50px;" align="center">
												姓名：										    
											</td>
											<td align="left">
												<input name="xingming" type="text" style="width: 227px;" value="${sessionScope.user.xingming }"/>
											</td>
										</tr>
										<tr align='center'>
											<td style="width: 50px;" align="center">
												性别：										    
											</td>
											<td align="left">
												<input type="radio" name="xingbie" value="男" checked="checked" style="border: 0px;"/>男
												&nbsp;&nbsp;&nbsp;
												<input type="radio" name="xingbie" value="女" style="border: 0px;"/>女
											</td>
										</tr>
										<tr align='center'>
											<td style="width: 50px;" align="center">
												年龄：										    
											</td>
											<td align="left">
												<input name="nianling" type="text" value="${sessionScope.user.nianling }" style="width: 227px;" onkeyup="value=value.replace(/[^\d]/g,'') " onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))"/>
											</td>
										</tr>
										<tr align='center'>
											<td style="width: 50px;" align="center">
												住址：										    
											</td>
											<td align="left">
												<input name="zhuzhi" type="text" style="width: 227px;" value="${sessionScope.user.zhuzhi }"/>
											</td>
										</tr>
										<tr align='center'>
											<td style="width: 50px;" align="center">
												职业：										    
											</td>
											<td align="left">
												<input name="zhiye" type="text" style="width: 227px;" value="${sessionScope.user.zhiye }"/>
											</td>
										</tr>
										<tr align='center'>
										   <td style="width: 50px;" align="left"></td>
										   <td align="left">
										      <input type="hidden" name="id" value="${sessionScope.user.id }">
										      <input type="button" value="确定" onclick="check1();" style="width: 80px;"/>
										      <input type="reset" value="重置" style="width: 80px;"/>&nbsp;	
										   </td>
										</tr>
								   </table>
								   </form>
    </body>
</html>
