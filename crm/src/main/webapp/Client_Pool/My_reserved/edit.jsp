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

<title></title>
</head>
<body>
<style>
.layui-input{width:200px;}
</style>

<form class="layui-form" lay-filter="myform" action="/crm/Reserve/update">
<input name="id" value="${param.id}" type="hidden">
<input name="revisitid" type="hidden">
<input name="clientid" type="hidden">
<input name="execuserid" type="hidden">
<input name="createdate" type="hidden">
<input name="userid" type="hidden">
  <div class="layui-form-item">
  
  	<div class="layui-inline">
      <label class="layui-form-label">预约时间</label>
      <div class="layui-input-inline">
        <input class="layui-input" id="test1" name="date" type="text" placeholder="yyyy-MM-dd" >
      </div>
    </div>

  </div>
  
  <div class="layui-form-item">
    <label class="layui-form-label">类型</label>
    <div class="layui-input-inline">
      <select name="type" >
      </select>
    </div>
    
    <label class="layui-form-label">状态</label>
    <div class="layui-input-inline">
      <select name="statu" >
      </select>
    </div>
    
    <label class="layui-form-label">执行状态</label>
    <div class="layui-input-inline">
      <select name="execstatu" >
      </select>
    </div>
  </div>
  
  <div class="layui-form-item">
    <label class="layui-form-label">结果</label>
    <div class="layui-input-block">
      <input type="text" name="result"  autocomplete="off" placeholder="请输入结果" class="layui-input">
    </div>
  </div>
  
   <div class="layui-form-item">
    <div class="layui-input-block">
      <button class="layui-btn" lay-submit="" lay-filter="demo1">保存</button>
    </div>
  </div>
</form>

<script type="text/javascript">
layui.use(['form','laydate'], function(){
	  var form = layui.form;
	  var laydate = layui.laydate;
	  laydate.render({
		    elem: '#test1'
		    ,trigger: 'click'
		  });
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
	$.post("/crm/Reserve/edit",{id:id}, function(json) {
		render('myform', json);
		getarray("/crm/Reserve/getTypes",{},"[name=type]",json.type);
		getarray("/crm/Reserve/getStatus",{},"[name=statu]",json.statu);
		getarray("/crm/Reserve/getExecstatus",{},"[name=execstatu]",json.execstatu);
	},"json");
	
}

init();

function getlist(url,data,selector,def_id){
		$.post(url,data, function(json) {
			var s=$(selector).empty();
			s.append($("<option value=''></option>"))
			for(var i=0;i<json.length;i++){
				var ss="";
				if(json[i].id==def_id) ss="selected='selected'";
				s.append($("<option value='"+json[i].id+"' "+ss+" >"+json[i].name+"</option>"))
			}
			layui.form.render('select');
		},"json");
}
</script>
</body>
</html>