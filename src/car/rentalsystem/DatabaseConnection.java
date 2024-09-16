package car.rentalsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseConnection {


	static void databaseConnection() {

		Connection con = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver load");
		} catch (ClassNotFoundException e) {
			System.o444ut.println(e);
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
}
