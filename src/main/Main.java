/**
* @author Audrey Johnston
* @version 1.0
* @since 1.0
*/

package main;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	
	public static void main(String[] args) {
		
	Shift shift1 = new Shift(1, "Monday", 1, 5, "High");
	
	Shift shift2 = new Shift(2, "Tuesday", 1, 4, "High");

	
	ArrayList<Employee> allEmployees = new ArrayList<Employee>();

	
	Employee employee1 = new Employee("Bob", 10, new ArrayList<Integer>(Arrays.asList(1,4,1,4,1,4,1,4,1,4,1,4)));
	allEmployees.add(employee1);
	Employee employee2 = new Employee("Jane", 10, new ArrayList<Integer>(Arrays.asList(1,4,0,0,0,0,0,0,0,0,0,0)));
	allEmployees.add(employee2);
	
	AssignShiftToEmployee assigner = new AssignShiftToEmployee();

	Shift selectedShift = shift2;
	
	
	//Need to add a method that calls this with a list of all employees
	assigner.determineEligibleEmployees(allEmployees, selectedShift);
	
	}
}

