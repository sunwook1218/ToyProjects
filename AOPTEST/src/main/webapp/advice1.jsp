<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ page import="java.io.File" trimDirectiveWhitespaces="true" %>
package com.sun.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Sample2Aop {

	@Before("execution(* *..service.*.*(..))")
	public void test() {
		System.out.println("before");
	}

}
