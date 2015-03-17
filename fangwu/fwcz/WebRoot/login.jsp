<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
	<meta http-equiv="description" content="This is my page"/>
	
	<style type="text/css">
	    body,form{margin:0px;padding:0px;}
		div{font-family:Verdana,"宋体";font-size:12px;color:#fff;}
		ul,li{padding:0px;margin:0px;list-style:none;}
		.b_w{width:388px;margin:auto;margin-top:180px;}
		.left{float:left;}
		.right{float:right;}
		.l_t{background:url(<%=path %>/images/l_t.gif);line-height:32px;padding:1px 8px;height:32px;overflow:hidden;}
		.l_title{font-size:14px;font-weight:bold;text-indent:12px;}
		.l_bg{background:url(<%=path %>/images/11111.jpg);line-height:30px;height:178px;overflow:hidden;}
		.l_user{margin:25px 10px 0 210px;}
		.l_user li{padding:0px!important;padding:4px;}
		.l_f{margin-top:1px;}
		.l_input{border:1px solid #6FAF01;background:#fff;height:16px;}
		.l_bnt{background:url(<%=path %>/images/login_bg.gif);width:53px;height:23px;line-height:23px;border:0px;color:#fff;font-size:12px;padding-bottom:3px;}
	</style>
	
	<script type='text/javascript' src='<%=path %>/dwr/interface/loginService.js'></script>
        <script type='text/javascript' src='<%=path %>/dwr/engine.js'></script>
        <script type='text/javascript' src='<%=path %>/dwr/util.js'></script>
        
		<script language="javascript">
		function check1()
		{                                                                                         
		     if(document.ThisForm.userName.value=="")
			 {
			 	alert("请输入用户名");
				document.ThisForm.userName.focus();
				return false;
			 }
			 if(document.ThisForm.userPw.value=="")
			 {
			 	alert("请输入密码");
				document.ThisForm.userPw.focus();
				return false;
			 }
			 document.getElementById("indicator").style.display="block";
			 loginService.login(document.ThisForm.userName.value,document.ThisForm.userPw.value,0,callback);
		}
		
		function callback(data)
		{
		    document.getElementById("indicator").style.display="none";
		    if(data=="no")
		    {
		        alert("用户名或密码错误");
		    }
		    if(data=="yes")
		    {
		        alert("通过验证,系统登录成功");
		        window.location.href="<%=path %>/loginSuccess.jsp";
		    }
		    
		}
	    </script>
	
  </head>
  
  <body bgcolor="#A6FFA6">
      <div class="b_w">
		   <div class="l_t">
		      <div class="left l_title">基于JSP的房屋租赁管理系统</div>
			  <div class="right">
				<a href="javascript:window.close()"><img src="<%=path %>/images//icon_close.gif" alt="关闭" hspace="4" vspace="8" border="0"/></a>
			  </div>
		   </div>
		   <div class="l_bg" >
		          <form action="" name="ThisForm" method="post" style="margin-left: 120px;margin-top: 25px;">
				     <table align="left" border="0" cellpadding="0" cellspacing="0">
							<tr align='center'>
								<td style="width: 40px;" align="right">
									账号：										    
								</td>
								<td align="left">
									<input name="userName" type="text" style="width: 90px;"/>
								</td>
							</tr>
							<tr align='center'>
								<td style="width: 40px;" align="right">
									密码：										    
								</td>
								<td align="left">
									<input name="userPw" type="password" style="width: 90px;"/>
								</td>
							</tr>
							<tr align='center'>
							   <td style="width: 40px;" align="left"></td>
							   <td align="left">
							      <input type="button" value="登陆" style="width: 43px;" onClick="check1()"/>&nbsp; 
							      <input type="reset" value="重置" style="width: 43px;"/>&nbsp;	
							      <img id="indicator" src="<%=path %>/images/loading.gif" style="display:none"/>
							   </td>
							</tr>
						</table>
			      </form>
		   </div>
		   <div class="l_f">
		      <div class="left"></div>
			  <div class="left" style="color: red"></div>
			  <div class="right"></div>
		   </div>
      </div>
  </body>
</html>
