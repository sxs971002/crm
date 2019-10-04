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


<form class="layui-form" lay-filter="myform" action="/crm/Reserve/insert">
<c:if test="${param.revisitid!=null}">
	<input name="revisitid" type="hidden" class="layui-input" value="${param.revisitid}"></input>
</c:if>
  
  <input name="clientid" type="hidden" class="layui-input" value="${param.clientid}"></input>
  <input name="userid" type="hidden" class="layui-input" value="${param.execuserid}"></input>
  <input name="execuserid" type="hidden" class="layui-input" value="${param.execuserid}"></input>
  
  <div class="layui-form-item">
  	  <label class="layui-form-label">预约客户</label>
	      <div class="layui-input-inline">
	        <input name="clientname"  class="layui-input" ></input> 
	      </div>
   	  <label class="layui-form-label">预约创建人</label>
	      <div class="layui-input-inline">
	        <input name="username"  class="layui-input" ></input>
	      </div>
	  <label class="layui-form-label">预约处理人</label>
		  <div class="layui-input-inline">
		      <input name="execusername"  class="layui-input" ></input> 
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
  
  <label class="layui-form-label">预约时间</label>
      <div class="layui-input-inline">
        <input class="layui-input" id="test1" name="date" type="text" placeholder="yyyy-MM-dd" >
      </div>
  
    <label class="layui-form-label">结果</label>
    <div class="layui-input-inline">
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

var clientid = ${param.clientid};
var execuserid = ${param.execuserid};

function init(){
	$.post("/crm/Client/edit",{id:clientid}, function(json) {
		render('myform', json);
		getarray("/crm/Reserve/getTypes",{},"[name=type]",0);
		getarray("/crm/Reserve/getStatus",{},"[name=statu]",0);
		getarray("/crm/Reserve/getExecstatus",{},"[name=execstatu]",0);
		getlist("/crm/Client/edit",{id:clientid},"[name=clientname]");
		getlist("/crm/User/edit",{id:execuserid},"[name=username]");
		getlist("/crm/User/edit",{id:execuserid},"[name=execusername]");
	},"json");
	
}

init();

function getlist(url,data,selector){
		$.post(url,data, function(json) {
			$(selector).val(json.name);
		},"json");
}
</script>
</body>
</html>