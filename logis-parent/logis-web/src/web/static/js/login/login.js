require.config({
	baseUrl: "/logis-web/static/",
	paths : {
		jquery : "plugins/h-ui.admin/lib/jquery/1.9.1/jquery.min",
		layuijs : "plugins/layui-v2.2.5/layui",
		ajax_lib:"js/modules/ajax_lib",
		common:	"js/common",
		base64:	"js/modules/base64.min"
	}
});

require([ 'common','ajax_lib','base64'],function(common , ajax , base64 ){
		$("#loginbtn").click(function() {
			var b = validateLogin();
			
			
			if(!!b){
				window.location.href = "index.html";
			}else{
				return b;
			}
		});
		function validateLogin() {
			var url= common.rootPath+"/login";
			var useraccount = $("#useraccount").val();
			if(!useraccount){
				layer.open({
					  type: 0, 
					  content:"用户名不能为空，请检查！" //这里content是一个普通的String
					});
				return false;
			}
			var userpasswd = $("#userpasswd").val();
			if(!userpasswd){
				layer.open({
					  type: 0, 
					  content: "密码不能为空，请检查！" //这里content是一个普通的String
					});
				return false;
			}
			var data={account:base64.encode(useraccount),passwd:base64.encode(userpasswd)};
			var b = false;
			ajax.postParam(url,data,function(res){
				
				if(res.content){
					b = true;
				}else{
					layer.open({
						  type: 0, 
						  content: "用户密码出错，请检查！" //这里content是一个普通的String
						});
				}
			});
			return b;
		}
	
});
