function subVai()
{
	var varXm = document.formAdd.xingming.value;
	var varCsrq = document.formAdd.shenri.value;
	var varSfzhm = document.formAdd.sfzhm.value;
	var varZz = document.formAdd.zhuzhi.value;
	
	if(varXm.Trim()=="")
	{
		alert("客户姓名不能为空!");
		return false;
	}
	if(varCsrq.Trim()=="")
	{
		alert("出生日期不能为空!");
		return false;
	}
	if(varSfzhm.Trim()=="")
	{
		alert("身份证号码不能为空!");
		return false;
	}
	if(varZz.Trim()=="")
	{
		alert("住址不能为空!");
		return false;
	}
	
	return true;
}