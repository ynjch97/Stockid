package com.eunjy.stockid.controller.login;

import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eunjy.stockid.domain.common.ResultVo;
import com.eunjy.stockid.domain.common.ResultVo.ResultStatus;
import com.eunjy.stockid.domain.user.UsrGrpVO;
import com.eunjy.stockid.service.login.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	LoginService loginService; 

	@RequestMapping(value = {"/", "/login/login.do"}, method = RequestMethod.GET) 
	public String login(Model model) { 
		return "login/login"; 
	}
	
	@RequestMapping(value = "/login/loginProcess.do", method = RequestMethod.POST) 
	public @ResponseBody ResultVo loginProcess(Model model, UsrGrpVO usrGrpVO
			, @RequestParam(required = false) String loginId, @RequestParam(required = false) String loginPw
			, @RequestParam(required = false) String isForce
			, HttpServletRequest request) throws Exception { 
		
		System.out.println("loginProcess start"); 
		boolean isForceVal = Boolean.parseBoolean(isForce);
		usrGrpVO.setUsrId(loginId);
		usrGrpVO.setUsrPw(loginPw);
		String resultMsg = loginService.login(usrGrpVO, isForceVal, request);
		ResultVo resultVo = new ResultVo(ResultStatus.SUCCESS, resultMsg);
		System.out.println("loginProcess resultMsg : " + resultMsg); 
		
		return resultVo;
		
	}

	@RequestMapping(value = "/login/join.do", method = {RequestMethod.POST, RequestMethod.GET}) 
	public String join(Model model) { 
		System.out.println("home controller start"); 
		return "login/join"; 
	}
	
	@RequestMapping(value = "/login/joinUsr.do", method = RequestMethod.POST) 
	public @ResponseBody ResultVo getUserList(Model model, UsrGrpVO usrGrpVO) { 
		int result = 0;
		
		try {
			usrGrpVO.setUsrPw( loginService.getEncryptResult(usrGrpVO.getUsrPw()) );
			result = loginService.insertUsr(usrGrpVO);
		} catch (NoSuchAlgorithmException e) {
			
		}
				
		if (result == 1) {
			return new ResultVo(ResultStatus.SUCCESS, "회원가입이 성공적으로 완료되었습니다.");
		} else {
			return new ResultVo(ResultStatus.FAIL, "회원가입에 실패하였습니다.");
		}
	}
	
}
