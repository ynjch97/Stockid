package com.eunjy.stockid.controller.etc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * @author YunJi
 * 부가 기능
 */
@Controller
public class EtcController {
	
	@RequestMapping(value = "/etc/calculator.do", method = RequestMethod.GET) 
	public String calculator(Model model) { 
		return "etc/calculator"; 
	}

}
