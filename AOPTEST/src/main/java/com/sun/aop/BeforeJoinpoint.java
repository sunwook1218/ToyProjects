package com.sun.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;

@Aspect
@Component
@Log4j
@Order(1)
public class BeforeJoinpoint {

	@Before("execution(* *..service.*.*(..))")
	public void test() {
		log.info("Before AOP");
	}

}
