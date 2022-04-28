package com.hospital.SampleHealthCare.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="appointment")
public class Appointment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long bookingId;
	
	@Column(name = "name")
	@NotEmpty
	@Size(min = 3, message="name should atleast 3 letters")
	private String name;
	
	@Column(name = "address")
	@NotEmpty
	@Size(min = 10, max =100, message="name should atleast 10 letters")
	private String address;
	
	@Column(name = "email")
	@Email
	private String email;
	
	@Column(name = "mobileNumber")
	@NotEmpty
	@Size(min = 10, message="number should atleast 10 digits")
	private String mobileNumber;
	
	@Column(name = "alternativeNumber")
	@NotEmpty
	@Size(min = 10, message="number should atleast 10 digits")
	private String alternativeNumber;
	
	@Column(name = "date")
    @DateTimeFormat(pattern = "yyyy-MM-ddHH:mm")
    private LocalDateTime time;

	public Appointment() {
		super();
	}

	public Appointment(long bookingId, @NotEmpty @Size(min = 3, message = "name should atleast 3 letters") String name,
			@NotEmpty @Size(min = 10, max = 100, message = "name should atleast 10 letters") String address,
			@Email String email,
			@NotEmpty @Size(min = 10, message = "number should atleast 10 digits") String mobileNumber,
			@NotEmpty @Size(min = 10, message = "number should atleast 10 digits") String alternativeNumber,
			LocalDateTime time) {
		super();
		this.bookingId = bookingId;
		this.name = name;
		this.address = address;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.alternativeNumber = alternativeNumber;
		this.time = time;
	}

	public long getBookingId() {
		return bookingId;
	}

	public void setBookingId(long bookingId) {
		this.bookingId = bookingId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getAlternativeNumber() {
		return alternativeNumber;
	}

	public void setAlternativeNumber(String alternativeNumber) {
		this.alternativeNumber = alternativeNumber;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "Appointment [bookingId=" + bookingId + ", name=" + name + ", address=" + address + ", email=" + email
				+ ", mobileNumber=" + mobileNumber + ", alternativeNumber=" + alternativeNumber + ", time=" + time
				+ "]";
	}

	
}
