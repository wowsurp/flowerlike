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
@Table(name = "tb_contents")
public class Contents {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idx;
	
	private int enterpriseIdx;
	
	@Column(length = 100)
	private String title;
	
	@Column(columnDefinition = "text")
	private String contents;
	
	@Column(length = 100)
	private String userId;
	
	private int priority;
	
	@Column(columnDefinition="char(19)")
	private String regDtm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	
	@ManyToOne
	@JoinColumn(name = "userId", referencedColumnName = "userId", insertable = false, updatable = false)
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "enterpriseIdx", referencedColumnName = "idx", insertable = false, updatable = false)
	private Enterprise enterprise;
}
