package com.eunjy.stockid.service.post;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eunjy.stockid.domain.post.PostMainVO;
import com.eunjy.stockid.mapper.post.PostMapper;

@Service
public class PostService {

	@Autowired
	private PostMapper postMapper;
	
	public List<PostMainVO> getPostList(PostMainVO postMainVO) { 
		return postMapper.getPostList(postMainVO); 
	}
	
}
