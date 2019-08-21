package com.ajs.apppush.entity;

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
	private String delYn;
	
	@Column(columnDefinition = "char(1)")
	private String hireRequest;
	
	@Column(columnDefinition = "char(19)")
	private String startDtm;
	
	@Column(columnDefinition = "char(19)")
	private String endDtm;
	
	@ManyToOne
	@JoinColumn(name = "enterpriseIdx", referencedColumnName = "idx", insertable = false, updatable = false)
	private Enterprise enterprise;
	
	@Transient
	@OneToOne(targetEntity = Photo.class)
	@JoinColumn(name = "employeeIdx", referencedColumnName = "idx")
	private List<Photo> photoList;

}
