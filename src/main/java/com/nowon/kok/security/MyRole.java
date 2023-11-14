package com.nowon.kok.security;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MyRole {
	USER("일반유저"),
	MANAGER("매니저"),
	ADMIN("관리자");
	
	private final String roleName;
}
