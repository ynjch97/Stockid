package com.eunjy.stockid.service.login;

import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.eunjy.stockid.domain.common.SessionUser;
import com.eunjy.stockid.domain.user.UsrGrpVO;
import com.eunjy.stockid.mapper.login.LoginMapper;
import com.eunjy.stockid.utiliy.Consts;
import com.eunjy.stockid.utiliy.LoginManager;
import com.eunjy.stockid.utiliy.SHA256Util;
import com.eunjy.stockid.utiliy.StringUtil;

@Service
public class LoginService {

	@Autowired
	private LoginMapper loginMapper;
	
	
	/**
	 * 로그인 검증 및 세션 정보 생성 1
	 * @param UsrGrpVO
	 * @return String
	 */
	public String login(UsrGrpVO usrGrpVO, boolean isForce, HttpServletRequest request) throws Exception {
		String resultMsg = "";
		
		// 데이터 NULL 체크
		if ( StringUtils.isEmpty(usrGrpVO.getUsrId()) || StringUtils.isEmpty(usrGrpVO.getUsrPw()) ) {
			return "ERROR_INPUT_NULL";
		} else {
			// 회원 존재 유무 확인 조회
			if ( loginMapper.countLoginId(usrGrpVO) > 0 ) {
				// IP확인
				String remoteAddress = request.getRemoteAddr();
				
				// login check
				SessionUser sessionUser = getSessionUser(usrGrpVO);
				
				if (sessionUser != null) { //로그인 성공
					// session create
					HttpSession session = request.getSession(true);
					session.removeAttribute(Consts.SessionAttr.USER);
					session.setAttribute(Consts.SessionAttr.USER, sessionUser);
					LoginManager loginManager = LoginManager.getInstance();
					
					String userId = sessionUser.getUsrId();
					
					// 작동여부 확인
					if (isForce) {
						if (loginManager.isUsing(userId)) {
							loginManager.getUserSession(userId).invalidate();
						}
					} else {
						if (loginManager.isUsing(userId)) {
							return "ALREADY_LOGGED_IN";
						}
					}
					
					loginManager.setSession(session);
					resultMsg = "GO_MAIN";
				} else { //로그인 실패
					resultMsg = "LOGIN_FAIL";
				}
			}else{
				resultMsg = "ID_DOES_NOT_EXIST";
			}
		}
		
		return resultMsg;
	}	
	
	/**
	 * 로그인 검증 및 세션 정보 생성 2
	 * @param UsrGrpVO
	 * @return SessionUser
	 */
	private SessionUser getSessionUser(UsrGrpVO usrGrpVO) {
		SessionUser sessionUser = loginMapper.login(usrGrpVO);
		return sessionUser;
	}


	/**
	 * 회원가입
	 * @param UsrGrpVO
	 * @return int
	 */
	public int insertUsr(UsrGrpVO usrGrpVO) { 
		return loginMapper.insertUsr(usrGrpVO); 
	}
	
	/**
	 * SHA-256 방식 암호화
	 * @param UsrGrpVO
	 * @return int
	 * @throws NoSuchAlgorithmException 
	 */
	public String getEncryptResult(String encryptStr) throws NoSuchAlgorithmException {
        // Base64 인코딩된 암호화 문자열
        String encrypted = SHA256Util.getEncrypt(encryptStr);
        System.out.println("암호화 : " + encrypted);
        
        // SHA256Util의 암호화 메소드 수행 중 오류 발생 시 오류 throw
        if ( StringUtil.isEmpty(encrypted) ) {
        	throw new NoSuchAlgorithmException();
        }
        
        return encrypted;
	}
	
}
