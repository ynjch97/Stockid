package com.eunjy.stockid.service.login;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eunjy.stockid.domain.user.UsrGrpVO;
import com.eunjy.stockid.mapper.login.LoginMapper;

@Service
public class LoginService {

	@Autowired
	private LoginMapper loginMapper;
	
	public int insertUsr(UsrGrpVO usrGrpVO) { 
		return loginMapper.insertUsr(usrGrpVO); 
	}
	
}
