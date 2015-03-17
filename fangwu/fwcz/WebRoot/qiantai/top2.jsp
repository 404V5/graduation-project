<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %> 
<%
    String path = request.getContextPath();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
     <script language="javascript">
			function zhongxin()
			{
			    var targetWinUrl="<%=path %>/auser/index.jsp";
				var targetWinName="newWin";
				var features="width="+screen.width+" ,height="+screen.height+" ,toolbar=yes, top=0, left=0, menubar=yes, scrollbars=yes, resizable=yes,location=no, status=yes";
				var new_win=window.open(targetWinUrl,targetWinName,features);
			}    
        </script>
  </head>
  
  <body>
            <div>
                <ul class="menu">
                    <li><a href="<%=path %>/chuzu?type=chuzuAll" class="nav" 
                        style="width: 70px;font-family: 微软雅黑;font-size: 12px;">系统首页</a>
                    </li>
                    <li><a href="<%=path %>/gonggao?type=gonggaoAll" class="nav" 
                        style="width: 70px;font-family: 微软雅黑;font-size: 12px;">公告信息</a>
                    </li>
                    <li><a href="<%=path %>/qiantai/chuzu/chuzuSea.jsp" class="nav" 
                        style="width: 70px;font-family: 微软雅黑;font-size: 12px;">房屋查询</a>
                    </li>
                    <li><a href="<%=path %>/chuzu?type=chuzuNew" class="nav" 
                        style="width: 70px;font-family: 微软雅黑;font-size: 12px;">最新出租</a>
                    </li>
                    <li><a href="<%=path %>/qiantai/user/userReg.jsp" class="nav" 
                        style="width: 70px;font-family: 微软雅黑;font-size: 12px;">会员注册</a>
                    </li>
                    
                    <c:if test="${sessionScope.userType !=1 }">
                    <li><a href="<%=path %>/qiantai/user/userLogin.jsp" class="nav"
                        style="width: 70px;font-family: 微软雅黑;font-size: 12px;">会员登录</a>
                    </li> 
                    </c:if>
                    
                    <c:if test="${sessionScope.userType ==1 }">    
                    <li><a href="#" class="nav"
                        style="width: 80px;font-family: 微软雅黑;font-size: 12px;">欢迎你：${sessionScope.user.xingming }</a>
                    </li>
                    <li><a href="<%=path %>/user?type=userLogout" class="nav"
                        style="width: 70px;font-family: 微软雅黑;font-size: 12px;">注销退出</a>
                    </li> 
                    <li><a href="#" onclick="zhongxin()" class="nav"
                        style="width: 70px;font-family: 微软雅黑;font-size: 12px;">个人中心</a>
                    </li> 
                    </c:if>                    
                </ul>
            </div>
  </body>
</html>
