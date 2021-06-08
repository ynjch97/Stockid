package com.eunjy.stockid.controller.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * @author YunJi
 * 메인 화면
 */
@Controller
@RequestMapping(value = "{grpUrl}")
public class MainController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping(value = "/main.do", method = {RequestMethod.POST, RequestMethod.GET}) 
	public String mainPage(@PathVariable("grpUrl") String grpUrl, Model model) {
		logger.debug("{} 의 메인 화면", grpUrl);
		
		return "main/mainPage"; 
	}
	
}
