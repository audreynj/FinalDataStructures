/**
* @author Audrey Johnston
* @version 1.0
* @since 1.0
*/

package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.PriorityQueue;

import javax.swing.JButton;
import javax.swing.JPanel;

import model.Employee;
import model.Shift;

public class ViewAllEmployeesPanel extends JPanel{

	//Will change this button
	private JButton startPanelButton = new JButton("View Employees");

	
	private ArrayList<Employee> allEmployees;
	private PriorityQueue<Shift> allShifts;
	
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
	
	
	
	//Show list of employees
	//Back buttons
	//Button and textbox to remove an employee
	public ViewAllEmployeesPanel(ArrayList<Employee> allEmployees, PriorityQueue<Shift> allShifts) {
		setAllEmployees(allEmployees);
		setAllShifts(allShifts);
		
		// Creates a ButtonListener
		ButtonListener bl = new ButtonListener();

		// Adds the ButtonListener to both JButtons
		startPanelButton.addActionListener(bl);

		
		// Adds the buttons to the panel
		add(startPanelButton);

	}
		
	//Will add removeEmployee() later, might have button in this file
		class ButtonListener implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {

			}


	
	}
}

