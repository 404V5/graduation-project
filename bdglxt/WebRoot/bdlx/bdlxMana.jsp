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
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />

		<link rel="stylesheet" type="text/css" href="<%=path %>/css/base.css" />
		
        <script language="javascript">
           function bdlxDel(id)
           {
               if(confirm('您确定删除吗？'))
               {
                   window.location.href="<%=path %>/bdlx?type=bdlxDel&id="+id;
               }
           }
           
           
           function bdlxAdd()
           {
                 var url="<%=path %>/bdlx/bdlxAdd.jsp";
                 //var n="";
                 //var w="480px";
                 //var h="500px";
                 //var s="resizable:no;help:no;status:no;scroll:yes";
				 //openWin(url,n,w,h,s);
				 window.location.href=url;
           }
       </script>
	</head>

	<body leftmargin="2" topmargin="2" background='<%=path %>/img/allbg.gif'>
			<table width='98%'  border='0'style="margin-top:8px;margin-left: 5px;">
			  <tr>
			    <td>
			        <form action="<%=path %>/bdlx?type=bdlxSearch" name="formAdd" method="post">
			                      名称： <input type="text" name="lxmc"/>
			           &nbsp;
			           <input type="submit" value="查询"/>
			        </form>
			    </td>
			  </tr>
		    </table>
			
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="4" background="<%=path %>/img/tbg.gif">&nbsp;&nbsp;</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td width="15%">类型名称</td>
					<td width="15%">类型描述</td>
					<td width="15%">缴费年限(年)</td>
					<td width="10%">操作</td>
		        </tr>	
				<c:forEach items="${requestScope.bdlxList}" var="bdlx">
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">
						${bdlx.lxmc}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${bdlx.lxms}
					</td>
					<td bgcolor="#FFFFFF" align="center">
					    ${bdlx.tbnx}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<form action="<%=path %>/bdlx/bdlxEditPre.jsp" method="post">
						    <input type="button" onclick="bdlxDel(${bdlx.id})" value="删除"/>
						        <input type="hidden" name="id" value="${bdlx.id}"/>
						        <input type="hidden" name="lxmc" value="${bdlx.lxmc}"/>
						        <input type="hidden" name="lxms" value="${bdlx.lxms}"/>
						        <input type="hidden" name="tbnx" value="${bdlx.tbnx}"/>
						    <input type="submit" value="编辑"/>
						</form>
					</td>
				</tr>
				</c:forEach>
			</table>
			
			<table width='98%'  border='0'style="margin-top:8px;margin-left: 5px;">
			  <tr>
			    <td>
			      <input type="button" value="添加" style="width: 80px;" onclick="bdlxAdd()" />
			    </td>
			  </tr>
		    </table>
	</body>
</html>
