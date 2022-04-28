package com.hospital.SampleHealthCare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.SampleHealthCare.entity.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

	public Appointment findByBookingId(Long id);
	
}
