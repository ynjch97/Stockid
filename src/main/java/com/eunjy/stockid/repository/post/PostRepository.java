package com.eunjy.stockid.repository.post;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.eunjy.stockid.domain.post.PostVO;

@Repository
public interface PostRepository extends JpaRepository<PostVO, Long>, JpaSpecificationExecutor<PostVO> {

	public List<PostVO> findByUseYn(String useYn);
	
	// 포스트 조회
	public List<PostVO> findAll(Specification<PostVO> spec);

}
