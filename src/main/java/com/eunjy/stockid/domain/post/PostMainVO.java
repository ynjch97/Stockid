package com.eunjy.stockid.domain.post;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PostMainVO {

	// 공통
	private String usrNum;
	private String grpNum;
	private String grpUrl;
	private String postNum;
	private String ctgryNum;

	// 포스트
	private String postTitle; 		// 포스트 제목
	private String postContent;		// 포스트 내용
	private String itemCd;			// 종목 코드
	private String investType;		// 투자 유형
	private String stockType;		// 주식 유형
	private String marketType;		// 마켓 유형
	private String coinType;		// 거래소 유형
	private String viewCnt;			// 조회수
	
	// 여부 확인
	private String useYn;
	private String delYn;
	
	// 등록, 수정
	private String regId;
	private String regDt;
	private String mdfyId;
	private String mdfyDt;
	
}