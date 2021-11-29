package com.eunjy.stockid.utiliy;

/**
 * 상수 정의 클래스
 *
 * <PRE>
 * 1. ClassName: Consts
 * 2. 작성자   : ynjch97
 * 3. 작성일   : 2021.5.13.
 * 4. 변경이력
 *		이름			일자				변경내용
 *     ———————————————————————————————————————————
 *		ynjch97		2021.5.13.		신규 개발
 * </PRE>
 */
public class Consts {

	/**
	 * 로그인 결과값
	 *
	 * <PRE>
	 * 1. ClassName: LoginResult
	 * 2. FileName : Consts.java
	 * 3. 작성자   : ynjch97
	 * 4. 작성일   : 2021.10.08.
	 * 5. 변경이력
	 *		이름			일자				변경내용
	 *     ———————————————————————————————————————————
	 *		ynjch97		2021.10.08.		신규 개발
	 * </PRE>
	 */
	public abstract static class LoginResult {
		/** 로그인 결과값 정보 */
		public static final String LOGIN_SUCCESS = "LOGIN_SUCCESS";
		public static final String LOGIN_FAIL = "LOGIN_FAIL";
		public static final String ERR_INPUT_NULL = "ERR_INPUT_NULL";
		public static final String ERR_ALREADY_LOGGED_IN = "ERR_ALREADY_LOGGED_IN";
		public static final String ERR_ID_NOT_EXIST = "ERR_ID_NOT_EXIST";
	}

	/**
	 * 그룹 생성 및 참여 결과값
	 *
	 * <PRE>
	 * 1. ClassName: GrpResult
	 * 2. FileName : Consts.java
	 * 3. 작성자   : ynjch97
	 * 4. 작성일   : 2021.11.30.
	 * 5. 변경이력
	 *		이름			일자				변경내용
	 *     ———————————————————————————————————————————
	 *		ynjch97		2021.11.30.		신규 개발
	 * </PRE>
	 */
	public abstract static class GrpResult {
		/** 그룹 생성 및 참여 결과값 정보 */
		public static final String NOT_EXIST = "NOT_EXIST";
		public static final String ALREADY_JOINED = "ALREADY_JOINED";
		public static final String ALREADY_APRVED = "ALREADY_APRVED";
	}

	/**
	 * 세션 정보
	 *
	 * <PRE>
	 * 1. ClassName: SessionAttr
	 * 2. FileName : Consts.java
	 * 3. 작성자   : ynjch97
	 * 4. 작성일   : 2021.5.13.
	 * 5. 변경이력
	 *		이름			일자				변경내용
	 *     ———————————————————————————————————————————
	 *		ynjch97		2021.5.13.		신규 개발
	 * </PRE>
	 */
	public abstract static class SessionAttr {
		/** 세션 사용자 정보 */
		public static final String USER = "session_user";
	}
	
	/**
	 * 투자 유형 정보
	 *
	 * <PRE>
	 * 1. ClassName: InvestType
	 * 2. FileName : Consts.java
	 * 3. 작성자   : ynjch97
	 * 4. 작성일   : 2021.5.20.
	 * 5. 변경이력
	 *		이름			일자				변경내용
	 *     ———————————————————————————————————————————
	 *		ynjch97		2021.5.20.		신규 개발
	 * </PRE>
	 */
	public abstract static class InvestType {
		/** 투자 유형 정보 */
		public static final String INVEST_COIN = "coin";
		public static final String INVEST_STOCK = "stock";
	}
	
	/**
	 *  회원 유형 정보
	 *
	 * <PRE>
	 * 1. ClassName: UsrType
	 * 2. FileName : Consts.java
	 * 3. 작성자   : ynjch97
	 * 4. 작성일   : 2021.11.13.
	 * 5. 변경이력
	 *		이름			일자				변경내용
	 *     ———————————————————————————————————————————
	 *		ynjch97		2021.11.13.		신규 개발
	 * </PRE>
	 */
	public abstract static class UsrType {
		/** 투자 유형 정보 */
		public static final String MASTER = "01";
		public static final String SUB_MASTER = "02";
		public static final String GENERAL = "03";
	}
	
}
