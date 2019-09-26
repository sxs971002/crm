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
.layui-input-inline{width:200px;}
</style>

<form class="layui-form" lay-filter="myform" action="/crm/Revisit/insert">

  <input name="clientid" type="hidden" class="layui-input" value="${param.clientid}"></input>
  <input name="execuserid" type="hidden" class="layui-input" value="${param.execuserid}"></input>

  <div class="layui-form-item">
    <label class="layui-form-label">回访客户</label>
    <div class="layui-input-inline">
      <input name="clientname"  class="layui-input" readonly="readonly"></input>
    </div>
    
    <label class="layui-form-label">执行人名称</label>
    <div class="layui-input-inline">
      <input name="execusername"  class="layui-input" readonly="readonly"></input> 
    </div>
  </div>
  
  <div class="layui-form-item">
    <label class="layui-form-label">电话状态</label>
    <div class="layui-input-inline">
      <select name="linkstatu" >
      </select>
    </div>
  
    <label class="layui-form-label">客户状态</label>
    <div class="layui-input-inline">
      <select name="clientstatu" >
      </select>
    </div>
  
    <label class="layui-form-label">意向状态</label>
    <div class="layui-input-inline">
      <select name="purposestatu" >
      </select>
    </div>
   </div>
  
  <div class="layui-form-item">
    <label class="layui-form-label">评估状态</label>
    <div class="layui-input-inline">
      <select name="assessstatu" >
      </select>
    </div>
  
    <label class="layui-form-label">执行状态</label>
    <div class="layui-input-inline">
      <select name="execstatu" >
      </select>
    </div>
  
    <label class="layui-form-label">状态</label>
    <div class="layui-input-inline">
      <select name="statu" >
      </select>
    </div>
  </div>
  
  <div class="layui-form-item">
    <label class="layui-form-label">询问状况</label>
    <div class="layui-input-inline">
      <input type="text" name="askinfo"  autocomplete="off" placeholder="请输入询问状况" class="layui-input">
    </div>
  
    <label class="layui-form-label">跟进状况</label>
    <div class="layui-input-inline">
      <input type="text" name="followinfo"  autocomplete="off" placeholder="请输入跟进状况" class="layui-input">
    </div>
 
    <label class="layui-form-label">问题状况</label>
    <div class="layui-input-inline">
      <input type="text" name="probleminfo"  autocomplete="off" placeholder="请输入问题状况" class="layui-input">
    </div>
  </div>
  
  <div class="layui-form-item">
    <label class="layui-form-label">备注</label>
    <div class="layui-input-inline">
      <input type="text" name="comments"  autocomplete="off" placeholder="请输入备注" class="layui-input">
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


function init(){
	$.post("/crm/Client/edit",{id:clientid}, function(json) {
		render('myform', json);
		getarray("/crm/Revisit/getLinkstatus",{},"[name=linkstatu]",json.linkstatu);
		getarray("/crm/Revisit/getClientstatus",{},"[name=clientstatu]",json.clientstatu);
		getarray("/crm/Revisit/getPurposestatus",{},"[name=purposestatu]",json.purposestatu);
		getarray("/crm/Revisit/getAssessstatus",{},"[name=assessstatu]",json.assessstatu);
		getarray("/crm/Revisit/getExecstatus",{},"[name=execstatu]",json.execstatu);
		getarray("/crm/Revisit/getStatus",{},"[name=statu]",json.statu);
		getlist("/crm/Client/edit",{id:clientid},"[name=clientname]");
		getlist("/crm/User/edit",{id:execuserid},"[name=execusername]");
	},"json");
	
}

var clientid = ${param.clientid};
var execuserid = ${param.execuserid};

init();

function getlist(url,data,selector){
	$.post(url,data, function(json) {
		$(selector).val(json.name);
	},"json");
}
</script>
</body>
</html>