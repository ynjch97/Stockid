package com.eunjy.stockid.service.post;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eunjy.stockid.domain.post.PostSpec;
import com.eunjy.stockid.domain.post.PostSpec.SearchKey;
import com.eunjy.stockid.domain.post.PostVO;
import com.eunjy.stockid.mapper.post.PostMapper;
import com.eunjy.stockid.repository.post.PostRepository;

@Service
public class PostService {

	@Autowired
	private PostMapper postMapper;
	
	@Autowired
	private PostRepository postRepository;
	
	// String key 값을 enum key 값으로 변경
	private Map<SearchKey, Object> getSearchKeys(Map<String, Object> searchRequest) {
		Map<SearchKey, Object> searchKeys = new HashMap<>();
		for (String key : searchRequest.keySet()) {
	        searchKeys.put(SearchKey.valueOf(key.toUpperCase()), searchRequest.get(key));
	    }
	    
		return searchKeys;
	}
	
	public List<PostVO> getPostList(PostVO postVO) { 
		return postMapper.getPostList(postVO); 
	}

	// 포스트 목록 조회
	public List<PostVO> getPostList(Map<String, Object> searchRequest) {
		searchRequest.put("USE_YN", "Y");
		searchRequest.put("DEL_YN", "N");
		
		// String key 값을 enum key 값으로 변경
		Map<SearchKey, Object> searchKeys = getSearchKeys(searchRequest);

		List<PostVO> userList = postRepository.findAll(PostSpec.searchWith(searchKeys));
		return userList; 
	}
	
}
