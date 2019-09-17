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
.layui-input {
	width: 200px;
}
</style>

	<c:if test="${param.id==null}">
		<form class="layui-form" lay-filter="myform" action="../User/insert">
	</c:if>
	<c:if test="${param.id!=null}">
		<form class="layui-form" lay-filter="myform" action="../User/update">
			<input type="hidden" name="id">
	</c:if>
	<div class="layui-form-item">
		<label class="layui-form-label">用户名</label>
		<div class="layui-input-block">
			<input type="text" name="name" autocomplete="off"
				placeholder="请输入用户名" class="layui-input">
		</div>
	</div>

	<div class="layui-form-item">
		<label class="layui-form-label">密码</label>
		<div class="layui-input-block">
			<input type="text" name="pass" autocomplete="off" placeholder="请输入密码"
				class="layui-input">
		</div>
	</div>

	<div class="layui-form-item">
		<label class="layui-form-label">联系方式</label>
		<div class="layui-input-block">
			<input type="text" name="tel" autocomplete="off"
				placeholder="请输入联系方式" class="layui-input">
		</div>
	</div>

	<div class="layui-form-item">
		<label class="layui-form-label">性别</label>
		<div class="layui-input-block">
			<select name="sex">
			</select>
		</div>

		<div class="layui-form-item">
			<label class="layui-form-label">权限</label>
			<div class="layui-input-block">
				<select name="power">
				</select>
			</div>

			<div class="layui-form-item">
				<label class="layui-form-label">状态</label>
				<div class="layui-input-block">
					<select name="statu">
					</select>
				</div>
			</div>
			
			<div class="layui-form-item">
				<label class="layui-form-label">工作组</label>
				<div class="layui-input-block">
					<select name="groupid">
					</select>
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

				var id = "${param.id}";
				function init() {
					$.post("edit", {
						id : id
					},
							function(json) {
								render('myform', json);
								getarray("../User/getSexs", {}, "[name=sex]",
										json.sex);
								getarray("../User/getPowers", {},
										"[name=power]", json.power);
								getarray("../User/getStatus", {},
										"[name=statu]", json.statu);
								getlist("../User/getGroups", {},
										"[name=groupid]", json.groupid);
							}, "json");
				}
				if (id.length > 0) {
					init();
				} else {
					getarray("../User/getSexs", {}, "[name=sex]", 0);
					getarray("../User/getPowers", {}, "[name=power]", 0);
					getarray("../User/getStatus", {}, "[name=statu]", 0);
					getlist("../User/getGroups", {}, "[name=groupid]", 0);
				}

				function getlist(url, data, selector, def_id) {
					$
							.post(
									url,
									data,
									function(json) {
										var s = $(selector).empty();
										s
												.append($("<option value=''></option>"))
										for (var i = 0; i < json.length; i++) {
											var ss = "";
											if (json[i].id == def_id)
												ss = "selected='selected'";
											s
													.append($("<option value='"+json[i].id+"' "+ss+" >"
															+ json[i].name
															+ "</option>"))
										}
										layui.form.render('select');
									}, "json");
				}
			</script>
</body>
</html>