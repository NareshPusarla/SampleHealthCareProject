package com.hospital.SampleHealthCare.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AspectConfig {

	public Logger log = LoggerFactory.getLogger(AspectConfig.class);
	
	@Before(value = "execution(* com.hospital.SampleHealthCare.controller.*.*(..))")
	public void beforeAdvice(JoinPoint joinPoint) {
		log.info("Executing {}", joinPoint);
	}

	@After(value = "execution(* com.hospital.SampleHealthCare.controller.*.*(..))")
	public void afterAdvice(JoinPoint joinPoint) {
		log.info("Executing {}", joinPoint);
	}
}
