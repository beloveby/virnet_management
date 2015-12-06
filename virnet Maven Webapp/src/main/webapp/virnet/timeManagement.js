RowNumber = 8;
ColNumber = 7;
TotalWeek = 0;

function prepare(){
	var body_content = $("#content");
	body_content.empty();
	
	var h = $("<h></h>");
	h.html("课时管理");
	h.attr("class", "tittle col-lg-12 col-md-12 col-sm-12 col-xs-12");
	h.appendTo(body_content);
	
	var c_btn_new = $("<button></button>");	
	c_btn_new.html("< 课时安排 >");
	c_btn_new.attr("id", "content_btn");
	c_btn_new.attr("class", "btn button-new");
	c_btn_new.attr("onclick", "classArrange()");
	c_btn_new.appendTo(body_content);
	
	createDateSelector().appendTo(body_content);
	
	$('.form_date').datetimepicker({
	    language:  'zh-CN',
	    weekStart: 1,
	    todayBtn:  1,
		autoclose: 1,
		todayHighlight: 1,
		startView: 2,
		minView: 2,
		forceParse: 0
	});
}

function showInChart(){	
	prepare();
	
	var body_content = $("#content");
	
	createWeekSelector(body_content);
	
	createCourseTable().appendTo(body_content);
	
	var c_btn_s = $("<button></button>");	
	c_btn_s.html("< 在表格内显示 >");
	c_btn_s.attr("class", "btn button-new");
	c_btn_s.attr("onclick", "showContent('time-management', 0);");
	c_btn_s.appendTo(body_content);
	
	var user = new userControl();
	
	var username = user.getUser();
	
	queryCourseTableInfo(username);
	
	queryCourseTable(false, username, 0, 0);

	
}

function showCourseTableWithWeek(){
	var week = $("select").val();
	
	var date = $("#courseTable-date").val();
	
	if(week == 0 && date == ""){
		week = 0;
		date = 0;
	}
	else if(week == 0 && date != ""){
		week = -1;
	}
	else{
		date = 0;
	}
	
	user = new userControl();
	username = user.getUser();
	
	queryCourseTable(username, date, week);
}

/**
 * 
 * @param user
 * @param date if xxxx-xx-xx, think as choosing the date 
 * @param week if 0, think as default week, if -1, think as using date
 */
function queryCourseTable(user, date, week){
	$.ajax({
		url : "showTimeArrange.action",
	    data : {
			user : user,
			date : date,
			week : week
	    },    
	    type : 'post',      
	    dataType : 'json',    
	    success : function(data){
	    	$("#course-table").replaceWith(createCourseTable());
	    	
	    	$("#course-table").CourseTable({
	    		detail : data["data"],
	    		single : week,
	    		TotalWeek : TotalWeek
	    	});

	    	$("select").select2("val", data["week"]);
	    	$("#courseTable-date").val(data["date"]);
	    },
	    error : function(data){
	    	alert("error");
	    }
	});
}

function queryCourseTableInfo(user){
	$.ajax({
		url : "courseTableInfo.action",
	    data : {
			user : user,
	    },    
	    type : 'post',      
	    dataType : 'json',    
	    success : function(data){
	    	totalweek = data["totalweek"];
	    	TotalWeek = totalweek;
	
	    	var select = $("select");
	    	
	    	for(var i = 0; i < totalweek; i++){	    		
	    		var option = $("<option></option>");
	    		option.attr("value", (i + 1));
	    		option.html("第" + (i + 1) + "周");
	    		option.appendTo(select);
	    		option = null;
	    	}
	    },
	    error : function(data){
	    	alert("Fail to load semester infomation.")
	    }
	});
}

function classArrange(){
	var user = new userControl();
	
	var username = user.getUser();
	
	prepare();
	
	$("#content_btn").attr("disabled", "disabled");
	
	createWeekSelector(body_content);
	
	createClassSelector(username).appendTo(body_content);
	
	var coursetable = createCourseTable();
	coursetable.appendTo(body_content);
	
	coursetable.CourseTable({
		
	});
	
	queryCourseTableInfo(username);
	
	queryCourseTable(true, username, 0, 0);
}

function createClassSelector(user){
	var c_s = $("<div><div>");
	c_s.attr("id", "class-container");
	
	var c_sh = $("<p></p>");
	c_sh.html("所有班级");
	c_sh.appendTo(c_s);
	
	$.ajax({
		url : "classInfo.action",
	    data : {
			user : user,
	    },    
	    type : 'post',      
	    dataType : 'json',    
	    success : function(data){
	    	var clist = data["class"];
	    	var length = clist.length;
	    	for(var i = 0; i < length; i++){
	    		var cbtn = $("<a></a>");
	    		cbtn.attr("class", "btn btn-success");
	    		cbtn.html(clist[i]["coursename"] + " " + clist[i]["classname"]);
	    		cbtn.attr("id", clist[i]["classid"]);
	    		cbtn.draggable({
	    		      appendTo: "body",
	    		      helper: "clone"
	    		    });
	    		cbtn.appendTo(c_s);
	    	}
	    },
	    error : function(data){
	    	
	    }
	});
	
	return c_s;
}

