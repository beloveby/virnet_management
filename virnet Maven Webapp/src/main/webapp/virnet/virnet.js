// JavaScript Document

var user = new userControl();
$(document).ready(function(e) {
	$.ajaxSetup({
		contentType : "application/x-www-form-urlencoded;charset=utf-8",
		complete : function(XMLHttpRequest,textStatus){
			var sessionstatus = XMLHttpRequest.getResponseHeader("sessionstatus");
			if(sessionstatus == "timeout"){
				alert("session is out of time, login in again please");
				window.location.replace("log/login.jsp");
			}
		}
	});
	
	if($("#sidebar-list").children().length == 0){
		alert("there's error when loading content, please login again.");
	}
	else{
		$("#sidebar-list").children().first().attr("class", "active");
	}
	
	user.userInit();
	
	contentLoad();
});

function contentLoad(){
	showContent($("#sidebar-list").children().attr("id"), 0, "");
}

//set cookie "log" as "out" when logout, in case that password is remembered at login page
function logout(){
	$.cookie("log", "out", {expires: 7, path: '/'});
}

/**
 * 
 * @param id operation name
 * @param page the number of required page, default page is 0
 * @param select the name of select if has, default is ""
 */
function showContent(id, page, select){
	username = user.getUser();
	
	$("#content").empty();
	$("#content").append($("<h class='tittle'><i class='icon-spinner icon-spin icon-4x'></i>Loading information...</h>"));

	//fetch data from server
	fetchData(id, username, page, select);
}


/**
 * 
 * @param i the click item
 * @param key the kind of operation
 */
function showDetail(name, key){
	//ajax need : user, id, id's name
	username = user.getUser();
	
	$("#content").empty();
	$("#content").append($("<h class='tittle'><i class='icon-spinner icon-spin icon-4x'></i>Loading information...</h>"));
	
	id = $("#sidebar-list .active").attr("id");
	
	$.ajax( {    
	    url:"showDetail",
	    data:{
	    	user : username,
	    	id : id,
	    	key : key,
	    	name : name
	    },    
	    type:'post',      
	    dataType:'json',    
	    success:function(data) { 
	    	//display the result
	    	var body = $("#content");
	    	body.empty();
	    	
	    	if(data["tittle"] != null){
	    		var h = $("<h></h>");
	    		h.appendTo(body);
	    		h.attr("class", "tittle");
	    		h.html(data["tittle"]["data"]);
	    	}
	    	
	    	if(data["button"] != null){
	    		var b = createButton(data["button"]);
	    		b.appendTo(body);
	    	}
	    	
	    	if(data["data"] != null){
	    		createDetail(data["data"]).appendTo(body);
	    	}
	    	
	    	$.cookie("click_id", id);
	    	if(data["id"] != null){
	    		$("#sidebar-list .active").attr("class", "");
	    		$("#" + data["id"]).attr("class", "active");
	    	
	    		//save cookie
	    		$.cookie("click_id", data["id"]);
	    	}
	    	
	    	//save cookie
	    	
	    	$.cookie("click_name", name);
	     },    
	     error : function() {
	    	 body_content = $("#content");
	    	 body_content.empty();
	    	 alert("error");
	     }
	}); 
}

/**
 * create detail information
 * @param content
 * @returns
 */
