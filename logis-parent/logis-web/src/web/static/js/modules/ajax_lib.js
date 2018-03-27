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
	
	//异常
	function exceptionHandle(res){
		debugger;
		layui.use([ 'layer' ], function(layer) {
			if(res.error){
				if(res.error.errorCode == "999999"){
					layer.msg(res.error.errMsg);
					setTimeout(function(){
						window.top.location.href = getRootPath()+"/templates/login.html";
					},800);
					return false;
				}
				var layer = layui.layer; // 只有执行了这一步，部分表单元素才会自动修饰成功
				layer.msg(res.error.errorCode); // 这里content是一个普通的String
			}
		});
	}
	
	var postParam = function(url,param,callback,errorFn) {
		$.ajax({
			type:"post",
			data:param,
			url:url,
			dataType:'json',
			async:false,
			success:function(res){
				debugger;
				if(res.status == true){
					callback(res.content||null);
				}else{
					exceptionHandle(res);
				}
			},
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
			success:function(res){
				if(!!res.content&&res.status == true){
					callback(res.content);
				}else{
					exceptionHandle(res);
				}
			},
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
			dataType:'json',
			success:function(res){
				if(!!res.content&&res.status == true){
					callback(res.content);
				}else{
					exceptionHandle(res);
				}
			},
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
			dataType:'json',
			success:function(res){
				if(!!res.content&&res.status == true){
					callback(res.content);
				}else{
					exceptionHandle(res);
				}
			},
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
			dataType:'json',
			success:function(res){
				if(!!res.content&&res.status == true){
					callback(res.content);
				}else{
					exceptionHandle(res);
				}
			},
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
			dataType:"json",
			success:function(res){
				if(!!res.content&&res.status == true){
					callback(res.content);
				}else{
					exceptionHandle(res);
				}
			},
			error:errorFn
		});
	};
	var asyncPostParam = function(url,param,callback,errorFn) {
		$.ajax({
			type:"post",
			data:param,
			url:url,
			dataType:'json',
			async:false,
			success:function(res){
				if(!!res.content&&res.status == true){
					callback(res.content);
				}else{
					exceptionHandle(res);
				}
			},
			error:errorFn
		});
	};
	var asyncGetParam = function(url,param,callback,errorFn) {
		$.ajax({
			type:"get",
			data:param,
			url:url,
			dataType:'json',
			async:false,
			success:function(res){
				if(!!res.content&&res.status == true){
					callback(res.content);
				}else{
					exceptionHandle(res);
				}
			},
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