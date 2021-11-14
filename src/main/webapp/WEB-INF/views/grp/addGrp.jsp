<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>

<div class="usr-grp">
	<div>
		<form id="addFrm">
			<img class="logo" src="../../image/common/logo.png" />
			<p>
				<span class="input-span">그룹명</span>
				<input type="text" id="grpNm" name="grpNm" v-model="grpNm" placeholder="그룹명" maxlength="20" />
			</p>
			<p class="margin-2">
				<span class="input-span">그룹 URL</span>
				<input type="text" id="grpUrl" name="grpUrl" v-model="grpUrl" @input="replaceUrl" placeholder="그룹 URL" maxlength="15" />
			</p>
			<p><span class="url-noti">https://stockid/<span>[그룹 URL]</span>/main.do 경로를 사용하게 됩니다.</span></p>
			<p>
				<span class="radio-span">공개 여부</span>
				<label for="openY" class="radio"><input type="radio" id="openY" name="openYn" v-model="openYn" value="Y" />공개</label>
				<label for="openN" class="radio"><input type="radio" id="openN" name="openYn" v-model="openYn" value="N" />비공개</label>
			</p>
			<p>
				<span class="input-span">그룹 설명</span>
				<textarea id="grpIntro" name="grpIntro" v-model="grpIntro" placeholder="그룹 설명" maxlength="50" ></textarea>
			</p>
			<p>
				<span class="input-span">그룹<br/>상세 설명</span>
				<textarea id="grpExpln" name="grpExpln" v-model="grpExpln" placeholder="그룹 상세 설명" maxlength="300" class="length-300" ></textarea>
			</p>

			<div class="save-wrap">
				<button type="button" class="btn-join btn-half" @click="addGrp">저장</button>
				<button type="button" class="btn-join btn-half">취소</button>
			</div>
		</form>
	</div>
</div>

<script type="text/javascript">

	var addFrmVm;
	var myGrpCnt = Number("${myGrpCnt}");

	$(document).ready(function () {
		vueInit();
		chkMyGrpCnt();
	})
	;
	
	// Vue.js 세팅
	function vueInit() {
		addFrmVm = new Vue({ // 그룹 생성
			el: "#addFrm",
			data: {
				grpNm: null,
				grpUrl: null,
				openYn: "Y",
				grpIntro: null,
				grpExpln: null
			},
			methods: {
				addGrp: function() { // 그룹 생성
					addGrp(this);
				},
				replaceUrl: function() { // 그룹 URL 숫자와 영어만 입력 가능
					this.grpUrl = returnStrWithout(this.grpUrl, "numEng");
				}
			}
		});
	}

	// 그룹 개수 체크
	function chkMyGrpCnt() {
		if (myGrpCnt >= 5) {
			alert("그룹은 총 5개까지만 참여 가능합니다.\r\n이전 페이지로 이동합니다.");
			history.back();
		}
	}
	 	
	// 그룹 생성 유효성 체크 
	function addChk(obj) {
		if ( isTrimEmpty( obj.grpNm ) ) {
			alert("그룹명을 입력하세요");
			$("#grpNm").focus();
			return false;
		} else if ( isTrimEmpty( obj.grpUrl ) ) {
			alert("그룹 URL을 입력하세요");
			$("#grpUrl").focus();
			return false;
		} else if ( isTrimEmpty( obj.grpIntro ) ) {
			alert("그룹 설명을 입력하세요");
			$("#grpIntro").focus();
			return false;
		}
		return true;
	}
	
	// 그룹 생성
	function addGrp(obj) {
		if ( !addChk(obj) ) { // 그룹 생성 유효성 체크
			return;
		}
		
		var formData = new FormData($('#addFrm')[0]);
		
		$.ajax({
			type: "POST",
			enctype: 'multipart/form-data',
			url : '/grp/ajax.addGrpProcess.do',
			data : formData,
			processData: false, // 내부적으로 query string 만드는 것 방지
			contentType: false,
			cache: false,
			timeout: 600000,
			success : function(data) {
				if (data.isSuccess) {
					movePage("/grp/grpList.do");
				} else {
					alert("그룹 생성에 실패하였습니다.\r\n관리자에게 문의 바랍니다.");
				}
			},
			error : function(e) {
				console.log(e.responseText.trim());
			}
		});
	}
</script>