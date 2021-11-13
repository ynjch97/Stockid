<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>

<div class="login">
	<div>
		<form id="infoFrm">
			<img class="logo" src="../../image/common/logo.png" />
			<p><input type="text" 		id="usrId" name="usrId" v-model="usrId" placeholder="아이디" maxlength="30" Readonly/></p>
			<p><input type="password" 	id="usrPw" name="usrPw" v-model="usrPw" @keyup="checkPw" placeholder="비밀번호" maxlength="30" /></p>
			<p><input type="password" 	id="usrPwChk" name="usrPwChk" v-model="usrPwChk" @keyup="checkPw" placeholder="비밀번호 확인" maxlength="30" /></p>
			<span class="pw-noti red hide"></span> <!-- 비밀번호 일치 여부에 따라 red 클래스 추가, 삭제 -->
			<p><input type="text" 		id="usrNm" name="usrNm" v-model="usrNm" placeholder="이름" maxlength="10" /></p>
			<p><input type="text" 		id="usrNick" name="usrNick" v-model="usrNick" placeholder="닉네임" maxlength="10" /></p>
			<p><input type="text" 		id="usrMobile" name="usrMobile" v-model="usrMobile" placeholder="전화번호" maxlength="20" /></p>
			<p><input type="text" 		id="usrEmail" name="usrEmail" v-model="usrEmail" placeholder="이메일" maxlength="50" /></p>
			<div class="save-wrap">
				<button type="button" class="btn-join btn-half" v-on:click="saveUserInfo">저장</button>
				<button type="button" class="btn-join btn-half">취소</button>
			</div>
		</form>
	</div>
</div>

<script type="text/javascript">
	var userInfo = ${userInfo};

	$(document).ready(function () {
		vueInit(); 
	});
	
	// Vue.js 세팅
	function vueInit() {
		infoFrmVm = new Vue({ // 개인정보 수정
			el: "#infoFrm",
			data: {
				usrId: userInfo.usrId,
				usrPw: null,
				usrPwChk: null,
				usrNm: userInfo.usrNm,
				usrNick: userInfo.usrNick,
				usrMobile: userInfo.usrMobile,
				usrEmail: userInfo.usrEmail,
			},
			methods: {
				checkPw: function(e) { 
					e.preventDefault();
					checkPw(this);
				},
				
				//저장버튼 클릭 이벤트
				saveUserInfo: function(e) { 
					if(nullChk()) {
						var formData = new FormData($('#infoFrm')[0]);

						$.ajax({
							type: "POST",
							enctype: 'multipart/form-data',
							url: '/user/changeUserInfo.do',
							data: formData,
							processData: false,
							contentType: false,
							cache: false,
							timeout: 600000,
							success: function (data) {
								if (data.isSuccess) {
									alert(data.resultMsg);
									movePage("/user/grpList.do");
								} else {
									alert(data.resultMsg);
								}
							},
							error: function (e) {
								console.log("ERROR : ", e);
							}
						});
					}
				}
			}
		});
	}
	
	// 비밀번호, 비밀번호 확인 일치 여부 확인
	function checkPw(obj) {
		$(".pw-noti").removeClass("hide");
		var isEqual = compareStr(obj.usrPw, obj.usrPwChk ); // 일치 여부 확인
		if (!isEqual) {
			$(".pw-noti").addClass("red");
		} else {
			$(".pw-noti").removeClass("red");
		}
	}
	
	// 필수값 확인
	function nullChk() {
		if($('#usrPw').val() === "" || $('#usrPwChk').val() === "") {
			alert("비밀번호는 필수값입니다.");
			return false;
		} else {
			return true;
		}	
	}
</script>