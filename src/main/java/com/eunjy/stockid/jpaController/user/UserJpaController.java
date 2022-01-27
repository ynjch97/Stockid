package com.eunjy.stockid.jpaController.user;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eunjy.stockid.domain.common.SessionUser;
import com.eunjy.stockid.domain.user.UsrGrpVO;
import com.eunjy.stockid.jpaDomain.user.UsrJpaSpec;
import com.eunjy.stockid.jpaDomain.user.UsrJpaSpec.SearchKey;
import com.eunjy.stockid.jpaDomain.user.UsrJpaVO;
import com.eunjy.stockid.jpaRepository.user.UserRepository;
import com.eunjy.stockid.jpaService.user.UserJpaService;
import com.eunjy.stockid.utiliy.Consts;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value = "/user")
public class UserJpaController {

	@Autowired
	UserJpaService userJpaService; 

	@Autowired
	UserRepository userRepository; 

	@RequestMapping(value = "/userInfo2.do", method = {RequestMethod.POST, RequestMethod.GET}) 
	public String userInfo2(Model model, UsrGrpVO usrGrpVO, HttpSession httpSession) { 
		SessionUser sessionUser = (SessionUser) httpSession.getAttribute(Consts.SessionAttr.USER);
		String usrId = "";
		if (sessionUser != null) usrId = sessionUser.getUsrId();
		
		ObjectMapper obj = new ObjectMapper(); 
		UsrJpaVO userInfo = userJpaService.findByUsrId(usrId);
		
		try {
			model.addAttribute("userInfo", obj.writeValueAsString(userInfo));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		return "user/userInfo"; 
	}

	@RequestMapping(value = "/userInfo3.do", method = {RequestMethod.POST, RequestMethod.GET}) 
	public List<UsrJpaVO> userInfo3(Model model, UsrJpaVO usrJpaVO, HttpSession httpSession) { 
		Map<String, Object> searchRequest = new HashMap<>();
		searchRequest.put("USR_NUM", "9");
		searchRequest.put("USR_ID", "ynjch");
		
		Map<SearchKey, Object> searchKeys = new HashMap<>();
	    for (String key : searchRequest.keySet()) {
	        searchKeys.put(SearchKey.valueOf(key.toUpperCase()), searchRequest.get(key));
	    }
	    
	    return searchKeys.isEmpty()
	            ? userRepository.findAll()
	            : userRepository.findAll(UsrJpaSpec.searchWith(searchKeys));
	}
	
}
