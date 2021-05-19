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
	
}
