package com.eunjy.stockid.controller.login;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eunjy.stockid.domain.UsrGrpVO;
import com.eunjy.stockid.service.login.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	LoginService loginService; 

	@RequestMapping(value = "/", method = RequestMethod.GET) 
	public String home(Model model) { 
		System.out.println("home controller start"); 
		return "login/login"; 
	}
	
}
