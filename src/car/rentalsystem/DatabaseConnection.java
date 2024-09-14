package car.rentalsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseConnection {
	
	//Resuablitly, Portablity 

	static Connection Get(String url, String port, String dbName, String dbUserName, String dbPswd) {
		Connection con = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver load");
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		}
		try {
			con = DriverManager.getConnection("jdbc:mysql://" + url + ":" + port + "/" + dbName, dbUserName, dbPswd);
		} catch (SQLException e) {
			System.out.println(e);
		}

		return con;
	}

	static void databaseConnection() {

		Connection con = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver load");
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		}
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "");
			System.out.println("Connection Done....");
			String sql = "select * from users";
			preparedStatement = con.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int id = resultSet.getInt("user_id");
				String first_name = resultSet.getString("first_name");
				String last_name = resultSet.getString("last_name");

				System.out.println("ID: " + id + ", First Name: " + first_name + " Last Name: " + last_name);
			}

		} catch (SQLException e) {
			System.out.println(e);
		}
	}
}
