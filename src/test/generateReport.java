package test;

import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Comparator;

public class generateReport {
	
    private double calculateSum(Employee employee) {
        return employee.getHours() * employee.getHourlyRate() + employee.getFixedCost();
    }
    
	public void calculateValues(HashSet<Employee> employeeSet) {
		HashMap<String, Double> totalInHouseCostPerDay = new HashMap<>();
		HashMap<String, Double> totalOutsourceCostPerDay = new HashMap<>();
		ArrayList<Employee> inHouseRankingList = new ArrayList<>();
		ArrayList<Employee> outSourceRankingList = new ArrayList<>();
		
		for (Employee e : employeeSet) {
			double sumOfEmployee = (e.getHours() * e.getHourlyRate()) + e.getFixedCost();
			if (e.getType() == EmployeeType.I) {
				inHouseRankingList.add(e);
				totalInHouseCostPerDay.put(e.getDate(), 
						totalInHouseCostPerDay.getOrDefault(e.getDate(), (double)0) + sumOfEmployee);
			} else {
				outSourceRankingList.add(e);
				totalOutsourceCostPerDay.put(e.getDate(), 
						totalOutsourceCostPerDay.getOrDefault(e.getDate(), (double)0) + sumOfEmployee);
			}
		}
		
		inHouseRankingList.sort(Comparator.comparingDouble(this::calculateSum).reversed());
		outSourceRankingList.sort(Comparator.comparingDouble(this::calculateSum).reversed());
		
		System.out.println("Total cost for in-house employees for each day: ");
		for (Map.Entry<String, Double> entry : totalInHouseCostPerDay.entrySet()) {
			System.out.printf("%s: %.2f\n", entry.getKey(), entry.getValue());
		}
		System.out.println("\nTotal cost for outsource employees for each day: ");
		for (Map.Entry<String, Double> entry : totalOutsourceCostPerDay.entrySet()) {
			System.out.printf("%s: %.2f\n", entry.getKey(), entry.getValue());
		}
		System.out.println("\nRanking of in-house employees: ");
		for (Employee e : inHouseRankingList) {
			System.out.printf("Employee ID: %s\n", e.getId());
		}
		
		System.out.println("\nRanking of outsource employees: ");
		for (Employee e : outSourceRankingList) {
			System.out.printf("Employee ID: %s\n", e.getId());
		}
	}
}
