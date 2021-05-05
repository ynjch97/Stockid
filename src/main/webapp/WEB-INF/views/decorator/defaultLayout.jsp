<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html> 
<html lang="ko">
	<head> 
		<meta charset="utf-8" />
		<title>Welcome to STOCKID</title>
		<link rel="stylesheet" href="/css/main.css" />
		<sitemesh:write property='div.header'/> 
		<jsp:include page="header.jsp"></jsp:include>
	</head> 
	<body> 
		<div> 
			<sitemesh:write property='body'/> 
		</div> 
	</body> 
</html>
