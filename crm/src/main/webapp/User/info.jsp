<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<link href="../X-admin/lib/layui/css/layui.css" rel="stylesheet">
<script type="text/javascript" src="../X-admin/lib/layui/layui.all.js"></script>
<script src="../X-admin/js/jquery-2.2.4.min.js"></script>
<script type="text/javascript" src="../X-admin/js/my.js"></script>

<title></title>
</head>
<body>
<style>
.layui-input{width:200px;margin-top: 10px;}
.layui-input-block {
    width: 200px;
    margin-top: 10px;
}
.layui-form-label {
margin-top: 10px;
}
</style>

<form class="layui-form" lay-filter="myform" action="../User/update">

	<div class="layui-form-item">
		<label class="layui-form-label">用户名</label>
		<div class="layui-input-inline">
			<input type="text" name="name" autocomplete="off" class="layui-input">
		</div>
	
		<label class="layui-form-label">密码</label>
		<div class="layui-input-inline">
			<input type="text" name="pass" autocomplete="off" class="layui-input">
		</div>
	</div>

	<div class="layui-form-item">
	
		<label class="layui-form-label">联系方式</label>
		<div class="layui-input-inline">
			<input type="text" name="tel" class="layui-input">
		</div>
	
		<label class="layui-form-label">性别</label>
		<div class="layui-input-inline">
			<input name="sexname" class="layui-input" readonly="readonly">
		</div>
		
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">权限</label>
		<div class="layui-input-inline">
			<input type="text" name="powername" readonly="readonly" class="layui-input">
		</div>
			
		<label class="layui-form-label">状态</label>
		<div class="layui-input-inline">
			<input type="text" name="statuname" readonly="readonly" class="layui-input">
		</div>			
	</div>	
	<div class="layui-form-item">
				<label class="layui-form-label">工作组</label>
				<div class="layui-input-inline">
					<input type="text" name="groupname" readonly="readonly" class="layui-input">
				</div>
	</div>

	<div class="layui-form-item">
				<div class="layui-input-block">
					<button class="layui-btn" lay-submit="" lay-filter="demo1">保存</button>
				</div>
			</div>
</form>

			<script type="text/javascript">
				layui.use([ 'form', ], function() {
					var form = layui.form;
					form.on('submit(demo1)', function(data) {
						$.post($("form").attr("action"), data.field, function(
								json) {
							closeFrame();
							parent.fresh('demo');
						}, "json");

						return false;
					});
				});

				var id = ${currentUser.id};
				alert(id);
				function init() {
					$.post("/crm/User/edit", {id : id},function(json) {
						render('myform', json);
					}, "json");
				}
				init();

				function getlist(url, data, selector, def_id) {
					$.post(url,data,function(json) {
							
					}, "json");
				}
			</script>
</body>
</html>