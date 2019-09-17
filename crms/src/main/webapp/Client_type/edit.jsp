<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
.layui-input{width:230px;margin-top: 10px}
.layui-form-label{width:100px}
.layui-btn{margin-left: 20px}
</style>

<c:if test="${param.id==null}">
<form class="layui-form" lay-filter="myform" action="../Client_type/insert">
</c:if>
<c:if test="${param.id!=null}">
<form class="layui-form" lay-filter="myform" action="../Client_type/update">
<input type="hidden" name="id" >
</c:if>
  <div class="layui-form-item">
    <label class="layui-form-label">客户类型名称</label>
    <div class="layui-input-block">
      <input type="text" name="name"  autocomplete="off" placeholder="请输入客户类型名称" class="layui-input">
    </div>
  </div>

   <div class="layui-form-item">
    <div class="layui-input-block">
      <button class="layui-btn" lay-submit="" lay-filter="demo1">保存</button>
    </div>
  </div>
</form>

<script type="text/javascript">
layui.use(['form',], function(){
	  var form = layui.form;
	  form.on('submit(demo1)', function(data){
		 $.post($("form").attr("action"), data.field, function(json) {
			  closeFrame();
			  parent.fresh('demo');
			}, "json");
		    
		    return false;
		  });
});



var id="${param.id}";
function init(){
	$.post("edit",{id:id}, function(json) {
		render('myform', json);
		
	},"json");
	
}
if(id.length>0){
	init();
}else{
	
}


</script>
</body>
</html>