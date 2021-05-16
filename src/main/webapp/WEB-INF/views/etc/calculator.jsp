<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>

<div class="container">
	<div class="sub-container">
		<div>
			<p>보유평단 <input type="text" id="now" placeholder="보유평단" maxlength="20" value="0" /></p>
			<p>보유수량 <input type="text" id="nowCnt" placeholder="보유수량" maxlength="20" value="0" /></p>
			<p>보유총액 : <span id="nowCost"></span>원</p>
			
			<p>매수희망가 <input type="text" id="hope" placeholder="매수희망가" maxlength="20" value="0" /></p>
			<p>매수희망수량 <input type="text" id="hopeCnt" placeholder="매수희망수량" maxlength="20" value="0" /></p>
			<p>매수희망총액 : <span id="hopeCost"></span>원</p>
			
			<p>평단가 : <span id="result"></span>원</p>
			<p>총 수량 : <span id="resultCnt"></span>주</p>
			<p>총 매수액 : <span id="resultCost"></span>원</p>
		</div>
	</div>
</div>

<script type="text/javascript">
	$(document).ready(function () {
		calc();
	}).on("keyup","#now, #nowCnt, #hope, #hopeCnt", function(){ // 입력 이벤트			
		if ( !isValidNumber( $(this).val() ) ) {
			$(this).val("");
			return;
		}
		$(this).val( $(this).val().toString().replaceAll(",","").replace(/\B(?=(\d{3})+(?!\d))/g,",") );
		calc();
	}).on("focus","#now, #nowCnt, #hope, #hopeCnt", function(){ // 포커스 이벤트
		$(this).select();
	})
	;
	
	function calc() {
		var now = Number( $("#now").val().replaceAll(",","") );
		var nowCnt = Number( $("#nowCnt").val().replaceAll(",","") );
		var hope = Number( $("#hope").val().replaceAll(",","") );
		var hopeCnt = Number( $("#hopeCnt").val().replaceAll(",","") );
		
		var nowTotal = now * nowCnt;
		var hopeTotal = hope * hopeCnt;
		var resultCnt = nowCnt + hopeCnt;
		var resultCost = hopeTotal + nowTotal;
		var result = resultCost / resultCnt;
		nowCost = isNaN(nowCost) ? 0 : nowCost;
		hopeCost = isNaN(hopeCost) ? 0 : hopeCost;
		result = isNaN(result) ? 0 : Math.round(result * 10) / 10;
		resultCnt = isNaN(resultCnt) ? 0 : resultCnt;
		resultCost = isNaN(resultCost) ? 0 : resultCost;
		
		$("#nowCost").text( nowTotal.toString().replace(/\B(?=(\d{3})+(?!\d))/g,",") );
		$("#hopeCost").text( hopeTotal.toString().replace(/\B(?=(\d{3})+(?!\d))/g,",") );
		$("#result").text( result.toString().replace(/\B(?=(\d{3})+(?!\d))/g,",") );
		$("#resultCnt").text( resultCnt.toString().replace(/\B(?=(\d{3})+(?!\d))/g,",") );
		$("#resultCost").text( resultCost.toString().replace(/\B(?=(\d{3})+(?!\d))/g,",") );
	}
	
	// 숫자 형식 체크
	function isValidNumber(str) {
		return /^[0-9,0-9]+$/.test(str);
	}
</script>