package test;

enum EmployeeType{
	I, //in house
	O // Outsource
}

public class Employee {
	private	final String id;
	private EmployeeType type;
	private String date;
	private double hours;
	private double hourlyRate;
	private double fixedCost;
	
	public Employee(String id, EmployeeType type, String date, double hours,
					double hourlyRate, double fixedCost) {
			this.id = id;
			this.type = type;
			this.date = date;
			this.hours = hours;
			this.hourlyRate = hourlyRate;
			this.fixedCost = fixedCost;
	}
	public String getId() {
		return this.id;
	}
	public EmployeeType getType() {
		return this.type;
	}
	public String getDate() {
		return this.date;
	}
	public double getHours() {
		return this.hours;
	}
	public double getHourlyRate() {
		return this.hourlyRate;
	}
	public double getFixedCost() {
		return this.fixedCost;
	}
}