function createDetail(content){
	var d_t = $("<table></table>");
	d_t.attr("class", "table table-hover table-striped detail-table");
	
	var collapse = new collapseUtil();
	
	$.each(content, function(index, value){
		var d_t_row = $("<tr></tr>");
		d_t_row.attr("class", "");
		d_t_row.appendTo(d_t);
		
		//head in div1, content in div2 as panel
		var d_t_row_th = $("<th></th>");
		d_t_row_th.attr("class", "col-lg-4 col-md-4 col-sm-4 col-xs-6");
		d_t_row_th.appendTo(d_t_row);
		d_t_row_th.html(value[0]["name"]);
		
		$.each(value, function(index, value){
			if(index != 0){
				var d_t_row_td = $("<td></td>");
				d_t_row_td.appendTo(d_t_row);
				
				if(value["class"] == "collapse"){
					if(value["name"].length != 0){
						collapse.createCollapse(value["name"]).appendTo(d_t_row_td);
					}
				}
				else if(value["class"] == "mutiselect"){
					if(value["name"].length != 0){
						createMutiSelect(value["name"], value["value"], d_t_row_td);
					}
				}
				else{
					var d_t_row_td_a = $("<a></a>");
					d_t_row_td_a.appendTo(d_t_row_td);
					d_t_row_td_a.attr("class", value["class"]);
					d_t_row_td_a.attr("onclick", value["onclick"]);
					d_t_row_td_a.attr("value", value["value"]);
					d_t_row_td_a.html(value["name"]);
				}
			}
		});
	});
	
	return d_t;
}

function createMutiSelect(data, value, father){
	var select = $("<select></select>");
	select.attr("class", "form-control multiselect multiselect-primary");
	select.attr("multiple", "multiple");
	select.attr("value", value);
	
	$.each(data, function(index, value){
		var option = $("<option></option>");
		option.attr("value", value["value"]);
		if(value["selected"] != null){
			option.attr("selected", value["selected"]);
		}
		option.html(value["name"]);
		option.appendTo(select);
	});

	select.appendTo(father);
	
	select.select2({dropdownCssClass: 'dropdown-inverse'});
}

function createSelect(data, s, father){	
	var select = $("<select></select>");
	select.attr("class", "form-control select select-primary select-block mbl");
	
	$.each(data, function(index, value){
		var option = $("<option></option>");
		option.attr("value", value["class"]);
		option.html(value["class"]);
		option.appendTo(select);
	});

	select.appendTo(father);
	
	select.select2({dropdownCssClass: 'dropdown-inverse'});
	
	if(s != ""){
		select.val(s).trigger("change");
	}
	
	select.on("change", function (e){
		SelectClick(select.val());
	});
}

function SelectClick(name){	
	id = $("#sidebar-list .active").first().attr("id");

	showContent(id, 0, name);

}

function createTable(content){
	var table = $("<table></table>");
	table.attr("class", "table table-striped");
	
	var thead = $("<thead></thead>");
	var tr_head = $("<tr></tr>");
	tr_head.appendTo(thead);
	
	$.each(content[0], function(index, value){
		var th = $("<th></th>");
		
		var p = $("<p></p>");
		p.appendTo(th);
		p.html(value["name"]);
		p.attr("class", value["class"]);
		
		th.appendTo(tr_head);
	});
	
	thead.appendTo(table);
	
	var tbody = $("<tbody></tbody>");
	tbody.appendTo(table);
	
	var collapse = new collapseUtil();
	
	$.each(content, function(index, value){
		if(index == 0){
			
		}
		else{
			var tr = $("<tr></tr>");
			tr.appendTo(tbody);
			
			$.each(value, function(i, value){
				var td = $("<td></td>");
				
				if(value["class"] == "collapse"){
					if(value["name"].length != 0){
						collapse.createCollapse(value["name"]).appendTo(td);
					}
				}
				else{
					var p = $("<p></p>");
					p.appendTo(td);
					p.html(value["name"]);
					p.attr("class", value["class"]);
					p.attr("onclick", value["onclick"]);
				}
				
				td.appendTo(tr);
			});
		}
	});	
	
	return table;
}

