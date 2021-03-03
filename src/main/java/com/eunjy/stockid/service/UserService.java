package com.eunjy.stockid.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eunjy.stockid.domain.UserVO;
import com.eunjy.stockid.mapper.UserMapper;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;
	
	public List<UserVO> getUserList() { 
		return userMapper.getUserList(); 
	}
	
}
