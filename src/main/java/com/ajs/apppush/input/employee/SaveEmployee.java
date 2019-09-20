package com.ajs.apppush.input.employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaveEmployee {

	private int idx;
	private int enterpriseIdx;
	private String userId;
	private String nickNm;
	private String introduction;
	private String workingHours;
	private String delYn;
	private String requestAgreeYn;
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public int getEnterpriseIdx() {
		return enterpriseIdx;
	}
	public void setEnterpriseIdx(int enterpriseIdx) {
		this.enterpriseIdx = enterpriseIdx;
	}
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
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public String getWorkingHours() {
		return workingHours;
	}
	public void setWorkingHours(String workingHours) {
		this.workingHours = workingHours;
	}
	public String getDelYn() {
		return delYn;
	}
	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}
	public String getRequestAgreeYn() {
		return requestAgreeYn;
	}
	public void setRequestAgreeYn(String requestAgreeYn) {
		this.requestAgreeYn = requestAgreeYn;
	}
	
	
	
}
