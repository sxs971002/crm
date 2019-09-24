<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<link href="/crm/X-admin/lib/layui/css/layui.css" rel="stylesheet">
<script type="text/javascript" src="/crm/X-admin/lib/layui/layui.all.js"></script>
<script src="/crm/X-admin/js/jquery-2.2.4.min.js"></script>
<script type="text/javascript" src="/crm/X-admin/js/my.js"></script>
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
    <button class="layui-btn layui-btn-sm" lay-event="appoints">批量分配</button>
  </div>
</script>

	<script>
	
		layui.use('table', function() {
			var table = layui.table;

			//第一个实例
			table.render({
				elem : '#demo',
				height : 462,
				url : '/crm/Client_Pool/noappoint' //数据接口
				,
				toolbar : '#toolbarDemo',
				page : true //开启分页
				,
				cols : [ [ //表头
				{
					field : 'id',
					title : 'ID',
					width : 100,
					sort : true,
				}, {
					field : 'name',
					title : '客户名称',
					width : 100
				},{
					field : 'sexname',
					title : '性别',
					width : 80
				},{
					field : 'tel',
					title : '联系方式',
					width : 150
				},{
					field : 'qq',
					title : 'QQ',
					width : 150
				},{
					field : 'email',
					title : '邮箱',
					width : 150
				},{
					field : 'address',
					title : '地址',
					width : 150
				},{
					field : 'infos',
					title : '额外信息',
					width : 150
				},{
					field : 'linkstatuname',
					title : '电话状态',
					width : 150
				},{
					field : 'clientstatuname',
					title : '客户状态',
					width : 150
				},{
					field : 'purposestatuname',
					title : '意向状态',
					width : 150
				},{
					field : 'assessstatuname',
					title : '评估状态',
					width : 150
				},{
					field : 'execstatuname',
					title : '执行状态',
					width : 150
				}, {
					field : 'clienttypename',
					title : '客户类型',
					width : 150
				}, {
					field : 'usernames',
					title : '处理人',
					width : 150
				}, {
					field : 'createuserid',
					title : '创建人',
					width : 150
				}, {
					field : 'createdate',
					title : '创建时间',
					width : 150
				}, {
					field : 'srcid',
					title : '客户来源',
					width : 150
				}, {
					field : 'count',
					title : '回访次数',
					width : 150
				}, {
					field : 'comments',
					title : '备注',
					width : 150
				}, {
					fixed : 'right',
					title : '操作',
					toolbar : '#barDemo',
					width : 200,
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
					openFrame('./edit.jsp?id='+data.id,'编辑',['900px', '100%']);
				}
			});

			table.on('toolbar(test)', function(obj) {
				if (obj.event === 'search') {
					var txt = $(event.target).prev().find("input").val();
					reload('demo',{txt : txt});
				} else {
					openFrame("./edit.jsp",'批量分配',['900px', '100%']);
				}
			});

		});
	</script>
</body>
</html>