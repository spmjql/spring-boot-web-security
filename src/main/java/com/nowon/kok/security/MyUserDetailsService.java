package com.nowon.kok.security;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.nowon.kok.domain.entity.MemberEntity;
import com.nowon.kok.domain.entity.MemberEntityRepository;

public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private MemberEntityRepository memRepo;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		//DB접속해서 회원이 존재하는지
		MemberEntity member = memRepo.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("존재하지 않는 유저"));
//		memRepo.aaa(email);
		Set<SimpleGrantedAuthority> grantedAuthority
			=member.getRoles().stream()
				.map(myRole -> new SimpleGrantedAuthority("ROLE_"+myRole.name()))
				.collect(Collectors.toSet());
//		USER -> "ROLE_USER"
//		Collection<? extends GrantedAuthority>
		return new User(email, member.getPass(), grantedAuthority);
	}

}
