<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	 <title></title>
  </head>
  <body>
	 <c:forEach var="equ" items="${equipmentVOs }">
	 	<li>
	 		${equ.equName}
	 	</li>
	 </c:forEach>
  </body>
</html>