package com.sun.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;

@Aspect
@Component
@Log4j
@Order(5)
public class AroundJoinpoint {
	
	@Around("execution(* *..service.*.*(..))")
	public Object logging(ProceedingJoinPoint pjp) throws Throwable {
		
		log.info("Around1");
		/*---------------*/
		Object result = pjp.proceed();
		/*---------------*/
		log.info("Around2");
		
		return result;
	}

}
