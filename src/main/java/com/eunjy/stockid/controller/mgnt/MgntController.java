package com.eunjy.stockid.controller.mgnt;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eunjy.stockid.domain.user.UsrGrpVO;
import com.eunjy.stockid.service.user.GrpService;
import com.eunjy.stockid.service.user.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MgntController {

	@Autowired
	UserService userService; 
	
	@Autowired
	GrpService grpService; 
	
	@RequestMapping(value = "/mgnt/userList.do", method = RequestMethod.GET) 
	public String userList(Model model) { 
		return "mgnt/userList"; 
	}

	@RequestMapping(value = "/welcome.do", method = RequestMethod.GET) 
	public String thymeLeafTest(Model model) { 
		model.addAttribute("name", "hi");
		return "thymeleaf/welcome"; 
	}
	
	@RequestMapping(value = "/mgnt/getUserList.do", method = RequestMethod.GET) 
	public @ResponseBody List<UsrGrpVO> getUserList(Model model) { 
		log.debug("mgnt/getUserList (수정 0304)"); 
		List<UsrGrpVO> userList = grpService.getMyGrpList(new UsrGrpVO());
		log.debug("userList size >>> " + userList.size()); 
		
		if (userList.size() > 0) {
			for (int i=0; i<userList.size(); i++) {
				log.debug(userList.get(i).toString());
			}
		}
		return userList;
	}
	
}
