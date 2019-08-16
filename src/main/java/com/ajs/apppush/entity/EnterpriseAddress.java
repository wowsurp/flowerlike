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
@Table(name = "tb_enterprise_address")
public class EnterpriseAddress {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idx;
	
	private int enterpriseIdx;
	
	@Column(columnDefinition = "char(1)")
	private String addressType;
	
	@Column(length = 200)
	private String roadAddress;
	
	@Column(length = 200)
	private String jibunAddress;
	
	@Column(length = 20)
	private String buildingName;
	
	@Column(length = 20)
	private String sido;
	
	@Column(length = 20)
	private String sigungu;
	
	@Column(length = 20)
	private String sigunguCode;
	
	@Column(length = 50)
	private String address;
	
	@Column(length = 20)
	private String roadName;
	
	@Column(length = 10)
	private String zoneCode;
	
	@OneToOne
	@JoinColumn(name = "enterpriseIdx", referencedColumnName = "idx", insertable = false, updatable = false)
	private Enterprise enterprise;
}
