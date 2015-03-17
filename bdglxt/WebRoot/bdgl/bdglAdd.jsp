<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>

<%
	String path = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<link rel="stylesheet" type="text/css" href="<%=path%>/css/base.css" />
		<script type="text/javascript" src="<%=path%>/datepicker/WdatePicker.js"></script>
		<script type="text/javascript" src="<%=path%>/commutil.js"></script>
		<script type="text/javascript" src="<%=path%>/bdgl/bdglBus.js"></script>
		<script language="javascript">
        </script>
	</head>

	<body leftmargin="2" topmargin="9"
		background='<%=path%>/img/allbg.gif'>
		<form action="<%=path%>/bdgl?type=bdglAdd" name="formAdd"
			method="post">
			<table width="98%" align="center" border="0" cellpadding="4"
				cellspacing="1" bgcolor="#CBD8AC" style="margin-bottom: 8px">
				<tr bgcolor="#EEF4EA">
					<td colspan="3" background="<%=path%>/img/wbg.gif" class='title'>
						<span>增加新保单</span>
					</td>
				</tr>
				<tr align='center' bgcolor="#FFFFFF" height="22">
					<td width="25%" bgcolor="#FFFFFF" align="right">
						编号：
					</td>
					<td width="75%" bgcolor="#FFFFFF" align="left">
						<input type="text" size="25" disabled="disabled" value="${requestScope.bh}"/>
						<input type="hidden" name="bianhao" value="${requestScope.bh}"/>
					</td>
				</tr>
				<tr align='center' bgcolor="#FFFFFF" height="22">
					<td width="25%" bgcolor="#FFFFFF" align="right">
						投保人：
					</td>
					<td width="75%" bgcolor="#FFFFFF" align="left">
						<input type="text" name="kehuname" id=kehuname size="15" readonly="readonly"/>
						<input type="hidden" name="kehu" id="kehu"/>&nbsp;&nbsp;
						<input type="button" value="选择" onclick="chooseKh()"/>
					</td>
				</tr>
				<tr align='center' bgcolor="#FFFFFF" height="22">
					<td width="25%" bgcolor="#FFFFFF" align="right">
						保险种类：
					</td>
					<td width="75%" bgcolor="#FFFFFF" align="left">
						<select name="leixing">
							<c:forEach items="${requestScope.bdlxList}" var="lx">
								<option value="${lx.id}">${lx.lxmc}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr align='center' bgcolor="#FFFFFF" height="22">
					<td width="25%" bgcolor="#FFFFFF" align="right">
						缴费方式：
					</td>
					<td width="75%" bgcolor="#FFFFFF" align="left">
						<select name="jffs">
							<c:forEach items="${requestScope.jffsList}" var="jffs">
								<option value="${jffs.id}">${jffs.mingcheng}</option>
							</c:forEach>
						</select>
					</td>
				</tr>				
				<tr align='center' bgcolor="#FFFFFF" height="22">
					<td width="25%" bgcolor="#FFFFFF" align="right">
						缴费时限：
					</td>
					<td width="75%" bgcolor="#FFFFFF" align="left">
						<select name="jfsx">
							<c:forEach items="${requestScope.jfsxList}" var="jfsx">
								<option value="${jfsx.id}">${jfsx.mingcheng}</option>
							</c:forEach>
						</select>
					</td>
				</tr>				
				<tr align='center' bgcolor="#FFFFFF" height="22">
					<td width="25%" bgcolor="#FFFFFF" align="right">
						投保金额：
					</td>
					<td width="75%" bgcolor="#FFFFFF" align="left">
						<input type="text" name="jine" size="25" />
						（元）
					</td>
				</tr>
				<tr align='center' bgcolor="#FFFFFF" height="22">
					<td width="25%" bgcolor="#FFFFFF" align="right">
						受益人：
					</td>
					<td width="75%" bgcolor="#FFFFFF" align="left">
						<input type="text" name="shouyiren" size="25" />
					</td>
				</tr>
				<tr align='center' bgcolor="#FFFFFF" height="22">
					<td width="25%" bgcolor="#FFFFFF" align="right">
						受益人性别：
					</td>
					<td width="75%" bgcolor="#FFFFFF" align="left">
						<input type="text" name="shouyirenxb" size="25" />
					</td>
				</tr>
				<tr align='center' bgcolor="#FFFFFF" height="22">
					<td width="25%" bgcolor="#FFFFFF" align="right">
						与投保人关系：
					</td>
					<td width="75%" bgcolor="#FFFFFF" align="left">
						<input type="text" name="guanxi" size="25" />
					</td>
				</tr>
				<tr align='center' bgcolor="#FFFFFF" height="22">
					<td width="25%" bgcolor="#FFFFFF" align="right">
						受益人身份证号：
					</td>
					<td width="75%" bgcolor="#FFFFFF" align="left">
						<input type="text" name="shouyirenxfz" size="25" />
					</td>
				</tr>
				<tr align='center' bgcolor="#FFFFFF" height="22">
					<td width="25%" bgcolor="#FFFFFF" align="right">
						&nbsp;
					</td>
					<td width="75%" bgcolor="#FFFFFF" align="left">
						<input type="submit" value="提交" onclick="return subVai();" />
						<input type="button" value="返回" onclick="javascript:history.go(-1)"/>
						&nbsp;
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
