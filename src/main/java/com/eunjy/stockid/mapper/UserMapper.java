package com.eunjy.stockid.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.eunjy.stockid.domain.UsrGrpVO;

@Mapper
public interface UserMapper {
	
	public List<UsrGrpVO> getUserList();

}
