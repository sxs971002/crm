<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<link href="/crm/X-admin/lib/layui/css/layui.css" rel="stylesheet">
<script type="text/javascript" src="/crm/X-admin/lib/layui/layui.all.js"></script>
<script src="/crm/X-admin/js/jquery-2.2.4.min.js"></script>
<script type="text/javascript" src="/crm/X-admin/js/my.js"></script>
<script type="text/javascript" src="/crm/X-admin/js/tableSelect.js"></script>
<title></title>
</head>
<body>
<style>
.layui-input{width:250px;}
.layui-input-block {
    width: 250px;
}
</style>

<form class="layui-form" lay-filter="myform" action="/crm/Client_Pool/updates">
  
  <input type="hidden" name="clientids" value="${param.clientids}">
  
  <div class="layui-form-item">
    <label class="layui-form-label">处理人</label>
    <div class="layui-input-block">
      	<input type="hidden" name="userids" class="layui-input">
		<input type="text" name="usernames" readonly="readonly" autocomplete="off" placeholder="请选择处理人" class="layui-input" id="demo"> 
    </div>
  
    <div class="layui-input-block">
      <button class="layui-btn" lay-submit="" lay-filter="demo1">保存</button>
    </div>
  </div>
</form>

<script type="text/javascript">

layui.use(['form'], function(){
	  var form = layui.form;
	  form.on('submit(demo1)', function(data){
		 $.post($("form").attr("action"), data.field, function(json) {
			  closeFrame();
			  parent.fresh('demo');
			}, "json");
		    
		    return false;
		  });
});

var tableSelect = layui.tableSelect;
tableSelect.render({
	elem: '#demo',	//定义输入框input对象
	checkedKey: 'tel' ,//表格的唯一建值，非常重要，影响到选中状态 必填
	searchKey: 'txt',	//搜索输入框的name值 默认keyword
	searchPlaceholder: '搜索',	//搜索输入框的提示文字 默认关键词搜索
	table: {	//定义表格参数，与LAYUI的TABLE模块一致，只是无需再定义表格elem
		url:'/crm/User/index',
		height:200,
		cols: [[
			{type: "checkbox"},
			{field: 'id', width: 200, title: 'ID'},
            {field: 'name', width: 200, title: '姓名'},
            {field: 'tel', width: 180, title: '电话'},
            {field: 'groupname', width: 180, title: '组名'}
		]],
		parseData:function(res){
			return{
				"count":res.count,
				"code":res.code,
				"msg":res.msg,
				"data":res.list
			}
		}
	},
	done: function (elem, data) {
	//选择完后的回调，包含2个返回值 elem:返回之前input对象；data:表格返回的选中的数据 []
	//拿到data[]后 就按照业务需求做想做的事情啦~比如加个隐藏域放ID...
	var NEWJSON = []
	var NEWJSON1 = []
	layui.each(data.data,function(index,item){
		NEWJSON.push(item.name)
		NEWJSON1.push(item.id)
	})
	elem.val(NEWJSON.join(","))
	$("[name=userids]").val(NEWJSON1.join(","));
	}
});

</script>
</body>
</html>