function subVai()
{
	var varMc = document.formAdd.lxmc.value;
	var varMs = document.formAdd.lxms.value;
	
	if(varMc.Trim()=="")
	{
		alert("类型名称不能为空!");
		return false;
	}
	return true;
}