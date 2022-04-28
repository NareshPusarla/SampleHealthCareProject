package com.hospital.SampleHealthCare.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name= "patients")
public class Patients {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long patientId;
	
	@Column(name = "name")
	@NotEmpty
	@Size(min = 3, message="name should atleast 3 letters")
	private String patientName;
	
	@Column(name = "address")
	@NotEmpty
	@Size(min = 10, message="name should atleast 10 letters")
	private String patientAddress;
	
	@Column(name = "email")
	@NotEmpty
	@Email
	private String patientEmail;
	
	@Column(name = "mobileNumber")
	@NotEmpty
	@Size(min = 10, message="name should atleast 10 digits")
	private String patientMobileNumber;

	public Patients() {
		super();
	}

	public Patients(long patientId, @NotEmpty @Size(min = 3, message = "name should atleast 3 letters") String patientName,
			@NotEmpty @Size(min = 10, message = "name should atleast 10 letters") String patientAddress,
			@NotEmpty @Email String patientEmail,
			@NotEmpty @Size(min = 10, message = "name should atleast 10 digits") String patientMobileNumber) {
		super();
		this.patientId = patientId;
		this.patientName = patientName;
		this.patientAddress = patientAddress;
		this.patientEmail = patientEmail;
		this.patientMobileNumber = patientMobileNumber;
	}

	public long getPatientId() {
		return patientId;
	}

	public void setPatientId(long patientId) {
		this.patientId = patientId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getPatientAddress() {
		return patientAddress;
	}

	public void setPatientAddress(String patientAddress) {
		this.patientAddress = patientAddress;
	}

	public String getPatientEmail() {
		return patientEmail;
	}

	public void setPatientEmail(String patientEmail) {
		this.patientEmail = patientEmail;
	}

	public String getPatientMobileNumber() {
		return patientMobileNumber;
	}

	public void setPatientMobileNumber(String patientMobileNumber) {
		this.patientMobileNumber = patientMobileNumber;
	}

	@Override
	public String toString() {
		return "User [patientId=" + patientId + ", patientName=" + patientName + ", patientAddress=" + patientAddress
				+ ", patientEmail=" + patientEmail + ", patientMobileNumber=" + patientMobileNumber + "]";
	}
	
}
