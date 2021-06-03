package com.eunjy.stockid.mapper.post;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.eunjy.stockid.domain.post.PostMainVO;

@Mapper
public interface PostMapper {
	
	public List<PostMainVO> getPostList(PostMainVO PostMainVO);

}
