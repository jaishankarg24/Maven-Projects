package com.abc.service;

import com.abc.dao.StudentDao;

import com.abc.dto.Student;
import com.abc.factory.StudentDaoFactory;

public class StudentServiceImpl implements StudentService {

	@Override
	public String save(Student student) {

		StudentDao studentDao = StudentDaoFactory.getStudentDao();
		String status = studentDao.save(student);

		return status;
	}

	@Override
	public Student findById(String sid) {

		StudentDao studentDao = StudentDaoFactory.getStudentDao();
		Student student = studentDao.findById(sid);

		return student;
	}

	@Override
	public String deleteById(String sid) {
		StudentDao studentDao = StudentDaoFactory.getStudentDao();
		String status = studentDao.deleteById(sid);

		return status;
	}

	@Override
	public String update(Student student) {
		StudentDao studentDao = StudentDaoFactory.getStudentDao();
		String status = studentDao.update(student);
		return status;
	}

}
