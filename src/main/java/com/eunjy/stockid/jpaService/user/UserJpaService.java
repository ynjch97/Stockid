package com.eunjy.stockid.jpaService.user;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eunjy.stockid.jpaDomain.user.UsrJpaVO;
import com.eunjy.stockid.jpaRepository.user.UserRepository;

@Service
public class UserJpaService {

	@Autowired
	private UserRepository userRepository;
	
	public UsrJpaVO findByUsrId(String usrId) {
		UsrJpaVO USR_ENTITY = new UsrJpaVO();
		Optional<UsrJpaVO> userInfo = userRepository.findByUsrId(usrId);
		return userInfo.orElse(USR_ENTITY); 
	}
	
}
