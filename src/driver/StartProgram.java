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
	
	//Setting up Priority Queue and ArrayList
	Shift shift1 = new Shift(1, "Monday", 1, 5, "High");
	Shift shift2 = new Shift(2, "Tuesday", 1, 4, "Important");
	Shift shift3 = new Shift(3, "Tuesday", 6, 8, "Low");

	PriorityQueue<Shift> allAvailableAShifts = new PriorityQueue<Shift>();
	allAvailableAShifts.add(shift1);
	allAvailableAShifts.add(shift2);	
	allAvailableAShifts.add(shift3);
	
	
	Employee employee1 = new Employee("Bob", 10, new ArrayList<Integer>(Arrays.asList(1,4,1,4,1,4,1,4,1,4,1,4)));
	Employee employee2 = new Employee("Jane", 10, new ArrayList<Integer>(Arrays.asList(2,4,0,3,0,0,0,0,0,0,0,0)));
		
	ArrayList<Employee> allEmployees = new ArrayList<Employee>();
	allEmployees.add(employee1);
	allEmployees.add(employee2);

	
	
	/**
	//Setting up GUI
	JFrame frame = new JFrame();
	JPanel allPanels = new JPanel(new CardLayout());

	StartPanel startPanel = new StartPanel(allEmployees, allAvailableAShifts);
	
	allPanels.add(startPanel, "1");

	// Sets the title, size, closing default, and visibility of the JFrame
	frame.setTitle("Assign Shift and Calendar");
	frame.setSize(500, 400);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setVisible(true);
	**/
	
	new ProgramFrame(allEmployees, allAvailableAShifts);
	
	
	}
	


}

