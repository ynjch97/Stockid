package com.eunjy.stockid.jpaRepository.user;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.eunjy.stockid.jpaDomain.user.UsrJpaVO;

@Repository
public interface UserRepository extends JpaRepository<UsrJpaVO, Long>, JpaSpecificationExecutor<UsrJpaVO> {
	
	// findBy 뒤에 컬럼명을 붙여주면 이를 이용한 검색이 가능
	public Optional<UsrJpaVO> findByUsrId(String usrId); 
	public Optional<UsrJpaVO> findByUsrNum(int usrNum);
	
	// 사용자 조회
	public List<UsrJpaVO> findAll(Specification<UsrJpaVO> spec);

}
