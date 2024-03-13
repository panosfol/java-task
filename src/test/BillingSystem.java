package test;

import java.util.HashSet;

public class BillingSystem {
	public static void main(String[] args) {
		Employee e1 = new Employee("A11", EmployeeType.I, "27/12/2024", 15, 10, 10);
		Employee e2 = new Employee("A12", EmployeeType.I, "28/12/2024", 20, 23, 0);
		Employee e3 = new Employee("A13", EmployeeType.I, "28/12/2024", 32.5, 22.5, 5.7);
		Employee e4 = new Employee("A14", EmployeeType.O, "27/12/2024", 32, 9, 6);
		Employee e5 = new Employee("A15", EmployeeType.O, "29/12/2024", 37.5, 14, 20);
		Employee e6 = new Employee("A16", EmployeeType.O, "29/12/2024", 20, 12, 15);
		
		HashSet<Employee> employeeSet = new HashSet<>();
		employeeSet.add(e1);
		employeeSet.add(e2);
		employeeSet.add(e3);
		employeeSet.add(e4);
		employeeSet.add(e5);
		employeeSet.add(e6);
		
		generateReport report = new generateReport();
		report.calculateValues(employeeSet);

	}
}



