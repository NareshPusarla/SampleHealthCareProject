package com.hospital.SampleHealthCare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.SampleHealthCare.entity.Patients;

public interface UserRepository extends JpaRepository<Patients, Long> {

	public Patients findByPatientId(Long id);
}