package com.ajs.apppush.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="tb_user")
public class User {

	@Id
	@Column(length = 100)
	private String userId;
	
	@Column(length = 20)
	private String nickNm;
	
	@Column(length = 100, unique = true)
	private String email;
	
	@Column(length = 200)
	private String token;
	
	@Column(length = 200)
	private String profile;
	
	@Column(length = 20)
	private String grade;

	@Column(columnDefinition = "char(1)")
	private String type;
	
	private long point;
	
	@Column(columnDefinition = "char(1)")
	private String status;
	
	private LocalDateTime regDtm;

	@Transient
	@OneToMany
	@JoinColumn(name = "userId", referencedColumnName = "userId")
	private List<Order> orderList;
	
	@Transient
	@OneToMany(targetEntity = Donation.class)
	@JoinColumn(referencedColumnName = "userId")
	private List<Donation> donationList;
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getNickNm() {
		return nickNm;
	}

	public void setNickNm(String nickNm) {
		this.nickNm = nickNm;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public long getPoint() {
		return point;
	}

	public void setPoint(long point) {
		this.point = point;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getRegDtm() {
		return regDtm;
	}

	public void setRegDtm(LocalDateTime regDtm) {
		this.regDtm = regDtm;
	}
	
	public List<Order> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}
	
	public List<Donation> getDonationList() {
		return donationList;
	}

	public void setDonationList(List<Donation> donationList) {
		this.donationList = donationList;
	}
}
