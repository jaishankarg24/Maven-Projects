package com.abc.dao;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.abc.dto.Student;
import com.abc.factory.ConnectionFactory;

public class StudentDaoImpl implements StudentDao {

	@Override
	public String save(Student student) {
		String status = "";
		try {
			Connection connection = ConnectionFactory.getConnectionToDb();
			String sqlSelectQuery = "select * from `student` where `sid`=?";
			PreparedStatement preparedStatement = null;

			preparedStatement = connection.prepareStatement(sqlSelectQuery);
			preparedStatement.setString(1, student.getSid());

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next() == true) {
				status = "alreadyExisted";

			} else {

				String sqlInsertQuery = "insert into `student`(`sid`,`sname`,`sage`,`saddress`)values(?,?,?,?)";
				preparedStatement = connection.prepareStatement(sqlInsertQuery);
				preparedStatement.setString(1, student.getSid());
				preparedStatement.setString(2, student.getSname());
				preparedStatement.setString(3, student.getSage());
				preparedStatement.setString(4, student.getSaddress());

				int rowCount = preparedStatement.executeUpdate();
				if (rowCount == 1) {
					status = "success";
				} else {
					status = "failure";
				}

			}

		} catch (SQLException e) {
			e.printStackTrace();
			status = "failure";
		}

		return status;
	}

	@Override
	public Student findById(String sid) {

		Student student = null;

		try {
			Connection connection = ConnectionFactory.getConnectionToDb();
			String sqlSelectQuery = "select * from `student` where `sid`=?";
			PreparedStatement preparedStatement = null;

			preparedStatement = connection.prepareStatement(sqlSelectQuery);
			preparedStatement.setString(1, sid);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next() == true) {

				student = new Student();

				// Keep the data obtained from ResultSet to Student DTO object
				student.setSid(resultSet.getString("sid"));
				student.setSname(resultSet.getString("sname"));
				student.setSage(resultSet.getString("sage"));
				student.setSaddress(resultSet.getString("saddress"));

			} else {
				student = null;
			}

		} catch (Exception e) {
			e.printStackTrace();

		}

		return student;
	}

	@Override
	public String deleteById(String sid) {
		String status = "";
		PreparedStatement preparedStatement = null;
		try {
			Connection connection = ConnectionFactory.getConnectionToDb();
			String sqlSelectQuery = "select * from `student` where `sid`=?";

			preparedStatement = connection.prepareStatement(sqlSelectQuery);
			preparedStatement.setString(1, sid);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next() == true) {

				String sqlDeleteQuery = "delete from `student` where `sid`=?";
				preparedStatement = connection.prepareStatement(sqlDeleteQuery);
				preparedStatement.setString(1, sid);
				int rowCount = preparedStatement.executeUpdate();
				if (rowCount == 1) {
					status = "success";
				} else {
					status = "failure";
				}

			} else {

				status = "notexisted";
			}

		} catch (SQLException e) {
			e.printStackTrace();
			status = "failure";
		}

		return status;
	}

	@Override
	public String update(Student student) {
		String status = "";
		try {
			Connection connection = ConnectionFactory.getConnectionToDb();
			String sqlUpdateQuery = "update `student` set `sname`=?,`sage`=?,`saddress`=? where `sid`=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sqlUpdateQuery);
			preparedStatement.setString(1, student.getSname());
			preparedStatement.setString(2, student.getSage());
			preparedStatement.setString(3, student.getSaddress());
			preparedStatement.setString(4, student.getSid());

			int rowCount = preparedStatement.executeUpdate();
			if (rowCount == 1) {
				status = "success";
			} else {
				status = "failure";
			}

		} catch (Exception e) {
			status = "failure";
		}

		return status;
	}
}
