package com.eunjy.stockid.controller.post;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eunjy.stockid.domain.post.PostVO;
import com.eunjy.stockid.service.post.PostService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;


/**
 * @author YunJi
 * 카테고리 별 포스트
 */
@Slf4j
@Controller
@RequestMapping(value = "{grpUrl}")
public class PostController {
	
	@Autowired
	PostService postService; 
	
	@RequestMapping(value = "/list.do", method = {RequestMethod.POST, RequestMethod.GET}) 
	public String postList(@PathVariable("grpUrl") String grpUrl, PostVO postVO, Model model) {
		log.debug("grpUrl : {}", grpUrl);
		
		ObjectMapper obj = new ObjectMapper(); 
		postVO.setGrpNum(1);
		postVO.setCtgryNum(1); // TODO 하드코딩
		List<PostVO> postList = postService.getPostList(postVO);

		try {
			model.addAttribute("postList", obj.writeValueAsString(postList));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return "post/postList"; 
	}
	
	// JPA 버전
	@RequestMapping("/list2.do") 
	public String postList2(@PathVariable("grpUrl") String grpUrl, PostVO postVO, Model model) {
		log.debug("grpUrl : {}", grpUrl);
		
		ObjectMapper obj = new ObjectMapper(); 
		Map<String, Object> searchRequest = new HashMap<>();

		searchRequest.put("GRP_NUM", "1");
		searchRequest.put("CTGRY_NUM", "1");
		List<PostVO> postList = postService.getPostList(searchRequest);

		try {
			model.addAttribute("postList", obj.writeValueAsString(postList));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return "post/postList"; 
	}
	
	@RequestMapping(value = "/write.do", method = {RequestMethod.POST, RequestMethod.GET}) 
	public String postWrite(@PathVariable("grpUrl") String grpUrl, Model model) { 
		log.debug("grpUrl : {}", grpUrl);
		return "post/postWrite"; 
	}

}
