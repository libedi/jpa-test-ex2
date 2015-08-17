package com.libedi.test;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="MEMBER",
		uniqueConstraints = {
			@UniqueConstraint(		// 유니크 제약조건 추가
				name = "NAME_AGE_UNIQUE",
				columnNames = {"NAME", "AGE"}
			)
})
public class Member {
	
	@Id
	@Column(name="ID")
	private String id;
	
//	/*
//	 * 제약조건 추가 : 회원이름 필수, 10자 미초과
//	 */
//	@Column(name="NAME", nullable = false, length = 10)		// 추가
//	private String username;
	
	@Column(name="NAME")
	private String username;
	
	private Integer age;
	
	/*
	 * 회원관리 프로그램에 요구사항이 추가됨
	 * 
	 * 1. 회원은 일반 회원과 관리자로 구분해야 한다.
	 * 2. 회원 가입일과 수정일이 있어야 한다.
	 * 3. 회원을 설명할 수 있는 필드가 있어야 한다. 이 필드는 길이 제한이 없다.
	 */
	//== 추가 ==
	@Enumerated(EnumType.STRING)
	private RoleType roleType;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastModifiedDate;
	
	@Lob
	private String description;
	
	// Getter, Setter
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public RoleType getRoleType() {
		return roleType;
	}
	public void setRoleType(RoleType roleType) {
		this.roleType = roleType;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}
	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
