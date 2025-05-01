/**
* @author Audrey Johnston
* @version 1.0
* @since 1.0
*/

package driver;

import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.AssignShiftToEmployee;
import model.Employee;
import model.Shift;
import view.StartPanel;
import view.ProgramFrame;

public class StartProgram {
	
	public static void main(String[] args) {
	
	//Setting up Priority Queue for shifts and ArrayList for employees
	Shift shift1 = new Shift(1, "Monday", 1, 5, "High");
	Shift shift2 = new Shift(2, "Tuesday", 1, 4, "Important");
	Shift shift3 = new Shift(3, "Tuesday", 6, 8, "Low");
	Shift shift4 = new Shift(4, "Saturday", 1, 3, "Important");

	PriorityQueue<Shift> allAvailableAShifts = new PriorityQueue<Shift>();
	allAvailableAShifts.add(shift1);
	allAvailableAShifts.add(shift2);	
	allAvailableAShifts.add(shift3);
	allAvailableAShifts.add(shift4);
	
	
	Employee employee1 = new Employee(100, "Bobby", 10, new ArrayList<Integer>(Arrays.asList(1,10,4,6,0,0,0,0,0,0,0,0)));
	Employee employee2 = new Employee(101, "Jane", 10, new ArrayList<Integer>(Arrays.asList(1,10,0,0,0,0,0,0,0,0,0,0)));
	Employee employee3 = new Employee(210, "Debbie", 10, new ArrayList<Integer>(Arrays.asList(1,10,1,4,3,8,7,9,0,0,0,0)));
	Employee employee4 = new Employee(250, "Steve", 10, new ArrayList<Integer>(Arrays.asList(1,10,1,9,3,8,1,5,4,9,0,0)));
	Employee employee5 = new Employee(286, "John", 10, new ArrayList<Integer>(Arrays.asList(1,9,1,4,1,4,1,4,1,4,0,0)));

	
	
	ArrayList<Employee> allEmployees = new ArrayList<Employee>();
	allEmployees.add(employee1);
	allEmployees.add(employee2);
	allEmployees.add(employee3);
	allEmployees.add(employee4);
	allEmployees.add(employee5);	
	
	
	//Run ProgramFrame for the GUI
	new ProgramFrame(allEmployees, allAvailableAShifts);
	
	}
}