function collapseUtil(){
	number = 0;
	
	this.createCollapse = function(content){
		var panel = $("<div></div>");
		panel.attr("class", "panel-group");
		panel.attr("id", "accordion" + number);
		
		var div = $("<div></div>");
		div.appendTo(panel);
		div.attr("class", "panel panel-info");
		
		var head = $("<div></div>");
		head.attr("class", "panel-heading");
		head.appendTo(div);
		
		var h = $("<h4></h4>");
		h.attr("class", "panel-title");
		h.appendTo(head);
		
		var a = $("<a></a>");
		a.attr("data-toggle", "collapse");
		a.attr("data-parent", "#accordion" + number);
	    a.attr("href", "#collapse" + number);
	    a.attr("class", "collapsed");
	    a.html(content[0]["name"] + " ...");
	    a.appendTo(h);
	    
	    var body = $("<div></div>");
	    body.attr("id", "collapse" + number);
	    body.attr("class", "panel-collapse collapse");
	    body.appendTo(div);
	    
	    var tableInner = $("<div></div>");
	    tableInner.attr("class", "panel-body");
	    tableInner.appendTo(body);
	    
	    $.each(content, function(index, value){
	    	var trInner = $("<div></div>");
	    	trInner.appendTo(tableInner);
	    	
	    	var a0 = $("<a></a>");
	    	a0.html(value["name"]);
	    	a0.attr("class", value["class"]);
	    	a0.attr("onclick", value["onclick"]);
	    	a0.appendTo(trInner);
	    });
	    
	    number++;
	    return panel;
	};
}

/**
 * create button
 * @param data data["content"]
 * 					button inner html
 * @param data data["class"]
 * 					button class style
 * @param data data["click"]
 * 					button onclick function
 * @returns {___anonymous_button_temp} jquery button
 */
function createButton(data){
	var button_temp = $("<button></button>");
	
	button_temp.html(data["content"]);
	button_temp.attr("class", data["class"]);
	button_temp.attr("onclick", data["click"]);
	
	return button_temp;
}

/**
 * ask for edit command from server, change page editable
 */
function editContent(){
	var id = $.cookie("click_id");
	var name = $.cookie("click_name");
	var username = user.getUser();
	
	$.ajax({
		url:"edit.action",
	    data:{
			id : id,
			user : username,
			name : name
	    },    
	    type:'post',      
	    dataType:'json',    
	    success:function(data){
	    	var body = $("#content");
	    	body.empty();
	    	
	    	if(data["tittle"] != null){
	    		var h = $("<h></h>");
	    		h.appendTo(body);
	    		h.attr("class", "tittle");
	    		h.html(data["tittle"]["data"]);
	    	}
	    	
	    	if(data["data"] != null){
	    		createDetail(data["data"]).appendTo(body);
	    	}
	    	
	    	if(data["button"] != null){
	    		createButton(data["button"]).appendTo(body);
	    	}
	    },
	    error:function(data){
	    	alert("error");
	    }
	});
}


/**
 * make the <a> changeable, in edit model, into <input> 
 * @param i the click item
 */
function editable(i){
	var content = $(i).html();
	var value = $(i).attr("value");
	
	var input = $("<input></input>");
	input.attr("type", "text"); 
	input.attr("class", "form-control");
	
	input.bind("blur", function(){
		var c = input.val();
		var a = $("<a></a>");
		a.html(c);
		a.attr("class", "btn btn-link a edit");
		a.attr("onclick", "editable(this);");
		a.attr("value", value);
		
		input.replaceWith(a);
	});
	
	$(i).replaceWith(input);
	input.focus();
	input.val(content);
}

/**
 * in edit model, submit information that be edit/create
 */
function submit(){
	var id = $.cookie("click_id");
	var name = $.cookie("click_name");
	var username = user.getUser();
	var map = {};
	
	$.each($(".edit"), function(index, value){
		map[$(value).attr('value')] = $(value).html();
	});
	
	var length = $("select").length;
	for(var i = 0; i < length; i++){
		var select = $($("select")[i]).val();
		var array = new Array();
		var l = 0;
		$.each(select, function(index, value){
			$.each($($("select")[i]).children("option"), function(i, val){
				if($(val).val() == value){
					array[l++] = $(val).html();
				}
			});
		});
		map[$($("select")[i]).attr("value")] = array;
	}
	
	$.ajax( {    
	    url:"submit.action",
	    data:{
			id : id,
			name : name,
			user : username,
			data : map,
	    },    
	    type:'post',      
	    dataType:'json',    
	    success:function(data){
	    	msg = Messenger().post({
	    		message : data["data"],
	    		showCloseButton : true
	    	});
	    	if(data["name"] != null && data["key"] != null){
	    		showDetail(data["name"], data["key"]);
	    	}
	    	else{
	    		showContent($("#sidebar-list .active").attr("id"), 0, "");
	    	}
	    },
	    error:function(data){
	    	alert("error");
	    }
	});
}


