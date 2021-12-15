<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta http-equiv="Cache-Control" content="no-siteapp" />
 <link href="${pageContext.request.contextPath }/mutualResource/assets/css/bootstrap.min.css" rel="stylesheet" />
        <link rel="stylesheet" href="${pageContext.request.contextPath }/mutualResource/css/style.css"/>       
        <link href="${pageContext.request.contextPath }/mutualResource/assets/css/codemirror.css" rel="stylesheet">
        <link rel="stylesheet" href="${pageContext.request.contextPath }/mutualResource/assets/css/ace.min.css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath }/mutualResource/font/css/font-awesome.min.css" />
        <!--[if lte IE 8]>
		  <link rel="stylesheet" href="${pageContext.request.contextPath }/mutualResource/assets/css/ace-ie.min.css" />
		<![endif]-->
		<script src="${pageContext.request.contextPath }/mutualResource/js/jquery-1.9.1.min.js"></script>
		<script src="${pageContext.request.contextPath }/mutualResource/assets/layer/layer.js" type="text/javascript" ></script>
        <script src="${pageContext.request.contextPath }/mutualResource/assets/laydate/laydate.js" type="text/javascript"></script>  
        <script src="${pageContext.request.contextPath }/mutualResource/assets/js/bootstrap.min.js"></script>
		<script src="${pageContext.request.contextPath }/mutualResource/assets/js/typeahead-bs2.min.js"></script>           	
		<script src="${pageContext.request.contextPath }/mutualResource/assets/js/jquery.dataTables.min.js"></script>
		<script src="${pageContext.request.contextPath }/mutualResource/assets/js/jquery.dataTables.bootstrap.js"></script>
                      
<title>个人信息管理</title>
</head>

<body>
<div class="clearfix">
 <div class="admin_info_style">
   <div class="admin_modify_style" id="Personal">
     <div class="type_title">我的信息 </div>
      <div class="xinxi">
        <div class="form-group"><label class="col-sm-3 control-label no-padding-right" for="form-field-1">用户名： </label>
          <div class="col-sm-9"><input type="text" name="name" id="website-title" value="${LOGIN_CLIENT.name }" class="col-xs-7 text_info" disabled="disabled">
          &nbsp;&nbsp;&nbsp;<a href="javascript:ovid()" onclick="change_Password()" class="btn btn-warning btn-xs">修改密码</a></div>
          
          </div>
          <div class="form-group"><label class="col-sm-3 control-label no-padding-right" for="form-field-1">性别： </label>
          <div class="col-sm-9">
          <span class="sex">${LOGIN_CLIENT.sex eq 1 ? "男":"女"}</span>
            <div class="add_sex">
            <label><input name="sex" type="radio" class="ace" value="1" ${LOGIN_CLIENT.sex eq 1 ? 'checked="checked"':'' }><span class="lbl">男</span></label>&nbsp;&nbsp;
            <label><input name="sex" type="radio" class="ace" value="0" ${LOGIN_CLIENT.sex eq 0 ? 'checked="checked"':'' }><span class="lbl">女</span></label>
            </div>
           </div>
          </div>
          <div class="form-group"><label class="col-sm-3 control-label no-padding-right" for="form-field-1">年龄： </label>
          <div class="col-sm-9"><input type="text" name="age" id="website-title" value="${LOGIN_CLIENT.age }" class="col-xs-7 text_info" disabled="disabled"></div>
          </div>
          <div class="form-group"><label class="col-sm-3 control-label no-padding-right" for="form-field-1">电话： </label>
          <div class="col-sm-9"><input type="text" name="phone" id="website-title" value="${LOGIN_CLIENT.phone }" class="col-xs-7 text_info" disabled="disabled"></div>
          </div>
          <div class="form-group"><label class="col-sm-3 control-label no-padding-right" for="form-field-1">电子邮箱： </label>
          <div class="col-sm-9"><input type="text" name="email" id="website-title" value="${LOGIN_CLIENT.email }" class="col-xs-7 text_info" disabled="disabled"></div>
          </div>
          
          
           <div class="Button_operation clearfix"> 
				<button onclick="modify();" class="btn btn-danger radius" type="submit">修改信息</button>				
				<button onclick="save_info();" class="btn btn-success radius" type="button">保存修改</button>              
			</div>
            </div>
    </div>
    
 </div>
