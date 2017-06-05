<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">
<head>
<meta charset="utf-8">
	<title>器材信息修改</title>
	<meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="">
	<meta name="author" content="">
	
	<link href='http://fonts.useso.com/css?family=Open+Sans:400,700'
		rel='stylesheet' type='text/css'>
	<link rel="stylesheet" type="text/css"
		href="${pageContext.request.contextPath }/lib/bootstrap/css/bootstrap.css">
	<link rel="stylesheet"
		href="${pageContext.request.contextPath }/lib/font-awesome/css/font-awesome.css">
	
	<script
		src="${pageContext.request.contextPath }/lib/jquery-1.11.1.min.js"
		type="text/javascript"></script>
	
	
	
	<link rel="stylesheet" type="text/css"
		href="${pageContext.request.contextPath }/stylesheets/theme.css">
	<link rel="stylesheet" type="text/css"
		href="${pageContext.request.contextPath }/stylesheets/premium.css">

</head>
<body class=" theme-blue">

	<!-- Demo page code -->

	<script type="text/javascript">
		$(function() {
			var match = document.cookie.match(new RegExp('color=([^;]+)'));
			if (match)
				var color = match[1];
			if (color) {
				$('body').removeClass(function(index, css) {
					return (css.match(/\btheme-\S+/g) || []).join(' ')
				})
				$('body').addClass('theme-' + color);
			}

			$('[data-popover="true"]').popover({
				html : true
			});

		});
	</script>
	<style type="text/css">
#line-chart {
	height: 300px;
	width: 800px;
	margin: 0px auto;
	margin-top: 1em;
}

