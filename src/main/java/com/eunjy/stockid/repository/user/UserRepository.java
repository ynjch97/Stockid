package com.eunjy.stockid.repository.user;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eunjy.stockid.domain.user.UsrEntity;

@Repository
public interface UserRepository extends JpaRepository<UsrEntity, Long>{

	// findBy 뒤에 컬럼명을 붙여주면 이를 이용한 검색이 가능
	public Optional<UsrEntity> findByUsrId(String usrId); 
	public List<UsrEntity> findByUsrNm(String usrNm);

}
