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
.layui-input{width:250px;}
.layui-input-block{width:250px;}
</style>

<c:if test="${param.id==null}">
<form class="layui-form" lay-filter="myform" action="../Revisit/insert">
</c:if>
<c:if test="${param.id!=null}">
<form class="layui-form" lay-filter="myform" action="../Revisit/update">
<input type="hidden" name="id" >
</c:if>
  <div class="layui-form-item">
    <label class="layui-form-label">客户名称</label>
    <div class="layui-input-block">
      <select name="clientid" >
      </select>
    </div>
  </div>
  
  
  <div class="layui-form-item">
    <label class="layui-form-label">电话状态</label>
    <div class="layui-input-block">
      <select name="linkstatu" >
      </select>
    </div>
  </div>
  
  <div class="layui-form-item">
    <label class="layui-form-label">客户状态</label>
    <div class="layui-input-block">
      <select name="clientstatu" >
      </select>
    </div>
  </div>
  
  <div class="layui-form-item">
    <label class="layui-form-label">意向状态</label>
    <div class="layui-input-block">
      <select name="purposestatu" >
      </select>
    </div>
  </div>
  
  <div class="layui-form-item">
    <label class="layui-form-label">评估状态</label>
    <div class="layui-input-block">
      <select name="assessstatu" >
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
    <label class="layui-form-label">状态</label>
    <div class="layui-input-block">
      <select name="statu" >
      </select>
    </div>
  </div>
  
  <div class="layui-form-item">
    <label class="layui-form-label">询问状况</label>
    <div class="layui-input-block">
      <input type="text" name="askinfo"  autocomplete="off" placeholder="请输入询问状况" class="layui-input">
    </div>
  </div>
  
  <div class="layui-form-item">
    <label class="layui-form-label">跟进状况</label>
    <div class="layui-input-block">
      <input type="text" name="followinfo"  autocomplete="off" placeholder="请输入跟进状况" class="layui-input">
    </div>
  </div>
  
  
  <div class="layui-form-item">
    <label class="layui-form-label">问题状况</label>
    <div class="layui-input-block">
      <input type="text" name="probleminfo"  autocomplete="off" placeholder="请输入问题状况" class="layui-input">
    </div>
  </div>

  
  <div class="layui-form-item">
    <label class="layui-form-label">备注</label>
    <div class="layui-input-block">
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


var id="${param.id}";
function init(){
	$.post("edit",{id:id}, function(json) {
		render('myform', json);
		getarray("../Revisit/getLinkstatus",{},"[name=linkstatu]",json.linkstatu);
		getarray("../Revisit/getClientstatus",{},"[name=clientstatu]",json.clientstatu);
		getarray("../Revisit/getPurposestatus",{},"[name=purposestatu]",json.purposestatu);
		getarray("../Revisit/getAssessstatus",{},"[name=assessstatu]",json.assessstatu);
		getarray("../Revisit/getExecstatus",{},"[name=execstatu]",json.execstatu);
		getarray("../Revisit/getStatus",{},"[name=statu]",json.statu);
		getlist("../Revisit/getClients",{},"[name=clientid]",json.clientid);
	},"json");
	
}
if(id.length>0){
	init();
}else{
	getarray("../Revisit/getLinkstatus",{},"[name=linkstatu]",0);
	getarray("../Revisit/getClientstatus",{},"[name=clientstatu]",0);
	getarray("../Revisit/getPurposestatus",{},"[name=purposestatu]",0);
	getarray("../Revisit/getAssessstatus",{},"[name=assessstatu]",0);
	getarray("../Revisit/getExecstatus",{},"[name=execstatu]",0);
	getarray("../Revisit/getStatus",{},"[name=statu]",0);
	getlist("../Revisit/getClients",{},"[name=clientid]",0);
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