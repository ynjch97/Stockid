package com.eunjy.stockid.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserVO {

	private int userNum;
	private String userId;
	private String userPw;
	private String regId;
	private String regDt;
	
}
