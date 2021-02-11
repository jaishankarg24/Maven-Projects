package com.abc.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.abc.factory.ConnectionFactory;

public class StudentDaoImpl implements StudentDao {

	@Override
	public String validateUser(int id, String user) {
		String status = "";

		try {
			Connection connection = ConnectionFactory.getConnectionToDb();
			String sqlSelectQuery = "select * from `student` where `sid`=? and `sname`=?";

			PreparedStatement preparedStatement = connection.prepareStatement(sqlSelectQuery);
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, user);

			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next() == true) {
				status = "success";
			} else {
				status = "failure";
			}

		} catch (Exception e) {
			e.printStackTrace();
			status = "failure";
		}
		return status;
	}

}
