<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>

<div class="usr-grp">
	<div>
		<form id="addFrm">
			<img class="logo" src="../../image/common/logo.png" />
			<p>					<input type="text" 		id="grpNm" name="grpNm" placeholder="그룹명" maxlength="20" /></p>
			<p class="margin-2"><input type="text" 		id="grpUrl" name="grpUrl" placeholder="그룹 URL" maxlength="15" /></p>
			<span class="url-noti">https://stockid/<span>[그룹 URL]</span>/main.do 경로를 사용하게 됩니다.</span>
			<p>					<textarea id="grpIntro" name="grpIntro" placeholder="그룹 설명" maxlength="50" ></textarea></p>
			<p>					<textarea id="grpExpln" name="grpExpln" placeholder="그룹 상세 설명" maxlength="300" class="length-300" ></textarea></p>
			<p>
				<label for="openY">공개</label><input type="radio" id="openY" name="openYn" value="Y" />
				<label for="openN">비공개</label><input type="radio" id="openN" name="openYn" value="N" />
			</p>

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