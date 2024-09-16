package car.rentalsystem;

import java.sql.Connection;

public class Login {

	public static void main(String[] args) {
		 
<<<<<<< HEAD
		 DatabaseConnection.query(); // method calling without parameter
=======
		Connection connection = DatabaseConnection.getConnection(null, null, null, null, null);
>>>>>>> master
	
	}
  
}
