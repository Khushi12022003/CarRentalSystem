package car.rentalsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.xml.transform.Result;

public class DatabaseConnection {

	// Resuablitly, Portablity

	static Connection createConnection(String url, String port, String dbName, String dbUserName, String dbPswd) {
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
			String url = "jdbc:mysql://10.0.0.17/login?useSSL=false&allowPublicKeyRetrieval=true";
			String username = "root";
		    String password = "Password@321";
//			con = DriverManager.getConnection("jdbc:mysql://10.0.0.17:3306/login", "root", "Password@321");
			con = DriverManager.getConnection(url, username, password);
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

	static void query() {

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
			con = createConnection(null, null, null, null, null);
			System.out.println("Connection Done....");
			String sql = "select * from users";
			preparedStatement = con.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int id = resultSet.getInt("user_id");
				String first_name = resultSet.getString("first_name");
				String last_name = resultSet.getString("last_name");
				
				int cr_id = resultSet.getInt("cr_id");
				String cr_name =resultSet.getString("cr_name");
				int manufacturing_year =resultSet.getInt("manufacturing_year");
				String cr_brand = resultSet.getString("cr_brand");
				long units = resultSet.getLong(" units");
				Float price =resultSet.getFloat("price");
		
				
				System.out.println("ID: " + id + " First Name: " + first_name + " Last Name: " + last_name + "cr_id :"+ cr_id+ "cr_Name:" + cr_name + "manufacturing_year :" + manufacturing_year + "brand :" + cr_brand 
						+"units:"+units+ "price:"+ price);
				
			}

		} catch (SQLException e) {
			System.out.println(e);
		}
	}		
}
