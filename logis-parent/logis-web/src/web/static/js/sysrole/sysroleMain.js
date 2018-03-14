require.config({
	baseUrl: "/logis-web/static/",
	paths : {
		jquery : "plugins/h-ui.admin/lib/jquery/1.9.1/jquery.min",
		layuijs : "plugins/layui-v2.2.5/layui",
		common:	"js/common",
		ajax_lib:"js/modules/ajax_lib"
	}
});

require([ 'common' ], function(common) {
	
	
	layui.use('table', function() {

		var table = layui.table;

		rootPath = common.rootPath;
		var param = {
			roleName : ""
		};
		table.render({
			elem : '#role-table',
			height : 'full-20', // 高度最大化减去差值
			url : rootPath + '/role/sysRole/listrole',
			method : "get",
			request : {
				pageName : 'pageIndex', // 页码的参数名称，默认：page
				limitName : 'pageSize' // 每页数据量的参数名，默认：limit
			},
			where : {
				queryrole : JSON.stringify(param)
			},
			cols : [ [  {
				field : 'id',
				width : 80,
				title : 'ID',
				sort : true
			}, {
				field : 'roleName',
				width : 80,
				title : '角色名称'
			}, {
				field : 'desc_',
				width : 80,
				title : '角色描述'
			}, {
				field : 'validly',
				width : 120,
				title : '是否有效',
				sort : true
			}, {
				field : 'creater',
				width : 100,
				title : '创建人'
			}, {
				field : 'createTime',
				title : '创建时间',
				minWidth : 100
			}, {
				field : 'updater',
				width : 80,
				title : '最后修改人',
				sort : true
			}, {
				field : 'updateTime',
				width : 120,
				title : '最后修改时间',
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
	$("#querybtn").on("click",function(){
		layui.use('table', function() {

			var table = layui.table;
			
			var param = {};
			var roleName = $("#roleName").val();
			if(roleName){
				param["roleName"] = roleName;
			}
			table.reload("role-table",{
				where : {
					queryrole : JSON.stringify(param)
				},
			})
			
		});
	});
	
	
});
