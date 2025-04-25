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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import model.Employee;
import model.Shift;

public class StartPanel extends JPanel{

	private ArrayList<Employee> allEmployees;
	private PriorityQueue<Shift> allShifts;
	
	private JTextArea startPanelArea = new JTextArea(10, 70);
	
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

	
	//Needs buttons for them all
	public StartPanel(ArrayList<Employee> allEmployees, PriorityQueue<Shift> allShifts) {

		setAllEmployees(allEmployees);
		setAllShifts(allShifts);
		
		
		startPanelArea.setText("This is the first page");	

		startPanelArea.setEnabled(false);
		startPanelArea.setDisabledTextColor(Color.BLACK);
		
		
		add(startPanelArea);
		
	}

}

