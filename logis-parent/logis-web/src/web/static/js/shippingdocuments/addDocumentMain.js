require.config({
	baseUrl: "/logis-web/static/",
	paths : {
		jquery : "plugins/h-ui.admin/lib/jquery/1.9.1/jquery.min",
		layuijs : "plugins/layui-v2.2.5/layui",
		document_:	"js/shippingdocuments/document",
		common:	"js/common",
		ajax_lib:"js/modules/ajax_lib"
	}
});
	var form;

	require([ 'document_','common','ajax_lib','layuijs' ], function(document_,common,ajax_lib,layuijs) {
		
		
		
		document_.addDocumentInit(common,ajax_lib);
		
		
		var billNo = $("#billNo").val();
		
		
		function validateForm(data){
			if(!data.billNo){
				layer.open({
					  type: 0, 
					  content:"单据号不能为空，请检查！" //这里content是一个普通的String
					});
				return false;
			}
			if(!data.billDate){
				layer.open({
					  type: 0, 
					  content:"单据日期不能为空，请检查！" //这里content是一个普通的String
					});
				return false;
			}
			if(!data.receiver){
				layer.open({
					  type: 0, 
					  content:" 收货人不能为空，请检查！" //这里content是一个普通的String
					});
				return false;
			}
			if(!data.shipper){
				layer.open({
					  type: 0, 
					  content:"发货人不能为空，请检查！" //这里content是一个普通的String
					});
				return false;
			}
		}
		function saveFunc(){
			var param;
			var url = common.rootPath + "/user/shippingDocuments/save";
			var data = {rowId:$("#rowId").val(),
					billNo:$("#billNo").val(),
					billDate:$("#billDate").val(),
					receiver:$("#receiver").val(),
					receiverPhone:$("#receiverPhone").val(),
					shipper:$("#shipper").val(),
					shipperPhone:$("#shipperPhone").val(),
					quantity:$("#quantity").val(),
					money:$("#money").val(),
					freight:$("#freight").val(),
					total:$("#total").val(),
					freightType:$("#freightType").val(),
					driver:$("#driver").val(),
					remarks:$("#remarks").val(),
					billState:$("#billState").val(),
					receivablesState:$("#receivablesState").val(),
					receivablesType:$("#receivablesType").val(),
					receivablesDate:$("#receivablesDate").val(),
					paymentType:$("#paymentType").val(),
					paymentState:$("#paymentState").val(),
					paymentType:$("#paymentType").val()
			};
			function formInit(){
				window.location.reload();
			}
			
			ajax_lib.asyncPost(url,data,function(returnData){
				
				if(true===returnData.status){
//					var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
//					parent.layer.close(index); //再执行关闭   
					formInit();
				} else {
					layer.open({
						type : 0,
						content : "单据保存失败。请稍后重试！" // 这里content是一个普通的String
					});
				}
			},function(){
				
				layer.open({
					type : 0,
					content : "单据保存失败。请稍后重试！" // 这里content是一个普通的String
				});
			})
			
		}
		
		layui.use([ 'form'],function(form){
			form.on("submit(formSubmit)",function(data){
				saveFunc();
				return false;
			});
		});
		
		
	});

	

