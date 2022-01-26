package com.eunjy.stockid.service.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eunjy.stockid.domain.user.UsrEntity;
import com.eunjy.stockid.domain.user.UsrGrpVO;
import com.eunjy.stockid.mapper.user.UserMapper;
import com.eunjy.stockid.repository.user.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private UserRepository userRepository;
	
	public UsrGrpVO getUserInfo(UsrGrpVO usrGrpVO) { 
		return userMapper.getUserInfo(usrGrpVO); 
	}

	public UsrEntity findByUsrId(String usrId) {
		UsrEntity USR_ENTITY = new UsrEntity();
		Optional<UsrEntity> userInfo = userRepository.findByUsrId(usrId);
		return userInfo.orElse(USR_ENTITY); 
	}
	
}
