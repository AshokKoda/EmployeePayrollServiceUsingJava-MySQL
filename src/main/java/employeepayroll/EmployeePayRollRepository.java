package employeepayroll;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeePayRollRepository {

	private Connection getConnection() {
		
		Connection connection = null;
		try {
			String URL = "jdbc:mysql://localhost:3306/emp_payroll_service";
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(URL, "root", "Koda@1996");
		} catch (Exception e) {
			System.out.println("Drivers not load.");
			System.out.println("Connection not established.");
		}
		return connection;
		
	}

	
}
