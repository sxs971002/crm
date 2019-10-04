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

<form class="layui-form" lay-filter="myform" action="/crm/User/passedit">

	<div class="layui-form-item">
		<label class="layui-form-label">初始密码:</label>
		<div class="layui-input-inline">
			<input type="text" name="pass" autocomplete="off" class="layui-input">
		</div>
	</div>

	<div class="layui-form-item">
	
		<label class="layui-form-label">*新密码:</label>
		<div class="layui-input-inline">
			<input type="text" name="newpass1" class="layui-input" missingMessage="密码必须填写">
		</div>
	</div>
	
	<div class="layui-form-item">
		<label class="layui-form-label">*确认新密码:</label>
		<div class="layui-input-inline">
			<input name="newpass2" class="layui-input" type="text" missingMessage="密码必须填写">
		</div>
		
	</div>

	<div class="layui-form-item">
		<div class="layui-input-block">
			<button class="layui-btn" lay-submit="" lay-filter="demo1">保存</button>
		</div>
	</div>
</form>
<script type="text/javascript">

	var id = ${currentUser.id};
	function init() {
		$.post("/crm/User/edit", {id : id},function(json) {
			render('myform', json);
		}, "json");
	}
	init();
	
	layui.use([ 'form', 'layer'], function() {
		var form = layui.form;
		var layer = layui.layer;
		form.on('submit(demo1)', function(data) {
			var newpass1 = $("[name=newpass1]").val();
			var newpass2 = $("[name=newpass2]").val();
			alert(newpass1);
			alert(newpass2);
			if(newpass1!=newpass2){
				layer.msg("两次输入密码不一致,请重新输入", {icon : 7});
			}else{
				alert(data.field.newpass1);
				$.post($("form").attr("action"), {newpass:newpass1}, function(json) {
					closeFrame();
					//parent.fresh('demo');
				}, "json");
			}
			return false;
		});
	});
</script>
</body>
</html>