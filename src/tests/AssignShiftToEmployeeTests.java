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

import org.junit.jupiter.api.Test;

import model.AssignShiftToEmployee;
import model.Employee;
import model.Shift;

/**
 * 
 */
class AssignShiftToEmployeeTests {

	@Test
	void notAvailableDay() {
		//ARRANGE
		Employee testEmployee = new Employee("Steve", 15, new ArrayList<Integer>(Arrays.asList(0,0,1,5,1,5,0,0,0,0,0,0)));
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
	void availableDayNotHours() {
		//ARRANGE
		Employee testEmployee = new Employee("Steve", 15, new ArrayList<Integer>(Arrays.asList(6,8,1,5,1,5,0,0,0,0,0,0)));
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
	void availableDayNotAllHours() {
		//ARRANGE
		Employee testEmployee = new Employee("Steve", 15, new ArrayList<Integer>(Arrays.asList(2,3,1,5,1,5,0,0,0,0,0,0)));
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
	void availableExactHours() {
		//ARRANGE
		Employee testEmployee = new Employee("Steve", 15, new ArrayList<Integer>(Arrays.asList(1,5,1,5,1,5,0,0,0,0,0,0)));
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
	void availableInTimeFrame() {
		//ARRANGE
		Employee testEmployee = new Employee("Steve", 15, new ArrayList<Integer>(Arrays.asList(1,5,1,5,1,5,0,0,0,0,0,0)));
		Shift testShift = new Shift(1, "Monday", 3, 4, "High");
		AssignShiftToEmployee assigner = new AssignShiftToEmployee();
		boolean actual, expected;
		
		//ACT
		actual = assigner.ifEmployeeWork(testShift, testEmployee);
	    expected = true;
		
		//ASSERT
		assertEquals(expected, actual);
	}
}

