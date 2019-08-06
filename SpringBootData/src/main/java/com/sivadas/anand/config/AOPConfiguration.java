package com.sivadas.anand.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class AOPConfiguration {

	private static final Logger LOGGER = LoggerFactory.getLogger(AOPConfiguration.class);

	@Before(value = "within(com.sivadas.anand.*)")
	public void beforeAdvice(final JoinPoint joinPoint) {

		LOGGER.info("Before method: {}", joinPoint.getSignature());

	}

	@After(value = "within(com.sivadas.anand.*)")
	public void afterAdvice(final JoinPoint joinPoint) {

		LOGGER.info("After method: {}", joinPoint.getSignature());
	}

}
