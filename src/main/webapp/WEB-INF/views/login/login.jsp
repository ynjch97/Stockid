<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>

<div class="login">
	<div>
		<form id="frm">
			<img class="logo" src="../../image/common/logo.png" />
			<p><input type="text" id="loginId" name="loginId" placeholder="아이디" maxlength="30" /></p>
			<p><input type="password" id="loginPw" name="loginPw" placeholder="비밀번호" maxlength="30" /></p>
			<button type="button" id="loginBtn" class="btn-login">로그인</button>
		</form>
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
			login();
		}
	}).on("click","#joinBtn",function(){ // 회원가입
		window.location = "/login/join.do";
	}).on("click","#findIdPw",function(){ // ID, PW 찾기
		window.location = "www.naver.com";
	})
	;
	
	// 1. 로그인 유효성 체크
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
	
	// 2. 로그인
	function login(isForce) {
		if (isForce == null) {
			isForce = false;
		}
		
		var formData = new FormData($('#frm')[0]);
		formData.set("isForce", isForce);
		
		$.ajax({
			type: "POST",
			enctype: 'multipart/form-data',
			url : '/login/loginProcess.do',
			data : formData,
			processData: false,
			contentType: false,
			cache: false,
			timeout: 600000,
			success : function(data) {
				console.log(data);
				if (data.isSuccess) {
					var resultMsg = data.resultMsg;
					if (resultMsg == "GO_MAIN") {
						movePage("/user/grpList.do");
					} else if (resultMsg == "ERROR_INPUT_NULL") {
						alert("잘못된 입력값입니다.\r\n아이디와 비밀번호를 다시 확인해주세요.");
			    		deleteCookie("usercookieId");
					} else if (resultMsg == "LOGIN_FAIL") {
						alert("로그인에 실패하였습니다.");
			    		deleteCookie("usercookieId");
					} else if (resultMsg == "ALREADY_LOGGED_IN") {
						alert("이미 로그인 되어있습니다. 메인으로 이동합니다.");
						movePage("/user/grpList.do");
					} else if (resultMsg == "ID_DOES_NOT_EXIST") {
			    		alert("존재하지 않는 아이디입니다.");
			    		deleteCookie("usercookieId");
					}
				}
			},
			error : function(e) {
				console.log(e.responseText.trim());
				viewLayer(e.responseText.trim());
			}
		});
	}
</script>