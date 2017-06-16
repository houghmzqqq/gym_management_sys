<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
  <head>
    <title>修改管理员信息</title>
    <meta charset="utf-8">
    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/lib/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/lib/font-awesome/css/font-awesome.css">

    <script src="${pageContext.request.contextPath}/lib/jquery-1.11.1.min.js" type="text/javascript"></script>

    

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/stylesheets/theme.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/stylesheets/premium.css">

    <style type="text/css">
        #line-chart {
            height:300px;
            width:800px;
            margin: 0px auto;
            margin-top: 1em;
        }
        .navbar-default .navbar-brand, .navbar-default .navbar-brand:hover { 
            color: #fff;
        }
    </style>
  </head>
  
  <body class=" theme-blue">

    <!-- Demo page code -->

    <script type="text/javascript">
        $(function() {
            var match = document.cookie.match(new RegExp('color=([^;]+)'));
            if(match) var color = match[1];
            if(color) {
                $('body').removeClass(function (index, css) {
                    return (css.match (/\btheme-\S+/g) || []).join(' ')
                })
                $('body').addClass('theme-' + color);
            }

            $('[data-popover="true"]').popover({html: true});
            
        });
    </script>

    <script type="text/javascript">
        $(function() {
            var uls = $('.sidebar-nav > ul > *').clone();
            uls.addClass('visible-xs');
            $('#main-menu').append(uls.clone());
        });
    </script>

    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <!-- Le fav and touch icons -->
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/assets/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="${pageContext.request.contextPath}/assets/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="${pageContext.request.contextPath}/assets/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="${pageContext.request.contextPath}/assets/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="${pageContext.request.contextPath}/assets/ico/apple-touch-icon-57-precomposed.png">
  

  <!--[if lt IE 7 ]> <body class="ie ie6"> <![endif]-->
  <!--[if IE 7 ]> <body class="ie ie7 "> <![endif]-->
  <!--[if IE 8 ]> <body class="ie ie8 "> <![endif]-->
  <!--[if IE 9 ]> <body class="ie ie9 "> <![endif]-->
  <!--[if (gt IE 9)|!(IE)]><!--> 
   
  <!--<![endif]-->

 <div class="navbar navbar-default" role="navigation">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="" href="index.html"><span class="navbar-brand"><span class="fa fa-paper-plane"></span> Aircraft</span></a></div>

        <div class="navbar-collapse collapse" style="height: 1px;">
          <ul id="main-menu" class="nav navbar-nav navbar-right">
            <li class="dropdown hidden-xs">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                    <span class="glyphicon glyphicon-user padding-right-small" style="position:relative;top: 3px;"></span> ${user.relName}
                    <i class="fa fa-caret-down"></i>
                </a>

              <ul class="dropdown-menu">
                <li><a href="./">My Account</a></li>
                <li class="divider"></li>
                <li class="dropdown-header">Admin Panel</li>
                <li><a href="./">Users</a></li>
                <li><a href="./">Security</a></li>
                <li><a tabindex="-1" href="./">Payments</a></li>
                <li class="divider"></li>
                <li><a tabindex="-1" href="${pageContext.request.contextPath}/login/logout">退出</a></li>
              </ul>
            </li>
          </ul>

        </div>
      </div>
    </div>
    

    <div class="sidebar-nav">
    <ul>
    <li><a href="#" data-target=".dashboard-menu" class="nav-header" data-toggle="collapse"><i class="fa fa-fw fa-dashboard"></i> 用户管理<i class="fa fa-collapse"></i></a></li>
    <li><ul class="dashboard-menu nav nav-list collapse in">
            <li><a href="index.html"><span class="fa fa-caret-right"></span> 主页</a></li>
            <li class="active"><a href="../adminList"><span class="fa fa-caret-right"></span> 管理员列表</a></li>
            <li ><a href="../roleList"><span class="fa fa-caret-right"></span> 角色列表</a></li>
            <li ><a href="../userList"><span class="fa fa-caret-right"></span> 用户列表</a></li>
    </ul></li>

