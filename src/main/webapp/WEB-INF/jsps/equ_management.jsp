<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">
<head>
<meta charset="utf-8">
<title>器材管理</title>
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
	<link rel="apple-touch-icon-precomposed" sizes="144x144"
		href="../assets/ico/apple-touch-icon-144-precomposed.png">
	<link rel="apple-touch-icon-precomposed" sizes="114x114"
		href="../assets/ico/apple-touch-icon-114-precomposed.png">
	<link rel="apple-touch-icon-precomposed" sizes="72x72"
		href="../assets/ico/apple-touch-icon-72-precomposed.png">
	<link rel="apple-touch-icon-precomposed"
		href="../assets/ico/apple-touch-icon-57-precomposed.png"> -->


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
            <li class="dropdown hidden-xs">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                    <span class="glyphicon glyphicon-user padding-right-small" style="position:relative;top: 3px;"></span>${user.relName}
                    <i class="fa fa-caret-down"></i>
                </a>

              <ul class="dropdown-menu">
                <li><a href="./">我的账户</a></li>
                <li class="divider"></li>
                <li class="dropdown-header">管理面板</li>
                <li><a href="./">用户列表</a></li>
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

			<!-- --------------------------------------------------------------------------------------------------------- -->

			<li data-popover="true"
				rel="popover" data-placement="right" data-original-title="" title=""><a
				href="#" data-target=".premium-menu" class="nav-header collapsed"
				data-toggle="collapse"><i class="fa fa-fw fa-fighter-jet"></i>
					器材<i class="fa fa-collapse"></i></a></li>
			<li><ul class="premium-menu nav nav-list collapse in">
					<li class="visible-xs visible-sm"><a href="#">- Premium
							features require a license -</a></li>
					<%-- <li><a href="${pageContext.request.contextPath}/equ/findForClient?thisPage=1&equTypeId=0"><span
							class="fa fa-caret-right"></span> 器材查询</a></li>
					<li><a href="${pageContext.request.contextPath}/cart/listEqu"><span
							class="fa fa-caret-right"></span> 器材订单项</a></li> --%>
					<li class="active"><a href="${pageContext.request.contextPath}/equ/findByTypeId?thisPage=1&equTypeId=0"><span
							class="fa fa-caret-right"></span> 器材管理</a></li>
					<li><a href="${pageContext.request.contextPath}/equOrder/findAll?thisPage=1"><span
							class="fa fa-caret-right"></span>器材订单管理</a></li>
				</ul></li>

		</ul>
	</div>

	<div class="content">
		<div class="header">

			<h1 class="page-title">体育馆器材列表</h1>
			<ul class="breadcrumb">
				<li><a href="index.html">Home</a></li>
				<li class="active">equ_management</li>
			</ul>

		</div>
		<div class="main-content">

			<div class="btn-toolbar list-toolbar">
				<!-- <button class="btn btn-primary">
					<i class="fa fa-plus"></i> New User
				</button> -->
				<form action="${pageContext.request.contextPath }/equ/findByTypeId"
					method="get">
					<input type="hidden" name="thisPage" value="1" /> <select
						name="equTypeId" class="btn btn-default">
						<option value="0">全部</option>
						<c:forEach var="equTypeVO" items="${equTypeVOs }">
							<option <c:if test="${equTypeId == equTypeVO.equTypeId }">
							selected="selected"</c:if> value="${equTypeVO.equTypeId }">
								${equTypeVO.equTypeName }</option>
						</c:forEach>
					</select>
					<button class="btn btn-default" type="submit">查找</button>
	    			<a href="${pageContext.request.contextPath }/equ/turnToAdd" class="btn btn-primary">
	    			<i class="fa fa-plus"></i> 添加</a>
				</form>
				<div class="btn-group"></div>
			</div>
			<table class="table">
				<thead>
					<tr>
						<th>编号</th>
						<th>类型名称</th>
						<th>名称</th>
						<th>可用数</th>
						<th>预定数</th>
						<th>借出数</th>
						<th>维修数</th>
						<th>损坏数</th>
						<th>报废数</th>
						<th>总数</th>
						<th>租借单价(元/h)</th>
						<th>押金(元/个)</th>
						<th>器材价值(元/个)</th>
						<th style="width: 3.5em;"></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="equipmentVO" items="${equipmentVOs }"
						varStatus="equVOs">
						<tr>
							<td>${equipmentVO.equId}</td>
							<td>${equipmentVO.equTypeName }</td>
							<td>${equipmentVO.equName }</td>
							<td>${equipmentVO.equNormalCount }</td>
							<td>${equipmentVO.equReserveCount }</td>
							<td>${equipmentVO.equBorrowCount }</td>
							<td>${equipmentVO.equRepairCount }</td>
							<td>${equipmentVO.equBrokenCount }</td>
							<td>${equipmentVO.equDiscardCount }</td>
							<td>${equipmentVO.equTotalCount }</td>
							<td>${equipmentVO.equBorrowUnitvaluent }</td>
							<td>${equipmentVO.equDeposit }</td>
							<td>${equipmentVO.equValue }</td>
							<td><a href="${pageContext.request.contextPath }/equ/turnToUpdate?equId=${equipmentVO.equId}">
							<i class="fa fa-pencil"></i></a> 
							<a href="#myModal${equVOs.index }" role="button" data-toggle="modal"><i class="fa fa-trash-o"></i>
							</a></td>
						</tr>
						
						<div class="modal small fade" id="myModal${equVOs.index }" tabindex="-1"
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
											<i class="fa fa-warning modal-icon"></i>确定要删除该器材吗？ <br>该操作不可撤销
										</p>
									</div>
									<div class="modal-footer">
										<button class="btn btn-default" data-dismiss="modal"
											aria-hidden="true">取消</button>
										<a
											href="${pageContext.request.contextPath }/equ/remove?equId=${equipmentVO.equId }"
											data-toggle="modal" class="btn btn-danger">删除</a>
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
				</tbody>
			</table>

			<ul class="pagination">
				<li><a
					href="${pageContext.request.contextPath }/equ/findByTypeId?thisPage=${dividePage.prePage}&equTypeId=${equTypeId}">&laquo;</a></li>

				<c:if test="${dividePage.pageCount < 5}">
					<c:set var="start" value="1" scope="page"></c:set>
					<c:set var="end" value="${dividePage.pageCount }" scope="page"></c:set>
				</c:if>
				<c:if test="${dividePage.pageCount > 5}">
					<c:choose>
						<c:when test="${dividePage.thisPage <= 3}">
							<c:set var="start" value="1" scope="page"></c:set>
							<c:if test="${dividePage.lastPage <=5}">
								<c:set var="end" value="${dividePage.lastPage}" scope="page"></c:set>
							</c:if>
							<c:if test="${dividePage.lastPage >5}">
								<c:set var="end" value="5" scope="page"></c:set>
							</c:if>
						</c:when>
						<c:when test="${dividePage.thisPage >= dividePage.lastPage-2}">
							<c:set var="start" value="${dividePage.lastPage-4}" scope="page"></c:set>
							<c:set var="end" value="${dividePage.lastPage}" scope="page"></c:set>
						</c:when>
						<c:otherwise>
							<c:set var="start" value="${dividePage.thisPage-2}" scope="page"></c:set>
							<c:set var="end" value="${dividePage.thisPage+2}" scope="page"></c:set>
						</c:otherwise>
					</c:choose>
				</c:if>

				<c:forEach begin="${start}" end="${end}" step="1" var="i">
					<c:if test="${i == dividePage.thisPage}">
						<li><a href="#" style="background-color: silver">${i}</a></li>
					</c:if>
					<c:if test="${i != dividePage.thisPage}">
						<li><a
							href="${pageContext.request.contextPath}/equ/findByTypeId?thisPage=${i}&equTypeId=${equTypeId}">${i}</a></li>
					</c:if>
				</c:forEach>
				<li><a
					href="${pageContext.request.contextPath }/equ/findByTypeId?thisPage=${dividePage.nextPage}&equTypeId=${equTypeId}">&raquo;</a></li>
			</ul>


			<hr>

			<!-- <footer>
               <hr>
           
               
               <p class="pull-right">Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a></p>
               <p>© 2014 <a href="#" target="_blank">Portnine</a></p>
           </footer> -->
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

		$(function() {
			$('.selectpicker').selectpicker({
				style : 'btn-info',
				size : 4
			})
		})
	</script>


</body>
</html>