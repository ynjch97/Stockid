package com.eunjy.stockid.mapper.user;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.eunjy.stockid.domain.user.UsrGrpVO;

@Mapper
public interface GrpMapper {
	
	public List<UsrGrpVO> getMyGrpList(UsrGrpVO usrGrpVO);

	public int insertGrp(UsrGrpVO usrGrpVO);
	public int insertGrpRltn(UsrGrpVO usrGrpVO);
	
	public int getDuplGrpCnt(UsrGrpVO usrGrpVO);
	
}
