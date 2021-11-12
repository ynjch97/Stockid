package com.eunjy.stockid.service.user;

import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.eunjy.stockid.domain.common.SessionUser;
import com.eunjy.stockid.domain.user.UsrGrpVO;
import com.eunjy.stockid.mapper.user.GrpMapper;
import com.eunjy.stockid.utiliy.Consts;

@Service
public class GrpService {

	@Autowired
	private GrpMapper grpMapper;
	
	public List<UsrGrpVO> getMyGrpList(UsrGrpVO usrGrpVO) { 
		return grpMapper.getMyGrpList(usrGrpVO); 
	}

	/**
	 * 그룹 생성
	 * @param UsrGrpVO
	 * @return int
	 */
	@Transactional(isolation=Isolation.READ_COMMITTED, rollbackFor=Exception.class) // 격리 레벨 : 커밋된 데이터에 대해 읽기 허용 & 예외 발생 시 강제로 Rollback
	public int insertGrp(UsrGrpVO usrGrpVO, SessionUser sessionUser) throws Exception {
		int result = 0;

		if (sessionUser != null) {
			usrGrpVO.setUsrNum( sessionUser.getUsrNum() );
			usrGrpVO.setUsrId( sessionUser.getUsrId() );
		}
		
		String grpPtcpCd = RandomStringUtils.random(10, 33, 125, false, false);
		usrGrpVO.setGrpPtcpCd(grpPtcpCd);
		
		result = grpMapper.insertGrp(usrGrpVO);
		
		usrGrpVO.setUsrType(Consts.UsrType.MASTER);
		usrGrpVO.setGrpNum( Integer.toString(usrGrpVO.getIntGrpNum()) );
		
		result += grpMapper.insertGrpRltn(usrGrpVO);
		
		return result;
	}	
	
}
