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
		
		layui.use('form', function(){
			  var form = layui.form; //只有执行了这一步，部分表单元素才会自动修饰成功
			  form.render();
			});    
		
		//获取选中id组成的字符串
		var ids = common.getUrlParam("ids");
		
		//对单按钮更新单据信息
		$("#billBtn_").click(function(){
			var billState = $("#billState_").val();
			var url = common.rootPath + "/user/shippingDocuments/doBillCheck";
			var param = {ids:ids,billState:billState};
			ajax_lib.asyncPostParam(url,param,function(returnData){
				if(true==returnData.status){
					var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
					parent.layer.close(index); //再执行关闭   
				} else {
					layer.open({
						  type: 0, 
						  content:"对单失败!" //这里content是一个普通的String
						});
				}
			},function(e){
				layer.open({
					  type: 0, 
					  content:"对单失败!" //这里content是一个普通的String
					});
			});
			
		});
		
	});