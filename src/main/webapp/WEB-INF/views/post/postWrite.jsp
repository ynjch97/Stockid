<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>

<div class="container">

	<h3 class="page-title">포스트 등록</h3>
	
	<div class="page-sub-title-style">
		<h3 class="sub-title">기본 정보</h3>
    </div>

	<div class="form-board">
		<table>
			<caption>포스트 등록 - 기본 정보</caption>
			<colgroup>
				<col width="15%"/>
				<col/>
				<col width="15%"/>
				<col/>
			</colgroup>
			<tbody>
				<tr>
					<th scope="row">그룹</th>
					<td>
						할수있다
					</td>
					<th scope="row"><span class="mendatory"></span><label for="postCtgry">카테고리</label></th>
					<td class="input-td">
						<select id="postCtgry" name="postCtgry" style="width:60%;">
							<option value="00">마감시황</option>
							<option value="01">뉴스</option>
							<option value="02">종목 추천</option>
						</select>
					</td>
				</tr>
				<tr>
					<th scope="row"><span class="mendatory"></span><label for="postTitle">제목</label></th>
					<td colspan="3" class="input-td">
						<input type="text" id="postTitle" name="postTitle" style="width:60%;" placeholder="제목을 입력하세요." maxlength="50"/>
					</td>
				</tr>
				<tr>
					<th scope="row"><label for="itemCd">종목명</label></th>
					<td colspan="3">
						<span class="item-txt">삼성전자</span>
						<button type="button" class="btn-dark-gray btn-tiny">종목 검색</button>
					</td>
				</tr>
				<tr>
					<th scope="row"><span class="mendatory"></span><label for="postContent_tmp">내용</label></th>
					<td colspan="3" class="input-td">
						<span class="textarea-limit">
							<textarea id="postContent_tmp" name="postContent_tmp" rows="12" cols="12" class="textarea" placeholder="내용을 입력하세요." maxlength="1000"></textarea>
							<input type="hidden" name="postContent" id="postContent" />
						</span>

					</td>
				</tr>
			</tbody>
		</table>
	</div>
	
	<div class="page-sub-title-style">
		<h3 class="sub-title">연관 종목 정보</h3>
    </div>

	<div class="form-board">
		<table>
			<caption>포스트 등록 - 연관 종목 정보</caption>
			<colgroup>
				<col width="15%"/>
				<col width="15%"/>
				<col/>
			</colgroup>
			<tbody>
				<tr>
					<th scope="row" rowspan="2" class="input-td">
						<input type="text" id="itemGrpType" name="itemGrpType" style="width:60%;" placeholder="유형" maxlength="20"/>
					</th>
					<td>
						<span class="item-txt">삼성바이오로직스</span>
						<button type="button" class="btn-dark-gray btn-tiny">종목 검색</button>
					</td>
					<td class="input-td">
						<input type="text" id="itemComment" name="itemComment" style="width:100%;" placeholder="설명" maxlength="100"/>
					</td>
				</tr>
				<tr>
					<td>
						<span class="item-txt">삼성엔지니어링</span>
						<button type="button" class="btn-dark-gray btn-tiny">종목 검색</button>
					</td>
					<td class="input-td">
						<input type="text" id="itemComment" name="itemComment" style="width:100%;" placeholder="설명" maxlength="100"/>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	
</div>


<script type="text/javascript">
	$(document).ready(function(){
		console.log("hi");
	});
</script>   