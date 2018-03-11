require.config({
	baseUrl: "/logis-web/static/",
	paths : {
		jquery : "plugins/h-ui.admin/lib/jquery/1.9.1/jquery.min",
		layuijs : "plugins/layui-v2.2.5/layui",
		ajax_lib:"js/modules/ajax_lib",
		common:	"js/common",
		md5:"https://cdn.bootcss.com/blueimp-md5/2.10.0/js/md5"
//		sysuser:	"js/sysuser/sysuser"
	},
	shim: {
	    md5:{
	        exports: "md5"
	    }
	}
});

require([ 'common','ajax_lib','md5'],function(common , ajax , md5 ){
		$("#loginbtn").click(function() {
			debugger;
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
				common.tips("提示","用户名不能为空，请检查！");
				return false;
			}
			var userpasswd = $("#userpasswd").val();
			if(!userpasswd){
				common.tips("提示","密码不能为空，请检查！");
				return false;
			}
			 var b = new Base64();  
			var data={account:b.encode(useraccount),passwd:b.encode(userpasswd)};
			var b = false;
			ajax.postParam(url,data,function(res){
				debugger;
				if(res.content){
					b = true;
				}else{
					common.tips("提示","用户密码出错，请检查！");
				}
			});
			return b;
		}
	
});
