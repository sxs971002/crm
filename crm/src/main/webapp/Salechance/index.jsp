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
				url : '../Salechance/index' //数据接口
				,
				toolbar : '#toolbarDemo',
				page : true //开启分页
				,
				cols : [ [ //表头
				{
					field : 'id',
					title : 'ID',
					width : 80,
					sort : true,
					fixed : 'right'
				}, {
					field : 'chance_form',
					title : '销售机会来源',
					width : 150
				},{
					field : 'cusname',
					title : '客户名称',
					width : 150
				},{
					field : 'statusname',
					title : '销售机会状态',
					width : 150
				}, {
					field : 'chance_createtime',
					title : '发现时间',
					width : 100
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
					openFrame('../Salechance/edit.jsp?id='+data.id,'编辑',['400px', '90%']);
				}
			});

			table.on('toolbar(test)', function(obj) {
				if (obj.event === 'search') {
					var txt = $(event.target).prev().find("input").val();
					reload('demo',{txt : txt});
				} else if(obj.event === 'add'){
					openFrame("../Salechance/edit.jsp",'新增',['400px', '90%']);
				}
			});

		});
	</script>
</body>
</html>