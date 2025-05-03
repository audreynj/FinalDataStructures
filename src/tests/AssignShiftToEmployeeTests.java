/**
* @author Audrey Johnston
* @version 1.0
* @since 1.0
*/

/**
 * 
 */
package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

import org.junit.jupiter.api.Test;

import model.AssignShiftToEmployee;
import model.Employee;
import model.Shift;

/**
 * 
 */
class AssignShiftToEmployeeTests {

	@Test
	void testNotAvailableDay() {
		//ARRANGE
		Employee testEmployee = new Employee(1, "Steve", 15, new ArrayList<Integer>(Arrays.asList(0,0,1,5,1,5,0,0,0,0,0,0)));
		Shift testShift = new Shift(1, "Monday", 1, 5, "High");
		AssignShiftToEmployee assigner = new AssignShiftToEmployee();
		boolean actual, expected;
		
		//ACT
		actual = assigner.ifEmployeeWork(testShift, testEmployee);
	    expected = false;
		
		//ASSERT
		assertEquals(expected, actual);
	}
	
	
	@Test
	void testAvailableDayNotHours() {
		//ARRANGE
		Employee testEmployee = new Employee(1, "Steve", 15, new ArrayList<Integer>(Arrays.asList(6,8,1,5,1,5,0,0,0,0,0,0)));
		Shift testShift = new Shift(1, "Monday", 1, 5, "High");
		AssignShiftToEmployee assigner = new AssignShiftToEmployee();
		boolean actual, expected;
		
		//ACT
		actual = assigner.ifEmployeeWork(testShift, testEmployee);
	    expected = false;
		
		//ASSERT
		assertEquals(expected, actual);
	}
	@Test
	void testAvailableDayNotAllHours() {
		//ARRANGE
		Employee testEmployee = new Employee(1, "Steve", 15, new ArrayList<Integer>(Arrays.asList(2,3,1,5,1,5,0,0,0,0,0,0)));
		Shift testShift = new Shift(1, "Monday", 1, 5, "High");
		AssignShiftToEmployee assigner = new AssignShiftToEmployee();
		boolean actual, expected;
		
		//ACT
		actual = assigner.ifEmployeeWork(testShift, testEmployee);
	    expected = false;
		
		//ASSERT
		assertEquals(expected, actual);
	}
	
	
	@Test
	void testAvailableExactHours() {
		//ARRANGE
		Employee testEmployee = new Employee(1, "Steve", 15, new ArrayList<Integer>(Arrays.asList(1,5,1,5,1,5,0,0,0,0,0,0)));
		Shift testShift = new Shift(1, "Monday", 1, 5, "High");
		AssignShiftToEmployee assigner = new AssignShiftToEmployee();
		boolean actual, expected;
		
		//ACT
		actual = assigner.ifEmployeeWork(testShift, testEmployee);
	    expected = true;
		
		//ASSERT
		assertEquals(expected, actual);
	}

	
	@Test
	void testAvailableInTimeFrame() {
		//ARRANGE
		Employee testEmployee = new Employee(1, "Steve", 15, new ArrayList<Integer>(Arrays.asList(1,5,1,5,1,5,0,0,0,0,0,0)));
		Shift testShift = new Shift(1, "Monday", 3, 4, "High");
		AssignShiftToEmployee assigner = new AssignShiftToEmployee();
		boolean actual, expected;
		
		//ACT
		actual = assigner.ifEmployeeWork(testShift, testEmployee);
	    expected = true;
		
		//ASSERT
		assertEquals(expected, actual);
	}
	
	
	@Test
	void testShiftsOverlap() {
		//ARRANGE
		Employee testEmployee = new Employee(1, "Steve", 15, new ArrayList<Integer>(Arrays.asList(1,5,1,5,1,5,0,0,0,0,0,0)));
		Shift testShift1 = new Shift(1, "Monday", 3, 4, "High");
		Shift testShift2 = new Shift(2, "Monday", 2, 6, "Low");

		AssignShiftToEmployee assigner = new AssignShiftToEmployee();
		boolean actual, expected;
		
		PriorityQueue<Shift> allTestShifts = new PriorityQueue<Shift>();
		allTestShifts.add(testShift1);

		
		assigner.assignShift(testEmployee, testShift1, allTestShifts);
	
		//ACT
		actual = assigner.ifEmployeeWork(testShift2, testEmployee);
	    expected = false;
		
		//ASSERT
		assertEquals(expected, actual);
	}
	
	
	@Test
	void testShiftsNotOverlap() {
		//ARRANGE
		Employee testEmployee = new Employee(1, "Steve", 15, new ArrayList<Integer>(Arrays.asList(1,6,1,6,1,6,0,0,0,0,0,0)));
		Shift testShift1 = new Shift(1, "Monday", 3, 4, "High");
		Shift testShift2 = new Shift(2, "Monday", 5, 6, "Low");

		AssignShiftToEmployee assigner = new AssignShiftToEmployee();
		boolean actual, expected;
		
		PriorityQueue<Shift> allTestShifts = new PriorityQueue<Shift>();
		allTestShifts.add(testShift1);

		
		assigner.assignShift(testEmployee, testShift1, allTestShifts);
	
		//ACT
		actual = assigner.ifEmployeeWork(testShift2, testEmployee);
	    expected = true;
		
		//ASSERT
		assertEquals(expected, actual);
	}
	
	
	@Test
	void testAssignShifts() {
		//ARRANGE
		Employee testEmployee = new Employee(1, "Steve", 15, new ArrayList<Integer>(Arrays.asList(1,5,1,5,1,5,0,0,0,0,0,0)));
		Shift testShift1 = new Shift(1, "Monday", 3, 4, "High");
		Shift testShift2 = new Shift(2, "Tuesday", 7, 9, "Low");

		AssignShiftToEmployee assigner = new AssignShiftToEmployee();
		String actual, expected;
		
		PriorityQueue<Shift> allTestShifts = new PriorityQueue<Shift>();
		allTestShifts.add(testShift1);
		allTestShifts.add(testShift2);

		assigner.assignShift(testEmployee, testShift1, allTestShifts);
		assigner.assignShift(testEmployee, testShift2, allTestShifts);
		
		//ACT
		actual = testEmployee.getShiftsTakenMessage();
	    expected = "Id: 1, Day: Monday, Start Time: 3, End Time: 4 -- Id: 2, Day: Tuesday, Start Time: 7, End Time: 9 -- ";
		
		//ASSERT
		assertEquals(expected, actual);
	}
	
	
	@Test
	void testSortByTimeNoShiftTaken() {
		//ARRANGE
		Shift shift1 = new Shift(1, "Monday", 1, 5, "High");
		Shift shift2 = new Shift(2, "Tuesday", 1, 4, "Important");
		Shift shift3 = new Shift(3, "Tuesday", 6, 8, "Low");
		Shift shift4 = new Shift(4, "Monday", 1, 3, "Important");

		PriorityQueue<Shift> allAvailableAShifts = new PriorityQueue<Shift>();
		allAvailableAShifts.add(shift1);
		allAvailableAShifts.add(shift2);	
		allAvailableAShifts.add(shift3);
		allAvailableAShifts.add(shift4);
		
		Employee employee1 = new Employee(100, "Bobby", 10, new ArrayList<Integer>(Arrays.asList(1,10,4,6,0,0,0,0,0,0,0,0)));
		Employee employee2 = new Employee(101, "Jane", 10, new ArrayList<Integer>(Arrays.asList(1,10,0,0,0,0,0,0,0,0,0,0)));
		Employee employee3 = new Employee(210, "Debbie", 10, new ArrayList<Integer>(Arrays.asList(1,10,1,4,3,8,7,9,0,0,0,0)));
		Employee employee4 = new Employee(250, "Steve", 10, new ArrayList<Integer>(Arrays.asList(1,10,1,9,3,8,1,5,4,9,0,0)));
		Employee employee5 = new Employee(286, "John", 10, new ArrayList<Integer>(Arrays.asList(1,9,1,4,1,4,1,4,1,4,1,4)));
		
		ArrayList<Employee> allEmployees = new ArrayList<Employee>();
		allEmployees.add(employee1);
		allEmployees.add(employee2);
		allEmployees.add(employee3);
		allEmployees.add(employee4);
		allEmployees.add(employee5);	
		
		AssignShiftToEmployee assigner = new AssignShiftToEmployee();
		

		//ACT
		ArrayList<Employee> actual = assigner.sortByTime(shift4, assigner.determineEligibleEmployeesList(allEmployees, shift4));
		ArrayList<Employee> expected = new ArrayList<Employee>();
		
		expected.add(employee2);
		expected.add(employee1);
		expected.add(employee3);
		expected.add(employee4);
		expected.add(employee5);
		
		//ASSERT
		assertEquals(expected, actual);
	}

	
	@Test
	void testSortByTimeOneShiftTaken() {
		//ARRANGE
		Shift shift1 = new Shift(1, "Monday", 1, 5, "High");
		Shift shift2 = new Shift(2, "Tuesday", 1, 4, "Important");
		Shift shift3 = new Shift(3, "Tuesday", 6, 8, "Low");
		Shift shift4 = new Shift(4, "Monday", 1, 3, "Important");

		PriorityQueue<Shift> allAvailableAShifts = new PriorityQueue<Shift>();
		allAvailableAShifts.add(shift1);
		allAvailableAShifts.add(shift2);	
		allAvailableAShifts.add(shift3);
		allAvailableAShifts.add(shift4);
		
		Employee employee1 = new Employee(100, "Bobby", 10, new ArrayList<Integer>(Arrays.asList(1,10,4,6,0,0,0,0,0,0,0,0)));
		Employee employee2 = new Employee(101, "Jane", 10, new ArrayList<Integer>(Arrays.asList(1,10,0,0,0,0,0,0,0,0,0,0)));
		Employee employee3 = new Employee(210, "Debbie", 10, new ArrayList<Integer>(Arrays.asList(1,10,1,4,3,8,7,9,0,0,0,0)));
		Employee employee4 = new Employee(250, "Steve", 10, new ArrayList<Integer>(Arrays.asList(1,10,1,9,3,8,1,5,4,9,0,0)));
		Employee employee5 = new Employee(286, "John", 10, new ArrayList<Integer>(Arrays.asList(1,9,1,4,1,4,1,4,1,4,1,4)));
		
		ArrayList<Employee> allEmployees = new ArrayList<Employee>();
		allEmployees.add(employee1);
		allEmployees.add(employee2);
		allEmployees.add(employee3);
		allEmployees.add(employee4);
		allEmployees.add(employee5);	
		
		AssignShiftToEmployee assigner = new AssignShiftToEmployee();
		
		assigner.assignShift(employee4, shift3, allAvailableAShifts);


		//ACT
		ArrayList<Employee> actual = assigner.sortByTime(shift4, assigner.determineEligibleEmployeesList(allEmployees, shift4));
		ArrayList<Employee> expected = new ArrayList<Employee>();
		
		expected.add(employee2);
		expected.add(employee1);
		expected.add(employee3);
		expected.add(employee5);
		expected.add(employee4);
				
		//ASSERT
		assertEquals(expected, actual);
	}
	
