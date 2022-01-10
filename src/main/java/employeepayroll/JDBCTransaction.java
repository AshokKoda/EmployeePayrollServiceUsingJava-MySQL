package employeepayroll;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTransaction {

	public static void main(String[] args) throws SQLException {

		Connection connection = null;

		try {
			connection = new EmployeePayRollRepository().getConnection();
			connection.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// For Employee
		int empId = 0; // local variable
		try (Statement st = connection.createStatement()) {
			String query = String.format(
					"insert into employee(name,gender,phoneno,address,startDate)" + "values ('%s','%s','%s','%s','%s')",
					"Test7", "F", "1234567890", "Address", Date.valueOf("2021-01-09"));
			int rowsAffected = st.executeUpdate(query, st.RETURN_GENERATED_KEYS);

			if (rowsAffected == 1) {
				System.out.println("Employee Data added.");
				System.out.println(st.getGeneratedKeys());
				ResultSet rs = st.getGeneratedKeys();

				if (rs.next()) {
					// System.out.println(rs.getInt(1));
					empId = rs.getInt(1);
				}
			}
			System.out.println(empId);
		} catch (SQLException e) {
			System.out.println(e);
			connection.rollback();
		}

		// For Pay roll
		int basic_pay = 50000;
		try (Statement st = connection.createStatement()) {
			int deduction = (int) (basic_pay * 2.0);
			int taxable_pay = basic_pay - deduction;
			int income_tax = (int) (taxable_pay * 0.1);
			int net_pay = basic_pay - income_tax;

			String query = String.format(
					"insert into payroll(basic_pay,deduction,income_tax,taxable_pay,net_pay,emp_id)"
							+ "values (%d,%d,%d,%d,%d,%d)",
					basic_pay, deduction, income_tax, taxable_pay, net_pay, empId);

			int rowsAffected = st.executeUpdate(query);
			if (rowsAffected >= 1) {
				System.out.println("Payroll data added.");
			}

		} catch (SQLException e) {
			System.out.println("Exception" + e.getMessage());
			connection.rollback();
		} catch (Exception e) {
			System.out.println("Exception" + e.getMessage());
			connection.rollback();
		}
		

		try {
			connection.commit();
		} finally {
			connection.close();
		}
	}
}
