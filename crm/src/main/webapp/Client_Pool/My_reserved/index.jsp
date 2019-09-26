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
<a class="layui-btn layui-btn-xs" lay-event="edit">修改</a>
<a class="layui-btn layui-btn-xs" lay-event="record">我的回访</a>
<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="infos">客户详情</a>
</script>
	<script type="text/html" id="toolbarDemo">
  <div class="layui-btn-container">
    <div class="layui-input-inline">
      <input type="text" name="txt" lay-verify="title"  autocomplete="off" placeholder="请输入名称" class="layui-input input">
    </div>
    <button class="layui-btn layui-btn-sm" lay-event="search">查询</button>
  </div>
</script>

	<script type="text/javascript">
	var execuserid = ${currentUser.id};
	
		layui.use('table', function() {
			var table = layui.table;

			//第一个实例
			table.render({
				elem : '#demo',
				height : 462,
				url : '/crm/Client_Pool/Myreserved' //数据接口
				,
				where:{execuserid:execuserid},
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
					field : 'revisitid',
					title : '回访表ID',
					width : 150
				},{
					field : 'clientname',
					title : '客户名称',
					width : 150
				},{
					field : 'username',
					title : '创建人',
					width : 150
				},{
					field : 'createdate',
					title : '创建时间',
					width : 150
				},{
					field : 'date',
					title : '预约时间',
					width : 150
				},{
					field : 'typename',
					title : '预约类型',
					width : 150
				},{
					field : 'statuname',
					title : '状态',
					width : 150
				},{
					field : 'execstatuname',
					title : '执行状态',
					width : 150
				}, {
					field : 'result',
					title : '结果',
					width : 150
				}, {
					fixed : 'right',
					title : '操作',
					toolbar : '#barDemo',
					width : 250,
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
				if (obj.event === 'infos') { ///lay-event 属性
					openFrame('./infos.jsp?clientid='+data.clientid,'客户详情',['1000px', '100%']);
				}else if(obj.event === 'record'){
					openFrame('./record.jsp?clientid='+data.clientid+'&execuserid='+execuserid,'我的回访',['1000px', '100%']);
				}else if(obj.event === 'edit'){
					openFrame('./edit.jsp?id='+data.id,'修改',['1000px', '70%']);
				}
				
			});

			table.on('toolbar(test)', function(obj) {
				if (obj.event === 'search') {
					var txt = $(event.target).prev().find("input").val();
					reload('demo',{txt : txt});
				}
			});

		});
		
	</script>
</body>
</html>