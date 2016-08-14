package com.ge.tps.dto;



public class ContactInfoDto {
	private long contactId;
	private long primaryMobileNo;
	private long secondaryMobileNo;
	private String secondaryMailId;
	private String faxNo;
	private long residenceNo;
	private long officeContactNo;
	public long getContactId() {
		return contactId;
	}
	public void setContactId(long contactId) {
		this.contactId = contactId;
	}
	
	public String getSecondaryMailId() {
		return secondaryMailId;
	}
	public void setSecondaryEmailId(String secondaryMailId) {
		this.secondaryMailId = secondaryMailId;
	}
	public String getFaxNo() {
		return faxNo;
	}
	public void setFaxNo(String faxNo) {
		this.faxNo = faxNo;
	}
	public long getResidenceNo() {
		return residenceNo;
	}
	public void setResidenceNo(long residenceNo) {
		this.residenceNo = residenceNo;
	}
	public long getOfficeContactNo() {
		return officeContactNo;
	}
	public void setOfficeContactNo(long officeContactNo) {
		this.officeContactNo = officeContactNo;
	}
	public long getPrimaryMobileNo() {
		return primaryMobileNo;
	}
	public void setPrimaryMobileNo(long primaryMobileNo) {
		this.primaryMobileNo = primaryMobileNo;
	}
	public long getSecondaryMobileNo() {
		return secondaryMobileNo;
	}
	public void setSecondaryMobileNo(long secondaryMobileNo) {
		this.secondaryMobileNo = secondaryMobileNo;
	}
	public void setSecondaryMailId(String secondaryMailId) {
		this.secondaryMailId = secondaryMailId;
	}
	

}
