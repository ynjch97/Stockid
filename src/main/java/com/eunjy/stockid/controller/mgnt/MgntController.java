package com.eunjy.stockid.controller.mgnt;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eunjy.stockid.domain.user.UsrGrpVO;
import com.eunjy.stockid.service.user.UserService;

@Controller
public class MgntController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	UserService userService; 
	
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
		logger.debug("mgnt/getUserList (수정 0304)"); 
		List<UsrGrpVO> userList = userService.getMyGrpList(new UsrGrpVO());
		logger.debug("userList size >>> " + userList.size()); 
		
		if (userList.size() > 0) {
			for (int i=0; i<userList.size(); i++) {
				logger.debug(userList.get(i).toString());
			}
		}
		return userList;
	}
	
}
