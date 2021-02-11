package com.abc.mainapp;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.Statement;

import com.abc.factory.ConnectionFactory;

public class App {

	public static void main(String[] args) {

		try {
			//Use factory method to get the connection 
			//Abstraction
			Connection connection = ConnectionFactory.getConnectionToDb();
			
			//Connection connection=DriverManager.getConnection();
			//getConnection() is a static factory method, it is creating an object of a DriverManager class which is implementing Connection Interface.
			
			System.out.println("Connection object is :" + connection);
			Statement statement = connection.createStatement();

			ResultSet resultSet = statement.executeQuery("select * from `student`");
			System.out.println("Records of the table is :");
			System.out.println("SID " + "\t" + "SNAME " + "\t" + "SADDRESS " + "\t" + "SAGE ");
			while (resultSet.next()) {
				System.out.println(resultSet.getInt("sno") + "\t" + resultSet.getString("sname") + "\t"
						+ resultSet.getString("saddress") + "\t\t" + resultSet.getInt("sage"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