function createCourseTable(){
	var c_table = $("<table></table>");
	c_table.attr("class", "table table-striped table-bordered table-hover table-responsive course-table");
	c_table.attr("id", "course-table");
	
	var c_thead = $("<thead></thead>");
	c_thead.appendTo(c_table);
	
	var c_tr = $("<tr></tr>");
	c_tr.appendTo(c_thead);
	
	var c_thead_content = new Array("", "一", "二", "三", "四", "五", "六", "日");
	for(var i = 0; i < 8; i++){
		var c_th = $("<th></th>");
		c_th.html(c_thead_content[i]);
		if(i == 0){
			c_th.attr("class", "courseTable-th col-lg-2 col-md-2 col-sm-2 col-xs-2");
		}
		else{
			c_th.attr("class", "courseTable-th");
		}
		
		c_th.appendTo(c_tr);
	}
	
	var c_tbody = $("<tbody></tbody>");
	c_tbody.appendTo(c_table);
	
	var c_tbody_content = new Array("8 : 00 ~ 10 : 00", "10 : 00 ~ 12 : 00", "12 : 00 ~ 14 : 00", "14 : 00 ~ 16 : 00", "16 : 00 ~ 18 : 00", "18 : 00 ~ 20 : 00", "20 : 00 ~ 22 : 00", "22 : 00 ~ 24 : 00");
	for(var i = 0; i < RowNumber; i++){
		var c_tb_tr = $("<tr></tr>");
		c_tb_tr.attr("id", "courseTableRow-" + i);
		c_tb_tr.appendTo(c_tbody);
		
		var c_th = $("<th></th>");
		c_th.html(c_tbody_content[i]);
		c_th.attr("class", "courseTable-th");
		c_th.appendTo(c_tb_tr);
		
		for(var j = 0; j < ColNumber; j++){
			var c_td = $("<td></td>");
			c_td.appendTo(c_tb_tr);
			c_td.html();
			c_td.attr("id", "courseTable-" + i + (j + 1));
			c_td.attr("class", "courseTable-item");
		}
	}
	
	return c_table;
}

function CourseTableCheck(){
	for(var j = 1; j <= ColNumber; j++){
		for(var i = 0; i < RowNumber; i++){
			var e = $("#courseTable-" + i + j);
			
			if(e.length == 0){
				continue;
			}
			
			var content = e.html();
			
			if(content == ""){
				continue;
			}
			
			for(var k = i + 1; k < RowNumber; k++){
				if($("#courseTable-" + k + j).length == 0){
					continue;
				}
				var c = $("#courseTable-" + k + j).html();
				
				if(c != content){
					$("#courseTable-" + i + j).attr("rowspan", k - i);
					i = k;
					break;
				}
				else{
					$("#courseTable-" + k + j).remove();
				}
			}
		}
	}
}

function createDateSelector(){
	c_d_div = $("<div></div>");
	c_d_div.attr("class", "col-lg-4 col-md-4");
		
		c_d_select = $("<div></div>");
		c_d_select.appendTo(c_d_div);
		c_d_select.attr("class", "input-group has-success date form_date");
		c_d_select.attr("data-date", "");
		c_d_select.attr("data-date-format", "dd MM yyyy");
		c_d_select.attr("data-link-field", "courseTable-date");
		c_d_select.attr("data-link-format", "yyyy-mm-dd");
		
			c_d_s_input = $("<input></input>");
			c_d_s_input.appendTo(c_d_select);
			c_d_s_input.attr("class", "form-control");
			c_d_s_input.attr("size", "16");
			c_d_s_input.attr("type", "text");
			c_d_s_input.attr("readonly", "");
			c_d_s_input.attr("id", "courseTable-date");
			c_d_s_input.attr("onchange", "courseTable_input_click()");
			c_d_s_input.attr("placeholder", "选择日期");
			
			c_d_s_span1 = $("<span></span>");
			c_d_s_span1.appendTo(c_d_select);
			c_d_s_span1.attr("class", "input-group-addon");
				
				c_d_s_s1_span = $("<span></span>");
				c_d_s_s1_span.appendTo(c_d_s_span1);
				c_d_s_s1_span.attr("class", "glyphicon glyphicon-remove");
				
			c_d_s_span2 = $("<span></span>");
			c_d_s_span2.appendTo(c_d_select);
			c_d_s_span2.attr("class", "input-group-addon");
				
				c_d_s_s2_span = $("<span></span>");
				c_d_s_s2_span.appendTo(c_d_s_span2);
				c_d_s_s2_span.attr("class", "glyphicon glyphicon-calendar");		
		
		c_d_input = $("<input></input>");
		c_d_input.appendTo(c_d_div);
		c_d_input.attr("type", "hidden"); 
		c_d_input.attr("id", "courseTable-date");	
	
	return c_d_div;
}

function courseTable_input_click(){
	$("select").select2("val", "0");
}

function createWeekSelector(father){
	var c_w_div = $("<div></div>");
	
	var select = $("<select></select>");
	select.attr("class", "form-control select select-success select-block mbl");
	
	var option = $("<option></option>");
	option.attr("value", 0);
	option.html("默认课表");
	option.appendTo(select);
	
	select.appendTo(c_w_div);
	
	c_w_div.appendTo(father);
	
	select.select2({dropdownCssClass: 'dropdown-inverse'});
	select.on("change", function(){
		$("#courseTable-date").val("");
	});
	
	var button = $("<button></button>");
	
	button.attr("class", "btn btn-success");
	button.html("<i class='icon-arrow-right'></i>.");
	button.attr("onclick", "showCourseTableWithWeek()");
	button.appendTo(c_w_div);
	
	select = null;
	c_w_div = null;
	option = null;
	button = null;
}