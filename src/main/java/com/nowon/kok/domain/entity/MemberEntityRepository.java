package com.nowon.kok.domain.entity;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MemberEntityRepository extends JpaRepository<MemberEntity, Long>{

	Optional<MemberEntity> findByEmail(String email);

	/*
	@Query("select m.* from MemberEntity m where m.email=:email")
	Optional<MemberEntity> aaa(@Param(value = "email") String email);
	*/

}
