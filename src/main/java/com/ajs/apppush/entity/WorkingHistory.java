package com.ajs.apppush.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "tb_working_history")
public class WorkingHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idx;

	private int enterpriseIdx;
	
	@Column(length = 50)
	private String enterpriseName;
	
	@Column(columnDefinition = "char(19)")
	private String startDtm;
	
	@Column(columnDefinition = "char(19)")
	private String endDtm;
	
	@Column(length = 100)
	private String employeeId;
	
	@Column(columnDefinition = "char(19)")
	private String regDtm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	
	@ManyToOne
	@JoinColumn(name = "employeeId", referencedColumnName = "userId", insertable = false, updatable = false)
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "enterpriseIdx", referencedColumnName = "idx", insertable = false, updatable = false)
	private Enterprise enterprise;

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

	public String getEnterpriseName() {
		return enterpriseName;
	}

	public void setEnterpriseName(String enterpriseName) {
		this.enterpriseName = enterpriseName;
	}

	public String getStartDtm() {
		return startDtm;
	}

	public void setStartDtm(String startDtm) {
		this.startDtm = startDtm;
	}

	public String getEndDtm() {
		return endDtm;
	}

	public void setEndDtm(String endDtm) {
		this.endDtm = endDtm;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getRegDtm() {
		return regDtm;
	}

	public void setRegDtm(String regDtm) {
		this.regDtm = regDtm;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Enterprise getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}
	
	
}
