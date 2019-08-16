package com.ajs.apppush.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="tb_order")
public class Order {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idx;
	
	@Column(length = 100)
	private String userId;
	
	private int price;
	
	@Column(length = 50)
	private String device;
	
	@Column(length = 100)
	private String iniKey;
	
	private LocalDateTime regDtm;
	
	private LocalDateTime approvalDtm;
	
	@Column(length = 20)
	private String status;

	@Transient
	@ManyToOne
	@JoinColumn
	private User user;
	
	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	public String getIniKey() {
		return iniKey;
	}

	public void setIniKey(String iniKey) {
		this.iniKey = iniKey;
	}

	public LocalDateTime getRegDtm() {
		return regDtm;
	}

	public void setRegDtm(LocalDateTime regDtm) {
		this.regDtm = regDtm;
	}

	public LocalDateTime getApprovalDtm() {
		return approvalDtm;
	}

	public void setApprovalDtm(LocalDateTime approvalDtm) {
		this.approvalDtm = approvalDtm;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
