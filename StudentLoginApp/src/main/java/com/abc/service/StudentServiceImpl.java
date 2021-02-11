package com.abc.service;

import com.abc.dao.StudentDao;

import com.abc.factory.StudentDaoFactory;

public class StudentServiceImpl implements StudentService {

	@Override
	public String validateUser(int id, String user) {

		StudentDao studentDao = StudentDaoFactory.getStudentDao();
		String status = studentDao.validateUser(id, user);

		return status;
	}

}
