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

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getRegDtm() {
		return regDtm;
	}

	public void setRegDtm(String regDtm) {
		this.regDtm = regDtm;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public List<Employee> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}

	public List<Contents> getContentsList() {
		return contentsList;
	}

	public void setContentsList(List<Contents> contentsList) {
		this.contentsList = contentsList;
	}

	public List<EnterpriseLike> getEnterpriseLikeList() {
		return enterpriseLikeList;
	}

	public void setEnterpriseLikeList(List<EnterpriseLike> enterpriseLikeList) {
		this.enterpriseLikeList = enterpriseLikeList;
	}

	public List<EnterpriseStar> getEnterpriseStarList() {
		return enterpriseStarList;
	}

	public void setEnterpriseStarList(List<EnterpriseStar> enterpriseStarList) {
		this.enterpriseStarList = enterpriseStarList;
	}

	public List<EnterpriseAddress> getEnterpriseAddressList() {
		return enterpriseAddressList;
	}

	public void setEnterpriseAddressList(List<EnterpriseAddress> enterpriseAddressList) {
		this.enterpriseAddressList = enterpriseAddressList;
	}

	public List<WorkingHistory> getWorkingHistoryList() {
		return workingHistoryList;
	}

	public void setWorkingHistoryList(List<WorkingHistory> workingHistoryList) {
		this.workingHistoryList = workingHistoryList;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
