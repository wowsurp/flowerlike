package com.ajs.apppush.entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	
	@Column(length = 200)
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
	@ManyToOne(targetEntity = PushNotification.class)
	@JoinColumn(name = "sender", referencedColumnName = "userId")
	private List<PushNotification> PushNotificationSenderList;
	
	@Transient
	@ManyToOne(targetEntity = PushNotification.class)
	@JoinColumn(name = "reciever", referencedColumnName = "userId")
	private List<PushNotification> PushNotificationRecieverList;
	
}
