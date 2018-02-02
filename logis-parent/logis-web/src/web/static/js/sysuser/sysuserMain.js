require.config({
	baseUrl: "../../static/",
	paths : {
		jquery : "plugins/h-ui.admin/lib/jquery/1.9.1/jquery.min",
		layuijs : "plugins/layui-v2.2.5/layui",
		sysuser:	"js/sysuser/sysuser"
	}
});
//测试git
require([ 'sysuser' ], function(sysuser) {
	sysuser.sysuserinit();
});