</div>
 <!--修改密码样式-->
         <div class="change_Pass_style" id="change_Pass">
            <ul class="xg_style">
             <li><label class="label_name">原&nbsp;&nbsp;密&nbsp;码</label><input name="原密码" type="password" class="" id="password"></li>
             <li><label class="label_name">新&nbsp;&nbsp;密&nbsp;码</label><input name="新密码" type="password" class="" id="Nes_pas"></li>
             <li><label class="label_name">确认密码</label><input name="再次确认密码" type="password" class="" id="c_mew_pas"></li>
              
            </ul>
     <!--       <div class="center"> <button class="btn btn-primary" type="button" id="submit">确认修改</button></div>-->
         </div>
</body>
</html>
<script>

 //按钮点击事件
function modify(){
	 $('.text_info').attr("disabled", false);
	 $('.text_info').addClass("add");
	  $('#Personal').find('.xinxi').addClass("hover");
	  $('#Personal').find('.btn-success').css({'display':'block'});
	};
function save_info(){
	    var num=0;
		 var str="";
     $(".xinxi input[type$='text']").each(function(n){
          if($(this).val()=="")
          {
               
			   layer.alert(str+=""+$(this).attr("name")+"不能为空！\r\n",{
                title: '提示框',				
				icon:0,								
          }); 
		    num++;
            return false;            
          } 
		 });
		  if(num>0){  return false;}	 	
          else{
			  
        	//ajax请求
				$.ajax({
					type : "POST",
					url : "${pageContext.request.contextPath}/client/base?m=updateBase",
					data : {
						"name" : $("input[name='name']").val(),
						"sex" : $("input[name='sex']").val(),
						"age" : $("input[name='age']").val(),
						"phone" : $("input[name='phone']").val(),
						"email" : $("input[name='email']").val(),
					},
					dataType : "json",
					success : function(data) {
						var i = 0;
						if (data['result'] == true) {
							i = 1;
						}

						layer.alert(data['msg'], {
							title : '提示框',
							icon : i,

						});

					}
				});
        	  
        	  
			  $('#Personal').find('.xinxi').removeClass("hover");
			  $('#Personal').find('.text_info').removeClass("add").attr("disabled", true);
			  $('#Personal').find('.btn-success').css({'display':'none'});
			
		  }		  		
	};	
 //初始化宽度、高度    
    $(".admin_modify_style").height($(window).height()); 
	$(".recording_style").width($(window).width()-400); 
    //当文档窗口发生改变时 触发  
    $(window).resize(function(){
	$(".admin_modify_style").height($(window).height()); 
	$(".recording_style").width($(window).width()-400); 
  });
 
    //修改密码
	function change_Password() {
		layer
				.open({
					type : 1,
					title : '修改密码',
					area : [ '300px', '300px' ],
					shadeClose : true,
					content : $('#change_Pass'),
					btn : [ '确认修改' ],
					yes : function(index, layero) {
						if ($("#password").val() == "") {
							layer.alert('原密码不能为空!', {
								title : '提示框',
								icon : 0,

							});
							return false;
						}
						if ($("#Nes_pas").val() == "") {
							layer.alert('新密码不能为空!', {
								title : '提示框',
								icon : 0,

							});
							return false;
						}

						if ($("#c_mew_pas").val() == "") {
							layer.alert('确认新密码不能为空!', {
								title : '提示框',
								icon : 0,

							});
							return false;
						}
						if (!$("#c_mew_pas").val
								|| $("#c_mew_pas").val() != $("#Nes_pas").val()) {

							layer.alert('密码不一致!', {
								title : '提示框',
								icon : 0,

							});
							return false;
						} else {

							//修改密码

							//ajax请求
							$.ajax({
								type : "POST",
								url : "${pageContext.request.contextPath}/client/base?m=updatePwd",
								data : {
									"newPwd" : $("#Nes_pas").val(),
									"password" : $("#password").val()
								},
								dataType : "json",
								success : function(data) {
									var i = 0;
									if (data['result'] == true) {
										i = 1;
									}

									layer.alert(data['msg'], {
										title : '提示框',
										icon : i,

									});

									layer.close(index);
								}
							});
									

						}
					}
				});
	}
</script>

