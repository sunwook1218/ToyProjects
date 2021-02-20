package com.mtcm.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mtcm.sample.dao.CmmnDao;

@Service
public class HrManagementService {

	@Autowired
	private CmmnDao dao;

}
