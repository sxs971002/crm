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
<a class="layui-btn layui-btn-xs" lay-event="addreserve">添加预约</a>
<a class="layui-btn layui-btn-xs" lay-event="histories">历史回访记录</a>
<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="remove">放弃</a>
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

	<script type="text/javascript">
	
	var tel = ${currentUser.tel};
	var execuserid = ${currentUser.id};
	
		layui.use('table', function() {
			var table = layui.table;

			//第一个实例
			table.render({
				elem : '#demo',
				height : 610,
				url : '/crm/Client_Pool/Myunexecuted' //数据接口
				,
				where:{tel:tel},
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
					width : 200
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
					title : '联系人们',
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
					width : 300,
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
				if (obj.event === 'addreserve') {
					openFrame('./addreserve.jsp?execuserid='+execuserid+'&clientid='+data.id,'编辑',['1000px', '80%']);
				}else if (obj.event === 'remove') { ///lay-event 属性
					
						$.post("/crm/Client/remove", {id : data.id}, 
								function(json) {
							reload('demo');
							layer.close(layer.index);
								}, "json");
					
				}else if(obj.event === 'histories') {
					openFrame('./histories.jsp?clientid='+data.id,'历史回访记录',['900px', '90%']);
				}else {
					openFrame('./edit.jsp?id='+data.id,'编辑',['900px', '100%']);
				}
			});

			table.on('toolbar(test)', function(obj) {
				if (obj.event === 'search') {
					var txt = $(event.target).prev().find("input").val();
					reload('demo',{txt : txt});
				} else if(obj.event === 'appoints'){
					openFrame("./edit.jsp",'批量分配',['900px', '100%']);
				}
			});

		});
		
	</script>
</body>
</html>