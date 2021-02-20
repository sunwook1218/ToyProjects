package com.sun.aop;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;

@Aspect
@Component
@Log4j
@Order(1)
public class AfterReturningJoinpoint {

	@AfterReturning("execution(* *..service.*.*(..))")
	public void logging() throws Throwable {

		log.info("AfterReturning");

	}

}
