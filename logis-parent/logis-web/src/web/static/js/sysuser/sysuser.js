define([ 'layuijs','common' ], function(layuijs,common) {
	var myModule = {};
	var moduleName = "sysuser module";
	var moduleVersion = "1.0.0";

	var rootPath = "";
	function getRootPath() {
		var curWwwPath = window.document.location.href;
		// 获取主机地址之后的目录，如： uimcardprj/share/meun.jsp
		var pathName = window.document.location.pathname;
		var pos = curWwwPath.indexOf(pathName);
		// 获取主机地址，如： http://localhost:8083
		var localhostPaht = curWwwPath.substring(0, pos);
		// 获取带"/"的项目名，如：/uimcardprj
		var projectName = localhostPaht
				+ pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
		return projectName;
	}

	/** 添加用户页面初始化 */
	var addUserInit = function() {
		
	}

	/** 用户列表初始化 */
	var sysuserinit = function() {

		layui.use('table', function() {

			var table = layui.table;

			rootPath = getRootPath();
			var param = {
				account : "test"
			};
			table.render({
				elem : '#user-table',
				height : 'full-20', // 高度最大化减去差值
				url : rootPath + '/user/sysUser/listuser',
				method : "get",
				request : {
					pageName : 'pageIndex', // 页码的参数名称，默认：page
					limitName : 'pageSize' // 每页数据量的参数名，默认：limit
				},
				where : {
					queryuser : JSON.stringify(param)
				},
				cols : [ [ {
					type : 'radiobox'
				}, {
					field : 'id',
					width : 80,
					title : 'ID',
					sort : true
				}, {
					field : 'account',
					width : 80,
					title : '用户名'
				}, {
					field : 'name_',
					width : 80,
					title : '名称'
				}, {
					field : 'email',
					width : 120,
					title : '邮箱',
					sort : true
				}, {
					field : 'userTyep',
					width : 100,
					title : '用户类型'
				}, {
					field : 'userStatus',
					title : '用户状态',
					minWidth : 100
				}, {
					field : 'pubCreatePerson',
					width : 80,
					title : '创建人',
					sort : true
				}, {
					field : 'pubCreateDate',
					width : 120,
					title : '创建时间',
					sort : true
				}, {
					field : 'pubModiPerson',
					width : 80,
					title : '修改人'
				}, {
					field : 'pubModiDate',
					width : 120,
					title : '修改时间',
					sort : true
				} ] ],
				page : true
			});
		});
		
		//绑定按钮
		$("#addbtn").on("click",function(){
			common.layerWinOpen('添加管理员','user-add.html','800','600');
		});
	};

	myModule.addUserInit = addUserInit;
	myModule.sysuserinit = sysuserinit;

	myModule.moduleName = moduleName;
	myModule.moduleVersion = moduleVersion;

	return myModule;
});