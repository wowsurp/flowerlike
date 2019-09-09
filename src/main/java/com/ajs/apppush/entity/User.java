package com.ajs.apppush.entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicUpdate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@DynamicUpdate
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="tb_user")
public class User {

	@Id
	@Column(length = 100)
	private String userId;
	
	@Column(length = 20)
	private String nickNm;
	
	@Column(length = 100, unique = true)
	private String email;
	
	@Column(length = 200)
	private String token;
	
	@Column(columnDefinition = "LongBlob")
	private String profile;
	
	@Column(length = 20)
	private String grade;

	@Column(columnDefinition = "char(1)")
	private String type;
	
	private long point = 0;
	
	@Column(columnDefinition = "char(1)")
	private String status = "I";
	
	@Column(columnDefinition="char(19)")
	private String regDtm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

	@Column(length = 100)
	private String device;
	
	@Column(length = 1000)
	private String intro;
	
	@Transient
	@OneToMany(targetEntity = Order.class)
	@JoinColumn(name = "userId", referencedColumnName = "userId")
	private List<Order> orderList;
	
	@Transient
	@OneToMany(targetEntity = Donation.class)
	@JoinColumn(name = "fromId", referencedColumnName = "userId")
	private List<Donation> fromIdList;
	
	@Transient
	@OneToMany(targetEntity = Donation.class)
	@JoinColumn(name = "toId", referencedColumnName = "userId")
	private List<Donation> toIdList;
	
	@Transient
	@OneToMany(targetEntity = EmployeeLike.class)
	@JoinColumn(name = "userId", referencedColumnName = "userId")
	private List<EmployeeLike> employeeLikeUserIdList;
	
	@Transient
	@OneToMany(targetEntity = EmployeeLike.class)
	@JoinColumn(name = "employeeUserId", referencedColumnName = "userId")
	private List<EmployeeLike> employeeLikeEmployeeUserIdList;
	
	@Transient
	@OneToMany(targetEntity = EmployeeStar.class)
	@JoinColumn(name = "userId", referencedColumnName = "userId")
	private List<EmployeeStar> employeeStarUserIdList;
	
	@Transient
	@OneToMany(targetEntity = EmployeeStar.class)
	@JoinColumn(name = "employeeUserId", referencedColumnName = "userId")
	private List<EmployeeStar> employeeStarEmployeeUserIdList;
	
	@Transient
	@OneToMany(targetEntity = Contents.class)
	@JoinColumn(name = "userId", referencedColumnName = "userId")
	private List<Contents> contentsList;

	@Transient
	@OneToMany(targetEntity = EnterpriseLike.class)
	@JoinColumn(name = "userId", referencedColumnName = "userId")
	private List<EnterpriseLike> enterpriseLikeList;
	
	@Transient
	@OneToMany(targetEntity = EnterpriseStar.class)
	@JoinColumn(name = "userId", referencedColumnName = "userId")
	private List<EnterpriseStar> enterpriseStarList;
	
	@Transient
	@OneToMany(targetEntity = PushNotification.class)
	@JoinColumn(name = "sender", referencedColumnName = "userId")
	private List<PushNotification> PushNotificationSenderList;
	
	@Transient
	@OneToMany(targetEntity = PushNotification.class)
	@JoinColumn(name = "reciever", referencedColumnName = "userId")
	private List<PushNotification> PushNotificationRecieverList;
	
	@Transient
	@OneToMany(targetEntity = Enterprise.class)
	@JoinColumn(name = "userId", referencedColumnName = "userId")
	private List<Enterprise> enterpriseList;
	
	@Transient
	@OneToMany(targetEntity = Employee.class)
	@JoinColumn(name = "userId", referencedColumnName = "userId")
	private List<Employee> employeeList;
	
	@Transient
	@OneToMany(targetEntity = WorkingHistory.class)
	@JoinColumn(name = "employeeId", referencedColumnName = "userId")
	private List<WorkingHistory> workingHistoryList;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getNickNm() {
		return nickNm;
	}

	public void setNickNm(String nickNm) {
		this.nickNm = nickNm;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public long getPoint() {
		return point;
	}

	public void setPoint(long point) {
		this.point = point;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRegDtm() {
		return regDtm;
	}

	public void setRegDtm(String regDtm) {
		this.regDtm = regDtm;
	}

	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public List<Order> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}

	public List<Donation> getFromIdList() {
		return fromIdList;
	}

	public void setFromIdList(List<Donation> fromIdList) {
		this.fromIdList = fromIdList;
	}

	public List<Donation> getToIdList() {
		return toIdList;
	}

	public void setToIdList(List<Donation> toIdList) {
		this.toIdList = toIdList;
	}

	public List<EmployeeLike> getEmployeeLikeUserIdList() {
		return employeeLikeUserIdList;
	}

	public void setEmployeeLikeUserIdList(List<EmployeeLike> employeeLikeUserIdList) {
		this.employeeLikeUserIdList = employeeLikeUserIdList;
	}

	public List<EmployeeLike> getEmployeeLikeEmployeeUserIdList() {
		return employeeLikeEmployeeUserIdList;
	}

	public void setEmployeeLikeEmployeeUserIdList(List<EmployeeLike> employeeLikeEmployeeUserIdList) {
		this.employeeLikeEmployeeUserIdList = employeeLikeEmployeeUserIdList;
	}

	public List<EmployeeStar> getEmployeeStarUserIdList() {
		return employeeStarUserIdList;
	}

	public void setEmployeeStarUserIdList(List<EmployeeStar> employeeStarUserIdList) {
		this.employeeStarUserIdList = employeeStarUserIdList;
	}

	public List<EmployeeStar> getEmployeeStarEmployeeUserIdList() {
		return employeeStarEmployeeUserIdList;
	}

	public void setEmployeeStarEmployeeUserIdList(List<EmployeeStar> employeeStarEmployeeUserIdList) {
		this.employeeStarEmployeeUserIdList = employeeStarEmployeeUserIdList;
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

	public List<PushNotification> getPushNotificationSenderList() {
		return PushNotificationSenderList;
	}

	public void setPushNotificationSenderList(List<PushNotification> pushNotificationSenderList) {
		PushNotificationSenderList = pushNotificationSenderList;
	}

	public List<PushNotification> getPushNotificationRecieverList() {
		return PushNotificationRecieverList;
	}

	public void setPushNotificationRecieverList(List<PushNotification> pushNotificationRecieverList) {
		PushNotificationRecieverList = pushNotificationRecieverList;
	}

	public List<Enterprise> getEnterpriseList() {
		return enterpriseList;
	}

	public void setEnterpriseList(List<Enterprise> enterpriseList) {
		this.enterpriseList = enterpriseList;
	}

	public List<Employee> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}

	public List<WorkingHistory> getWorkingHistoryList() {
		return workingHistoryList;
	}

	public void setWorkingHistoryList(List<WorkingHistory> workingHistoryList) {
		this.workingHistoryList = workingHistoryList;
	}
	
	
}
