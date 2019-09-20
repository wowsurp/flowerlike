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
@Table(name = "tb_push_notification")
public class PushNotification {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idx;
	
	@Column(length = 50)
	private String title;
	
	@Column(length = 50)
	private String message;
	
	@Column(length = 500)
	private String link;
	
	@Column(columnDefinition = "char(10)")
	private String sendDt;
	
	@Column(columnDefinition = "char(2)")
	private String sendHour;
	
	@Column(columnDefinition = "char(2)")
	private String sendMinute;
	
	@Column(length = 100)
	private String sender;
	
	@Column(length = 100)
	private String reciever;
	
	@ManyToOne
	@JoinColumn(name = "sender", referencedColumnName = "userId", insertable = false, updatable = false)
	private User userSender;
	
	@ManyToOne
	@JoinColumn(name = "reciever", referencedColumnName = "userId", insertable = false, updatable = false)
	private User userReciever;
}
