require.config({
	baseUrl : "/logis-web/static/",
	paths : {
		jquery : "plugins/h-ui.admin/lib/jquery/1.9.1/jquery.min",
		layuijs : "plugins/layui-v2.2.5/layui",
		ajax_lib : "js/modules/ajax_lib",
		common : "js/common",
		base64 : "js/modules/base64.min"
	}
});

require([ 'common', 'ajax_lib', 'base64' ], function(common, ajax, base64) {

	$("#loginbtn").click(function() {
		login();
	});
	// 回车事件
	document.onkeydown = function(event) {
		var e = event || window.event;
		if (e && e.keyCode == 13) { // 回车键的键值为13
			login();
		}
	};
	function login() {
		var b = validateLogin();
		if (!!b) {
			window.location.href = "index.html";
		} else {
			return b;
		}
	}
	function validateLogin() {
		var url = common.rootPath + "/login";
		var useraccount = $("#useraccount").val();
		if (!useraccount) {
			layer.msg("用户名不能为空，请检查！");
			return false;
		}
		var userpasswd = $("#userpasswd").val();
		if (!userpasswd) {
			layer.msg("密码不能为空，请检查！");
			return false;
		}
		var data = {
			account : base64.encode(useraccount),
			passwd : base64.encode(userpasswd)
		};
		var b = false;
		ajax.postParam(url, data, function(res) {
			if (res === true) {
				b = true;
			} else {
				layer.msg("用户密码出错，请检查！");
			}
		});
		return b;
	}

});
