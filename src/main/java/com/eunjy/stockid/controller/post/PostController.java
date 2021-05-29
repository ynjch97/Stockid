package com.eunjy.stockid.controller.post;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * @author YunJi
 * 카테고리 별 포스트
 */
@Controller
@RequestMapping(value = "{grpUrl}")
public class PostController {

	@RequestMapping(value = "/list.do", method = RequestMethod.POST) 
	public String postList(@PathVariable("grpUrl") String grpUrl, Model model) {
		System.out.println("grpUrl : " + grpUrl);
		
		return "post/postList"; 
	}
	
	@RequestMapping(value = "/write.do", method = RequestMethod.GET) 
	public String postWrite(@PathVariable("grpUrl") String grpUrl, Model model) { 
		System.out.println("grpUrl : " + grpUrl);
		
		return "post/postWrite"; 
	}

}