.navbar-default .navbar-brand, .navbar-default .navbar-brand:hover {
	color: #fff;
}
</style>

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
	<!-- <link rel="shortcut icon" href="../assets/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="../assets/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="../assets/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="../assets/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="../assets/ico/apple-touch-icon-57-precomposed.png"> -->


	<!--[if lt IE 7 ]> <body class="ie ie6"> <![endif]-->
	<!--[if IE 7 ]> <body class="ie ie7 "> <![endif]-->
	<!--[if IE 8 ]> <body class="ie ie8 "> <![endif]-->
	<!--[if IE 9 ]> <body class="ie ie9 "> <![endif]-->
	<!--[if (gt IE 9)|!(IE)]><!-->

	<!--<![endif]-->

	<div class="navbar navbar-default" role="navigation">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target=".navbar-collapse">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="" href="index.html"><span class="navbar-brand"><span
					class="fa fa-paper-plane"></span> Aircraft</span></a>
		</div>

		<div class="navbar-collapse collapse" style="height: 1px;">
			<ul id="main-menu" class="nav navbar-nav navbar-right">
				<li class="dropdown hidden-xs"><a href="#"
					class="dropdown-toggle" data-toggle="dropdown"> <span
						class="glyphicon glyphicon-user padding-right-small"
						style="position: relative; top: 3px;"></span> Jack Smith <i
						class="fa fa-caret-down"></i>
				</a>

					<ul class="dropdown-menu">
						<li><a href="./">My Account</a></li>
						<li class="divider"></li>
						<li class="dropdown-header">Admin Panel</li>
						<li><a href="./">Users</a></li>
						<li><a href="./">Security</a></li>
						<li><a tabindex="-1" href="./">Payments</a></li>
						<li class="divider"></li>
						<li><a tabindex="-1" href="sign-in.html">Logout</a></li>
					</ul></li>
			</ul>

		</div>
	</div>
	</div>


	<div class="sidebar-nav">
		<ul>
			<li><a href="#" data-target=".dashboard-menu" class="nav-header"
				data-toggle="collapse"><i class="fa fa-fw fa-dashboard"></i>
					Dashboard<i class="fa fa-collapse"></i></a></li>
			<li><ul class="dashboard-menu nav nav-list collapse">
					<li><a href="index.html"><span class="fa fa-caret-right"></span>
							Main</a></li>
					<li><a href="users.html"><span class="fa fa-caret-right"></span>
							User List</a></li>
					<li><a href="user.html"><span class="fa fa-caret-right"></span>
							User Profile</a></li>
					<li><a href="media.html"><span class="fa fa-caret-right"></span>
							Media</a></li>
					<li><a href="calendar.html"><span
							class="fa fa-caret-right"></span> Calendar</a></li>
				</ul></li>

			<!-- --------------------------------------------------------------------------------------------------------- -->

			<li data-popover="true"
				data-content="Items in this group require a <strong><a href='http://portnine.com/bootstrap-themes/aircraft' target='blank'>premium license</a><strong>."
				rel="popover" data-placement="right"><a href="#"
				data-target=".premium-menu" class="nav-header collapsed"
				data-toggle="collapse"><i class="fa fa-fw fa-fighter-jet"></i>
					器材<i class="fa fa-collapse"></i></a></li>
			<li><ul class="premium-menu nav nav-list collapse in">
					<li><a href="${pageContext.request.contextPath}/equ/findForClient?thisPage=1&equTypeId=0"><span
							class="fa fa-caret-right"></span> 器材查询</a></li>
					<li><a href="${pageContext.request.contextPath}/cart/listEqu"><span
							class="fa fa-caret-right"></span> 器材订单项</a></li>
					<li class="active"><a href="${pageContext.request.contextPath}/equ/findByTypeId?thisPage=1&equTypeId=0"><span
							class="fa fa-caret-right"></span> 器材管理</a></li>
				</ul></li>

			<li><a href="#" data-target=".legal-menu"
				class="nav-header collapsed" data-toggle="collapse"><i
					class="fa fa-fw fa-legal"></i> 场地<i class="fa fa-collapse"></i></a></li>
			<li><ul class="legal-menu nav nav-list collapse">
					<li><a href="${pageContext.request.contextPath}/field/findForClient?thisPage=1&fieldTypeId=0"><span
							class="fa fa-caret-right"></span>场地查询</a></li>
					<li><a href="${pageContext.request.contextPath}/cart/listField"><span
							class="fa fa-caret-right"></span>场地订单项</a></li>
					<li><a href="${pageContext.request.contextPath}/field/findByTypeId?thisPage=1&fieldTypeId=0"><span
							class="fa fa-caret-right"></span>场地管理</a></li>
				</ul></li>

			<li><a href="#" data-target=".accounts-menu"
				class="nav-header collapsed" data-toggle="collapse"><i
					class="fa fa-fw fa-briefcase"></i> 订单<i class="fa fa-collapse"></i></a></li>
			<li><ul class="accounts-menu nav nav-list collapse">
					<li><a href="${pageContext.request.contextPath}/fieldOrder/findByUserId?userId=${sessionScope.user.userId}"><span
							class="fa fa-caret-right"></span>场地订单查询</a></li>
					<li><a href="${pageContext.request.contextPath}/equOrder/findByUserId?userId=${sessionScope.user.userId}"><span
							class="fa fa-caret-right"></span>器材订单查询</a></li>
					<li><a href="${pageContext.request.contextPath}/fieldOrder/findAll?thisPage=1"><span
							class="fa fa-caret-right"></span>场地订单管理</a></li>
					<li><a href="${pageContext.request.contextPath}/equOrder/findAll?thisPage=1"><span
							class="fa fa-caret-right"></span>器材订单管理</a></li>
				</ul></li>

			<!--  <li><a href="#" data-target=".accounts-menu" class="nav-header collapsed" data-toggle="collapse"><i class="fa fa-fw fa-briefcase"></i> Account <span class="label label-info">+3</span></a></li>
       <li><ul class="accounts-menu nav nav-list collapse">
           <li ><a href="sign-in.html"><span class="fa fa-caret-right"></span> Sign In</a></li>
           <li ><a href="sign-up.html"><span class="fa fa-caret-right"></span> Sign Up</a></li>
           <li ><a href="reset-password.html"><span class="fa fa-caret-right"></span> Reset Password</a></li>
            </ul></li> -->



			<li><a href="help.html" class="nav-header"><i
					class="fa fa-fw fa-question-circle"></i> Help</a></li>
			<li><a href="faq.html" class="nav-header"><i
					class="fa fa-fw fa-comment"></i> Faq</a></li>
			<li><a href="http://portnine.com/bootstrap-themes/aircraft"
				class="nav-header" target="blank"><i class="fa fa-fw fa-heart"></i>
					Get Premium</a></li>
		</ul>
	</div>

	<div class="content">
		<div class="header">

			<h1 class="page-title">器材信息修改</h1>
			<ul class="breadcrumb">
				<li><a href="index.html">Home</a></li>
				<li><a href="equipments.html">Equ</a></li>
				<li class="active">equ_update</li>
			</ul>

		</div>
		<div class="main-content">

			<ul class="nav nav-tabs">
				<li class="active"><a href="#home" data-toggle="tab">器材基本信息</a></li>
				<!-- <li><a href="#profile" data-toggle="tab">Password</a></li> -->
			</ul>

			<div class="row">
				<div class="col-md-4">
					<br>
					<div id="myTabContent" class="tab-content">
						<div class="tab-pane active in" id="home">
							<form id="tab" action="${pageContext.request.contextPath }/equ/update" method="post">
								<input name="equId" type="hidden"
										value="${equipmentVO.equId }" class="form-control">
								<div class="form-group">
									<label>器材名称</label> <input name="equName" type="text"
										value="${equipmentVO.equName }" class="form-control">
								</div>
								<div class="form-group">
									<label>类型</label> 
									<select name="equTypeId"
										id="DropDownTimezone" class="form-control">
										<c:forEach var="equTypeVO" items="${equTypeVOs }">
											<option <c:if test="${equipmentVO.equTypeId == equTypeVO.equTypeId }">
											selected="selected"</c:if> value="${equTypeVO.equTypeId }">${equTypeVO.equTypeName }</option>
										</c:forEach>
									</select>
								</div>
								<div class="form-group">
									<label>可用数量</label> <input name="equNormalCount" type="text"
										value="${equipmentVO.equNormalCount }" class="form-control">
								</div>
								<div class="form-group">
									<label>被预定数量</label> <input name="equReserveCount" type="text"
										value="${equipmentVO.equReserveCount }" class="form-control">
								</div>
								<div class="form-group">
									<label>已借出数量</label> <input name="equBorrowCount" type="text"
										value="${equipmentVO.equBorrowCount }" class="form-control">
								</div>
								<div class="form-group">
									<label>维修数量</label> <input name="equRepairCount" type="text"
										value="${equipmentVO.equRepairCount }" class="form-control">
								</div>
								<div class="form-group">
									<label>损坏数量</label> <input name="equBrokenCount" type="text"
										value="${equipmentVO.equBrokenCount }" class="form-control">
								</div>
								<div class="form-group">
									<label>报废数量</label> <input name="equDiscardCount" type="text"
										value="${equipmentVO.equDiscardCount }" class="form-control">
								</div>
								<div class="form-group">
									<label>器材总数</label> <input name="equTotalCount" type="text"
										value="${equipmentVO.equTotalCount }" class="form-control">
								</div>
								<div class="form-group">
									<label>租借单价</label> <input name="equBorrowUnitvaluent"
										type="text" value="${equipmentVO.equBorrowUnitvaluent }"
										class="form-control">
								</div>
								<div class="form-group">
									<label>租借押金</label> <input name="equDeposit" type="text"
										value="${equipmentVO.equDeposit }" class="form-control">
								</div>
								<div class="form-group">
									<label>器材价值</label> <input name="equValue" type="text"
										value="${equipmentVO.equValue }" class="form-control">
								</div>
								<div class="btn-toolbar list-toolbar">
									<button type="submit" class="btn btn-primary"><i class="fa fa-save"></i> 保存</button>
									<a href="#myModal" data-toggle="modal" class="btn btn-danger">删除</a>
								</div>

							</form>
						</div>

					</div>

					<!-- <div class="btn-toolbar list-toolbar">
      <button class="btn btn-primary"><i class="fa fa-save"></i> 保存</button>
      <a href="#myModal" data-toggle="modal" class="btn btn-danger">删除</a>
    </div> -->
				</div>
			</div>

			<div class="modal small fade" id="myModal" tabindex="-1"
				role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">×</button>
							<h3 id="myModalLabel">提示信息</h3>
						</div>
						<div class="modal-body">

							<p class="error-text">
								<i class="fa fa-warning modal-icon"></i>确定要删除该器材吗？
								<br/>给操作不可撤销
							</p>
						</div>
						<div class="modal-footer">
							<button class="btn btn-default" data-dismiss="modal"
								aria-hidden="true">取消</button>
							<a href="${pageContext.request.contextPath }/equ/remove?equId=${equipmentVO.equId}" data-toggle="modal" class="btn btn-danger">删除</a>
						</div>
					</div>
				</div>
			</div>
			<hr>

		</div>
	</div>


	<script
		src="${pageContext.request.contextPath }/lib/bootstrap/js/bootstrap.js"></script>
	<script type="text/javascript">
		$("[rel=tooltip]").tooltip();
		$(function() {
			$('.demo-cancel-click').click(function() {
				return false;
			});
		});
	</script>


</body>
</html>