package com.ajs.apppush.entity;

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
	private String regDtm;
	
	@ManyToOne
	@JoinColumn(name = "employeeId", referencedColumnName = "userId", insertable = false, updatable = false)
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "enterpriseIdx", referencedColumnName = "idx", insertable = false, updatable = false)
	private Enterprise enterprise;
}
