<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html> 
<html lang="ko">
	<head> 
		<meta charset="utf-8" />
		<title>Welcome to STOCKID</title>
		<link rel="shortcut icon" href="../image/common/favicon.ico" type="image/x-icon" />
		
		<link rel="stylesheet" href="/css/main.css" />
		<link rel="stylesheet" href="/css/header.css" />
		<link rel="stylesheet" href="/css/footer.css" />
		<link rel="stylesheet" href="/css/mobile.css" />
		<script type="text/javascript" src="/js/jquery-3.6.0.min.js" ></script>
		<script type="text/javascript" src="/js/vue.js" ></script>
		
		<sitemesh:write property='div.header'/> 
		<jsp:include page="header.jsp"></jsp:include>
	</head> 
	<body> 
		<div> 
			<sitemesh:write property='body'/> 
		</div> 
		<div> 
			<sitemesh:write property='div.footer'/> 
			<jsp:include page="footer.jsp"></jsp:include>
		</div> 
	</body> 
</html>
