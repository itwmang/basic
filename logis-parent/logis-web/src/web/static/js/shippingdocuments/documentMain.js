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

require([ 'document_', 'common', 'ajax_lib', 'layuijs' ], function(document_,
		common, ajax_lib, layuijs) {

	document_.documentinit();

	layui.use([ 'form', 'laydate' ], function() {
		var form = layui.form; // 只有执行了这一步，部分表单元素才会自动修饰成功
		laydate = layui.laydate;

		// 日期
		laydate.render({
			elem : '#billDateBeginStr'
		});
		laydate.render({
			elem : '#billDateEndStr'
		});
		form.render();
	});

	// 查询按钮事件
	$("#searchBtn").click(function() {
		document_.queryFunc();
	});

	$("#resetBtn").click(function() {
		$("#billNo").val("");
		$("#billDateBeginStr").val("");
		$("#billDateEndStr").val("");

		$('select').each(function(i, j) {
			$(j).find("option:selected").attr("selected", false);
			$(j).find("option").first().attr("selected", true);
			layui.use([ 'form' ], function() {
				var form = layui.form; // 只有执行了这一步，部分表单元素才会自动修饰成功

				form.render('select');
			});
		})

	});
	// 绑定按钮
	$("#addBtn").on(
			"click",
			function() {
				common.layerWinOpen('货运单新增', 'document-add.html', '1000',
						'500', null, function() {
							layui.use('table', function() {
								document_.queryFunc();
							});
						});
			});
	// 修改按钮事件
	$("#editBtn").click(
			function() {

				var checkStatus, data, length;

				layui.use('table', function() {
					var table = layui.table; // 只有执行了这一步，部分表单元素才会自动修饰成功
					checkStatus = table.checkStatus('document-table');
					data = checkStatus.data;
					length = data.length;
				});
				if (1 == length) {
					var id = data[0].rowId;
					common.layerWinOpen('货运单修改', 'document-add.html?id=' + id,
							'1000', '500', null, function() {
								layui.use('table', function() {
									document_.queryFunc();
								});
							});
				} else {
					layer.msg("请选择一条数据进行修改！");
				}
			});

	// 删除按钮事件
	$("#delBtn").click(function() {
		var checkStatus, data, length;
		var ids = [];

		layui.use('table', function() {
			var table = layui.table; // 只有执行了这一步，部分表单元素才会自动修饰成功
			checkStatus = table.checkStatus('document-table');
			data = checkStatus.data;
			length = data.length;
		});
		if (0 == length) {
			layer.msg("请至少选中一行数据删除！");
		} else {
			layer.confirm("确定要删除这些数据！", function() {
				var index = layer.confirm();
				layer.close(index);

				for (var i = 0; i < length; i++) {
					ids[i] = data[i].rowId;
				}
				var url = common.rootPath + "/user/shippingDocuments/delete";
				var param = {
					ids : ids.join(",")
				}
				ajax_lib.asyncPostParam(url, param, function(res) {
					if (res.status) {
						layer.msg("删除成功！");

						layui.use('table', function() {
							document_.queryFunc();
						});
					}
				});

			}, function() {

			});
		}
	});

	// 对单按钮事件
	$("#billBtn").click(
			function() {

				var checkStatus, data, length;

				layui.use('table', function() {
					var table = layui.table; // 只有执行了这一步，部分表单元素才会自动修饰成功
					checkStatus = table.checkStatus('document-table');
					data = checkStatus.data;
					length = data.length;
				});
				if (0 == length) {
					layer.msg("请至少选中一条数据进行操作！");
				} else {
					var ids = [];
					for (var i = 0; i < length; i++) {
						ids[i] = data[i].rowId;
					}
					common.layerWinOpen('对单页面', 'bill.html?ids='
							+ ids.join(","),'450', '400', null, function() {
						layui.use('table', function() {
							document_.queryFunc();
						});
					});
				}
			});

	// 收款按钮事件
	$("#recBtn").click(
			function() {

				var checkStatus, data, length;

				layui.use('table', function() {
					var table = layui.table; // 只有执行了这一步，部分表单元素才会自动修饰成功
					checkStatus = table.checkStatus('document-table');
					data = checkStatus.data;
					length = data.length;
				});
				if (0 == length) {
					layer.msg("请至少选中一条数据进行操作！");
				} else {
					var ids = [];
					for (var i = 0; i < length; i++) {
						ids[i] = data[i].rowId;
					}
					common.layerWinOpen('收款页面', 'receivables.html?ids='
							+ ids.join(","),'450', '400', null, function() {
						layui.use('table', function() {
							document_.queryFunc();
						});
					});
				}
			});

	// 付款按钮事件
	$("#payBtn").click(
			function() {
				var checkStatus, data, length;

				layui.use('table', function() {
					var table = layui.table; // 只有执行了这一步，部分表单元素才会自动修饰成功
					checkStatus = table.checkStatus('document-table');
					data = checkStatus.data;
					length = data.length;
				});
				if (0 == length) {
					layer.msg("请至少选中一条数据进行操作！");
				} else {
					var ids = [];
					for (var i = 0; i < length; i++) {
						ids[i] = data[i].rowId;
					}
					common.layerWinOpen('付款页面', 'payment.html?ids='
							+ ids.join(","), '450', '400', null, function() {
						layui.use('table', function() {
							document_.queryFunc();
						});
					});
				}
			});

});