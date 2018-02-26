require.config({
	baseUrl: "/logis-web/static/",
	paths : {
		jquery : "plugins/h-ui.admin/lib/jquery/1.9.1/jquery.min",
		layuijs : "plugins/layui-v2.2.5/layui",
		sysuser:"js/sysuser/sysuser",
		common:	"js/common"
	}
});

define([ 'layuijs'],function(){
	var myModule = {};
	var moduleName = "common module";
	var moduleVersion = "1.0.0";
	
	/** 弹出层 
	 * 参数解释： title 标题 url 请求的url id 需要操作的数据id w 弹出层宽度（缺省调默认值） h 弹出层高度（缺省调默认值）
	 */
	function layerWinOpen(title,url,w,h,callback){
		if (title == null || title == '') {
			title=false;
		};
		if (url == null || url == '') {
			url="404.html";
		};
		if (w == null || w == '') {
			w=800;
		};
		if (h == null || h == '') {
			h=($(window).height() - 50);
		};
		return layer.open({
			type: 2,
			area: [w+'px', h +'px'],
			fix: false, // 不固定
			maxmin: true,
			shade:0.4,
			title: title,
			content: url,
			success:callback
		});
	}
	/**关闭window窗口，传入窗口index*/
	function layerWinClose(index){
		layer.close(index);
	}
	myModule.layerWinOpen = layerWinOpen;
	myModule.layerWinClose = layerWinClose;

	myModule.moduleName = moduleName;
	myModule.moduleVersion = moduleVersion;

	return myModule;
})