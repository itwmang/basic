define([ 'layuijs', 'common','ajax_lib'], function(layuijs, common,ajax_lib) {
	var myModule = {};
	var moduleName = "document module";
	var moduleVersion = "1.0.0";
	var tableObj = null;

	/** 添加用户页面初始化 */
	var fillBillNo = function() {
		// 初始化单据号
		var url = common.rootPath + "/user/shippingDocuments/getBillNo";
		ajax_lib.asyncGet(url, null, function(res) {
			if (!res.content) {
				layer.open({
					type : 0,
					content : "单据号生成失败。请稍后重试！" // 这里content是一个普通的String
				});
			}
			$("#billNo").val(res.content);

		});
	}
		/** 添加用户页面初始化 */
		var addDocumentInit = function(common, ajax_lib) {

		layui.use([ 'form', 'laydate' ], function() {
			form = layui.form; // 只有执行了这一步，部分表单元素才会自动修饰成功
			laydate = layui.laydate;

			// 日期
			laydate.render({
				elem : '#billDate',
				value : $("#billDate").val() ? $("#billDate").val() : new Date
			});

			form.render();
		});

		$("#receiver").focus();

		$("#money").change(function() {
			var a = $("#money").val();
			var b = $("#freight").val();
			if (!a) {
				a = 0;
			}
			if (!b) {
				b = 0;
			}
			$("#total").val(a * 1 + b * 1);
		})

		$("#freight").change(function() {
			var a = $("#money").val();
			var b = $("#freight").val();
			if (!a) {
				a = 0;
			}
			if (!b) {
				b = 0;
			}
			$("#total").val(a * 1 + b * 1);
		})

		// 修改 获取数据 加载到新增form
		var json = {};
		var id = common.getUrlParam("id");
		if (id) {
			var url = common.rootPath + "/user/shippingDocuments/edit/" + id;
			ajax_lib.asyncGet(url, null, function(res) {
				if (res) {
					json = res.content.returnObject;
					$("#billNo").val(json.billNo);
					$("#billDate").val(document_.getFormatDate(json.billDate));
					$("#receiver").val(json.receiver);
					$("#receiverPhone").val(json.receiverPhone);
					$("#shipper").val(json.shipper);
					$("#shipperPhone").val(json.shipperPhone);
					$("#quantity").val(json.quantity);
					var a = json.money;
					if (a) {
						$("#money").val();
					} else {
						$("#money").val(0)
					}
					var b = json.freight;
					if (b) {
						$("#freight").val();
					} else {
						$("#freight").val(0)
					}
					var c = json.total;
					if (c) {
						$("#total").val();
					} else {
						$("#total").val(0)
					}
					$("#freightType").val(json.freightType);
					$("#driver").val(json.driver);
					$("#remarks").val(json.remarks);
					$("#billState")
							.val(document_.getFormatDate(json.billState));
					$("#receivablesState").val(json.receivablesState);
					$("#receivablesType").val(json.receivablesType);
					$("#receivablesDate").val(
							document_.getFormatDate(json.receivablesDate));
					$("#paymentType").val(json.paymentType);
					$("#paymentState").val(json.paymentState);
					$("#paymentDate").val(
							document_.getFormatDate(json.paymentDate));
				}
			});
		} else {
			fillBillNo();
		}

		// 回车事件
		document.onkeydown = function(event) {
			var e = event || window.event;
			if (e && e.keyCode == 13) { // 回车键的键值为13
				$("#saveBtn").click();
			}
		};

	}

	/** 对单页面初始化 */
	var billInit = function() {

	}

	/** 收款页面初始化 */
	var receivablesInit = function() {

	}

	/** 付款页面初始化 */
	var paymentInit = function() {

	}

	/** 用户列表初始化 */
	var documentinit = function() {

		layui.use('table', function() {

			var table = layui.table;

			rootPath = common.rootPath;
			var param = {
				account : "test"
			};
			tableObj = table.render({
				elem : '#document-table',
				height : 'full-300', // 高度最大化减去差值
				url : rootPath + '/user/shippingDocuments/listdocument',
				method : "get",
				request : {
					pageName : 'pageIndex', // 页码的参数名称，默认：page
					limitName : 'pageSize' // 每页数据量的参数名，默认：limit
				},
				where : {
					querydocument : JSON.stringify(param)
				},
				cols : [ [
						{
							type : 'checkbox'
						},
						{
							field : 'rowId',
							width : 120,
							title : 'das',
							style : "display : none"
						},
						{
							field : 'billNo',
							width : 150,
							title : '单据号',
							sort : true
						},
						{
							field : 'billDate',
							width : 120,
							title : '单据日期',
							sort : true,
							templet : function(value) {
								return getFormatDate(value.billDate,
										"yyyy-MM-dd");
							}
						},
						{
							field : 'receiver',
							width : 120,
							title : '收货人'
						},
						{
							field : 'receiverPhone',
							width : 125,
							title : '收货人电话',
						},
						{
							field : 'shipper',
							width : 120,
							title : '发货人'
						},
						{
							field : 'shipperPhone',
							width : 125,
							title : '发货人电话'
						},
						{
							field : 'quantity',
							title : '数量',
							minwidth : 120
						},
						{
							field : 'money',
							width : 120,
							title : '贷款'
						},
						{
							field : 'freight',
							width : 120,
							title : '运费'
						},
						{
							field : 'total',
							width : 120,
							title : '合计'
						},
						{
							field : 'freightType',
							width : 120,
							title : '货运方式'
						},
						{
							field : 'driver',
							width : 120,
							title : '司机'
						},
						{
							field : 'remarks',
							width : 120,
							title : '备注'
						},
						{
							field : 'billState',
							width : 120,
							title : '单据状态'
						},
						{
							field : 'receivablesType',
							width : 120,
							title : '收款方式'
						},
						{
							field : 'receivablesDate',
							width : 150,
							title : '收款日期',
							sort : true,
							templet : function(value) {
								return getFormatDate(value.receivablesDate,
										"yyyy-MM-dd");
							}
						},
						{
							field : 'paymentType',
							width : 120,
							title : '付款方式'
						},
						{
							field : 'paymentDate',
							width : 150,
							title : '付款日期',
							sort : true,
							templet : function(value) {
								return getFormatDate(value.paymentDate,
										"yyyy-MM-dd");
							}
						} ] ],
				page : true,
				done : function(res, curr, count) {
					$("th[data-field='rowId']").hide();

					// 处理单元格点击事件
					var tb = $("#" + this.page.elem);
					var td = tb.parent().parent().find(".layui-table-body")
							.find("td");
					td.on("click", function() {
						var checkbox = $(this).find(".layui-form-checkbox");
						if (checkbox.length > 0) {
//							return false;
						} else {
							var tdck = $(this).parent().find(
									".layui-form-checkbox");
							tdck.click();
						}
						// if(!checkbox.hasClass("layui-form-checked")){
						// checkbox.addClass("layui-form-checked");
						// }else{
						// checkbox.removeClass("layui-form-checked");
						// }
					})
				}
			});
		});

		// 绑定按钮
		$("#addBtn").on(
				"click",
				function() {
					common.layerWinOpen('货运单新增', 'document-add.html', '1000',
							'550', null, function() {
								layui.use('table', function() {
									queryFunc();
								});
							});
				});

	};

	// 查询
	var queryFunc = function() {
		var url = common.rootPath + "/user/shippingDocuments/listdocument";
		var param = {
			billNo : $("#billNo").val(),
			freightType : $("#freightType").val(),
			billDateBeginStr : $("#billDateBeginStr").val(),
			billDateEndStr : $("#billDateEndStr").val(),
			receivablesState : $("#receivablesState").val(),
			receivablesType : $("#receivablesType").val(),
			paymentState : $("#paymentState").val(),
			paymentType : $("#paymentType").val(),
			queryCustomer : $("#queryCustomer").val()
		};
		var data = encodeURI(JSON.stringify(param), "utf-8");
		layui.use('table', function() {

			var table = layui.table;
			table.reload("document-table", {
				// height : 'full-20', // 高度最大化减去差值
				url : rootPath + '/user/shippingDocuments/listdocument',
				method : "get",
				where : { // 设定异步数据接口的额外参数，任意设
					querydocument : data
				},
				page : {
					curr : 1
				// 重新从第 1 页开始
				}
			});
		});
	}

	// 格式化日期
	var getFormatDate = function(date, pattern) {
		if (date == "" || date == null) {
			return "";
		}
		date = new Date(date);
		if (date == undefined) {
			date = new Date();
		}
		if (pattern == undefined) {
			pattern = "yyyy-MM-dd";
		}
		return date.format(pattern);
	}

	// 扩展Date的format方法
	Date.prototype.format = function(format) {
		var o = {
			"M+" : this.getMonth() + 1,
			"d+" : this.getDate(),
			"h+" : this.getHours(),
			"m+" : this.getMinutes(),
			"s+" : this.getSeconds(),
			"q+" : Math.floor((this.getMonth() + 3) / 3),
			"S" : this.getMilliseconds()
		}
		if (/(y+)/.test(format)) {
			format = format.replace(RegExp.$1, (this.getFullYear() + "")
					.substr(4 - RegExp.$1.length));
		}
		for ( var k in o) {
			if (new RegExp("(" + k + ")").test(format)) {
				format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k]
						: ("00" + o[k]).substr(("" + o[k]).length));
			}
		}
		return format;
	}

	//列表页查询
	myModule.queryFunc = queryFunc;
	//初始化单据编码
	myModule.fillBillNo = fillBillNo;
	//编辑页初始化
	myModule.addDocumentInit = addDocumentInit;
	//列表页初始化
	myModule.documentinit = documentinit;
	//日期格式化工具
	myModule.getFormatDate = getFormatDate;

	myModule.tableObj = tableObj;

	myModule.moduleName = moduleName;
	myModule.moduleVersion = moduleVersion;

	return myModule;
});