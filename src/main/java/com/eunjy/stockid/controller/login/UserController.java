package com.eunjy.stockid.controller.login;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eunjy.stockid.domain.UsrGrpVO;
import com.eunjy.stockid.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService userService; 

	@RequestMapping(value = "/", method = RequestMethod.GET) 
	public String home(Model model) { 
		System.out.println("home controller start"); 
		return "login/login"; 
	}
	
	@RequestMapping(value = "/login/grpList.do", method = RequestMethod.GET) 
	public String grpList(Model model) { 
		System.out.println("login/grpList"); 
		return "login/grpList"; 
	}

	@RequestMapping(value = "/mgnt/userList.do", method = RequestMethod.GET) 
	public String userList(Model model) { 
		System.out.println("mgnt/userList"); 
		return "mgnt/userList"; 
	}

	@RequestMapping(value = "/welcome.do", method = RequestMethod.GET) 
	public String thymeLeafTest(Model model) { 
		System.out.println("thymeleaf!!"); 
		model.addAttribute("name", "hi");
		return "thymeleaf/welcome"; 
	}
	
	@RequestMapping(value = "/mgnt/getUserList.do", method = RequestMethod.GET) 
	public @ResponseBody List<UsrGrpVO> getUserList(Model model) { 
		System.out.println("mgnt/getUserList (수정 0304)"); 
		List<UsrGrpVO> userList = userService.getUserList();
		System.out.println("userList size >>> " + userList.size()); 
		
		if (userList.size() > 0) {
			for (int i=0; i<userList.size(); i++) {
				System.out.println(userList.get(i).toString());
			}
		}
		return userList;
	}
	
}
