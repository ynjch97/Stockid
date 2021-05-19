package com.eunjy.stockid.controller.post;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * @author YunJi
 * 카테고리 별 포스트
 */
@Controller
public class PostController {

	@RequestMapping(value = "/post/list.do", method = RequestMethod.GET) 
	public String postList(Model model) { 
		return "post/postList"; 
	}
	
	@RequestMapping(value = "/post/write.do", method = RequestMethod.GET) 
	public String postWrite(Model model) { 
		return "post/postWrite"; 
	}

}