	@Test
	void testUnassignShift() {
		//ARRANGE
		Employee testEmployee = new Employee(1, "Steve", 15, new ArrayList<Integer>(Arrays.asList(1,5,1,5,1,5,0,0,0,0,0,0)));
		Shift testShift1 = new Shift(1, "Monday", 3, 4, "High");
		Shift testShift2 = new Shift(2, "Tuesday", 7, 9, "Low");

		AssignShiftToEmployee assigner = new AssignShiftToEmployee();
		String actual, expected;
		
		PriorityQueue<Shift> allTestShifts = new PriorityQueue<Shift>();
		allTestShifts.add(testShift1);
		allTestShifts.add(testShift2);
		
		ArrayList<Employee> allEmployees = new ArrayList<Employee>();
		allEmployees.add(testEmployee);

		assigner.assignShift(testEmployee, testShift1, allTestShifts);
		assigner.assignShift(testEmployee, testShift2, allTestShifts);
		
		assigner.unassignShift(testShift1, allEmployees);
		
		//ACT
		actual = testEmployee.getShiftsTakenMessage();
	    expected = "Id: 2, Day: Tuesday, Start Time: 7, End Time: 9 -- ";
		
		//ASSERT
		assertEquals(expected, actual);
	}
	
	
	@Test
	void testRemoveShift() {
		//ARRANGE
		Shift testShift1 = new Shift(1, "Monday", 1, 5, "Important");
		Shift testShift2 = new Shift(2, "Tuesday", 1, 4, "Important");
		Shift testShift3 = new Shift(3, "Tuesday", 6, 8, "Important");
		Shift testShift4 = new Shift(4, "Monday", 1, 3, "Important");

		AssignShiftToEmployee assigner = new AssignShiftToEmployee();
		String actual = "", expected = "";
		
		PriorityQueue<Shift> allTestShifts = new PriorityQueue<Shift>();
		allTestShifts.add(testShift1);
		allTestShifts.add(testShift2);
		allTestShifts.add(testShift3);
		allTestShifts.add(testShift4);

		
		assigner.removeShift(testShift3,allTestShifts);
		
		
		//ACT
		for(Shift selectedShift: allTestShifts) {
			actual = actual + selectedShift.getId() + " -- ";

		}

	    expected = "1 -- 2 -- 4 -- ";
		
		//ASSERT
		assertEquals(expected, actual);
	}
	
	
	
