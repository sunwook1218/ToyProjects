package com.sun.service;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.dao.Dao;
import com.sun.model.Member;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class CRUDService {

	@Autowired
	private Dao dao;

	/**
	 * @param option : option에 따라 aop가 다르게 적용됩니다.
	 * @param name1  : member instance1의 name
	 * @param age1   : member instance1의 age
	 * @param name2  : member instance2의 name
	 * @param age2   : member instance2의 age
	 */
	public void aopTestProcess(Integer option, String name1, Integer age1, String name2, Integer age2) {
		
		log.info("fun start");

		Member member1 = new Member(name1, age1);
		Member member2 = new Member(name2, age2);

		if (option == 1)
			process1(member1, member2);
		if (option == 2)
			process2(member1, member2);
		if (option == 3)
			process3(member1, member2);
		if (option == 4)
			process4(member1, member2);
		
		log.info("fun end");

	}

	private void process1(Member member1, Member member2) {
		
		log.info("fun start");

		dao.insert(member1);

		dao.insert(member2);
		
		log.info("fun end");
	}

	private void process2(Member member1, Member member2) {

		log.info("fun start");
		
		dao.insert(member1);

		try {
			throw new RuntimeException("Exception");

		} catch (RuntimeException e) {
			System.out.println("");
		}
		
		dao.insert(member2);
		
		log.info("fun end");

	}

	private void process3(Member member1, Member member2) throws RuntimeException {

		log.info("fun start");
		
		dao.insert(member1);
		
		if(member1.equals(member1)) 	
			throw new RuntimeException("Exception");
		

		dao.insert(member2);
		
		log.info("fun end");

	}

	private void process4(Member member1, Member member2) {

		log.info("fun start");
		
		dao.insert(member1);

		dao.insert(member2);
		
		log.info("fun end");

	}

	public void delete() {
		
		log.info("fun start");
		
		dao.delete();
		
		log.info("fun end");
	}

	public List<Member> selectAll() {
		
		log.info("fun start");
		
		
		log.info("fun end");
		
		return dao.selectAll();
		
		
	}

}
