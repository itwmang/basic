require.config({
	baseUrl : "/logis-web/static/",
	paths : {
		jquery : "plugins/h-ui.admin/lib/jquery/1.9.1/jquery.min",
		layuijs : "plugins/layui-v2.2.5/layui",
		document_ : "js/shippingdocuments/document",
		common : "js/common",
		ajax_lib : "js/modules/ajax_lib"
	}
});

require([ 'document_', 'common', 'ajax_lib' ], function(document_, common,
		ajax_lib) {

	layui.use([ 'form', 'laydate' ], function() {
		var form = layui.form, //只有执行了这一步，部分表单元素才会自动修饰成功
		laydate = layui.laydate;

		//日期
		laydate.render({
			elem : '#receivablesDate_',
			value:new Date()
		});

		form.render();
	});

	//获取选中id组成的字符串
	var ids = common.getUrlParam("ids");

	//对单按钮更新单据信息
	$("#recBtn_").click(function() {
		var receivablesType = $("#receivablesType_").val();
		var receivablesDate = $("#receivablesDate_").val();
		var receivablesState = "已收";
		var url = common.rootPath + "/user/shippingDocuments/doReceivables";
		var param = {
			ids : ids,
			receivablesType : receivablesType,
			receivablesDate : receivablesDate,
			receivablesState : receivablesState
		};
		ajax_lib.asyncPostParam(url, param, function(returnData) {
			if (true == returnData.status) {
				var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
				parent.layer.close(index); //再执行关闭   
			} else {
				alert("收款失败!");
			}
		});

	});

});