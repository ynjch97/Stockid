package com.eunjy.stockid.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UsrGrpVO {

	// 공통
	private int usrNum;
	private int grpNum;
	private int rltnNum;
	
	// 사용자
	private String usrId;
	private String usrPw;
	private String usrNm;
	private String usrMobile;
	private String dfltGrpNum;

	// 그룹
	private String grpNm;
	private String grpPtcpCd;
	private String grpExpln;
	private String headUsrNum;
	private String headUsrYn;

	// 여부 확인
	private String useYn;
	private String openYn;
	private String headAprvYn;
	private String mbrAprvYn;
	
	// 등록, 수정
	private String regId;
	private String regDt;
	private String mdfyId;
	private String mdfyDt;
	
}