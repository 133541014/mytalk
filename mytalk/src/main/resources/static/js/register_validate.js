$().ready(function() {
	$("#register_form").validate({
		submitHandler:function(form){
			$.ajax({
		        type:"get",
		        url:"/register",
		        data:$("#register_form").serialize(),
		        dataType:"text",
		        success: function(str){
		        	
		        	if(str == "success"){
		        		window.location = "/";
		        	}else{
		        		$(".inner-message").remove();
		        		$("#register_form").prepend("<div class=\"form-group inner-message\" style=\"color:red;\"><div class=\"col-sm-4 col-sm-offset-4\">"+str+"</div></div>")
		        	}
		        }
		      });
		 },
		rules: {
			username: {
				required: true,
				maxlength:15,
				minlength:6,
				specialCharFilter:true
			},
			password:{
				required:true,
				maxlength:15,
				minlength:6
			},
			repassword:{
				required:true,
				equalTo: "#password"
			},
			nickname:{
				required:true,
				maxlength:6
			},
			email:{
				required:true,
				email:true
				
			}
		},
		messages: {
			username: {
				required:"必须输入用户名",
				minlength:jQuery.format("用户名不能小于{0}个字 符"),
				maxlength:jQuery.format("用户名不能大于{0}个字 符"),
				specialCharFilter:"不能使用特殊字符"
			},
			password: {
				required: "请输入密码",
				minlength: jQuery.format("密码不能小于{0}个字 符"),
				maxlength: jQuery.format("密码不能大于{0}个字 符")
			},
			repassword: {
				required: "请重复输入密码",
				equalTo: "两次密码不一样"
			},
			nickname:{
				required: "请输入昵称",
				maxlength: jQuery.format("昵称不能大于{0}个字 符")
			},
			email: {
				required: "请输入邮箱",
				email: "请输入有效邮箱"
			}
		}
	});
	
});
