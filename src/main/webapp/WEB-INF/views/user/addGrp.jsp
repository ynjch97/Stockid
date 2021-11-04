<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>

<div class="login">
	<div>
		<form id="addFrm">
			<img class="logo" src="../../image/common/logo.png" />
			<p><input type="text" 		id="usrId" name="usrId" placeholder="아이디" maxlength="30" /></p>
			<p><input type="text" 		id="usrNm" name="usrNm" placeholder="이름" maxlength="10" /></p>
			<p><input type="text" 		id="usrNick" name="usrNick" placeholder="닉네임" maxlength="10" /></p>
			<p><input type="text" 		id="usrMobile" name="usrMobile" placeholder="전화번호" maxlength="20" /></p>
			<p><input type="text" 		id="usrEmail" name="usrEmail" placeholder="이메일" maxlength="50" /></p>
			<div class="save-wrap">
				<button type="button" class="btn-join btn-half">저장</button>
				<button type="button" class="btn-join btn-half">취소</button>
			</div>
		</form>
	</div>
</div>

<script type="text/javascript">

	var addFrmVm;
	var myGrpCnt = "${myGrpCnt}";

	$(document).ready(function () {
		if (myGrpCnt >= 5) {
		}
	})
	;
	
</script>