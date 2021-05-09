<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>

<div class="login">
	<div>
		<div class="tit-wrap">
			<span style="display: none;">그룹 목록</span>
			<span id="userInfoBtn">개인정보 수정</span>
		</div>
		<div class="no-grp-wrap" style="display: none;">
			<p>가입된 그룹이 없습니다.</p>
			<p>그룹을 생성하거나</p>
			<p>초대 코드를 입력해 가입해보세요.</p>
		</div>
		<div class="grp-wrap" style="display: none;">
			<ul>
				<li><span class="grpMain">그룹명</span><span class="grpSetting">></span></li>
			</ul>
		</div>
		<div class="btn-wrap">
			<button class="btn-join-grp disabled">그룹 참여하기</button>
			<button class="btn-crt-grp disabled">그룹 생성하기</button>
		</div>
		<span class="grp-noti red">* 그룹은 총 5개까지만 참여 가능합니다.</span>
	</div>
</div>
			
<script type="text/javascript">
	var grpList = ${myGrpList};

	$(document).ready(function(){
		init();
	}).on("click","#userInfoBtn",function(){ // 개인정보 수정으로 이동
		goUserInfo();
	}).on("click",".grpMain",function(){ // 그룹 메인으로 이동
		var grpNum = $(this).parent("li").data("grpNum");
		goMain(grpNum);
	}).on("click",".grpSetting",function(){ // 그룹 설정으로 이동
		var grpNum = $(this).parent("li").data("grpNum");
		goSetting(grpNum);
	})
	;
	
	// 1. 데이터 세팅
	function init() {
		var grpCnt = grpList.length;
		
		// 그룹 개수에 따른 버튼 활성화
	    if (grpCnt < 5) {
			$(".grp-noti").removeClass("red");
			$(".btn-join-grp").removeClass("disabled");
			$(".btn-crt-grp").removeClass("disabled");
		}
		
		// 그룹 리스트 세팅
		if (grpCnt > 0) {
			$(".grp-wrap").show();
			$(".tit-wrap span:first-child").show();
			$.each(grpList, function(idx, grp) {
				var $grpLi = $(".grp-wrap ul li").eq(0).hide().clone(); // 첫 번째 항목 숨기기
				$grpLi.show().attr("data-grp-num", grp.grpNum).find("span:first-child").text(grp.grpNm); // data, 이름 세팅
				$(".grp-wrap ul").append($grpLi);
		    });
		    
		} else {
			$(".no-grp-wrap").show();
		}
	}
	
	// 2. 개인정보 수정으로 이동
	function goUserInfo() {
		window.location = "/user/userInfo.do";
	}
	
	// 3. 해당 그룹 메인으로 이동
	function goMain(grpNum) {
		alert("메인 : " + grpNum);
	}
	
	// 4. 해당 그룹 설정으로 이동
	function goSetting(grpNum) {
		alert("설정 : " + grpNum);
	}
</script>   