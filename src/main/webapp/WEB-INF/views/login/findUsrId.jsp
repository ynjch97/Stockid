<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>

<div class="usr-grp">
	<div>
		<form id="frm" class="find-noti">
			<img class="logo" src="../../image/common/logo.png" />
			<p class="title">아이디 찾기</p>
			<p class="sub">가입하신 방법에 따라 아이디 찾기가 가능합니다.</p>
			<div class="check">
				<input id="check_method1" name="check_method" value="1" type="radio" checked="checked"><label for="check_method1">이메일</label>
				<input id="check_method2" name="check_method" value="2" type="radio"><label for="check_method2"><span id="search_type_mobile_lable" style="display:inline;">휴대폰번호</span></label>
			</div>
			<p><input type="text" id="usrNm" name="usrNm" placeholder="이름" maxlength="10" /></p>
			<p><input type="text" id="usrMobile" name="usrMobile" placeholder="전화번호" maxlength="20" /></p>
			<p><input type="text" id="usrEmail" name="usrEmail" placeholder="이메일" maxlength="50" /></p>
			<button type="button" id="joinBtn" class="btn-join">확인</button>
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
			url: '/login/ajax.findUsrIdProcess.do',
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