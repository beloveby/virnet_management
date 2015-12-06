/**
 * server for page login.jsp, deal with the page initial, and form submit process
 */

$(document).ready(function(e) {
	logoutCheck();
	
	logFail();
	
	loginCheck();   
});

function login(user, password, remember_info){
	//get the form value
	user = $.trim($("#login-input").val());
	password = $.trim($("#login-password").val());
	remember_info = $("input[name='remember']").prop('checked');
	
	if(user != "" && password != ""){
		//save cookie
		var remember;
		if(remember_info){
			remember = "true";
		}
		else{
			remember = "false";
		}
		
		$.cookie("auto_login", remember, {expires: 7, path: '/'});
		$.cookie("user_id", user, {expires:7, path: '/'});
		$.cookie("keyResult", password, {expires:7, path: '/'});

		return true;
	}
	else{
		return false;
	}

}