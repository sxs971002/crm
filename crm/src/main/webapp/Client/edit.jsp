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
<script type="text/javascript" src="../X-admin/js/tableSelect.js"></script>
<title></title>
</head>
<body>
<style>
.layui-input{width:250px;}
.layui-input-block {
    width: 250px;
}
</style>

<c:if test="${param.id==null}">
<form class="layui-form" lay-filter="myform" action="../Client/insert">
</c:if>
<c:if test="${param.id!=null}">
<form class="layui-form" lay-filter="myform" action="../Client/update">
<input type="hidden" name="id" >
</c:if>
  <div class="layui-form-item">
    <label class="layui-form-label">客户名称</label>
    <div class="layui-input-block">
      <input type="text" name="name"  autocomplete="off" placeholder="请输入客户名称" class="layui-input">
    </div>
  </div>
  
  <div class="layui-form-item">
    <label class="layui-form-label">性别</label>
    <div class="layui-input-block">
      <select name="sex" >
      </select>
    </div>
  </div>
  
  <div class="layui-form-item">
    <label class="layui-form-label">联系方式</label>
    <div class="layui-input-block">
      <input type="text" name="tel"  autocomplete="off" placeholder="请输入联系方式" class="layui-input">
    </div>
  </div>
  
  <div class="layui-form-item">
    <label class="layui-form-label">QQ</label>
    <div class="layui-input-block">
      <input type="text" name="qq"  autocomplete="off" placeholder="请输入QQ" class="layui-input">
    </div>
  </div>
  
  <div class="layui-form-item">
    <label class="layui-form-label">邮箱</label>
    <div class="layui-input-block">
      <input type="text" name="email"  autocomplete="off" placeholder="请输入邮箱" class="layui-input">
    </div>
  </div>
   
   <div class="layui-form-item">
    <label class="layui-form-label">地址</label>
    <div class="layui-input-block">
      <input type="text" name="address"  autocomplete="off" placeholder="请输入地址" class="layui-input">
    </div>
  </div>
  
  <div class="layui-form-item">
    <label class="layui-form-label">额外信息</label>
    <div class="layui-input-block">
      <input type="text" name="infos"  autocomplete="off" placeholder="请输入备注信息" class="layui-input">
    </div>
  </div>
  
  <div class="layui-form-item">
    <label class="layui-form-label">处理人</label>
    <div class="layui-input-block">
      	<input type="hidden" name="userids">
		<input type="text" name="usernames" readonly="readonly" autocomplete="off" placeholder="请输入" class="layui-input" id="demo"> 
    </div>
  </div>
  
  <div class="layui-form-item">
    <label class="layui-form-label">创建人</label>
    <div class="layui-input-block">
      <select name="createuserid"></select>
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
    <label class="layui-form-label">客户类型</label>
    <div class="layui-input-block">
      <select name="clienttypeid" >
      </select>
    </div>
  </div>
  
  <div class="layui-form-item">
    <label class="layui-form-label">客户来源</label>
    <div class="layui-input-block">
      <select name="srcid"></select>
    </div>
  </div>
  
  <div class="layui-form-item">
    <label class="layui-form-label">回访次数</label>
    <div class="layui-input-block">
      <input type="text" name="count"  autocomplete="off" placeholder="请输入回访次数" class="layui-input">
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

var tableSelect = layui.tableSelect;
tableSelect.render({
	elem: '#demo',	//定义输入框input对象
	checkedKey: 'id' ,//表格的唯一建值，非常重要，影响到选中状态 必填
	searchKey: 'txt',	//搜索输入框的name值 默认keyword
	searchPlaceholder: '搜索',	//搜索输入框的提示文字 默认关键词搜索
	table: {	//定义表格参数，与LAYUI的TABLE模块一致，只是无需再定义表格elem
		url:'../User/index',
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

var id="${param.id}";
function init(){
	$.post("../Client/edit",{id:id}, function(json) {
		render('myform', json);
		getarray("../Client/getSexs",{},"[name=sex]",json.sex);
		getarray("../Client/getLinkstatus",{},"[name=linkstatu]",json.linkstatu);
		getarray("../Client/getClientstatus",{},"[name=clientstatu]",json.clientstatu);
		getarray("../Client/getPurposestatus",{},"[name=purposestatu]",json.purposestatu);
		getarray("../Client/getAssessstatus",{},"[name=assessstatu]",json.assessstatu);
		getarray("../Client/getExecstatus",{},"[name=execstatu]",json.execstatu);
		getarray("../Client/getStatus",{},"[name=statu]",json.statu);
		getlist("../Client/getSrcs",{},"[name=srcid]",json.srcid);
		getlist("../Client/getClienttypes",{},"[name=clienttypeid]",json.clienttypeid);
		getlist("../Client/getCreateuser",{},"[name=createuserid]",json.createuserid);
	},"json");
	
}
if(id.length>0){
	init();
}else{
	getarray("../Client/getSexs",{},"[name=sex]",0);
	getarray("../Client/getLinkstatus",{},"[name=linkstatu]",0);
	getarray("../Client/getClientstatus",{},"[name=clientstatu]",0);
	getarray("../Client/getPurposestatus",{},"[name=purposestatu]",0);
	getarray("../Client/getAssessstatus",{},"[name=assessstatu]",0);
	getarray("../Client/getExecstatus",{},"[name=execstatu]",0);
	getarray("../Client/getStatus",{},"[name=statu]",0);
	getlist("../Client/getSrcs",{},"[name=srcid]",0);
	getlist("../Client/getClienttypes",{},"[name=clienttypeid]",0);
	getlist("../Client/getCreateuser",{},"[name=createuserid]",0);
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