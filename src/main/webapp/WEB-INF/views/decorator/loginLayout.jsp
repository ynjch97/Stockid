<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
//[뒤로가기]버튼으로 보지 못하도록, no-cache로 설정
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0);
response.setHeader("Cache-Control", "no-cache");
%>
<!DOCTYPE html> 
<html lang="ko">
	<head> 
		<meta charset="utf-8" />
		<title>Welcome to STOCKID</title>
		<link rel="shortcut icon" href="../image/common/favicon.ico" type="image/x-icon" />
		
		<link rel="stylesheet" href="/css/main.css" />
		<link rel="stylesheet" href="/css/login.css" />
		<link rel="stylesheet" href="/css/mobile.css" />
		<script type="text/javascript" src="/js/jquery-3.6.0.min.js" ></script>
		<script type="text/javascript" src="/js/vue.js" ></script>
		<script type="text/javascript" src="/js/common.js" ></script>
		<script type="text/javascript" src="/js/login.js" ></script>
		
		<!-- [뒤로가기]버튼으로 보지 못하도록, no-cache로 설정 -->
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="Cache-Control" content="No-Cache"> 
		<meta http-equiv="pragma" content="No-cache"> 
		<meta http-equiv="expires" content="0">
	</head> 
	<body> 
		<div> 
			<sitemesh:write property='body'/> 
		</div> 
	</body> 
</html>
