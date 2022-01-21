<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<c:set var="sessionUser" value="${sessionScope.session_user}" />

<div class="usr-grp" id="grpDiv">
	<div>
		<div class="tit-wrap">
			<span v-if="grpExist">그룹 목록</span>
			<span @click="goUserInfo">개인정보 수정</span>
		</div>
		<div class="grp-wrap" v-if="grpExist">
			<ul v-for="(grpInfo, idx) in grpList" :key="grpInfo.grpNum">
				<li>
					<span class="grpMain" @click="goMain" :idx="idx">{{grpInfo.grpNm}}</span>
					<span class="grpSetting" @click="goSetting" :idx="idx">></span>
				</li>
			</ul>
		</div>
		<div class="no-grp-wrap" v-else>
			<p>가입된 그룹이 없습니다.</p>
			<p>${sessionUser.usrNick} 님의 그룹을 생성하거나</p>
			<p>초대 코드를 입력해 가입해보세요.</p>
		</div>
		<div class="btn-wrap">
			<button class="btn-join-grp" :class="{ 'disabled': grpFull }" @click="goJoinGrp">그룹 참여하기</button>
			<button class="btn-crt-grp" :class="{ 'disabled': grpFull }" @click="goAddGrp">그룹 생성하기</button>
		</div>
		<span class="grp-noti" :class="{ 'red': grpFull }">* 그룹은 총 5개까지만 참여 가능합니다.</span>
	</div>
</div>
			
<script type="text/javascript">

	var grpDivVm;
	const grpList = ${myGrpList};
	const grpCnt = grpList.length;

	$(function() {
		vueInit();
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
				grpList: grpList,
				grpIdx: null
			},
			methods: {
				goUserInfo: function(e) { // 개인정보 수정으로 이동
					movePage("/user/userInfo.do");
				},
				goMain: function(e) { // 해당 그룹 메인으로 이동
					this.grpIdx = e.target.getAttribute('idx');
					var grpUrl = this.grpList[this.grpIdx].grpUrl;
					movePage("/" + grpUrl + "/main.do");
				},
				goSetting: function(e) { // 해당 그룹 설정으로 이동
					this.grpIdx = e.target.getAttribute('idx');
					var grpNum = this.grpList[this.grpIdx].grpNum;
					goSetting(grpNum); 
				},
				goJoinGrp: function(e) { // 그룹 참여로 이동
					goJoinGrp();
				},
				goAddGrp: function(e) { // 그룹 생성으로 이동
					goAddGrp();
				}
			}
		});
		
	}
	
	// 2. 해당 그룹 설정으로 이동
	function goSetting(grpNum) {
		alert("설정 : " + grpNum);
	}
	
	// 3. 그룹 참여로 이동 
	function goJoinGrp() {
		if (grpCnt >= 5) {
			alert("그룹은 총 5개까지만 참여 가능합니다.");
		} else {
			movePage("/grp/joinGrp.do");
		}
	}
	
	// 4. 그룹 생성으로 이동 
	function goAddGrp() {
		if (grpCnt >= 5) {
			alert("그룹은 총 5개까지만 참여 가능합니다.");
		} else {
			movePage("/grp/addGrp.do");
		}
	}
</script>   