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
<form class="layui-form" lay-filter="myform" action="../Reserve/insert">
</c:if>
<c:if test="${param.id!=null}">
<form class="layui-form" lay-filter="myform" action="../Reserve/update">
<input type="hidden" name="id" >
</c:if>

  <div class="layui-form-item">
    <label class="layui-form-label">回访表id</label>
    <div class="layui-input-block">
      <input type="text" name="revisitid"  autocomplete="off" placeholder="请输入" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">客户</label>
    <div class="layui-input-block">
      <select name="clientid" >
      </select>
    </div>
  </div>
  
  
  <div class="layui-inline">
      <label class="layui-form-label">预约时间</label>
      <div class="layui-input-inline">
        <input class="layui-input" id="test1" name="date" type="text" placeholder="yyyy-MM-dd" >
      </div>
    </div>
    
  
  <div class="layui-form-item">
    <label class="layui-form-label">创建人</label>
    <div class="layui-input-block">
      <select name="userid" >
      </select>
    </div>
  </div>
  
  <div class="layui-form-item">
    <label class="layui-form-label">预约处理人</label>
    <div class="layui-input-block">
      <select name="execuserid" >
      </select>
    </div>
  </div>
  
  <div class="layui-form-item">
    <label class="layui-form-label">类型</label>
    <div class="layui-input-block">
      <select name="type" >
      </select>
    </div>
  </div>
  
  <div class="layui-form-item">
    <label class="layui-form-label">状态</label>
    <div class="layui-input-block">
      <select name="statu" >
      </select>
    </div>
  </div>
  
  <div class="layui-form-item">
    <label class="layui-form-label">执行状态</label>
    <div class="layui-input-block">
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
	$.post("edit",{id:id}, function(json) {
		render('myform', json);
		getarray("../Reserve/getTypes",{},"[name=type]",json.type);
		getarray("../Reserve/getStatus",{},"[name=statu]",json.statu);
		getarray("../Reserve/getExecstatus",{},"[name=execstatu]",json.execstatu);
		getlist("../Reserve/getClients",{},"[name=clientid]",json.clientid);
		getlist("../Reserve/getUsers",{},"[name=userid]",json.userid);
		getlist("../Reserve/getUsers",{},"[name=execuserid]",json.execuserid);
	},"json");
	
}
if(id.length>0){
	init();
}else{
	getarray("../Reserve/getTypes",{},"[name=type]",0);
	getarray("../Reserve/getStatus",{},"[name=statu]",0);
	getarray("../Reserve/getExecstatus",{},"[name=execstatu]",0);
	getlist("../Reserve/getClients",{},"[name=clientid]",0);
	getlist("../Reserve/getUsers",{},"[name=userid]",0);
	getlist("../Reserve/getUsers",{},"[name=execuserid]",0);
}

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