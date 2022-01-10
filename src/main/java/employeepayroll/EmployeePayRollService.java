package employeepayroll;

public class EmployeePayRollService {

	EmployeePayRollRepository respository = new EmployeePayRollRepository();

	public static void main(String[] args) {

		EmployeePayRollService service = new EmployeePayRollService();
		// service.retrieveData();
		// service.updateSalary("Terrisa", 3000000);
		service.updateSalaryUsingPreparedStatement("Lasya", 100000);
	}

	private void updateSalary(String name, int basic_pay) {

		respository.updateSalary(name.toLowerCase(), basic_pay);
	}

	private void updateSalaryUsingPreparedStatement(String name, int basic_pay) {

		respository.updateSalaryUsingPreparedStatement(name.toLowerCase(), basic_pay);
	}

	private void retrieveData() {

		System.out.println(respository.retrieveData());
	}

}
