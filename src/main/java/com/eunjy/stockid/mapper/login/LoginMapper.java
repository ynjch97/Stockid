package com.eunjy.stockid.mapper.login;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.eunjy.stockid.domain.UsrGrpVO;

@Mapper
public interface LoginMapper {
	
	public List<UsrGrpVO> getUserList();

}
