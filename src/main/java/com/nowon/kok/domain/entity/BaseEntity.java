package com.nowon.kok.domain.entity;

import java.time.LocalDateTime;

import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;

@Getter
@MappedSuperclass
public abstract class BaseEntity {
	
	@CreationTimestamp
	LocalDateTime createDate;
	@UpdateTimestamp
	LocalDateTime updatedDate;
}
