package com.eunjy.stockid.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.eunjy.stockid.domain.UserVO;

@Mapper
public interface UserMapper {
	
	public List<UserVO> getUserList();

}
