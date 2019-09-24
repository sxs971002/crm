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
<script type="text/javascript" src="../X-admin/js/tableSelect.js"></script>

<title></title>
</head>
<body>
	<style>
.layui-input {
	width: 200px;
}

.layui-input-block {
	width: 200px;
}
</style>

	<c:if test="${param.id==null}">
		<form class="layui-form" lay-filter="myform" action="../Order/insert">
	</c:if>
	<c:if test="${param.id!=null}">
		<form class="layui-form" lay-filter="myform" action="../Order/update">
			<input type="hidden" name="id">
	</c:if>
	<div class="layui-form-item">
		<div class="layui-inline">
			<label class="layui-form-label">客户名称</label>
			<div class="layui-input-block">
				<select name="clientid"></select>
			</div>
		</div>

			<div class="layui-inline">
				<label class="layui-form-label">业绩时间</label>
				<div class="layui-input-block">
					<input class="layui-input" id="test1" name="performdate"
						type="text" placeholder="yyyy-MM-dd">
				</div>
			</div>

			<div class="layui-inline">
				<label class="layui-form-label">合同时间</label>
				<div class="layui-input-block">
					<input class="layui-input" id="test2" name="orderdate" type="text"
						placeholder="yyyy-MM-dd">
				</div>
			</div>
	</div>
	<div class="layui-form-item">
			<div class="layui-inline">
				<label class="layui-form-label">开始时间</label>
				<div class="layui-input-block">
					<input class="layui-input" id="test3" name="startdate" type="text"
						placeholder="yyyy-MM-dd">
				</div>
			</div>

			<div class="layui-inline">
				<label class="layui-form-label">结束时间</label>
				<div class="layui-input-block">
					<input class="layui-input" id="test4" name="enddate" type="text"
						placeholder="yyyy-MM-dd">
				</div>
			</div>

			<div class="layui-inline">
				<label class="layui-form-label">额外信息</label>
				<div class="layui-input-block">
					<input type="text" name="infos" autocomplete="off"
						placeholder="请输入额外信息" class="layui-input">
				</div>
			</div>
	</div>

	<div class="layui-form-item">
			<div class="layui-inline">
				<label class="layui-form-label">创建人</label>
				<div class="layui-input-block">
					<select name="createuserid"></select>
				</div>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label">文件</label>
				<div class="layui-input-block">
					<input type="text" name="files" autocomplete="off"
						placeholder="请输入文件" class="layui-input">
				</div>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label">业绩人员</label>
				<div class="layui-input-block">
					<input type="hidden" name="performuserids"> 
					<input
						type="text" name="performusernames" readonly="readonly"
						autocomplete="off" placeholder="请选择业绩人员" class="layui-input"
						id="demo">
				</div>
			</div>
	</div>

	<div class="layui-form-item">
			<div class="layui-inline">
				<label class="layui-form-label">业绩比重</label>
				<div class="layui-input-block">
					<input type="text" name="performweight" autocomplete="off"
						placeholder="请输入业绩比重" class="layui-input">
				</div>
			</div>

			<div class="layui-inline">
				<label class="layui-form-label">状态</label>
				<div class="layui-input-block">
					<select name="statu">
					</select>
				</div>
			</div>

			<div class="layui-inline">
				<label class="layui-form-label">总金额</label>
				<div class="layui-input-block">
					<input type="text" name="totalprice" autocomplete="off"
						placeholder="请输入总金额" class="layui-input">
				</div>
			</div>
	</div>

	<div class="layui-form-item">
			<div class="layui-inline">
				<label class="layui-form-label">备注</label>
				<div class="layui-input-block">
					<input type="text" name="comments" autocomplete="off"
						placeholder="请输入备注" class="layui-input">
				</div>
			</div>
	</div>

			<div class="layui-inline">
				<div class="layui-input-block">
					<button class="layui-btn" lay-submit="" lay-filter="demo1">保存</button>
				</div>
			</div>
			</form>

			<script type="text/javascript">
				layui.use([ 'form', 'laydate' ], function() {
					var form = layui.form;
					var laydate = layui.laydate;
					laydate.render({
						elem : '#test1',
						trigger : 'click'
					});
					laydate.render({
						elem : '#test2',
						trigger : 'click'
					});
					laydate.render({
						elem : '#test3',
						trigger : 'click'
					});
					laydate.render({
						elem : '#test4',
						trigger : 'click'
					});
					form.on('submit(demo1)', function(data) {
						console.log(data.field)
						
						$.post($("form").attr("action"), data.field, function(
								json) {
							closeFrame();
							parent.fresh('demo');
						}, "json");

						return false;
					});
				});

				var tableSelect = layui.tableSelect;
				tableSelect.render({
					elem : '#demo', //定义输入框input对象
					checkedKey : 'id',//表格的唯一建值，非常重要，影响到选中状态 必填
					searchKey : 'txt', //搜索输入框的name值 默认keyword
					searchPlaceholder : '搜索', //搜索输入框的提示文字 默认关键词搜索
					table : { //定义表格参数，与LAYUI的TABLE模块一致，只是无需再定义表格elem
						url : '../User/index',
						height : 200,
						cols : [ [ {
							type : "checkbox"
						}, {
							field : 'id',
							width : 200,
							title : 'ID'
						}, {
							field : 'name',
							width : 200,
							title : '姓名'
						}, {
							field : 'tel',
							width : 180,
							title : '电话'
						}, {
							field : 'groupname',
							width : 180,
							title : '组名'
						} ] ],
						parseData : function(res) {
							return {
								"count" : res.count,
								"code" : res.code,
								"msg" : res.msg,
								"data" : res.list
							}
						}
					},
					done : function(elem, data) {
						//选择完后的回调，包含2个返回值 elem:返回之前input对象；data:表格返回的选中的数据 []
						//拿到data[]后 就按照业务需求做想做的事情啦~比如加个隐藏域放ID...
						var NEWJSON = []
						var NEWJSON1 = []
						layui.each(data.data, function(index, item) {
							NEWJSON.push(item.name)
							NEWJSON1.push(item.id)
						})
						elem.val(NEWJSON.join(","))
						$("[name=performuserids]").val(NEWJSON1.join(","));
					}
				});

				var id = "${param.id}";
				function init() {
					$.post("edit", {
						id : id
					}, function(json) {
						render('myform', json);
						getarray("../Order/getStatus", {}, "[name=statu]",
								json.statu);
						getlist("../Order/getCreateusers", {},
								"[name=createuserid]", json.createuserid);
						getlist("../Order/getClients", {}, "[name=clientid]",
								json.clientid);
					}, "json");

				}
				if (id.length > 0) {
					init();
				} else {
					getarray("../Order/getStatus", {}, "[name=statu]", 0);
					getlist("../Order/getCreateusers", {},"[name=createuserid]", 0);
					getlist("../Order/getClients", {}, "[name=clientid]", 0);
				}

				function getlist(url, data, selector, def_id) {
					$.post(
									url,
									data,
									function(json) {
										var s = $(selector).empty();
										s.append($("<option value=''></option>"))
										for (var i = 0; i < json.length; i++) {
											var ss = "";
											if (json[i].id == def_id)
												ss = "selected='selected'";
											s.append($("<option value='"+json[i].id+"' "+ss+" >"+ json[i].name+ "</option>"))
										}
										layui.form.render('select');
									}, "json");
				}
			</script>
</body>
</html>