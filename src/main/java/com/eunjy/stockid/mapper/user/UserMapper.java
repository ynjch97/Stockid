package com.eunjy.stockid.mapper.user;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.eunjy.stockid.domain.user.UsrGrpVO;

@Mapper
public interface UserMapper {
	
	public List<UsrGrpVO> getMyGrpList(UsrGrpVO usrGrpVO);
	
	public UsrGrpVO getUserInfo(UsrGrpVO usrGrpVO);

}
