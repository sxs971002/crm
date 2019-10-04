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
<a class="layui-btn layui-btn-xs" lay-event="addreserve">追加预约</a>
</script>
	<script type="text/html" id="toolbarDemo">
  <div class="layui-btn-container">
    <div class="layui-input-inline">
      <input type="text" name="txt" lay-verify="title"  autocomplete="off" placeholder="请输入名称" class="layui-input input">
    </div>
    <button class="layui-btn layui-btn-sm" lay-event="search">查询</button>
    <button class="layui-btn layui-btn-sm" lay-event="add">新增回访</button>
  </div>
</script>

	<script>
	var clientid ="${param.clientid}";
	var execuserid ="${param.execuserid}";
		layui.use('table', function() {
			var table = layui.table;

			//第一个实例
			table.render({
				elem : '#demo',
				height : 462,
				url : '/crm/Client_Pool/Myrevisit' //数据接口
				,
				where:{
					clientid:clientid,
					execuserid:execuserid
				},
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
					field : 'clientname',
					title : '客户名称',
					width : 150
				}, {
					field : 'date',
					title : '回访日期',
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
				},{
					field : 'askinfo',
					title : '询问状况',
					width : 150
				}, {
					field : 'followinfo',
					title : '跟踪状况',
					width : 150
				}, {
					field : 'probleminfo',
					title : '问题状况',
					width : 150
				}, {
					field : 'comments',
					title : '备注',
					width : 150
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
				if (obj.event === 'addreserve') { ///lay-event 属性
					openFrame('/crm/Client_Pool/My_unexecuted/addreserve.jsp?execuserid='+execuserid+'&clientid='+clientid+'&revisitid='+data.id,'追加预约',['1000px', '90%']);
				}else{
					openFrame('/crm/Revisit/edit.jsp?id='+data.id,'编辑',['1000px', '70%']);
				}
			});

			table.on('toolbar(test)', function(obj) {
				if (obj.event === 'search') {
					var txt = $(event.target).prev().find("input").val();
					reload('demo',{txt : txt});
				} else {
					openFrame("./myrevisit.jsp?clientid="+clientid+'&execuserid='+execuserid,'新增回访',['1000px', '90%']);
				}
			});

		});
	</script>
</body>
</html>