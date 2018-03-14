define([ 'jquery' ], function($) {
	var myModule = {};
	var moduleName = "ajax_lib module";
	var moduleVersion = "1.0.0";
	
	var rootPath= "";
	function getRootPath(){
		var curWwwPath = window.document.location.href;
		// 获取主机地址之后的目录，如： uimcardprj/share/meun.jsp
		var pathName = window.document.location.pathname;
		var pos = curWwwPath.indexOf(pathName);
		// 获取主机地址，如： http://localhost:8083
		var localhostPaht = curWwwPath.substring(0, pos);
		// 获取带"/"的项目名，如：/uimcardprj
		var projectName = localhostPaht + pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
		return projectName;
	}
	
	var postParam = function(url,param,callback,errorFn) {
		$.ajax({
			type:"post",
			data:param,
			url:url,
			dataType:'json',
			async:false,
			success:callback,
			error:errorFn
		});
	};
	var getParam = function(url,param,callback,errorFn) {
		$.ajax({
			type:"get",
			data:param,
			url:url,
			dataType:'json',
			async:false,
			success:callback,
			error:errorFn
		});
	};

	var postRequest = function(url,param,callback,errorFn) {
		$.ajax({
			type:"post",
			data:JSON.stringify(param),
			url:url,
			contentType:"application/json",
			async:false,
			success:callback,
			error:errorFn
		});
	};
	var getRequest = function(url,param,callback,errorFn) {
		$.ajax({
			type:"get",
			data:JSON.stringify(param),
			url:url,
			contentType:"application/json",
			async:false,
			success:callback,
			error:errorFn
		});
	};
	var asyncPost = function(url,param,callback,errorFn) {
		$.ajax({
			type:"post",
			data:JSON.stringify(param),
			url:url,
			contentType:"application/json",
			async:true,
			success:callback,
			error:errorFn
		});
	};
	var asyncGet = function(url,param,callback,errorFn) {
		$.ajax({
			type:"get",
			data:JSON.stringify(param),
			url:url,
			contentType:"application/json",
			async:true,
			success:callback,
			error:errorFn
		});
	};
	var asyncPostParam = function(url,param,callback,errorFn) {
		$.ajax({
			type:"post",
			data:param,
			url:url,
			dataType:'json',
			async:true,
			success:callback,
			error:errorFn
		});
	};
	var asyncGetParam = function(url,param,callback,errorFn) {
		$.ajax({
			type:"get",
			data:param,
			url:url,
			dataType:'json',
			async:true,
			success:callback,
			error:errorFn
		});
	};
	//转换参数为json字符串的post请求
	myModule.postParam = postParam;
	//转换参数为json字符串的get请求
	myModule.postGet = getParam;
	
	//没有转换参数为json字符串的post请求
	myModule.postRequest = postRequest;
	//没有转换参数为json字符串的get请求
	myModule.getRequest = getRequest;

	//转换参数为json字符串的post请求
	myModule.asyncPost = asyncPost;
	//转换参数为json字符串的get请求
	myModule.asyncGet = asyncGet;
	
	//没有转换参数为json字符串的post请求
	myModule.asyncPostParam = asyncPostParam;
	//没有转换参数为json字符串的get请求
	myModule.asyncGetParam = asyncGetParam;

	myModule.moduleName = moduleName;
	myModule.moduleVersion = moduleVersion;

	return myModule;
});