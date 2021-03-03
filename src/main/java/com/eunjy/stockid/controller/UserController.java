package com.eunjy.stockid.controller;

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

	@RequestMapping(value = "/mgnt/userList", method = RequestMethod.GET) 
	public String userList(Model model) { 
		System.out.println("mgnt/userList"); 
		return "mgnt/userList"; 
	}
	
	@RequestMapping(value = "/mgnt/getUserList", method = RequestMethod.GET) 
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
