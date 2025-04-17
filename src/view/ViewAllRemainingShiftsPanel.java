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

public class ViewAllRemainingShiftsPanel extends JPanel{

	//Show list of shifts that have not been taken yet
	//Back buttons
	
	//Will change this button
	private JButton startPanelButton = new JButton("View Shifts");

	
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
	

	public ViewAllRemainingShiftsPanel(ArrayList<Employee> allEmployees, PriorityQueue<Shift> allShifts) {
		setAllEmployees(allEmployees);
		setAllShifts(allShifts);
		
		// Creates a ButtonListener
		ButtonListener bl = new ButtonListener();

		// Adds the ButtonListener to both JButtons
		startPanelButton.addActionListener(bl);

		
		// Adds the buttons to the panel
		add(startPanelButton);

	}
		
	//Will add removeShift() later, might have button in this file
		class ButtonListener implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {


			}

	
	}
}