	@Test
	void testRemoveEmployee() {
		//ARRANGE
		AssignShiftToEmployee assigner = new AssignShiftToEmployee();
		String actual = "", expected = "";
		
		Employee employee1 = new Employee(100, "Bobby", 10, new ArrayList<Integer>(Arrays.asList(1,10,4,6,0,0,0,0,0,0,0,0)));
		Employee employee2 = new Employee(101, "Jane", 10, new ArrayList<Integer>(Arrays.asList(1,10,0,0,0,0,0,0,0,0,0,0)));
		Employee employee3 = new Employee(210, "Debbie", 10, new ArrayList<Integer>(Arrays.asList(1,10,1,4,3,8,7,9,0,0,0,0)));
		Employee employee4 = new Employee(250, "Steve", 10, new ArrayList<Integer>(Arrays.asList(1,10,1,9,3,8,1,5,4,9,0,0)));
		Employee employee5 = new Employee(286, "John", 10, new ArrayList<Integer>(Arrays.asList(1,9,1,4,1,4,1,4,1,4,1,4)));
		
		ArrayList<Employee> allEmployees = new ArrayList<Employee>();
		allEmployees.add(employee1);
		allEmployees.add(employee2);
		allEmployees.add(employee3);
		allEmployees.add(employee4);
		allEmployees.add(employee5);	
		
		assigner.removeEmployee(employee4,allEmployees);
		
		
		//ACT
		for(Employee selectedEmployee: allEmployees) {
			actual = actual + selectedEmployee.getId() + " -- ";

		}

	    expected = "100 -- 101 -- 210 -- 286 -- ";
		
		//ASSERT
		assertEquals(expected, actual);
	}
	
}