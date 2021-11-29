<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>

<div class="usr-grp">
	<div>
		<form id="joinFrm">
			<img class="logo" src="../../image/common/logo.png" />

			<p><input type="text" id="grpPtcpCd" name="grpPtcpCd" v-model="grpPtcpCd" placeholder="그룹 참여 코드" maxlength="30" /></p>

			<div class="save-wrap">
				<button type="button" class="btn-join btn-half" @click="joinGrp">참여</button>
				<button type="button" class="btn-join btn-half" @click="cancel">취소</button>
			</div>
		</form>
	</div>
</div>

<script type="text/javascript">

	var joinFrmVm;
	var myGrpCnt = Number("${myGrpCnt}");

	$(document).ready(function () {
		vueInit();
		chkMyGrpCnt();
	})
	;
	
	// Vue.js 세팅
	function vueInit() {
		joinFrmVm = new Vue({ // 그룹 참여
			el: "#joinFrm",
			data: {
				grpPtcpCd: null
			},
			methods: {
				joinGrp: function() { // 그룹 참여
					joinGrp();
				},
				cancel: function() {
					history.back();
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
	 	
	// 그룹 참여 유효성 체크 
	function joinChk() {
		if ( isTrimEmpty( joinFrmVm.grpPtcpCd ) ) {
			alert("그룹 참여 코드를 입력하세요");
			$("#grpPtcpCd").focus();
			return false;
		}
		return true;
	}
	
	// 그룹 참여
	function joinGrp() {
		if ( !joinChk() ) { // 그룹 참여 유효성 체크
			return;
		}
		
		var formData = new FormData($('#joinFrm')[0]);
		
		$.ajax({
			type: "POST",
			enctype: 'multipart/form-data',
			url : '/grp/ajax.joinGrpProcess.do',
			data : formData,
			processData: false, // 내부적으로 query string 만드는 것 방지
			contentType: false,
			cache: false,
			timeout: 600000,
			success : function(data) {
				if (data.isSuccess) {
					alert("그룹 참여 신청이 완료되었습니다.\r\n방장 승인 후 그룹이 활성화 되며 활동이 가능합니다.");
					movePage("/grp/grpList.do");
				} else {
					var resultMsg = data.resultMsg;
					if ( compareStr(resultMsg, "ALREADY_APRVED") ) {
						alert("이미 가입 승인이 완료된 그룹입니다.");
					} else if ( compareStr(resultMsg, "ALREADY_JOINED") ) {
						alert("이미 가입 신청이 완료된 그룹입니다.");
					} else if ( compareStr(resultMsg, "NOT_EXIST") ) {
						alert("폐쇄된 그룹의 참여 코드이거나 잘못된 참여 코드입니다.");
					} else {
						alert("그룹 참여에 실패하였습니다.\r\n관리자에게 문의 바랍니다.");
					}
				}
			},
			error : function(e) {
				alert("그룹 참여에 실패하였습니다.\r\n관리자에게 문의 바랍니다.");
				console.log(e.responseText.trim());
			}
		});
		
		// 초기화
		joinFrmVm.grpPtcpCd = ""; 
	}
	
</script>