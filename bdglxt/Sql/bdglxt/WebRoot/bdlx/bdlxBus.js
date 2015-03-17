function subVai()
{
	var varMc = document.formAdd.lxmc.value;
	var varMs = document.formAdd.lxms.value;
	var varNx = document.formAdd.tbnx.value;
	
	if(varMc.Trim()=="")
	{
		alert("类型名称不能为空!");
		return false;
	}
	/*if(varMs.Trim()=="")
	{
		alert("出生日期不能为空!");
		return false;
	}*/
	if(varNx.Trim()=="")
	{
		alert("缴费年限不能为空!");
		return false;
	}
	
	return true;
}