function chooseKh()
{
	//客户选择
	var strUrl = "/bdglxt/kehu?type=kehuChoose&id="+Math.random();
	var ret = window.showModalDialog(strUrl,"","dialogWidth:800px; dialogHeight:500px; dialogLeft: status:no; directories:yes;scrollbars:yes;Resizable=no;");
	if(ret != null)
	{
		document.getElementById("kehu").value = ret[0];		//客户ID
		document.getElementById("kehuname").value=ret[1];	//客户姓名
	}
}

function kehuAdd()
{
	var arrKh = document.getElementsByName("id");
	var bolCheck = false;
	var varVal = "";
	for(var i=0;i<arrKh.length;i++)
	{
		if(arrKh[i].checked)
		{
			bolCheck = true;
			varVal = arrKh[i].value;
			break;
		}
	}
	
	if(bolCheck==true)
	{
		var hidName = "hid_name_"+varVal;
		var hidVal = document.getElementById(hidName).value;
		
		var arrVal = new Array();
		arrVal[0] = varVal;
		arrVal[1] = hidVal
		
		window.returnValue = arrVal;
		window.close();
	}else{
		alert("请选择客户!");
	}
}

function subVai()
{
	var varKh = document.getElementById("kehu").value
	
	if(varKh=="")
	{
		alert("客户不能为空!");
		return false;
	}
	return true;
}