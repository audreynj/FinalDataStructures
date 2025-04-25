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

public class ViewAllEmployeesPanel extends JPanel{

	//Will change this button
	private JButton updateViewButton = new JButton("Update Employees");

	//May change size
	private JTextArea viewEmployeesArea = new JTextArea(10, 70);

	
	private ArrayList<Employee> allEmployees;
	private PriorityQueue<Shift> allShifts;
	
	
	private String viewEmployeesAreaText = "";

	
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
		updateViewButton.addActionListener(bl);

		
		//Use JScrollPane for JTextArea and setEditable(false)
		SetTextArea();

		viewEmployeesArea.setEnabled(false);
		viewEmployeesArea.setDisabledTextColor(Color.BLACK);
		

		
		JScrollPane scroll = new JScrollPane(viewEmployeesArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		add(scroll);
		
		// Adds the buttons to the panel
		add(updateViewButton);

	}
		
	//This method uses Selection Sort
	public void SetTextArea() {
		viewEmployeesAreaText = "";

		for (int i = 0; i < allEmployees.size() - 1; i++) {
              
            // Find the minimum element in unsorted array
            int min_idx = i;
          
            for (int j = i + 1; j < allEmployees.size(); j++) {
                if (allEmployees.get(j).getId() < allEmployees.get(min_idx).getId())
                    min_idx = j;
            }

            // Swap the found minimum element with the first
            // element
            Employee temp = allEmployees.get(min_idx);
            allEmployees.set(min_idx, allEmployees.get(i));
            allEmployees.set(i, temp);
        }
		
		
		for(Employee selectedEmployee: allEmployees) {
			viewEmployeesAreaText += selectedEmployee.toString() + "\n";
		}
		
		viewEmployeesArea.setText(viewEmployeesAreaText);	
		
	}

		//Will add removeEmployee() later, might have button in this file
		class ButtonListener implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == updateViewButton) {
					SetTextArea();	
			}

		}
	
	}
}

