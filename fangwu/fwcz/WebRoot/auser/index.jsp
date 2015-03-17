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
 	</style>
	
	<script language="javascript">
		
	</script>
	
  </head>
  

  <frameset rows="102,*" cols="*" frameborder="no" border="0" framespacing="0">
  <frame src="<%=path %>/auser/top.jsp" name="topFrame" scrolling="No" noresize="noresize" id="topFrame" title="top" />
  <frameset cols="180,*" frameborder="no" border="0" framespacing="0">
    <frame src="<%=path %>/auser/left.jsp" name="leftFrame" scrolling="No" noresize="noresize" id="leftFrame" title="left" />
    <frame src="<%=path %>/auser/main.jsp" name="mainFrame" id="mainFrame" title="main" />
  </frameset>
</frameset>
<noframes><body>
</body>
</noframes>
</html>
