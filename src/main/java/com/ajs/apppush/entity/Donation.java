package com.ajs.apppush.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

//@Entity
//@Table(name="tb_donation")
public class Donation {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idx;
	
	@Column(length = 100)
	private String fromId;
	
	@Column(length = 100)
	private String toId;
	
	private int price;

	@Column(length = 20)
	private String status;
	
	private LocalDateTime regDtm;

	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="fromId", referencedColumnName = "userId", insertable = false, updatable = false),
		@JoinColumn(name="toId", referencedColumnName = "userId", insertable = false, updatable = false)
	})
	private User user;
	
	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}
	
	public String getFromId() {
		return fromId;
	}

	public void setFromId(String fromId) {
		this.fromId = fromId;
	}

	public String getToId() {
		return toId;
	}

	public void setToId(String toId) {
		this.toId = toId;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
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

}
