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
}

