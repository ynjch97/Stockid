package com.eunjy.stockid.controller.user;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eunjy.stockid.domain.common.ResultVo;
import com.eunjy.stockid.domain.common.SessionUser;
import com.eunjy.stockid.domain.common.ResultVo.ResultStatus;
import com.eunjy.stockid.domain.user.UsrGrpVO;
import com.eunjy.stockid.service.user.UserService;
import com.eunjy.stockid.service.login.LoginService;
import com.eunjy.stockid.utiliy.Consts;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value = "/user")
public class UserController {
	
	@Autowired
	UserService userService; 
	@Autowired
	LoginService loginService;

	@RequestMapping(value = "/userInfo.do", method = {RequestMethod.POST, RequestMethod.GET}) 
	public String userInfo(Model model, UsrGrpVO usrGrpVO, HttpSession httpSession) { 
		SessionUser sessionUser = (SessionUser) httpSession.getAttribute(Consts.SessionAttr.USER);
		if (sessionUser != null) usrGrpVO.setUsrNum( sessionUser.getUsrNum() );
		
		ObjectMapper obj = new ObjectMapper(); 
		UsrGrpVO userInfo = userService.getUserInfo(usrGrpVO);
		try {
			model.addAttribute("userInfo", obj.writeValueAsString(userInfo));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		return "user/userInfo"; 
	}
	
	@RequestMapping(value = "/user/changeUserInfo.do", method = RequestMethod.POST) 
	public @ResponseBody ResultVo changeUserInfo(Model model, UsrGrpVO usrGrpVO) { 
		int result = 0;
		
		try {	
			usrGrpVO.setUsrPw(loginService.getEncryptResult(usrGrpVO.getUsrPw()));
			result = loginService.updateUsr(usrGrpVO); 
		} catch (Exception ex) {
			log.error("Error : {}", ex);
		}
				
		if (result == 1) {
			return new ResultVo(ResultStatus.SUCCESS, "회원정보가 성공적으로 수정되었습니다.");
		} else {
			return new ResultVo(ResultStatus.FAIL, "오류가 발생했습니다.");
		}
	}

}
