<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<link href="../X-admin/lib/layui/css/layui.css" rel="stylesheet">
<script type="text/javascript" src="../X-admin/lib/layui/layui.all.js"></script>
<script src="../X-admin/js/jquery-2.2.4.min.js"></script>
<script type="text/javascript" src="../X-admin/js/my.js"></script>
<title></title>
<style type="text/css">
.input {
	font-size: 16px; width : 200px;
	height: 30px;
	margin-top: -10px;
	margin-right: 10px;
	width: 200px;
}

.layui-form-select{width:200px;
}
</style>
</head>
<body>
	<table id="demo" lay-filter="test"></table>
	<script type="text/html" id="barDemo">
<a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
	<script type="text/html" id="toolbarDemo">
  <div class="layui-btn-container">
    <div class="layui-input-inline">
      <input type="text" name="txt" lay-verify="title"  autocomplete="off" placeholder="请输入名称" class="layui-input input">
    </div>
    <button class="layui-btn layui-btn-sm" lay-event="search">查询</button>
    <button class="layui-btn layui-btn-sm" lay-event="add">新增</button>
  </div>
</script>

	<script>
	
		layui.use('table', function() {
			var table = layui.table;

			//第一个实例
			table.render({
				elem : '#demo',
				height : 462,
				url : '../Order/index' //数据接口
				,
				toolbar : '#toolbarDemo',
				page : true //开启分页
				,
				cols : [ [ //表头
				{
					field : 'id',
					title : 'ID',
					width : 50,
					sort : true,
				},{
					field : 'clientname',
					title : '客户名称',
					width : 80
				},{
					field : 'createdate',
					title : '创建日期',
					width : 80
				},{
					field : 'performdate',
					title : '业绩日期',
					width : 150
				},{
					field : 'orderdate',
					title : '合同日期',
					width : 150
				},{
					field : 'startdate',
					title : '开始日期',
					width : 150
				},{
					field : 'enddate',
					title : '截止日期',
					width : 150
				},{
					field : 'infos',
					title : '额外信息',
					width : 80
				},{
					field : 'createusername',
					title : '创建人名称',
					width : 80
				},{
					field : 'files',
					title : '文件',
					width : 80
				},{
					field : 'performuserids',
					title : '业绩人员',
					width : 80
				},{
					field : 'performweight',
					title : '业绩比重',
					width : 80
				}, {
					field : 'statu',
					title : '状态',
					width : 80
				}, {
					field : 'totalprice',
					title : '总金额',
					width : 80
				}, {
					field : 'comments',
					title : '备注',
					width : 80
				}, {
					fixed : 'right',
					title : '操作',
					toolbar : '#barDemo',
					width : 150,
					align : 'center'
				}

				] ],
				parseData : function(res) {
					return {
						"code" : res.code,
						"msg" : res.msg,
						"count" : res.count,
						"data" : res.list
					}
				}
			});
			
			

			//obj 行      obj.data 行数据    data.id 列
			//test  是table的lay-filter="test" 属性
			table.on('tool(test)', function(obj) {
				var data = obj.data;
				if (obj.event === 'del') { ///lay-event 属性
					
					myconfirm("刪除？",function(){
						$.post("delete", {id : data.id}, 
								function(json) {
							reload('demo');
							layer.close(layer.index);
								}, "json");
					});
				}else{
					openFrame('../Order/edit.jsp?id='+data.id,'编辑',['400px', '70%']);
				}
			});

			table.on('toolbar(test)', function(obj) {
				if (obj.event === 'search') {
					var txt = $(event.target).prev().find("input").val();
					reload('demo',{txt : txt});
				} else {
					openFrame("../Order/edit.jsp",'新增',['400px', '70%']);
				}
			});

		});
	</script>
</body>
</html>