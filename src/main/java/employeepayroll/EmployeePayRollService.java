package employeepayroll;


public class EmployeePayRollService {

	EmployeePayRollRepository respository = new EmployeePayRollRepository();
	
	public static void main(String[] args) {
		
		EmployeePayRollService service = new EmployeePayRollService();
		//service.retrieveData();
		service.updateSalary();
	}

	private void updateSalary() {
		
		
	}

	private void retrieveData() {
		
		System.out.println(respository.retrieveData());
	}

}
