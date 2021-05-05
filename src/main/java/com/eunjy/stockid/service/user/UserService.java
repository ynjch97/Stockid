package com.eunjy.stockid.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eunjy.stockid.domain.UsrGrpVO;
import com.eunjy.stockid.mapper.user.UserMapper;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;
	
	public List<UsrGrpVO> getUserList() { 
		return userMapper.getUserList(); 
	}
	
}
