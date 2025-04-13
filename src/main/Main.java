/**
* @author Audrey Johnston
* @version 1.0
* @since 1.0
*/

package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

import model.AssignShiftToEmployee;
import model.Employee;
import model.Shift;

public class Main {
	
	public static void main(String[] args) {
		
	Shift shift1 = new Shift(1, "Monday", 1, 5, "High");
	
	Shift shift2 = new Shift(2, "Tuesday", 1, 4, "Important");

	Shift shift3 = new Shift(3, "Tuesday", 6, 8, "Low");

	
	ArrayList<Employee> allEmployees = new ArrayList<Employee>();

	
	Employee employee1 = new Employee("Bob", 10, new ArrayList<Integer>(Arrays.asList(1,4,1,4,1,4,1,4,1,4,1,4)));
	allEmployees.add(employee1);
	Employee employee2 = new Employee("Jane", 10, new ArrayList<Integer>(Arrays.asList(2,4,0,3,0,0,0,0,0,0,0,0)));
	allEmployees.add(employee2);
	
	AssignShiftToEmployee assigner = new AssignShiftToEmployee();

	Shift selectedShift = shift3;
	
	
	//Need to add a method that calls this with a list of all employees
	ArrayList<Employee> eligibleEmployees = assigner.determineEligibleEmployeesList(allEmployees, selectedShift);
	
	for(Employee selectedEmployee: eligibleEmployees) {
		System.out.println(selectedEmployee.getName());
		
	}

	
	//Will move this later
	PriorityQueue<Shift> allShifts = new PriorityQueue<Shift>();
	allShifts.add(shift1);
	allShifts.add(shift2);	
	allShifts.add(shift3);
	}
}

