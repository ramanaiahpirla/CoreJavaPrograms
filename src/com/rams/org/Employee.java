package com.rams.org;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Employee {

	private static final AtomicInteger count = new AtomicInteger(0);

	private int id;
	private String name;
	private int age;
	private String gender;
	private String deptName;
	private double salary;
	private String address;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Employee(int id, String name, int age, String gender, String deptName, double salary, String address) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.deptName = deptName;
		this.salary = salary;
		this.address = address;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", deptName="
				+ deptName + ", salary=" + salary + ", address=" + address + "]";
	}

	public static void main(String[] args) {
		ArrayList<Employee> employeeList = new ArrayList<Employee>();
		employeeList
				.add(new Employee(count.incrementAndGet(), "Ram", 35, "Male", "Business Lending", 250000, "Hyderabad"));
		employeeList
				.add(new Employee(count.incrementAndGet(), "Raj", 32, "Male", "Business Lending", 240000, "Hyderabad"));
		employeeList.add(new Employee(count.incrementAndGet(), "Joe", 48, "Male", "Mortgages", 200000, "Sydney"));
		employeeList.add(
				new Employee(count.incrementAndGet(), "Frank", 45, "Male", "Business Lending", 285000, "Canberra"));
		employeeList.add(new Employee(count.incrementAndGet(), "Kim", 52, "Female", "CJE", 660000, "Adelaide"));
		employeeList.add(new Employee(count.incrementAndGet(), "Marshal", 47, "Male", "BAU", 885000, "Sydney"));
		employeeList.add(
				new Employee(count.incrementAndGet(), "Peter", 43, "Male", "Business Lending", 715000, "Melbourne"));
		employeeList.add(new Employee(count.incrementAndGet(), "Mary", 23, "Female", "Digital", 710000, "Sydney"));
		employeeList.add(
				new Employee(count.incrementAndGet(), "Josina", 27, "Female", "Business Lending", 515000, "Canberra"));

		// Find list of employees whose name starts with alphabet R

		List<Employee> nameStartsWithA = employeeList.stream().filter(e -> e.getName().startsWith("R"))
				.collect(Collectors.toList());
		System.out.println("Find list of employees whose name starts with alphabet R : " + nameStartsWithA);

		// Group The employee names By Department Names

		Map<String, List<String>> empByDeptNames = employeeList.stream().collect(Collectors
				.groupingBy(Employee::getDeptName, Collectors.mapping(Employee::getName, Collectors.toList())));
		System.out.println("Group The employee names By Department Names :" + empByDeptNames);

		// Group The employees By Department Names

		Map<String, List<Employee>> employeesByDeptNames = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getDeptName));
		System.out.println("Group The employees By Department Names :" + employeesByDeptNames);

		// Find the total count of employees using stream

		long countOfEmployees = employeeList.stream().count();
		System.out.println("Find the total count of employees using stream : " + countOfEmployees);

		// Find the max age of employees

		int age = employeeList.stream().mapToInt(Employee::getAge).max().getAsInt();
		System.out.println("Find the max age of employees : " + age);

		// Find the max age of employees

		Optional<Employee> empOptional = employeeList.stream().max(Comparator.comparing(Employee::getAge));
		System.out.println("Find the max age of employees:" + empOptional);

		// Find all department names

		Set<String> departmentNames = employeeList.stream().map(Employee::getDeptName).collect(Collectors.toSet());
		System.out.println("Find all department names : " + departmentNames);

		// Find the count of employee in each department

		Map<String, Long> countOfEmpInEachDept = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getDeptName, Collectors.counting()));
		System.out.println("Find the count of employee in each department :" + countOfEmpInEachDept);

		// Find the list of employees whose age is less than 30

		List<Employee> empAgeLessthan30 = employeeList.stream().filter(e -> e.getAge() < 30)
				.collect(Collectors.toList());
		System.out.println("Find the list of employees whose age is less than 30 : " + empAgeLessthan30);

		// Find the list of employees names whose age is less than 30

		List<String> empNamesAgeLessthan30 = employeeList.stream().filter(e -> e.getAge() < 30)
				.collect(Collectors.mapping(Employee::getName, Collectors.toList()));
		System.out.println("Find the list of employees names whose age is less than 30 :" + empNamesAgeLessthan30);

		// Find the list of employees whose age is in between 26 and 31

		List<Employee> empAgeBetween26And31 = employeeList.stream().filter(e -> e.getAge() > 26 && e.getAge() < 30)
				.collect(Collectors.toList());

		System.out.println("Find the list of employees whose age is in between 26 and 31 : " + empAgeBetween26And31);

		// Find the list of employees names whose age is in between 26 and 31

		List<String> empNamesAgeBetween26And31 = employeeList.stream().filter(e -> e.getAge() > 26 && e.getAge() < 30)
				.collect(Collectors.mapping(Employee::getName, Collectors.toList()));

		System.out.println(
				"Find the list of employees names whose age is in between 26 and 31:" + empNamesAgeBetween26And31);

		// Find the average age of male and female employee

		Map<String, Double> avgAgeofMaleAndFemale = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));
		System.out.println("Find the average age of male and female employee : " + avgAgeofMaleAndFemale);

		// Find the department who is having maximum number of employees

		Entry<String, Long> deptWitMaxNoOfEmps = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getDeptName, Collectors.counting())).entrySet().stream()
				.max(Map.Entry.comparingByValue()).get();

		System.out.println("Find the department who is having maximum number of employees : " + deptWitMaxNoOfEmps);

		// Find the Employees who stays in Sydney and sort them by their names

		List<Employee> empWhoBelongsToSydney = employeeList.stream().filter(e -> e.getAddress().equals("Sydney"))
				.sorted(Comparator.comparing(Employee::getName)).collect(Collectors.toList());

		System.out.println(
				"Find the Employee who stays in Sydney and sort them by their names : " + empWhoBelongsToSydney);

		// Find the Employees names who stays in Sydney and sort them by their names
		List<String> empNamesBasedonLocation = employeeList.stream().filter(e -> e.getAddress().equals("Sydney"))
				.sorted(Comparator.comparing(Employee::getName))
				.collect(Collectors.mapping(Employee::getName, Collectors.toList()));

		System.out.println("Find the Employee names who stays in Sydney and sort them by their names : "
				+ empNamesBasedonLocation);

		// Find the average salary in all departments

		Map<String, Double> avgSalInAllDept = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getDeptName, Collectors.averagingDouble(Employee::getSalary)));

		System.out.println("Find the average salary in all departments : " + avgSalInAllDept);

		// Find the highest salary in each department

		Map<String, Optional<Employee>> highSalInEachDept = employeeList.stream().collect(Collectors
				.groupingBy(Employee::getDeptName, Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))));
		
		System.out.println("Find the highest salary in each department : " + highSalInEachDept);
		
		
		// Find the list of employee and sort them by their salary
		
		
	}

}
