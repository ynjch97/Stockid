package com.eunjy.stockid.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eunjy.stockid.domain.user.UsrGrpVO;
import com.eunjy.stockid.mapper.user.GrpMapper;

@Service
public class GrpService {

	@Autowired
	private GrpMapper grpMapper;
	
	public List<UsrGrpVO> getMyGrpList(UsrGrpVO usrGrpVO) { 
		return grpMapper.getMyGrpList(usrGrpVO); 
	}
	
}
