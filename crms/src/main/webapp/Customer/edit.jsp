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
.layui-input{width:200px;}
</style>

<c:if test="${param.id==null}">
<form class="layui-form" lay-filter="myform" action="../Customer/insert">
</c:if>
<c:if test="${param.id!=null}">
<form class="layui-form" lay-filter="myform" action="../Customer/update">
<input type="hidden" name="id" >
</c:if>
  <div class="layui-form-item">
    <label class="layui-form-label">客户名称</label>
    <div class="layui-input-block">
      <input type="text" name="cusname"  autocomplete="off" placeholder="请输入客户名称" class="layui-input">
    </div>
  </div>
  
  <div class="layui-form-item">
    <label class="layui-form-label">联系方式</label>
    <div class="layui-input-block">
      <input type="text" name="custel"  autocomplete="off" placeholder="请输入联系方式" class="layui-input">
    </div>
  </div>
  
   <div class="layui-form-item">
    <label class="layui-form-label">性别</label>
    <div class="layui-input-block">
      <select name="cussex" >
      </select>
    </div>
  </div>
   <div class="layui-form-item">
    <label class="layui-form-label">地址</label>
    <div class="layui-input-block">
      <input type="text" name="cusaddress"  autocomplete="off" placeholder="请输入地址" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">等级</label>
    <div class="layui-input-block">
      <select name="cuslevelid" >
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
		getarray("../Customer/getSexs",{},"[name=cussex]",json.cussex);
		getlist("../Customer/getStatus",{},"[name=cuslevelid]",json.cuslevelid);
	},"json");
	
}
if(id.length>0){
	init();
}else{
	getarray("../Customer/getSexs",{},"[name=cussex]",0);
	getlist("../Customer/getStatus",{},"[name=cuslevelid]",0);
}

function getlist(url,data,selector,def_id){
		$.post(url,data, function(json) {
			var s=$(selector).empty();
			s.append($("<option value=''></option>"))
			for(var i=0;i<json.length;i++){
				var ss="";
				if(json[i].id==def_id) ss="selected='selected'";
				s.append($("<option value='"+json[i].id+"' "+ss+" >"+json[i].levelname+"</option>"))
			}
			layui.form.render('select');
		},"json");
}
</script>
</body>
</html>