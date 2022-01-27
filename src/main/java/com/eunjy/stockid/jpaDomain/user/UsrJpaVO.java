package com.eunjy.stockid.jpaDomain.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="USR_INFO")
@Getter
@Setter
public class UsrJpaVO {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USR_NUM")
    private Long usrNum;

    @Column(name = "USR_ID", length = 30, nullable = false)
    private String usrId;
    
    @Column(name = "USR_PW", length = 256)
    private String usrPw;
    
    @Column(name = "USR_NM", length = 10)
    private String usrNm;
    
    @Column(name = "USR_NICK", length = 10)
    private String usrNick;
    
    @Column(name = "USR_MOBILE", length = 20)
    private String usrMobile;
    
    @Column(name = "USR_EMAIL", length = 50)
    private String usrEmail;
    
    @Column(name = "DFLT_GRP_NUM", length = 11)
    private String dfltGrpNum;
    
    @Column(name = "USE_YN", length = 1, columnDefinition ="char")
    private String useYn;
    
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