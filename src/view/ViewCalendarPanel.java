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

public class ViewCalendarPanel extends JPanel{

	
	//Display list with shifts per day with employee 
	
	//Will change this button
	private JButton startPanelButton = new JButton("View Calendar");
	
	//May change size
	private JTextArea calendarArea = new JTextArea(5, 50);
	
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

		
		
		//Use JScrollPane for JTextArea and setEditable(false)
		
		// Adds the buttons to the panel
		add(startPanelButton);
		
		calendarArea.setText("Hi");	

		calendarArea.setEnabled(false);
		calendarArea.setDisabledTextColor(Color.BLACK);
		

		
		JScrollPane scroll = new JScrollPane(calendarArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		add(scroll);

		
	
	}

	
		
	
	class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {


		}


	
	}
}

