package com.eunjy.stockid.controller.user;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eunjy.stockid.domain.user.UsrGrpVO;
import com.eunjy.stockid.service.user.UserService;
import com.eunjy.stockid.utiliy.Consts;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class UserController {
	
	@Autowired
	UserService userService; 

	@RequestMapping(value = "/user/grpList.do", method = {RequestMethod.POST, RequestMethod.GET}) 
	public String grpList(Model model, UsrGrpVO usrGrpVO, HttpSession httpSession) { 
		usrGrpVO.setUsrNum("2");// test
		ObjectMapper obj = new ObjectMapper(); 
		List<UsrGrpVO> myGrpList = userService.getMyGrpList(usrGrpVO);
		
		try {
			model.addAttribute("myGrpList", obj.writeValueAsString(myGrpList));
			model.addAttribute("sessionTest", httpSession.getAttribute(Consts.SessionAttr.USER));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return "user/grpList"; 
	}

	@RequestMapping(value = "/user/userInfo.do", method = {RequestMethod.POST, RequestMethod.GET}) 
	public String userInfo(Model model) { 
		return "user/userInfo"; 
	}

}
