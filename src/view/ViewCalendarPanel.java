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
import view.AssignShiftPanel.ButtonListener;

public class ViewCalendarPanel extends JPanel{

	
	//Display list with shifts per day with employee 
	
	//Will change this button
	private JButton startPanelButton = new JButton("View Calendar");

	
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
	

	public ViewCalendarPanel(ArrayList<Employee> allEmployees, PriorityQueue<Shift> allShifts) {
		setAllEmployees(allEmployees);
		setAllShifts(allShifts);
		
		// Creates a ButtonListener
		ButtonListener bl = new ButtonListener();

		// Adds the ButtonListener to both JButtons
		startPanelButton.addActionListener(bl);

		
		// Adds the buttons to the panel
		add(startPanelButton);

	}
		
	
		class ButtonListener implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {


			}


	
	}
}

