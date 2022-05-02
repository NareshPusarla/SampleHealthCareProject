package com.hospital.SampleHealthCare.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hospital.SampleHealthCare.entity.Appointment;
import com.hospital.SampleHealthCare.entity.Patients;
import com.hospital.SampleHealthCare.exception.ResourceNotFoundException;
import com.hospital.SampleHealthCare.repository.AppointmentRepository;
import com.hospital.SampleHealthCare.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {

//	@Autowired
//	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	public UserRepository userRepository;
	
	@Autowired
	public AppointmentRepository appointmentRepository;
	

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		return new User("admin", "password", new ArrayList<>());
	}

	// create record
	public Patients createPatient(Patients newPatient) {
		return userRepository.save(newPatient);
	}

	// get all patients
	public List<Patients> getAllPatients() {
		return userRepository.findAll();
	}

	// get all by id
	public Patients getPatientsById(Long id) throws ResourceNotFoundException {
		Patients patients = userRepository.findByPatientId(id);
		if (patients != null) {
			return patients;
		} else {
			throw new ResourceNotFoundException("User not found with this id: " + id);
		}
	}

	// update patients by id
	public ResponseEntity<Patients> updatePatient(Long id, Patients updatePatient) throws ResourceNotFoundException {
		Patients patient = userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Patient not exist with id: " + id));

		patient.setPatientName(updatePatient.getPatientName());
		patient.setPatientEmail(updatePatient.getPatientEmail());
		patient.setPatientAddress(updatePatient.getPatientAddress());
		patient.setPatientMobileNumber(updatePatient.getPatientMobileNumber());

		Patients updatedPatient = userRepository.save(patient);
		return ResponseEntity.ok(updatedPatient);
	}

	// delete patient
//	public ResponseEntity<Map<String, Boolean>> deletePatient(Long id) throws ResourceNotFoundException {
//
//		Patients patient = userRepository.findByPatientId(id);
//
//		if (patient != null) {
//			userRepository.delete(patient);
//			Map<String, Boolean> response = new HashMap<>();
//			response.put("deleted", Boolean.TRUE);
//			return ResponseEntity.ok(response);
//		} else {
//			throw new ResourceNotFoundException("User not found with this id: " + id);
//		}
//
//	}
	
	public void deletePatient(Patients patients) {
		userRepository.delete(patients);
	}
	
	//Appointment logic
	
	// create record
		public Appointment createAppointment(Appointment newAppointment) {
			return appointmentRepository.save(newAppointment);
		}

		// get all patients
		public List<Appointment> getAllAppointments() {
			return appointmentRepository.findAll();
		}

		// get all by id
		public Appointment getAppointmentById(Long id) throws ResourceNotFoundException {
			Appointment patients = appointmentRepository.findByBookingId(id);
			if (patients != null) {
				return patients;
			} else {
				throw new ResourceNotFoundException("User not found with this id: " + id);
			}
		}

		// update patients by id
		public ResponseEntity<Appointment> updateAppointment(Long id, Appointment updateAppointment) throws ResourceNotFoundException {
			Appointment appointment = appointmentRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Appointment not exist with id: " + id));

//			patient.setName(updateAppointment.getName());
//			patient.setEmail(updateAppointment.getEmail());
//			patient.setAddress(updateAppointment.getAddress());
//			patient.setMobileNumber(updateAppointment.getMobileNumber());
//			patient.setAlternativeNumber(updateAppointment.getAlternativeNumber());
			
			appointment.setName(updateAppointment.getName());
			appointment.setAddress(updateAppointment.getAddress());
			appointment.setEmail(updateAppointment.getEmail());
			appointment.setMobileNumber(updateAppointment.getMobileNumber());
			appointment.setAlternativeNumber(updateAppointment.getAlternativeNumber());
			appointment.setTime(updateAppointment.getTime());

			Appointment updatedAppointment = appointmentRepository.save(appointment);
			return ResponseEntity.ok(updatedAppointment);
		}

		// delete appointment
//		public ResponseEntity<Map<String, Boolean>> deleteAppointment(Long id) throws ResourceNotFoundException {
//
//			Appointment patient = appointmentRepository.findByBookingId(id);
//
//			if (patient != null) {
//				appointmentRepository.delete(patient);
//				Map<String, Boolean> response = new HashMap<>();
//				response.put("deleted", Boolean.TRUE);
//				return ResponseEntity.ok(response);
//			} else {
//				throw new ResourceNotFoundException("Appointment not found with this id: " + id);
//			}
//
//		}
		
		public void deleteAppointment(Appointment appointment) {
			appointmentRepository.delete(appointment);
		}

}
