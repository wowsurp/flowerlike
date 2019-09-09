package com.ajs.apppush.entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;

@Data
@Entity
@Table(name="tb_employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idx;
	
	private int enterpriseIdx;
	
	@Column(length = 100)
	private String userId;
	
	@Column(length = 20)
	private String nickNm;
	
	@Column(length = 500)
	private String introduction;
	
	@Column(length = 300)
	private String workingHours;
	
	@Column(columnDefinition = "char(1)")
	private String delYn = "N";
	
	@Column(columnDefinition = "char(1)")
	private String requestAgreeYn;
	
	@Column(columnDefinition="char(19)")
	private String regDtm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	
	@ManyToOne
	@JoinColumn(name = "enterpriseIdx", referencedColumnName = "idx", insertable = false, updatable = false)
	private Enterprise enterprise;
	
	@Transient
	@OneToOne(targetEntity = Photo.class)
	@JoinColumn(name = "employeeIdx", referencedColumnName = "idx")
	private List<Photo> photoList;

	@ManyToOne
	@JoinColumn(name = "userId", referencedColumnName = "userId", insertable = false, updatable = false)
	private User user;

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public int getEnterpriseIdx() {
		return enterpriseIdx;
	}

	public void setEnterpriseIdx(int enterpriseIdx) {
		this.enterpriseIdx = enterpriseIdx;
	}

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

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getWorkingHours() {
		return workingHours;
	}

	public void setWorkingHours(String workingHours) {
		this.workingHours = workingHours;
	}

	public String getDelYn() {
		return delYn;
	}

	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}

	public String getRequestAgreeYn() {
		return requestAgreeYn;
	}

	public void setRequestAgreeYn(String requestAgreeYn) {
		this.requestAgreeYn = requestAgreeYn;
	}

	public String getRegDtm() {
		return regDtm;
	}

	public void setRegDtm(String regDtm) {
		this.regDtm = regDtm;
	}

	public Enterprise getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}

	public List<Photo> getPhotoList() {
		return photoList;
	}

	public void setPhotoList(List<Photo> photoList) {
		this.photoList = photoList;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}
