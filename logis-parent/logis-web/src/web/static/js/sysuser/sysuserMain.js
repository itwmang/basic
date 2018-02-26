require.config({
	baseUrl: "/logis-web/static/",
	paths : {
		jquery : "plugins/h-ui.admin/lib/jquery/1.9.1/jquery.min",
		layuijs : "plugins/layui-v2.2.5/layui",
		sysuser:	"js/sysuser/sysuser",
		common:	"js/common",
		ajax_lib:"js/modules/ajax_lib"
	}
});

require([ 'sysuser','common' ], function(sysuser) {
	sysuser.sysuserinit();
});
