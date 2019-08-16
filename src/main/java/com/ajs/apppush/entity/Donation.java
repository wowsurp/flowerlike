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

import lombok.Data;

@Data
@Entity
@Table(name="tb_donation")
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
	@JoinColumn(name="fromId", referencedColumnName = "userId", insertable = false, updatable = false)
	private User userFromId;
	
	@ManyToOne
	@JoinColumn(name="toId", referencedColumnName = "userId", insertable = false, updatable = false)
	private User userToId;
	
}
