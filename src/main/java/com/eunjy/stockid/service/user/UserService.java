package com.eunjy.stockid.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eunjy.stockid.domain.user.UsrGrpVO;
import com.eunjy.stockid.mapper.user.UserMapper;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;
	
	public List<UsrGrpVO> getMyGrpList(UsrGrpVO usrGrpVO) { 
		return userMapper.getMyGrpList(usrGrpVO); 
	}
	
	public UsrGrpVO getUserInfo(UsrGrpVO usrGrpVO) { 
		return userMapper.getUserInfo(usrGrpVO); 
	}
	
}
