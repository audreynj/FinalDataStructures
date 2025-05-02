/**
* @author Audrey Johnston
* @version 1.0
* @since 1.0
*/

package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.PriorityQueue;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import model.Employee;
import model.Shift;
import view.AssignShiftPanel.ButtonListener;

public class ViewAllShiftsPanel extends JPanel{

	private JButton updateViewButton = new JButton("Update Shifts");
	private JTextArea viewRemainingShiftsArea = new JTextArea(10, 70);
	private String viewRemainingShiftsAreaText = "";

	
	//Create allEmployees and allShifts
	private ArrayList<Employee> allEmployees;
	private PriorityQueue<Shift> allShifts;
		
	//Getter and Setters
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
	

	public ViewAllShiftsPanel(ArrayList<Employee> allEmployees, PriorityQueue<Shift> allShifts) {
		setAllEmployees(allEmployees);
		setAllShifts(allShifts);
		
		// Creates a ButtonListener
		ButtonListener bl = new ButtonListener();

		// Adds the ButtonListener to both JButtons
		updateViewButton.addActionListener(bl);

		
		//Use JScrollPane for JTextArea and setEditable(false)
		for(Shift selectedShift: allShifts) {
			viewRemainingShiftsAreaText += selectedShift.toString() + "\n";
		}
		
		viewRemainingShiftsArea.setText(viewRemainingShiftsAreaText);	
		viewRemainingShiftsArea.setEnabled(false);
		viewRemainingShiftsArea.setDisabledTextColor(Color.BLACK);
		

		
		JScrollPane scroll = new JScrollPane(viewRemainingShiftsArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		add(scroll);
		
		// Adds the buttons to the panel
		add(updateViewButton);

	}
		
	//Will add removeShift() later, might have button in this file
	class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == updateViewButton) 
			{
				viewRemainingShiftsAreaText = "";
				for(Shift selectedShift: allShifts) 
				{
					if(selectedShift.isShiftTaken() == false) {
					viewRemainingShiftsAreaText += selectedShift.toString() + "\n";
				}
				
				viewRemainingShiftsArea.setText(viewRemainingShiftsAreaText);	
				}
			}
		}
	}
}