<li data-popover="true"
				rel="popover" data-placement="right" data-original-title="" title=""><a
				href="#" data-target=".premium-menu" class="nav-header collapsed"
				data-toggle="collapse"><i class="fa fa-fw fa-fighter-jet"></i>
					器材<i class="fa fa-collapse"></i></a></li>
			<li><ul class="premium-menu nav nav-list collapse">
					<li class="visible-xs visible-sm"><a href="#">- Premium
							features require a license -</a></li>
					<%-- <li><a href="${pageContext.request.contextPath}/equ/findForClient?thisPage=1&equTypeId=0"><span
							class="fa fa-caret-right"></span> 器材查询</a></li>
					<li><a href="${pageContext.request.contextPath}/cart/listEqu"><span
							class="fa fa-caret-right"></span> 器材订单项</a></li> --%>
					<li><a href="${pageContext.request.contextPath}/equ/findByTypeId?thisPage=1&equTypeId=0"><span
							class="fa fa-caret-right"></span> 器材管理</a></li>
					<li><a href="${pageContext.request.contextPath}/equOrder/findAll?thisPage=1"><span
							class="fa fa-caret-right"></span>器材订单管理</a></li>
				</ul></li>


<li><a href="#" data-target=".legal-menu"
				class="nav-header collapsed" data-toggle="collapse"><i
					class="fa fa-fw fa-legal"></i> 场地<i class="fa fa-collapse"></i></a></li>
			<li><ul class="legal-menu nav nav-list collapse">
					<li><a href="${pageContext.request.contextPath}/field/findByTypeId?thisPage=1&fieldTypeId=0"><span
							class="fa fa-caret-right"></span>场地管理</a></li>
					<li><a href="${pageContext.request.contextPath}/fieldOrder/findAll?thisPage=1"><span
							class="fa fa-caret-right"></span>场地订单管理</a></li>
				</ul></li>
            </ul>
    </div>

    <div class="content">
        <div class="header">
            
            <h1 class="page-title">修改管理员信息</h1>
                    <ul class="breadcrumb">
            <li><a href="../index">主页</a> </li>
            <li><a href="../adminList">用户管理</a> </li>
            <li class="active">修改管理员信息</li>
        </ul>

        </div>
        <div class="main-content">
            

<div class="row">
  <div class="col-md-4">
    <br>
    <div id="myTabContent" class="tab-content">
      <div class="tab-pane active in" id="home">
      <form id="updateAdminForm" action="${pageContext.request.contextPath}/userManage/doUpdateAdmin" method="post">
      	<input type="hidden" name="adminId" value="${admin.adminId }" >
      	<input type="hidden" name="adminName" value="${admin.adminName }">	
         <div class="form-group">
        <label>用户名</label>
        <input type="text" class="form-control" value="${admin.adminName }"  disabled="disabled">
        </div>
        <div class="form-group">
        <label>管理员姓名</label>
        <input type="text" name="relName" class="form-control" value="${admin.relName }" placeholder="请输入管理员姓名" required>
        </div>
        
        <div class="form-group">
            <label>管理员角色</label>
            <select name=roleName id="role" class="form-control">
            	<c:forEach var="role" items="${roleList }">
              		<option value="${role.roleName }">${role.roleName }</option>
              	</c:forEach>
              </select>      
          </div>
        </div>
        <div class="btn-toolbar list-toolbar">
      <input type="submit" class="btn btn-primary"></button>
    </div>
        </form>
        <label class="remember-me" style="color:red;">${wrongMsg}</label>
      </div>
      
  <!--   <div class="btn-toolbar list-toolbar">
      <button id="doAddAdmin" class="btn btn-primary"><i class="fa fa-save"></i> Save</button>
      <a href="#myModal" data-toggle="modal" class="btn btn-danger">Delete</a>
    </div>-->
  </div>
</div>

<div class="modal small fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
        <h3 id="myModalLabel">Delete Confirmation</h3>
      </div>
      <div class="modal-body">
        
        <p class="error-text"><i class="fa fa-warning modal-icon"></i>Are you sure you want to delete the user?</p>
      </div>
      <div class="modal-footer">
        <button class="btn btn-default" data-dismiss="modal" aria-hidden="true">Cancel</button>
        <button class="btn btn-danger" data-dismiss="modal">Delete</button>
      </div>
    </div>
  </div>
</div>


            <footer>
                <hr>

                
                <p class="pull-right">Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a></p>
                <p>© 2014 <a href="#" target="_blank">Portnine</a></p>
            </footer>
        </div>
    </div>




    <script src="${pageContext.request.contextPath}/lib/bootstrap/js/bootstrap.js"></script>
    <script type="text/javascript">
        $("[rel=tooltip]").tooltip();
        $(function() {
            $('.demo-cancel-click').click(function(){return false;});
            $('#doAddAdmin').click(function(){
            	$('#addAdminForm').submit();
            });
        });
    </script>
    
  
</body>
</html>