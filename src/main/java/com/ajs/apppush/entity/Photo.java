package com.ajs.apppush.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="tb_photo")
public class Photo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idx;
	
	private int employeeIdx;
	
	@Column(length = 200)
	private String filePath;
	
	@OneToOne
	@JoinColumn(name = "employeeIdx", referencedColumnName = "idx", insertable = false, updatable = false)
	private Employee employee;

}
