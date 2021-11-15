<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<c:set var="sessionUser" value="${sessionScope.session_user}" />

<div class="usr-grp" id="grpDiv">
	<div>
		<div class="tit-wrap">
			<span v-if="grpExist">그룹 목록</span>
			<span id="userInfoBtn">개인정보 수정</span>
		</div>
		<div class="grp-wrap" v-if="grpExist">
			<ul v-for="grpInfo in grpList">
				<li data-grp-num="1" data-grp-url="I_CAN"><span class="grpMain">{{grpInfo.grpNm}}</span><span class="grpSetting">></span></li>
			</ul>
		</div>
		<div class="no-grp-wrap" v-else>
			<p>가입된 그룹이 없습니다.</p>
			<p>${sessionUser.usrNick} 님의 그룹을 생성하거나</p>
			<p>초대 코드를 입력해 가입해보세요.</p>
		</div>
		<div class="btn-wrap">
			<button class="btn-join-grp joinGrp" :class="{ 'disabled': grpFull }">그룹 참여하기</button>
			<button class="btn-crt-grp addGrp" :class="{ 'disabled': grpFull }">그룹 생성하기</button>
		</div>
		<span class="grp-noti" :class="{ 'red': grpFull }">* 그룹은 총 5개까지만 참여 가능합니다.</span>
	</div>
</div>
			
<script type="text/javascript">

	var grpDivVm;
	const grpList = ${myGrpList};
	const grpCnt = grpList.length;

	$(document).ready(function(){
		vueInit();
	}).on("click","#userInfoBtn",function(){ // 개인정보 수정으로 이동
		goUserInfo();
	}).on("click",".grpMain",function(){ // 그룹 메인으로 이동
		var grpUrl = $(this).parent("li").data("grpUrl");
		goMain(grpUrl);
	}).on("click",".grpSetting",function(){ // 그룹 설정으로 이동
		var grpNum = $(this).parent("li").data("grpNum");
		goSetting(grpNum);
	}).on("click",".joinGrp",function(){ // 그룹 참여로 이동
		goJoinGrp();
	}).on("click",".addGrp",function(){ // 그룹 생성으로 이동
		goAddGrp();
	})
	;
	
	// 1. Vue.js 데이터 세팅
	function vueInit() {
		grpDivVm = new Vue({ 
			el: "#grpDiv",
			data: {
				// 그룹 개수에 따른 버튼 활성화 (그룹이 5개일 경우 참여, 생성 버튼 비활성화)
				grpFull: (grpCnt >= 5), 
				// 그룹 리스트 존재
				grpExist: (grpCnt > 0), 
				grpList: grpList
			},
			methods: {
			}
		});
		
	}
	
	// 1. 데이터 세팅
	/* 
	function init() {
		var grpCnt = grpList.length;
		
		// 그룹 리스트 세팅
		if (grpCnt > 0) {
			$.each(grpList, function(idx, grp) {
				var $grpLi = $(".grp-wrap ul li").eq(0).hide().clone(); // 첫 번째 항목 숨기기
				$grpLi.show().attr("data-grp-num", grp.grpNum).attr("data-grp-url", grp.grpUrl).find("span:first-child").text(grp.grpNm); // data, 이름 세팅
				$(".grp-wrap ul").append($grpLi);
		    });
		} 
	} 
	*/
	
	// 2. 개인정보 수정으로 이동
	function goUserInfo() {
		movePage("/user/userInfo.do");
	}
	
	// 3. 해당 그룹 메인으로 이동
	function goMain(grpUrl) {
		movePage("/" + grpUrl + "/main.do");
	}
	
	// 4. 해당 그룹 설정으로 이동
	function goSetting(grpNum) {
		alert("설정 : " + grpNum);
	}
	
	// 5. 그룹 참여로 이동 
	function goJoinGrp() {
		if (grpCnt >= 5) {
			alert("그룹은 총 5개까지만 참여 가능합니다.");
		} else {
			movePage("/grp/joinGrp.do");
		}
	}
	
	// 6. 그룹 생성으로 이동 
	function goAddGrp() {
		if (grpCnt >= 5) {
			alert("그룹은 총 5개까지만 참여 가능합니다.");
		} else {
			movePage("/grp/addGrp.do");
		}
	}
</script>   