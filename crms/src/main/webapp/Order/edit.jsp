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
<form class="layui-form" lay-filter="myform" action="../Order/insert">
</c:if>
<c:if test="${param.id!=null}">
<form class="layui-form" lay-filter="myform" action="../Order/update">
<input type="hidden" name="id" >
</c:if>
  <div class="layui-form-item">
    <label class="layui-form-label">客户名称</label>
    <div class="layui-input-block">
      <input type="text" name="clientid"  autocomplete="off" placeholder="请输入客户名称" class="layui-input">
    </div>
  </div>
  
  <div class="layui-inline">
      <label class="layui-form-label">创建时间</label>
      <div class="layui-input-inline">
        <input class="layui-input" id="test1" name="createdate" type="text" placeholder="yyyy-MM-dd" >
      </div>
    </div>
    
    <div class="layui-inline">
      <label class="layui-form-label">业绩时间</label>
      <div class="layui-input-inline">
        <input class="layui-input" id="test2" name="performdate" type="text" placeholder="yyyy-MM-dd" >
      </div>
    </div>
    
    <div class="layui-inline">
      <label class="layui-form-label">合同时间</label>
      <div class="layui-input-inline">
        <input class="layui-input" id="test3" name="orderdate" type="text" placeholder="yyyy-MM-dd" >
      </div>
    </div>
    
    <div class="layui-inline">
      <label class="layui-form-label">开始时间</label>
      <div class="layui-input-inline">
        <input class="layui-input" id="test4" name="startdate" type="text" placeholder="yyyy-MM-dd" >
      </div>
    </div>
    
    <div class="layui-inline">
      <label class="layui-form-label">结束时间</label>
      <div class="layui-input-inline">
        <input class="layui-input" id="test5" name="enddate" type="text" placeholder="yyyy-MM-dd" >
      </div>
    </div>
  
  <div class="layui-form-item">
    <label class="layui-form-label">额外信息</label>
    <div class="layui-input-block">
      <input type="text" name="infos"  autocomplete="off" placeholder="请输入联系人们" class="layui-input">
    </div>
  </div>
  
  <div class="layui-form-item">
    <label class="layui-form-label">创建人</label>
    <div class="layui-input-block">
      <input type="text" name="createuserid"  autocomplete="off" placeholder="请输入创建人" class="layui-input">
    </div>
  </div>
  
  <div class="layui-form-item">
    <label class="layui-form-label">文件</label>
    <div class="layui-input-block">
      <input type="text" name="files"  autocomplete="off" placeholder="请输入文件" class="layui-input">
    </div>
  </div>
  
  <div class="layui-form-item">
    <label class="layui-form-label">业绩人员</label>
    <div class="layui-input-block">
      <input type="text" name="performuserids"  autocomplete="off" placeholder="请输入业绩人员" class="layui-input">
    </div>
  </div>
  
  <div class="layui-form-item">
    <label class="layui-form-label">业绩比重</label>
    <div class="layui-input-block">
      <input type="text" name="performweight"  autocomplete="off" placeholder="请输入业绩比重" class="layui-input">
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
    <label class="layui-form-label">总金额</label>
    <div class="layui-input-block">
      <input type="text" name="totalprice"  autocomplete="off" placeholder="请输入总金额" class="layui-input">
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
	  laydate.render({
		    elem: '#test2'
		    ,trigger: 'click'
		  });
	  laydate.render({
		    elem: '#test3'
		    ,trigger: 'click'
		  });
	  laydate.render({
		    elem: '#test4'
		    ,trigger: 'click'
		  });
	  laydate.render({
		    elem: '#test5'
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
		getarray("../Order/getStatus",{},"[name=statu]",json.statu);
		getlist("../Order/Createusers",{},"[name=createuserid]",json.createuserid);
		getlist("../Order/getClients",{},"[name=clientid]",json.clientid);
	},"json");
	
}
if(id.length>0){
	init();
}else{
	getarray("../Order/getStatus",{},"[name=statu]",0);
	getlist("../Order/getCreateusers",{},"[name=createuserid]",0);
	getlist("../Order/getClients",{},"[name=clientid]",0);
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