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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;

@Data
@Entity
@Table(name="tb_enterprise")
public class Enterprise {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idx;
	
	@Column(length = 50)
	private String name;
	
	@Column(columnDefinition = "LongBlob")
	private String thumbnail;
	
	@Column(columnDefinition="char(19)")
	private String regDtm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	
	@Column(length = 1000)
	private String intro;
	
	@Transient
	@OneToMany(targetEntity = Employee.class)
	@JoinColumn(name="enterpriseIdx", referencedColumnName = "idx")
	private List<Employee> employeeList;

	@Transient
	@OneToMany(targetEntity = Contents.class)
	@JoinColumn(name="enterpriseIdx", referencedColumnName = "idx")
	private List<Contents> contentsList;
	
	@Transient
	@OneToMany(targetEntity = EnterpriseLike.class)
	@JoinColumn(name="enterpriseIdx", referencedColumnName = "idx")
	private List<EnterpriseLike> enterpriseLikeList;
	
	@Transient
	@OneToMany(targetEntity = EnterpriseStar.class)
	@JoinColumn(name="enterpriseIdx", referencedColumnName = "idx")
	private List<EnterpriseStar> enterpriseStarList;
	
	@Transient
	@OneToOne(targetEntity = EnterpriseAddress.class)
	@JoinColumn(name="enterpriseIdx", referencedColumnName = "idx")
	private List<EnterpriseAddress> enterpriseAddressList;
	
	@Transient
	@OneToOne(targetEntity = WorkingHistory.class)
	@JoinColumn(name="enterpriseIdx", referencedColumnName = "idx")
	private List<WorkingHistory> workingHistoryList;
	
	@ManyToOne
	@JoinColumn(name = "userId", referencedColumnName = "userId", insertable = false, updatable = false)
	private User user;
}
