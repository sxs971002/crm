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
<form class="layui-form" lay-filter="myform" action="../Salechance/insert">
</c:if>
<c:if test="${param.id!=null}">
<form class="layui-form" lay-filter="myform" action="../Salechance/update">
<input type="hidden" name="id" >
</c:if>
  <div class="layui-form-item">
    <label class="layui-form-label">机会来源</label>
    <div class="layui-input-block">
      <input type="text" name="chance_form"  autocomplete="off" placeholder="请输入用户名" class="layui-input">
    </div>
  </div>
  
  <div class="layui-form-item">
    <label class="layui-form-label">顾客名称</label>
    <div class="layui-input-block">
      <select name="chance_cusid" >
      </select>
    </div>
  </div>
  
   <div class="layui-form-item">
    <label class="layui-form-label">机会状态</label>
    <div class="layui-input-block">
      <select name="chance_statusid" >
      </select>
    </div>
  </div>
   <div class="layui-form-item">
    <label class="layui-form-label">创建时间</label>
    <div class="layui-input-inline">
        <input type="text" class="layui-input" name="chance_createtime" placeholder="yyyy-MM-dd">
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

layui.use('laydate', function(){
	  var laydate = layui.laydate;
	  
	  //执行一个laydate实例
	  laydate.render({
	    elem: "input[name='chance_createtime']" //指定元素
	  });
	});

var id="${param.id}";
function init(){
	$.post("edit",{id:id}, function(json) {
		render('myform', json);
		getlist("../Salechance/getCus",{},"[name=chance_cusid]",json.chance_cusid);
		getlist1("../Salechance/getStatus",{},"[name=chance_statusid]",json.chance_statusid);
	},"json");
	
}
if(id.length>0){
	init();
}else{
	getlist("../Salechance/getCus",{},"[name=chance_cusid]",0);
	getlist1("../Salechance/getStatus",{},"[name=chance_statusid]",0);
}

function getlist1(url,data,selector,def_id){
	$.post(url,data, function(json) {
		var s=$(selector).empty();
		s.append($("<option value=''></option>"))
		for(var i=0;i<json.length;i++){
			var ss="";
			if(json[i].id==def_id) ss="selected='selected'";
			s.append($("<option value='"+json[i].id+"' "+ss+" >"+json[i].statusname+"</option>"))
		}
		layui.form.render('select');
	},"json");
}

function getlist(url,data,selector,def_id){
		$.post(url,data, function(json) {
			var s=$(selector).empty();
			s.append($("<option value=''></option>"))
			for(var i=0;i<json.length;i++){
				var ss="";
				if(json[i].id==def_id) ss="selected='selected'";
				s.append($("<option value='"+json[i].id+"' "+ss+" >"+json[i].cusname+"</option>"))
			}
			layui.form.render('select');
		},"json");
}
</script>

</body>
</html>