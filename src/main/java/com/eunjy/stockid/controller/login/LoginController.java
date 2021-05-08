package com.eunjy.stockid.controller.login;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eunjy.stockid.domain.common.CommonResultVo;
import com.eunjy.stockid.domain.common.CommonResultVo.ResultStatus;
import com.eunjy.stockid.domain.user.UsrGrpVO;
import com.eunjy.stockid.service.login.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	LoginService loginService; 

	@RequestMapping(value = "/", method = RequestMethod.GET) 
	public String login(Model model) { 
		System.out.println("home controller start"); 
		return "login/login"; 
	}
	
	@RequestMapping(value = "/login/loginProcess.do", method = RequestMethod.POST) 
	public String loginProcess(Model model) { 
		System.out.println("home controller start"); 
		return "login/loginProcess"; 
	}

	@RequestMapping(value = "/login/join.do", method = RequestMethod.GET) 
	public String join(Model model) { 
		System.out.println("home controller start"); 
		return "login/join"; 
	}
	
	@RequestMapping(value = "/login/joinUsr.do", method = RequestMethod.POST) 
	public @ResponseBody CommonResultVo getUserList(Model model) { 
		
		
		CommonResultVo rsltVo = new CommonResultVo(ResultStatus.FAIL);
		return rsltVo;
	}
	
}
