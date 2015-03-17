<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
	
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/qiantai.css" />
	
	<style rel="stylesheet" type="text/css">
		.list_noimg
		{
		      PADDING-RIGHT: 0px; PADDING-LEFT: 0px; PADDING-BOTTOM: 1px; OVERFLOW: hidden; PADDING-TOP: 1px; BORDER-BOTTOM: #eee 1px solid; ZOOM: 1
		}
		
	</style>
	
	<script type="text/javascript">
            
    </script>
  </head>
  
  <body>
     <div id="main_content">
		<div id="top_banner">
       		<jsp:include flush="true" page="/qiantai/top1.jsp"></jsp:include>
        </div>
        
        <div id="page_content">
            <jsp:include flush="true" page="/qiantai/top2.jsp"></jsp:include>
            <div id="left_section">
                <!-- 11 -->
            	<!-- <div class="title">企业介绍</div> -->
                <div class="text_content">
                    <c:forEach items="${chuzuList}" var="chuzu" varStatus="s">
						<fieldset style="width:95%; margin-left:5px;"><legend class="fieldtitle"></legend>
                         <table width="100%" border="0" cellpadding="2" cellspacing="2">
										     <tr>
										         <td align="left">房产户型：<a href="<%=path %>/chuzu?type=chuzuDetailQian&id=${chuzu.id}">${chuzu.huxing}</a></td>
										     </tr>
										     <tr>
										         <td align="left">房产面积：${chuzu.mianji}</td>
										     </tr>
										     <tr>
										         <td align="left">出租价格：${chuzu.jiage}(每月)</td>
										     </tr>
										     <tr>
										         <td align="left">备注信息：${chuzu.beizhu}</td>
										     </tr>
										     <tr>
										         <td align="left">所在地址：${chuzu.dizhi}</td>
										     </tr>
										     <tr>
										         <td align="left">户主姓名：${chuzu.lianxiren}</td>
										     </tr>
										     <tr>
										         <td align="left">联系电话：${chuzu.lianxihua}</td>
										     </tr>
										     <tr>
										         <td align="left">发布时间：${chuzu.fabushijian}</td>
										     </tr>
										</table> 
                    </fieldset>
					</c:forEach>
                </div>
                <!-- 11 -->
            </div>
            <div id="right_section">
            	<jsp:include flush="true" page="/qiantai/right.jsp"></jsp:include>
            </div>
            <div class="clear"></div>   
        </div>
		<div id="footer">
		    	<div class="copyright" align="center">
		           <a href="<%=path %>/login.jsp" style="text-decoration: none;color: white">系统后台</a>
		        </div>
		</div>
     </div>
  </body>
</html>
