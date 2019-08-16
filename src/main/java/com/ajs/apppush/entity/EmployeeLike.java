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
@Table(name="tb_employee_like")
public class EmployeeLike {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idx;
	
	@Column(length = 100)
	private String employeeUserId;
	
	@Column(length = 100)
	private String userId;
	
	@ManyToOne
	@JoinColumn(name="userId", referencedColumnName = "userId", insertable = false, updatable = false)
	private User userUserId;
	
	@ManyToOne
	@JoinColumn(name="employeeUserId", referencedColumnName = "userId", insertable = false, updatable = false)
	private User userEmployeeUserId;
	
}
