<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>

<div class="login">
	<div>
		<img class="logo" src="../../image/common/logo.png" />
		<p><input type="text" id="loginId" name="loginId" placeholder="아이디" maxlength="30" /></p>
		<p><input type="password" id="loginPw" name="loginPw" placeholder="비밀번호" maxlength="30" /></p>
		<button id="loginBtn" class="btn-login">로그인</button>
		<span class="join-wrap">
			<a href="javascript:void(0);" id="joinBtn">회원가입 ></a>
			<a href="javascript:void(0);" id="findIdPw">ID, PW 찾기 ></a>
		</span>
	</div>
</div>

<script type="text/javascript">
	$(document).ready(function () {
	}).on("click","#loginBtn",function(){ // 로그인
		if ( loginChk() ) {
			window.location = "/user/grpList.do";
		}
	}).on("click","#joinBtn",function(){ // 회원가입
		window.location = "/login/join.do";
	}).on("click","#findIdPw",function(){ // ID, PW 찾기
		window.location = "www.naver.com";
	})
	;

	function loginChk() {
		if ( isTrimEmpty($("#loginId").val()) ) {
			alert("아이디를 입력하세요");
			$("#loginId").focus();
			return false;
		} else if ( isTrimEmpty($("#loginPw").val()) ) {
			alert("비밀번호를 입력하세요");
			$("#loginPw").focus();
			return false;
		}
		return true;
	}
</script>