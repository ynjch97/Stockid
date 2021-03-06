package com.eunjy.stockid.domain.user;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UsrGrpVO {

	// 공통
	private String usrNum;
	private String grpNum;
	private String rltnNum;
	
	// 사용자
	private String usrId;
	private String usrPw;
	private String usrNm;
	private String usrNick;
	private String usrMobile;
	private String usrEmail;
	private String dfltGrpNum;
	private String usrType;

	// 그룹
	private String grpNm;
	private String grpUrl;
	private String grpPtcpCd;
	private String grpExpln;
	private String headUsrNum;
	private String headUsrYn;

	// 여부 확인
	private String useYn;
	private String openYn;
	private String headAprvYn;
	private String mbrDelYn;
	private String mbrDelDt;
	
	// 등록, 수정
	private String regId;
	private String regDt;
	private String mdfyId;
	private String mdfyDt;
	
}