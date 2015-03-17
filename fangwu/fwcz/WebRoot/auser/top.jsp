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
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
	<meta http-equiv="description" content="This is my page"/>
	
	<style type="text/css">
        div,form,input,table,p,textrea,body,ul,li,iframe{margin:0px;padding:0px;}
		body,table,div,td,input,textarea{font-size:12px;font-family:verdana,"宋体";color:#333;}
		a{color:#333;text-decoration:none;}
		a:hover{color:#f30;text-decoration:none;}
		.left{float:left;}
		.right{float:right;}
		.clear{clear:both;}
		.dis{display:none;}
		.block{display:block;}
		.mag_t{margin-top:10px;}
		.input{border:1px solid #ddd;color:#333;padding:0 4px;height:20px;}
		.inputs{border:1px solid #ddd;color:#333;width:100%;}
		.bnt{background:url(<%=path %>/images/bnt.gif) no-repeat center;color:#fff;border:0px;line-height:26px;height:26px;width:66px;}
		.bnt01{background:url(<%=path %>/images/bnt01.gif) no-repeat center;color:#fff;border:0px;line-height:26px;height:26px;width:44px;}
		#head{width:100%; repeat-x top;overflow:hidden;height: 120px;}
		
		.head_txt span{color:#f30;}
		.head_txt span a{color:#f30;}
		.head_txt span a:hover{color:#57A728;}
		.head_menu{padding:45px 10px 0 0;}
		#head_menu ul,li{list-style:none;float:left;}
		#head_menu li{background:#5BAA26;width:70px;height:24px;margin:0 2px 0 0;display:block;line-height:24px;color:#fff;text-align:center;}
		#head_menu li a{color:#fff;}
		#head_menu li a:hover{color:#ff0;}
		
		#content{width:100%;background:#6BB146;float:left;}
		#left{background:#6BB146;width:200px;float:left;}
		#left ul,li{list-style:none;overflow:hidden;}
		.left_title{background:url(<%=path %>/images/sdcms_left_title.gif);display:block;color:#fff;font-size:14px;font-weight:bold;line-height:32px;height:32px;width:200px;text-indent:36px;margin-bottom:8px;}
		.left_title a{color:#fff;}
		.left_title a:hover{color:#ff0;}
		.left_link{text-indent:36px;color:#fff;height:24px;line-height:24px;display:block;width:200px;}
		.left_link a{color:#fff;}
		.left_link a:hover{color:#ff0;}
		.left_link_over{text-indent:36px;color:#fff;display:block;width:200px;background:url(left_menu_bg_over.gif);height:24px;line-height:24px;}
		.left_link_over a{color:#fff;}
		.left_link_over a:hover{color:#ff0;}
		/*#right{height:100%;}*/
		#right{margin-left:200px;padding:10px;background:#fff;}
		.sdcms_notice{border:1px solid #FCBA72;background:#FDFAF6;padding:6px 12px;line-height:25px;}
		.sdcms_notice span{font-weight:bold;}
		#sdcms_sub_title ul,li{list-style:none;}
		#sdcms_sub_title li.sub{float:left;background:url(sdcms_sub_title.gif) no-repeat top;width:86px;height:28px;margin-bottom:-1px;text-align:center;font-weight:bold;color:#5BAA26;line-height:28px;margin-right:2px;}
		#sdcms_sub_title li.sub a{color:#5BAA26}
		#sdcms_sub_title li.unsub{float:left;background:url(sdcms_sub_title01.gif) no-repeat top;width:86px;height:27px;text-align:center;line-height:27px;margin-right:2px;}
		#sdcms_sub_title li.unsub a{color:#555;}
		#sdcms_right_b{border:1px solid #BAE9A2;padding:10px;_padding:5px 10px 10px 10px;clear:both;}
		.table_b{background:#DBF0D1;width:100%;}
		.title_bg{background:#fff url(sub_title.gif) repeat-x center;color:#5BAA26;font-size:12px;line-height:25px;text-align:center;}
		.tdbg{background:#fff;}
		.tdbg span{color:#999;}
		.tdbg01{background:#FDFBF5;padding:6px 10px;border:1px solid #FCF8EC;}
 	</style>
	
	<script language="javascript">
		function logout()
		{
		   if(confirm("确定要退出本系统吗??"))
		   {
			   window.parent.location="<%=path %>/login.jsp";
		   }
		}
	</script>
	
  </head>
  

  <body >
      <div id="head" style="height: 100px;background-color:#6BB146">
		  <div class="left"></div>
		  <div class="left head_txt" style="font-family: 微软雅黑;color: black;font-size: 26px;margin-top: 30px;margin-left: 18px;">
		                   基于JSP的房屋租赁管理系统
		  </div>
		  <div class="right head_menu">
		    <span style="margin-right: 30px;font-family: 微软雅黑;color: white;font-size: 15px;">
		                     <!-- 您好：尊敬的管理员  -->
		       &nbsp;&nbsp;&nbsp;&nbsp;              
		       <!-- <a href="#"  onclick="logout()"> 退出管理</a> -->
		    </span>
		  </div>
      </div>
  </body>
</html>
