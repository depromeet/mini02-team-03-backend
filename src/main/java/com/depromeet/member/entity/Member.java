package com.depromeet.member.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.SpringSecurityCoreVersion;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class Member implements UserDetails {
	
	private static final long serialVersionUID = 
			SpringSecurityCoreVersion.SERIAL_VERSION_UID;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "member_id", nullable = false)
	private Long memberId;
	
	@Column(name = "phone", length = 15, nullable = false, unique = true)
	private String phone;
	
	@Column(name = "password", length = 30)
	private String password;
	
	@Column(name = "name", length = 5, nullable = false)
	private String name;
	
	@Column(name = "joined_study_id")
	private Long joinedStudyId;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public String getUsername() {
		return phone;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Long getJoinedStudyId() {
		return joinedStudyId;
	}
	
	public void setJoinedStudyId(Long joinedStudyId) {
		this.joinedStudyId = joinedStudyId;
	}
}
