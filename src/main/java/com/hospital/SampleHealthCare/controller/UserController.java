package com.hospital.SampleHealthCare.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.SampleHealthCare.entity.Appointment;
import com.hospital.SampleHealthCare.entity.Patients;
import com.hospital.SampleHealthCare.exception.ResourceNotFoundException;
import com.hospital.SampleHealthCare.model.AuthRequest;
import com.hospital.SampleHealthCare.model.AuthResponse;
import com.hospital.SampleHealthCare.service.UserService;
import com.hospital.SampleHealthCare.utility.JWTUtility;

//import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
//@SecurityRequirement(name = "javainuse-openapi")
//@RequestMapping("/patient")
public class UserController {

	@Autowired
	private JWTUtility jwtUtility;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserService userService;

	@GetMapping("/")
	public String home() {
		return "Welcome to Daily Code Buffer!!";
	}

	@PostMapping("/authenticate")
	public AuthResponse authenticate(@RequestBody AuthRequest authRequest) throws Exception {

		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}

		final UserDetails userDetails = userService.loadUserByUsername(authRequest.getUsername());

		final String token = jwtUtility.generateToken(userDetails);

		return new AuthResponse(token);
	}

	@GetMapping("/fetchrecords")
	public List<Patients> getAllRecords() {
		return userService.getAllPatients();
	}

	@PostMapping("/addrecord")
	public Patients createRecord(@RequestBody Patients patient) {
		return userService.createPatient(patient);
	}

	@GetMapping("/fetchrecords/{id}")
	public Patients getAllRecordsById(@PathVariable Long id) throws ResourceNotFoundException {
		return userService.getPatientsById(id);
	}

	// update patients by id
	@PutMapping("/updaterecord/{id}")
	public ResponseEntity<Patients> updatePatient(@PathVariable Long id, @RequestBody Patients updatePatient)
			throws ResourceNotFoundException {
		return userService.updatePatient(id, updatePatient);
	}

	// delete patient
//	@DeleteMapping("/deleterecord/{id}")
//	public ResponseEntity<Map<String, Boolean>> deletePatient(@PathVariable Long id) throws ResourceNotFoundException {
//		return userService.deletePatient(id);
//	}
	
	@DeleteMapping("/deleterecord")
	public Patients removeUser(@RequestBody Patients user) {
		userService.deletePatient(user);
		return user;
	}
	

	//Appointment api
	
	@GetMapping("/fetchappointments")
	public List<Appointment> getAllAppointments() {
		return userService.getAllAppointments();
	}

	@PostMapping("/addappointment")
	public Appointment createAppointment(@RequestBody Appointment appointment) {
		return userService.createAppointment(appointment);
	}

	@GetMapping("/fetchappointments/{id}")
	public Appointment getAppointmentById(@PathVariable Long id) throws ResourceNotFoundException {
		return userService.getAppointmentById(id);
	}

	// update patients by id
	@PutMapping("/updateappointment/{id}")
	public ResponseEntity<Appointment> updateAppointment(@PathVariable Long id, @RequestBody Appointment updateappointment)
			throws ResourceNotFoundException {
		return userService.updateAppointment(id, updateappointment);
	}

	// delete patient
	@DeleteMapping("/deleteappointment")
//	public ResponseEntity<Map<String, Boolean>> deleteAppointment(@PathVariable Long id) throws ResourceNotFoundException {
//		return userService.deleteAppointment(id);
//	}
	public Appointment removeAppointment(@RequestBody Appointment user) {
		userService.deleteAppointment(user);
		return user;
	}
	
}
