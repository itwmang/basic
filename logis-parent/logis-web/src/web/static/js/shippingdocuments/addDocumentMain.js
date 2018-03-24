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


	require([ 'document_','common','ajax_lib','layuijs' ], function(document_,common,ajax_lib,layuijs) {
		
		
		layui.use(['form','laydate'], function(){
			  var form = layui.form; //只有执行了这一步，部分表单元素才会自动修饰成功
			  laydate = layui.laydate;
				
				//日期
				  laydate.render({
				    elem: '#billDate'
				  });
				
			  form.render();
		});    
		
		document_.addDocumentInit();
		
		
		$("#money").keyup(function(){
			var a = $("#money").val();
			var b = $("#freight").val();
			if(!a){
				a = 0;
			}
			if(!b){
				b = 0;
			}
			$("#total").val((a*1+b*1).toFixed(2));	
		})
		
		$("#freight").keyup(function(){
			var a = $("#money").val();
			var b = $("#freight").val();
			if(!a){
				a = 0;
			}
			if(!b){
				b = 0;
			}
			$("#total").val((a*1+b*1).toFixed(2));	
		})
		
		//修改 获取数据 加载到新增form
		var json = {};
		var id = common.getUrlParam("id");
		if(id){
			var url = common.rootPath + "/user/shippingDocuments/edit/"+id;
			ajax_lib.asyncGet(url,null,function(res){
				if(res){
					json = res.content.returnObject;
					$("#billNo").val(json.billNo);
					$("#billDate").val(document_.getFormatDate(json.billDate));
					$("#receiver").val(json.receiver);
					$("#receiverPhone").val(json.receiverPhone);
					$("#shipper").val(json.shipper);
					$("#shipperPhone").val(json.shipperPhone);
					$("#quantity").val(json.quantity);
					var a = json.money;
					if(a){
						$("#money").val(a.toFixed(2));
					} else{
						$("#money").val(0)
					}
					var b = json.freight;
					if(b){
						$("#freight").val(b.toFixed(2));
					} else{
						$("#freight").val(0)
					}
					var c= json.total;
					if(c){
						$("#total").val(c.toFixed(2));
					} else{
						$("#total").val(0)
					}
					$("#freightType").val(json.freightType);
					$("#driver").val(json.driver);
					$("#remarks").val(json.remarks);
					$("#billState").val(json.billState);
					$("#receivablesState").val(json.receivablesState);
					$("#receivablesType").val(json.receivablesType);
					$("#receivablesDate").val(document_.getFormatDate(json.receivablesDate));
					$("#paymentType").val(json.paymentType);
					$("#paymentState").val(json.paymentState);
					$("#paymentDate").val(document_.getFormatDate(json.paymentDate));
				}
			});
		}
		
		//保存按钮事件
		$("#saveBtn").on("click",function(){
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

			for(var x in json){
				if(data[x]){
					json[x] = data[x];
				}
			}
			
			
			if(json["rowId"]){
				param = json;
			} else{
				param = data;
			}
			
			ajax_lib.asyncPost(url,param,function(status){
				if(true==status.status){
					var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
					parent.layer.close(index); //再执行关闭   
				} else {
					alert("保存失败!");
				}
			})
			
		});
	});

	

