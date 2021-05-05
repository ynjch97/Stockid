<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>

<div class="login">
	<div>
		<div class="tit-wrap">
			<span>그룹 목록</span>
			<span></span>
		</div>
		<div class="grp-wrap">
			<ul>
				<li><span>1그룹</span><span>></span></li>
				<li><span>1그룹</span><span>></span></li>
				<li><span>1그룹</span><span>></span></li>
				<li><span>1그룹</span><span>></span></li>
				<li><span>1그룹</span><span>></span></li>
				<li><span>1그룹1그룹1그룹1그룹1그룹1그룹1그룹1그룹1그룹1그룹1그룹1그룹1그룹1그룹1그룹</span><span>></span></li>
			</ul>
		</div>
		<div class="btn-wrap">
			<button class="btn-join-grp">그룹 참여하기</button>
			<button class="btn-crt-grp">그룹 생성하기</button>
		</div>
		<span class="grp-noti">* 그룹은 총 5개까지만 참여 가능합니다.</span>
	</div>
</div>
			
<script type="text/javascript">
	$(document).ready(function(){
		var grpCnt = $(".grp-wrap ul li").length;
		if (grpCnt == 5) {
			$(".grp-noti").addClass("red");
			$(".btn-join-grp").addClass("disabled");
			$(".btn-crt-grp").addClass("disabled");
		}
	});
</script>   