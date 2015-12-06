// JavaScript Document
function logoutCheck(){
	logout = $.cookie("log");

	if(logout == "out"){
		$.cookie("auto_login", "false", {expires: 7, path: '/'});
	}
}

function logFail(){	
	if(state == 1){
		//no such user
		$("#login-input").parent().parent().attr("class", "form-group has-error");
	}
	else if(state == 2){
		//wrong password
		$("#login-password").parent().parent().attr("class", "form-group has-error");
	}
	else if(state == 3){
		//user with no character
		alert(statement);
	}
}

function loginCheck(){
	remember = $.cookie("auto_login");//get the variable to judge whether auto login
	user = $.cookie("user_id");//get the saved user id
	password = $.cookie("keyResult");//get the saved password
	
	//auto login
	if(remember == "true"){
		$("#login-input").val(user);
		$("#login-password").val(password);
		$("input[name='remember']").prop('checked', true);

		$("#login").submit();
		fail = "success";
	}
	else{
		$("#login-input").val(user);
		$("#login-password").val("");
		$("input[name='remember']").prop('checked', false);
	}
	
	$.cookie("log", "in", {expires: 7, path: '/'});
}