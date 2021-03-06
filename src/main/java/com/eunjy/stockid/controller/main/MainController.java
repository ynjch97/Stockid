package com.eunjy.stockid.controller.main;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;


/**
 * @author YunJi
 * 메인 화면
 */
@Slf4j
@Controller
@RequestMapping(value = "{grpUrl}")
public class MainController {

	@RequestMapping(value = "/main.do", method = {RequestMethod.POST, RequestMethod.GET}) 
	public String mainPage(@PathVariable("grpUrl") String grpUrl, Model model) {
		log.debug("{} 의 메인 화면", grpUrl);
		return "main/mainPage"; 
	}
	
}