function addContent(id){
	var username = user.getUser();
	
	$.ajax({
		url:"add.action",
	    data:{
			id : id,
			user : username
	    },    
	    type:'post',      
	    dataType:'json',    
	    success:function(data){
	    	$.cookie("click_name", "");
	    	$.cookie("click_id", $("#sidebar-list .active").attr("id"));
	    	
	    	var body = $("#content");
	    	body.empty();
	    	
	    	if(data["tittle"] != null){
	    		var h = $("<h></h>");
	    		h.appendTo(body);
	    		h.attr("class", "tittle");
	    		h.html(data["tittle"]["data"]);
	    	}
	    	
	    	if(data["data"] != null){
	    		createDetail(data["data"]).appendTo(body);
	    	}
	    	
	    	if(data["button"] != null){
	    		createButton(data["button"]).appendTo(body);
	    	}
	    },
	    error:function(data){
	    	alert("error");
	    }
	});
	
}

/**
 * show content when side bar is clicked
 * @param item onclick item
 */
function sidebar_click(item){
	$("#sidebar-list .active").attr("class", "");
	$(item).attr("class", "active");
	
	//loading
	
	showContent($(item).attr("id"), 0, "");	
}


/**
 * ajax, loading content from server of certain side bar item
 * @param id sidebar name
 * @param user the current user
 * @param page required number of page, if not choose, set as 0
 * @param select if have select
 */
function fetchData(id, user, page, select){
	$.ajax( {    
	    url:"loadInfo.action",
	    data:{
			id : id,
			user : user,
			page : page,
			select : select
	    },    
	    type:'post',      
	    dataType:'json',    
	    success:function(data) { 
	    	//display the result
	    	body_content = $("#content");
	    	body_content.empty();
	    	
	    	if(data == null){
	    		return;
	    	}
	    	
	    	var h = $("<h></h>");
	    	h.html($("#" + id).children().first().html());
	    	h.attr("class", "tittle col-lg-12 col-md-12 col-sm-12 col-xs-12");
	    	h.appendTo(body_content);
	    	
	    	if(data["button_new"] != null){
		    	var button_new = createButton(data["button_new"]);
		    	button_new.appendTo(body_content);
	    	}
	    	
	    	if(data["select"] != null){
	    		var s_select = createSelect(data["select"], select, body_content);
	    	}
	    	
	    	if(data["data"] != null){
	    		var table = createTable(data["data"]);
	    		table.appendTo(body_content);
	    	}
	    	
	    	var pageutil = new PageUtil();
	    	pageutil.setPageNO(data["page"]);
	    	pageutil.setPageCurrent(page);
	    	content_page = pageutil.createPageUtil();
	    	if(content_page != null){
	    		content_page.appendTo(body_content);
	    	}
	    	
	    	if(data["detail"] != null){
	    		createDetail(data["detail"]).appendTo(body_content);
	    	}
	    	
	    	if(data["button_switch"] != null){
		    	var button_switch = createButton(data["button_switch"]);
		    	button_switch.appendTo(body_content);
	    	}
	    	
	    	$("#sidebar-list .active").attr("class", "");
    		$("#" + id).attr("class", "active");
	    	
	    	storeHistory(id, "fetchData", {
				id : id,
				user : user,
				page : page,
				select : select
		    });
	     },    
	     error : function() {
	    	 body_content = $("#content");
	    	 body_content.empty();
	    	 alert("error");
	     }
	}); 
}