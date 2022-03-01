package com.eunjy.stockid.mapper.post;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.eunjy.stockid.domain.post.PostVO;

@Mapper
public interface PostMapper {
	
	public List<PostVO> getPostList(PostVO postVO);

}
