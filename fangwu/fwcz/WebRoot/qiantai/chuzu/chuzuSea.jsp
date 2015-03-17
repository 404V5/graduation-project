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
	
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/qiantai.css" />
	
	<script language="javascript">
		    function chaxun()
			{    
			    document.ThisForm.submit();                                                                               
			}
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
                <!-- 22 -->
               	<div id="gray_box_border">
                         <form action="<%=path %>/chuzu?type=chuzuRes" name="ThisForm" method="post">
							       <table align="left" border="0" cellpadding="5" cellspacing="5">
										<tr align='center'>
											<td style="width: 50px;" align="center">
												户型：										    
											</td>
											<td align="left">
												<input name="huxing" type="text" style="width: 227px;"/>
											</td>
										</tr>
										<tr align='center'>
											<td style="width: 50px;" align="center">
												地址：										    
											</td>
											<td align="left">
												<input name="dizhi" type="text" style="width: 227px;" value=""/>
											</td>
										</tr>
										<tr align='center'>
										   <td style="width: 50px;" align="left"></td>
										   <td align="left">
										      <input type="button" value="查询" onclick="chaxun();" style="width: 80px;"/>
										      <input type="reset" value="重置" style="width: 80px;"/>&nbsp;	
										   </td>
										</tr>
								   </table>
								   </form>
                </div>  
                <!-- 22 -->
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
