/**
* @author Audrey Johnston
* @version 1.0
* @since 1.0
*/

package view;

import java.awt.Color;
import java.util.ArrayList;
import java.util.PriorityQueue;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import model.Employee;
import model.Shift;

public class StartPanel extends JPanel{

	//Declare allEmployees and allShifts
	private ArrayList<Employee> allEmployees;
	private PriorityQueue<Shift> allShifts;
	
	//TextArea to display start message
	private JTextArea startPanelArea = new JTextArea(10, 70);
	
	//Getter and Setter
	public ArrayList<Employee> getAllEmployees() {
		return allEmployees;
	}
	public void setAllEmployees(ArrayList<Employee> allEmployees) {
		this.allEmployees = allEmployees;
	}
	public PriorityQueue<Shift> getAllShifts() {
		return allShifts;
	}
	public void setAllShifts(PriorityQueue<Shift> allShifts) {
		this.allShifts = allShifts;
	}

	
	public StartPanel(ArrayList<Employee> allEmployees, PriorityQueue<Shift> allShifts) {
		//Set up allEmployees and allShifts
		setAllEmployees(allEmployees);
		setAllShifts(allShifts);
		
		//Text and properties for startPanelArea
		startPanelArea.setText("This program is used to determine an employee for a shift."
				+ " \nThe inputted hours should be in military time, and a zero means you can not work at that time. \n"
				+ "This code is based on my current job, with 6 work days and shifts starting from 5 and ending at 11pm."
				+ "\n Select the tabs above to add or assign, delete or unassign, or view shifts and employees created. ");	
		startPanelArea.setEnabled(false);
		startPanelArea.setDisabledTextColor(Color.BLACK);
		
		//Add startPanelArea to panel
		add(startPanelArea);	
	}
}