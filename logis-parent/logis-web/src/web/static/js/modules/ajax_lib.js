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
			async:true,
			success:callback,
			error:errorFn
		});
	};
	var postGet = function(url,param,callback) {
		$.ajax({
			type:"get",
			data:param,
			url:url,
			async:true,
			success:callback,
			error:errorFn
		});
	};
	var asyncPost = function(url,param,callback) {
		$.ajax({
			type:"post",
			data:JSON.stringify(param),
			url:url,
			async:true,
			success:callback,
			error:errorFn
		});
	};
	var asyncGet = function(url,param,callback) {
		$.ajax({
			type:"post",
			data:JSON.stringify(param),
			url:url,
			async:true,
			success:callback,
			error:errorFn
		});
	};
	//没有转换参数为json字符串的post请求
	myModule.postParam = postParam;
	//没有转换参数为json字符串的get请求
	myModule.postGet = postGet;
	//转换参数为json字符串的post请求
	myModule.asyncPost = asyncPost;
	//转换参数为json字符串的get请求
	myModule.asyncGet = asyncGet;

	myModule.moduleName = moduleName;
	myModule.moduleVersion = moduleVersion;

	return myModule;
});