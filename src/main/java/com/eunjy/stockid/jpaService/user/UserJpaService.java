package com.eunjy.stockid.jpaService.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.eunjy.stockid.jpaDomain.user.UsrJpaSpec;
import com.eunjy.stockid.jpaDomain.user.UsrJpaSpec.SearchKey;
import com.eunjy.stockid.jpaDomain.user.UsrJpaVO;
import com.eunjy.stockid.jpaRepository.user.UserRepository;

@Service
public class UserJpaService {

	@Autowired
	private UserRepository userRepository;

	// String key 값을 enum key 값으로 변경
	private Map<SearchKey, Object> getSearchKeys(Map<String, Object> searchRequest) {
		Map<SearchKey, Object> searchKeys = new HashMap<>();
		for (String key : searchRequest.keySet()) {
	        searchKeys.put(SearchKey.valueOf(key.toUpperCase()), searchRequest.get(key));
	    }
	    
		return searchKeys;
	}
	
	// usrId를 이용한 사용자 조회
	public UsrJpaVO findByUsrId(String usrId) {
		UsrJpaVO USR_ENTITY = new UsrJpaVO();
		Optional<UsrJpaVO> userInfo = userRepository.findByUsrId(usrId);
		return userInfo.orElse(USR_ENTITY); 
	}
	
	// usrNum를 이용한 사용자 조회
	public UsrJpaVO findByUsrNum(int usrNum) {
		UsrJpaVO USR_ENTITY = new UsrJpaVO();
		Optional<UsrJpaVO> userInfo = userRepository.findByUsrNum(usrNum);
		return userInfo.orElse(USR_ENTITY); 
	}
	
	// 사용자 정보 조회
	public UsrJpaVO getUserInfo(Map<String, Object> searchRequest) {
		// String key 값을 enum key 값으로 변경
		Map<SearchKey, Object> searchKeys = getSearchKeys(searchRequest);
	    
		List<UsrJpaVO> userList = userRepository.findAll(UsrJpaSpec.searchWith(searchKeys));
		UsrJpaVO usrInfo = null;
		if (userList.size() > 0) usrInfo = userList.get(0);
		return usrInfo; 
	}
	
	// 사용자 목록 조회
	public List<UsrJpaVO> getUserList(Map<String, Object> searchRequest) {
		// String key 값을 enum key 값으로 변경
		Map<SearchKey, Object> searchKeys = getSearchKeys(searchRequest);
	    
		List<UsrJpaVO> userList = userRepository.findAll(UsrJpaSpec.searchWith(searchKeys));
		return userList; 
	}
	
}
