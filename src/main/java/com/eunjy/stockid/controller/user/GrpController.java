package com.eunjy.stockid.controller.user;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eunjy.stockid.domain.common.SessionUser;
import com.eunjy.stockid.domain.user.UsrGrpVO;
import com.eunjy.stockid.service.user.GrpService;
import com.eunjy.stockid.utiliy.Consts;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping(value = "/grp")
public class GrpController {
	
	@Autowired
	GrpService grpService; 

	@RequestMapping(value = "/grpList.do", method = {RequestMethod.POST, RequestMethod.GET}) 
	public String grpList(Model model, UsrGrpVO usrGrpVO, HttpSession httpSession) { 
		SessionUser sessionUser = (SessionUser) httpSession.getAttribute(Consts.SessionAttr.USER);
		if (sessionUser != null) usrGrpVO.setUsrNum( sessionUser.getUsrNum() );
		
		ObjectMapper obj = new ObjectMapper(); 
		List<UsrGrpVO> myGrpList = grpService.getMyGrpList(usrGrpVO);
		try {
			model.addAttribute("myGrpList", obj.writeValueAsString(myGrpList));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return "grp/grpList"; 
	}
	
	@RequestMapping(value = "/addGrp.do", method = {RequestMethod.POST, RequestMethod.GET}) 
	public String addGrp(Model model, UsrGrpVO usrGrpVO, HttpSession httpSession) { 
		SessionUser sessionUser = (SessionUser) httpSession.getAttribute(Consts.SessionAttr.USER);
		if (sessionUser != null) usrGrpVO.setUsrNum( sessionUser.getUsrNum() );
		
		List<UsrGrpVO> myGrpList = grpService.getMyGrpList(usrGrpVO);
		int myGrpCnt = 0;
		if (myGrpList.size() != 0) {
			myGrpCnt = myGrpList.get(0).getTotalCnt();
		}
		
		model.addAttribute("myGrpCnt", myGrpCnt);
		
		return "grp/addGrp"; 
	}

}
