package com.eunjy.stockid.jpaDomain.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

public class UsrJpaSpec {

	// 검색 조건 정의 
	public enum SearchKey {
		USR_NUM("usrNum"),
		USR_ID("usrId"),
		USR_NM("usrNm");

		private final String value;
		
		SearchKey(String value) {
			this.value = value;
		}
		
		private String getValue() {
			return value;
		}
	}
	
	// Specification 정의
	public static Specification<UsrJpaVO> searchWith(Map<SearchKey, Object> searchKeyword) {
		return (Specification<UsrJpaVO>) ((root, query, builder) -> {
			List<Predicate> predicate = getPredicateWithKeyword(searchKeyword, root, builder);
			return builder.and(predicate.toArray(new Predicate[0]));
		});
	}
	
	private static List<Predicate> getPredicateWithKeyword(Map<SearchKey, Object> searchKeyword
			, Root<UsrJpaVO> root, CriteriaBuilder builder) {
		List<Predicate> predicate = new ArrayList<>();
		for (SearchKey key : searchKeyword.keySet()) {
			switch (key) {
				case USR_NUM:
					predicate.add(builder.equal(
						root.get(key.value), Integer.valueOf(searchKeyword.get(key).toString())
					));
				case USR_ID:
					predicate.add(builder.equal(
						root.get(key.value), searchKeyword.get(key)
					));
			}
		}
		return predicate;
	}
	
}