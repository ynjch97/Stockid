package com.eunjy.stockid.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eunjy.stockid.service.user.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService userService; 

	@RequestMapping(value = "/user/grpList.do", method = RequestMethod.GET) 
	public String grpList(Model model) { 
		System.out.println("user/grpList"); 
		return "user/grpList"; 
	}

}
