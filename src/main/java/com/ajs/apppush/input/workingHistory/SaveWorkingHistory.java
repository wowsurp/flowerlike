package com.ajs.apppush.input.workingHistory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaveWorkingHistory {

	private int idx;
	private int enterpriseIdx;
	private String startDtm;
	private String endDtm;
	private String employeeId;
	
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
	public String getStartDtm() {
		return startDtm;
	}
	public void setStartDtm(String startDtm) {
		this.startDtm = startDtm;
	}
	public String getEndDtm() {
		return endDtm;
	}
	public void setEndDtm(String endDtm) {
		this.endDtm = endDtm;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	
}
