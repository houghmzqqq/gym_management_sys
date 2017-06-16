<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <meta charset="utf-8">
    <title>个人信息</title>
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
                    <span class="glyphicon glyphicon-user padding-right-small" style="position:relative;top: 3px;"></span>${user.name}
                    <i class="fa fa-caret-down"></i>
                </a>

              <ul class="dropdown-menu">
                <li><a href="./">我的账户</a></li>
                <li class="divider"></li>
                <li class="dropdown-header">个人面板</li>
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
    <li><a href="#" data-target=".dashboard-menu" class="nav-header" data-toggle="collapse"><i class="fa fa-fw fa-dashboard"></i> 用户操作<i class="fa fa-collapse"></i></a></li>
    <li><ul class="dashboard-menu nav nav-list collapse in">
            <li ><a href="index.html"><span class="fa fa-caret-right"></span> 主页</a></li>
            <li ><a href="users.html"><span class="fa fa-caret-right"></span> 器材租借</a></li>
    </ul></li>
    </div>

    <div class="content">
        <div class="header">
            <div class="stats">
    <p class="stat"><span class="label label-info">5</span> Tickets</p>
    <p class="stat"><span class="label label-success">27</span> Tasks</p>
    <p class="stat"><span class="label label-danger">15</span> Overdue</p>
</div>

            <h1 class="page-title">个人信息</h1>
                    <ul class="breadcrumb">
            <li><a href="index">主页</a> </li>
            <li class="active">个人信息</li>
        </ul>

        </div>
        <div class="main-content">
        <div class="btn-toolbar list-toolbar">
    <a  href="http://baidu.com" id="updateInfo" class="btn btn-primary"><i class="fa fa-plus"></i> 修改个人信息 </a>
  <div class="btn-group">
  </div>
</div>
        <div class="row">
  
  <div class="col-md-12">

      
                      <ul class="list-group list-info">
                            <li class="list-group-item">
                                <span class="text-info fa fa-user fa-fw"></span>
                                <span>用户名：</span>
                                ${userInfo.userName }
                            </li>
                            <li class="list-group-item">
                                <span class="text-info fa fa-comment fa-fw"></span>
                                <span>用户姓名：</span>
                                ${userInfo.name }
                            </li>
                            <li class="list-group-item">
                                <span class="text-info fa fa-university fa-fw"></span>
                                <span>用户角色：</span>
                                 <c:choose>
								<c:when test="${userInfo.userRole == '超级管理员' }">
									<span class="label label-danger">${userInfo.userRole }</span>
								</c:when>
								<c:when test="${userInfo.userRole == '普通用户' }">
									<span class="label label-success">${userInfo.userRole }</span>
								</c:when>
								<c:otherwise>
									<span class="label label-info">${userInfo.userRole }</span>
								</c:otherwise>
							</c:choose>
						</li>
                            <li class="list-group-item">
                                <span class="text-info fa fa-envelope fa-fw"></span>
                                <span>邮箱：</span>
                                ${userInfo.email }
                            </li>
                            <li class="list-group-item">
                                <span class="text-info fa fa-home fa-fw"></span>
                                <span>${userInfo.idType }号码：</span>
                                 ${userInfo.idCode }
                            </li>
                            <li class="list-group-item">
                                <span class="text-info fa fa-phone fa-fw"></span>
                                <span>联系电话：</span>
                                ${userInfo.telephone }
                            </li>
                            <li class="list-group-item">
                                <span class="text-info fa fa-question fa-fw"></span>
                                <span>密保问题：</span>
                                ${userInfo.question }
                            </li>
                            <li class="list-group-item">
                                <span class="text-info fa fa-question fa-fw"></span>
                                <span>密保答案：</span>
                                ${userInfo.answer }
                            </li>
                        </ul>

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
        });
    </script>
    
  
</body>
</html>

