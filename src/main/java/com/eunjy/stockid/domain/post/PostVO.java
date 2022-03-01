package com.eunjy.stockid.domain.post;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="POST_INFO")
@Getter
@Setter
@NoArgsConstructor
public class PostVO {

	// 기본
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "POST_NUM", length = 11)
	private int postNum;

	@Column(name = "GRP_NUM", length = 11)
	private int grpNum;

	@Column(name = "CTGRY_NUM", length = 11)
	private int ctgryNum;

	// 포스트
	@Column(name = "POST_TITLE", length = 30)
	private String postTitle; 		// 포스트 제목

	@Column(name = "POST_CONTENT")
	private String postContent;		// 포스트 내용

	@Column(name = "ITEM_CD", length = 30)
	private String itemCd;			// 종목 코드
	
	@Column(name = "INVEST_TYPE", length = 15)
	private String investType;		// 투자 유형
	
	@Column(name = "STOCK_TYPE", length = 15)
	private String stockType;		// 주식 유형

	@Column(name = "MARKET_TYPE", length = 15)
	private String marketType;		// 마켓 유형

	@Column(name = "COIN_TYPE", length = 15)
	private String coinType;		// 거래소 유형
	
    @Column(name = "VIEW_CNT", length = 11)
	private int viewCnt;			// 조회수
	
	// 여부 확인
    @Column(name = "USE_YN", length = 1, columnDefinition ="char")
	private String useYn;

    @Column(name = "DEL_YN", length = 1, columnDefinition ="char")
	private String delYn;
	
	// 등록, 수정
	@Column(name = "REG_ID", length = 20)
    private String regId;
    
    // @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "REG_DT")
	private String regDt;
    
    @Column(name = "MDFY_ID", length = 20)
    private String mdfyId;
    
    // @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "MDFY_DT")
	private String mdfyDt;
	
}