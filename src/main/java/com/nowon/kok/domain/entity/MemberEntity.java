package com.nowon.kok.domain.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.nowon.kok.security.MyRole;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@SequenceGenerator(name = "genSeqMem",
			sequenceName = "seqMem", initialValue = 1, allocationSize = 1)
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table (name = "myMember")
@Entity
public class MemberEntity extends BaseEntity{

	@Id
	@GeneratedValue(generator = "genSeqMem", strategy = GenerationType.SEQUENCE)
	private long no;
	@Column(nullable = false, unique = true)
	private String email;
	@Column(nullable = false)
	private String pass;//암호화해서 저장
	@Column(nullable = false)
	private String name;
	
	//role
	@Builder.Default
	//@Enumerated 선언하지 않으면 ordinal(숫자)로 저장됨
	@Enumerated(EnumType.STRING)//DB에 저장유형을 문자로 저장
	@CollectionTable(name = "role")
	@ElementCollection(fetch = FetchType.EAGER)//1:n MemberEntity에서만 접근가능한 내장테이블
	private Set<MyRole> roles = new HashSet<>();
	//편의메서드
	public MemberEntity addRole(MyRole role) {
		roles.add(role);
		return this;
	}
	
}
