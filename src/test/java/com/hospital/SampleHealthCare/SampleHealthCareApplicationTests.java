package com.hospital.SampleHealthCare;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.hospital.SampleHealthCare.entity.Appointment;
import com.hospital.SampleHealthCare.entity.Patients;
import com.hospital.SampleHealthCare.exception.ResourceNotFoundException;
import com.hospital.SampleHealthCare.repository.AppointmentRepository;
import com.hospital.SampleHealthCare.repository.UserRepository;
import com.hospital.SampleHealthCare.service.UserService;

import net.bytebuddy.asm.Advice.Local;

@RunWith(SpringRunner.class)
@SpringBootTest
class SampleHealthCareApplicationTests {

	@Autowired
	private UserService service;

	@MockBean
	private UserRepository repository;
	
	@MockBean
	public AppointmentRepository appointmentRepository;
	
	@Test
	void contextLoads() {
	}

	//Patient record api's
	
	@Test
	public void getUsersTest() {
		when(repository.findAll()).thenReturn(Stream
				.of(new Patients(376, "Danile", "USA", "daniel@gmail.com","8974563214"), new Patients(958, "Huy", "UK", "huy@gmail.com", "7418529635")).collect(Collectors.toList()));
		assertEquals(2, service.getAllPatients().size());
	}

	@Test
	public void getUserbyIdTest() {
		when(repository.findAll()).thenReturn(Stream
				.of(new Patients(111, "Naresh", "innis", "test@gmail.com", "852741963"), new Patients(112, "Rajesh", "innis", "test@gmail.com", "952771963")).collect(Collectors.toList()));
		assertEquals(2, service.getAllPatients().size());
	}

	@Test
	public void saveUserTest() {
		Patients user = new Patients(111, "Naresh", "innis", "test@gmail.com", "852741963");
		when(repository.save(user)).thenReturn(user);
		assertEquals(user, service.createPatient(user));
	}

	@Test
	public void deleteUserTest(){
		Patients user = new Patients(111, "Naresh", "innis", "test@gmail.com", "852741963");
		service.deletePatient(user);
		verify(repository, times(1)).delete(user);
	}
	
	//Appointment record api's
	
	@Test
	public void getAppointmentsTest() {
		when(appointmentRepository.findAll()).thenReturn(Stream
				.of(new Appointment(376, "Danile", "USA", "daniel@gmail.com","8974563214", "7896641236",LocalDateTime.now()), new Appointment(958, "Huy", "UK", "huy@gmail.com", "7418529635","7896641236", LocalDateTime.now())).collect(Collectors.toList()));
		assertEquals(2, service.getAllAppointments().size());
	}

	@Test
	public void getAppointmentbyIdTest() {
		when(appointmentRepository.findAll()).thenReturn(Stream
				.of(new Appointment(111, "Naresh", "innis", "test@gmail.com", "852741963","7896641236",LocalDateTime.now()), new Appointment(112, "Rajesh", "innis", "test@gmail.com", "952771963","7896641236",LocalDateTime.now())).collect(Collectors.toList()));
		assertEquals(2, service.getAllAppointments().size());
	}

	@Test
	public void saveAppointmentTest() {
		Appointment user = new Appointment(111, "Naresh", "innis", "test@gmail.com", "852741963","7896641236",LocalDateTime.now());
		when(appointmentRepository.save(user)).thenReturn(user);
		assertEquals(user, service.createAppointment(user));
	}

	@Test
	public void deleteAppointmentTest(){
		Appointment user = new Appointment(111, "Naresh", "innis", "test@gmail.com", "852741963","7896641236",LocalDateTime.now());
		service.deleteAppointment(user);
		verify(appointmentRepository, times(1)).delete(user);
	}
}
