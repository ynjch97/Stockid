package com.eunjy.stockid.domain.post;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

public class PostSpec {

	// 검색 조건 정의 
	public enum SearchKey {
		GRP_NUM("grpNum"),
		CTGRY_NUM("ctgryNum"),
		USE_YN("useYn"),
		DEL_YN("delYn");

		private final String value;
		
		SearchKey(String value) {
			this.value = value;
		}
		
		private String getValue() {
			return value;
		}
	}
	
	// Specification 정의
	public static Specification<PostVO> searchWith(Map<SearchKey, Object> searchKeyword) {
		return (Specification<PostVO>) ((root, query, builder) -> {
			List<Predicate> predicate = getPredicateWithKeyword(searchKeyword, root, builder);
			return builder.and(predicate.toArray(new Predicate[0]));
		});
	}
	
	private static List<Predicate> getPredicateWithKeyword(Map<SearchKey, Object> searchKeyword
			, Root<PostVO> root, CriteriaBuilder builder) {
		List<Predicate> predicate = new ArrayList<>();
		for (SearchKey key : searchKeyword.keySet()) {
			switch (key) {
				case GRP_NUM:	// int 자료형
					predicate.add(builder.equal(
						root.get(key.value), Integer.parseInt(searchKeyword.get(key).toString())
					));
				case CTGRY_NUM:	// int 자료형
					predicate.add(builder.equal(
						root.get(key.value), Integer.parseInt(searchKeyword.get(key).toString())
					));
				default:		// string
					predicate.add(builder.equal(
						root.get(key.value), searchKeyword.get(key)
					));
			}
		}
		return predicate;
	}
	
}