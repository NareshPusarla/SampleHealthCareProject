package com.hospital.SampleHealthCare;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
//@SecurityScheme(name="javainuse-openapi", scheme = "basic", in = SecuritySchemeIn.HEADER, type = SecuritySchemeType.HTTP)
//@EnableAspectJAutoProxy(proxyTargetClass=true)  
public class SampleHealthCareApplication {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public static void main(String[] args) {
		SpringApplication.run(SampleHealthCareApplication.class, args);
	}
	
	@SuppressWarnings("deprecation")
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
}
