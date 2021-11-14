<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>

<div class="usr-grp">
	<div>
		<form id="frm">
			<img class="logo" src="../../image/common/logo.png" />
			<p><input type="text" id="usrId" name="usrId" placeholder="아이디" maxlength="30" /></p>
			<p><input type="password" id="usrPw" name="usrPw" placeholder="비밀번호" maxlength="30" /></p>
			<p><input type="password" id="usrPwChk" name="usrPwChk" placeholder="비밀번호 확인" maxlength="30" /></p>
			<span class="pw-noti red hide"></span> <!-- 비밀번호 일치 여부에 따라 red 클래스 추가, 삭제 -->
			<p><input type="text" id="usrNm" name="usrNm" placeholder="이름" maxlength="10" /></p>
			<p><input type="text" id="usrNick" name="usrNick" placeholder="닉네임" maxlength="10" /></p>
			<p><input type="text" id="usrMobile" name="usrMobile" placeholder="전화번호" maxlength="20" /></p>
			<p><input type="text" id="usrEmail" name="usrEmail" placeholder="이메일" maxlength="50" /></p>
			<button type="button" id="joinBtn" class="btn-join">회원가입</button>
		</form>
	</div>
</div>

<script type="text/javascript">
	$(document).ready(function () {
	}).on("keyup","#usrPw, #usrPwChk",function(){ // 비밀번호, 비밀번호 확인 일치 여부 확인
		$(".pw-noti").prev().addClass("margin-2");
		$(".pw-noti").removeClass("hide");
		var isEqual = compareStr( $("#usrPw").val(),$("#usrPwChk").val() ); // 일치 여부 확인2
		if (!isEqual) {
			$(".pw-noti").addClass("red");
		} else {
			$(".pw-noti").removeClass("red");
		}
	}).on("click","#joinBtn",function(){ // 회원 가입
		if ( joinChk() ) {
			joinUsr();
		}
	})
	;
	
	// 1. 유효성 체크
	function joinChk() {
		var result = true;
		var $chkTarget = $("#frm input");
		
		$.each($chkTarget, function(idx, elem) {
		    if ( isTrimEmpty($(elem).val()) ) {
				alert($(elem).attr("placeholder") + " 란을 입력하세요");
				$(elem).focus();
				result = false;
				return false;
			}
	    });
	    
    	return result;
	}
	
	// 2. 회원 가입
	function joinUsr() {
		var formData = new FormData($('#frm')[0]);
		
		$.ajax({
			type: "POST",
			enctype: 'multipart/form-data',
			url: '/login/ajax.joinProcess.do',
			data: formData,
			processData: false,
			contentType: false,
			cache: false,
			timeout: 600000,
			success: function (data) {
				if (data.isSuccess) {
					alert(data.resultMsg);
					window.location = "/login/login.do";
				} else {
					alert(data.resultMsg);
				}
			},
			error: function (e) {
				console.log("ERROR : ", e);
			}
		});
	}
	
	// 테스트용 데이터 삽입
	function test() {
		$("#usrId").val("testID");
		$("#usrNm").val("테스트이름");
		$("#usrNick").val("테스트닉네임");
		$("#usrMobile").val("01023452345");
		$("#usrEmail").val("test@naver.com");
	}
</script>