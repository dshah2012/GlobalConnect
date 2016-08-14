package com.ge.tps.dto;

import java.util.Date;

import com.ge.tps.enums.Gender;
import com.ge.tps.enums.MaritalStatus;

public class PersonalInfoDto {
		private long personalInfoId;
		private String firstName;
		private String middleName;
		private String lastName;
		private String spouseName;
		
		private Gender gender;
		private MaritalStatus maritalstatus;
		private boolean readyToRelocate;
		private Date dateOfBirth;
		
		public String getSpouseName() {
			return spouseName;
		}
		public void setSpouseName(String spouseName) {
			this.spouseName = spouseName;
		}
		public long getPersonalInfoId() {
			return personalInfoId;
		}
		public void setPersonalInfoId(long personalInfoId) {
			this.personalInfoId = personalInfoId;
		}
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getMiddleName() {
			return middleName;
		}
		public void setMiddleName(String middleName) {
			this.middleName = middleName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public Gender getGender() {
			return gender;
		}
		public void setGender(Gender gender) {
			this.gender = gender;
		}
		public MaritalStatus getMaritalstatus() {
			return maritalstatus;
		}
		public void setMaritalstatus(MaritalStatus maritalstatus) {
			this.maritalstatus = maritalstatus;
		}
		public boolean isReadyToRelocate() {
			return readyToRelocate;
		}
		public void setReadyToRelocate(boolean readyToRelocate) {
			this.readyToRelocate = readyToRelocate;
		}
		public Date getDateOfBirth() {
			return dateOfBirth;
		}
		public void setDateOfBirth(Date dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
		}
		
		
		
}
