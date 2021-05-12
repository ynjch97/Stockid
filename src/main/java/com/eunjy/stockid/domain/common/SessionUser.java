package com.eunjy.stockid.domain.common;

import lombok.Data;

@Data
public class SessionUser {

	// Session 사용자 정보
	private String usrNum;
	private String usrId;
	private String usrPw;
	private String usrNm;
	private String usrNick;
	private String usrMobile;
	private String usrEmail;
	private String dfltGrpNum;
	private String usrType;
	private String useYn;
	private String regId;
	private String regDt;
	private String mdfyId;
	private String mdfyDt;
	
}