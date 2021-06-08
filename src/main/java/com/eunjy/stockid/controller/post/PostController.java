package com.eunjy.stockid.controller.post;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eunjy.stockid.domain.post.PostMainVO;
import com.eunjy.stockid.service.post.PostService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * @author YunJi
 * 카테고리 별 포스트
 */
@Controller
@RequestMapping(value = "{grpUrl}")
public class PostController {

	private static final Logger logger = LoggerFactory.getLogger(PostController.class);
	
	@Autowired
	PostService postService; 
	
	@RequestMapping(value = "/list.do", method = {RequestMethod.POST, RequestMethod.GET}) 
	public String postList(@PathVariable("grpUrl") String grpUrl, PostMainVO postMainVO, Model model) {
		logger.debug("grpUrl : {}", grpUrl);
		
		ObjectMapper obj = new ObjectMapper(); 
		postMainVO.setGrpUrl(grpUrl);
		postMainVO.setCtgryNum("1"); // TODO 하드코딩
		List<PostMainVO> postList = postService.getPostList(postMainVO);

		try {
			model.addAttribute("postList", obj.writeValueAsString(postList));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return "post/postList"; 
	}
	
	@RequestMapping(value = "/write.do", method = RequestMethod.GET) 
	public String postWrite(@PathVariable("grpUrl") String grpUrl, Model model) { 
		logger.debug("grpUrl : {}", grpUrl);
		return "post/postWrite"; 
	}

}
