define([ 'layuijs','common' ], function(layuijs,common) {
	var myModule = {};
	var moduleName = "document module";
	var moduleVersion = "1.0.0";
	var tableObj = null;

	/** 添加用户页面初始化 */
	var addDocumentInit = function() {
		
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
			tableObj =	table.render({
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
				cols : [ [ {
					type : 'checkbox'
				}, 
				{
					field : 'rowId',
					width : 80,
					title : 'das',
					style:"display : none"
				},
				{
					field : 'billNo',
					width : 90,
					title : '单据号',
					sort : true
				}, {
					field : 'billDate',
					width : 120,
					title : '单据日期',
					sort : true,
					templet:function(value){
		            	return getFormatDate(value.billDate, "yyyy-MM-dd" );
		            }
				}, {
					field : 'receiver',
					width : 80,
					title : '收货人'
				}, {
					field : 'receiverPhone',
					width : 100,
					title : '收货人电话',
				}, {
					field : 'shipper',
					width : 80,
					title : '发货人'
				}, {
					field : 'shipperPhone',
					width : 100,
					title : '发货人电话'
				}, {
					field : 'quantity',
					title : '数量',
					minWidth : 80
				}, {
					field : 'money',
					width : 80,
					title : '贷款',
					templet:function(value){
						var a = value.money;
		            	if(a){
		            		return a.toFixed(2);
		            	} else{
		            		return 0;
		            	}
		            }
				}, {
					field : 'freight',
					width : 80,
					title : '运费',
					templet:function(value){
						var a = value.freight;
		            	if(a){
		            		return a.toFixed(2);
		            	} else{
		            		return 0;
		            	}
		            }
				}, {
					field : 'total',
					width : 80,
					title : '合计',
					templet:function(value){
						var a = value.total;
		            	if(a){
		            		return a.toFixed(2);
		            	} else{
		            		return 0;
		            	}
		            }
				}, {
					field : 'freightType',
					width : 100,
					title : '货运方式'
				} , {
					field : 'driver',
					width : 80,
					title : '司机'
				},  {
					field : 'remarks',
					width : 120,
					title : '备注'
				},  {
					field : 'billState',
					width : 100,
					title : '单据状态'
				},  {
					field : 'receivablesState',
					width : 100,
					title : '收款状态'
				},  {
					field : 'receivablesType',
					width : 100,
					title : '收款方式'
				},  {
					field : 'receivablesDate',
					width : 110,
					title : '收款日期',
					sort : true,
					templet:function(value){
		            	return getFormatDate(value.receivablesDate, "yyyy-MM-dd" );
		            }
				},  {
					field : 'paymentState',
					width : 100,
					title : '付款状态'
				},  {
					field : 'paymentType',
					width : 100,
					title : '付款方式'
				},  {
					field : 'paymentDate',
					width : 110,
					title : '付款日期',
					sort : true,
					templet:function(value){
		            	return getFormatDate(value.paymentDate, "yyyy-MM-dd" );
		            }
				} ,  {
					field : 'pubCreatePerson',
					width : 100,
					title : '创建人'
				},  {
					field : 'pubCreateDate',
					width : 140,
					title : '创建时间',
					sort : true,
					templet:function(value){
		            	return getFormatDate(value.pubCreateDate, "yyyy-MM-dd hh:mm:ss" );
		            }
				},  {
					field : 'pubModiPerson',
					width : 100,
					title : '最后修改人'
				},  {
					field : 'pubModiDate',
					width : 140,
					title : '最后修改时间',
					sort : true,
					templet:function(value){
		            	return getFormatDate(value.pubModiDate, "yyyy-MM-dd hh:mm:ss" );
		            }
				}] ],
				page : true,
				done: function(res, curr, count){  
					$("th[data-field='rowId']").hide();
                }  	
			});
		});
		
		//绑定按钮
		$("#addBtn").on("click",function(){
			common.layerWinOpen('货运单新增','document-add.html','1000','600',null,function(){
				layui.use('table', function() {
					queryFunc();
				});
			});
		});
		
	};
	
	//查询
	var queryFunc = function(){
		var url = common.rootPath + "/user/shippingDocuments/listdocument";
		var param = {
					billNo:$("#billNo").val(),
					freightType:$("#freightType").val(),
					billDateBeginStr:$("#billDateBeginStr").val(),
					billDateEndStr:$("#billDateEndStr").val(),
					receivablesState:$("#receivablesState").val(),
					receivablesType:$("#receivablesType").val(),
					paymentState:$("#paymentState").val(),
					paymentType:$("#paymentType").val()
					};
		var data = encodeURI(JSON.stringify(param),"utf-8");
		
		layui.use('table', function() {

			var table = layui.table;
			table.reload("document-table",{ 
//				height : 'full-20', // 高度最大化减去差值
				url : rootPath + '/user/shippingDocuments/listdocument',
				method : "get",
				where: { //设定异步数据接口的额外参数，任意设					
					querydocument : data
				  }
				  ,page: {
				    curr: 1 //重新从第 1 页开始
				  }
			});
		});
	}
	
	
	
	//格式化日期
	var getFormatDate = function(date, pattern) {
		if(date==""||date==null){
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

	myModule.queryFunc = queryFunc;
	myModule.addDocumentInit = addDocumentInit;
	myModule.documentinit = documentinit;
	myModule.getFormatDate = getFormatDate;
	
	myModule.tableObj = tableObj;

	myModule.moduleName = moduleName;
	myModule.moduleVersion = moduleVersion;

	return myModule;
});