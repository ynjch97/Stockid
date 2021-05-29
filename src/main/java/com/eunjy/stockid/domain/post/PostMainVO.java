package com.eunjy.stockid.domain.post;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PostMainVO {

	// 공통
	private String usrNum;
	private String grpNum;

	// 여부 확인
	private String useYn;
	private String openYn;
	
	// 등록, 수정
	private String regId;
	private String regDt;
	private String mdfyId;
	private String mdfyDt;
	
}