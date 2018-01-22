define([ 'layuijs' ], function(layuijs) {
	var myModule = {};
	var moduleName = "sysuser module";
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
	
	var sysuserinit = function() {

		layui.use('table', function() {
			
			var table = layui.table;
			
			rootPath = getRootPath();
			var param = {account:"test"};
			table.render({
				elem : '#user-table',
				url : rootPath+'/user/sysUser/listuser',
				request:{
					pageName: 'pageIndex', //页码的参数名称，默认：page
					limitName: 'pageSize' //每页数据量的参数名，默认：limit
				},
				method:"get",
				where:{
					queryuser:JSON.stringify(param)
				},
				cols : [ [ {
					type : 'radiobox'
				}, {
					field : 'id',
					width : 80,
					title : 'ID',
					sort : true
				}, {
					field : 'username',
					width : 80,
					title : '用户名'
				}, {
					field : 'sex',
					width : 80,
					title : '性别',
					sort : true
				}, {
					field : 'city',
					width : 80,
					title : '城市'
				}, {
					field : 'sign',
					title : '签名',
					minWidth : 150
				}, {
					field : 'experience',
					width : 80,
					title : '积分',
					sort : true
				}, {
					field : 'score',
					width : 80,
					title : '评分',
					sort : true
				}, {
					field : 'classify',
					width : 80,
					title : '职业'
				}, {
					field : 'wealth',
					width : 135,
					title : '财富',
					sort : true
				} ] ],
				page : true
			});
		});
	};

	myModule.sysuserinit = sysuserinit;

	myModule.moduleName = moduleName;
	myModule.moduleVersion = moduleVersion;

	return myModule;
});