package employeepayroll;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteEmployee {

	public static void main(String[] args) throws SQLException {
		
		Connection connection = null;

		try {
			connection = new EmployeePayRollRepository().getConnection();
			connection.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			String query = "delete from employee where id = ?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, 13); //Index no and phone no
			int rowCount = ps.executeUpdate();
			System.out.println("Record Deleted successfully." + "Total Count: " + rowCount);
		} catch (Exception e) {
			System.out.println("Exception" + e.getMessage());
		}
		
		try {
			connection.commit();
		} finally {
			connection.close();
		}

	}

}
