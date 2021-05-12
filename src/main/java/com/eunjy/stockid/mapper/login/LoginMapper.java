package com.eunjy.stockid.mapper.login;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.eunjy.stockid.domain.common.SessionUser;
import com.eunjy.stockid.domain.user.UsrGrpVO;

@Mapper
public interface LoginMapper {

	// 회원 존재 유무 확인 조회
	public int countLoginId(UsrGrpVO usrGrpVO);

	// 로그인용 회원 조회
	public SessionUser login(UsrGrpVO usrGrpVO);
	
	// 회원가입
	public int insertUsr(UsrGrpVO usrGrpVO);

}
