package com.mtcm.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mtcm.sample.dao.CmmnDao;

@Service
public class MainCalendarService {

	@Autowired
	private CmmnDao dao;

}
