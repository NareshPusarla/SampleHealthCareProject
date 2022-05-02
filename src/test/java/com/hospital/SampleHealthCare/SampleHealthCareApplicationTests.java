package com.hospital.SampleHealthCare;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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

import com.hospital.SampleHealthCare.entity.Patients;
import com.hospital.SampleHealthCare.exception.ResourceNotFoundException;
import com.hospital.SampleHealthCare.repository.UserRepository;
import com.hospital.SampleHealthCare.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
class SampleHealthCareApplicationTests {

	@Autowired
	private UserService service;

	@MockBean
	private UserRepository repository;
	
	@Test
	void contextLoads() {
	}

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
	
}
