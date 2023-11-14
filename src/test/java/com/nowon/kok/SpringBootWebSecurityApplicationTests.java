package com.nowon.kok;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.nowon.kok.domain.entity.MemberEntity;
import com.nowon.kok.domain.entity.MemberEntityRepository;
import com.nowon.kok.security.MyRole;

@SpringBootTest
class SpringBootWebSecurityApplicationTests {

	@Autowired
	MemberEntityRepository memRepo;
	@Autowired
	PasswordEncoder pe;
	
	@Test
	void 관리자가입테스트() {
		
		memRepo.save(MemberEntity.builder()
				.email("test1117@test.com")
				.pass(pe.encode("1234"))
				.name("관리자01")
				.build()
				.addRole(MyRole.USER)
				.addRole(MyRole.ADMIN)
				//.addRole(MyRole.MANAGER)
				);
	}

}
