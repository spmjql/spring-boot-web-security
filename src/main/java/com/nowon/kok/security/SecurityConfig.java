package com.nowon.kok.security;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(13);
	}
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests(authorize->
				authorize
					.antMatchers("/css/**","/img/**","/js/**").permitAll() // static 자원들 인증없이 접근가능
					.antMatchers("/","/signup").permitAll()//인증없이 접근가능
					//.antMatchers("/mail").hasAnyRole("USER")
					//.antMatchers("/admin/**").hasAnyRole("ADMIN")
					.anyRequest().authenticated()//나머지는 인증(로그인)해야해요
					)
			//.formLogin(Customizer.withDefaults())
			.formLogin(formLogin->formLogin
					.loginPage("/signin")//get
					.loginProcessingUrl("/signin")//post
					.usernameParameter("email")//default:username--form
					.passwordParameter("pass")
					.permitAll()
					)
				;

		return http.build();
	}
}
