<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>中国人民大学虚拟网络实验室</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<!-- Loading Bootstrap -->
   	<link href="http://apps.bdimg.com/libs/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet">
   	
   	<!-- Loading Flat UI -->
    <link href="Flat-UI-master/dist/css/flat-ui.css" rel="stylesheet">
    <link rel="shortcut icon" href="Flat-UI-master/dist/img/favicon.ico">
    <!-- HTML5 shim, for IE6-8 support of HTML5 elements. All other JS at the end of file. -->
    <!--[if lt IE 9]>
      <script src="res/js/vendor/html5shiv.js"></script>
      <script src="res/js/vendor/respond.min.js"></script>
    <![endif]-->
    
    <!-- Loading jquery UI -->
    <link rel="stylesheet" href="jquery-ui-1.11.4.custom/jquery-ui.css" />
    
    <!-- Loading Messenger -->
    <link rel="stylesheet" type="text/css" href="res/css/messenger.css">
	<link rel="stylesheet" type="text/css" href="res/css/messenger-theme-future.css">
    
    <link href="res/css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">
    <link rel="stylesheet" href="res/css/font-awesome.min.css">
    <link href="virnet/virnet.css" rel="stylesheet">
   	<link href="virnet/timeManagement.css" rel="stylesheet">	
  </head>
  
  <body>
  <script type="text/javascript">
  n = "${session.cplist}"
  </script>
	<nav class="navbar navbar-inverse" role="navigation">
       <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" 
             data-target="#navbar-collapse">
             <span class="sr-only">切换导航</span>
             <span class="icon-bar"></span>
             <span class="icon-bar"></span>
             <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand">Virnet</a>
       </div>
       <div class="collapse navbar-collapse" id="navbar-collapse">
          <ul class="nav navbar-nav navbar-right">
             <li class="active"><a class="btn" id="user-name">User Name</a></li>
             <li><a class="btn" onclick="logout()" href="log/login.jsp">Log out</a></li>
             <li><a class="btn">About Us</a></li>
          </ul>
       </div>
    </nav>
    
    <div class="container-fluid">
        <div class="row-fluid">
	        <!--Side bar content-->
	        <div class="col-md-2">
	       		<div class="">
	                <ul id="sidebar-list" class="nav nav-tabs nav-stacked">
	                    <s:iterator value="#session.cplist">
		                	<li id=<s:property value="operation" /> onclick="sidebar_click(this)"><a class="btn btn-link"><s:property value="operation"/></a></li>   
						</s:iterator>
					</ul>
	            </div>
	        </div>
	        
	        <!--Body content--> 
	        <div class="col-lg-10 col-md-10 col-sm-12 col-xs-12" id="content"></div>        
        </div>
    </div>

<script type="text/javascript" src="http://code.jquery.com/jquery-2.1.4.js"></script>
<script type="text/javascript" src="virnet/page.js"></script>
<script type="text/javascript" src="virnet/user.js"></script>
<script type="text/javascript" src="virnet/virnet.js"></script>
<script type="text/javascript" src="http://apps.bdimg.com/libs/jquery/2.0.0/jquery.min.js"></script>
<script type="text/javascript" src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script type="text/javascript" src="res/js/jquery.cookie.js"></script>  
<script type="text/javascript" src="res/js/bootstrap-datetimepicker.js" charset="UTF-8"></script>
<script type="text/javascript" src="res/js/locales/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script> 
<script type="text/javascript" src="virnet/timeManagement.js"></script>
<script type="text/javascript" src="Flat-UI-master/dist/js/flat-ui.min.js"></script>
<script type="text/javascript" src="jquery-ui-1.11.4.custom/jquery.min.js"></script>
<script type="text/javascript" src="jquery-ui-1.11.4.custom/jquery-ui.js"></script>
<script type="text/javascript" type="text/javascript" src="res/js/messenger.min.js"></script>
<script type="text/javascript" src="res/js/messenger-theme-future.js"></script>
<script type="text/javascript" src="virnet/history.js"></script>
<script type="text/javascript" src="https://raw.githubusercontent.com/WickyNilliams/headroom.js/master/dist/headroom.js"></script>
<script type="text/javascript" src="virnet/jquery.coursetable.js"></script>
</body>
</html>
