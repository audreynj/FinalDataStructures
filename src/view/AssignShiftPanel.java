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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.AssignShiftToEmployee;
import model.Employee;
import model.Shift;
import view.ViewAllEmployeesPanel.ButtonListener;

public class AssignShiftPanel extends JPanel{

	
	//Back button
	//List of employees
	//Place to enter employee id 
	//Confirm button
	
	//Will change this button
	private JButton assignButton = new JButton("Assign");
	private JButton clearButton = new JButton("Clear");
	
	private JLabel assignLabel = new JLabel("Assign to Employee(Use ID): ");
	
	private String viewEligibleEmployeesAreaText = "";
	private AssignShiftToEmployee assigner = new AssignShiftToEmployee();

	
	private JTextField employeeIdField;
	
	//May change size
	private JTextArea viewEligibleEmployeesArea = new JTextArea(10, 70);
	
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
	

	public AssignShiftPanel(ArrayList<Employee> allEmployees, PriorityQueue<Shift> allShifts) {
		setAllEmployees(allEmployees);
		setAllShifts(allShifts);
		
		// Creates a ButtonListener
		ButtonListener bl = new ButtonListener();
		clearButton.addActionListener(bl);

		
		// Adds the ButtonListener to both JButtons
		assignButton.addActionListener(bl);

		//Use JScrollPane for JTextArea and setEditable(false)
		for(Employee selectedEmployee: assigner.determineEligibleEmployeesList(allEmployees, allShifts.peek())) {
			viewEligibleEmployeesAreaText += selectedEmployee.toString() + "\n";
		}
		
		viewEligibleEmployeesArea.setText(viewEligibleEmployeesAreaText);	

		viewEligibleEmployeesArea.setEnabled(false);
		viewEligibleEmployeesArea.setDisabledTextColor(Color.BLACK);
		
		employeeIdField = new JTextField(16);


		
		JScrollPane scroll = new JScrollPane(viewEligibleEmployeesArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		add(scroll);
		
		
		// Adds the buttons to the panel
		add(assignButton);
		add(clearButton);
		add(assignLabel);
		add(employeeIdField);


	}
		
		class ButtonListener implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == assignButton) {
					try {
						
						for(Employee selectedEmployee: allEmployees) {
							if(selectedEmployee.getId() == Integer.parseInt(employeeIdField.getText())){
								assigner.assignShift(selectedEmployee, allShifts.peek(), allShifts);
							}
						}
						
						clearFields();
												
					} catch (Exception exception) {
						JOptionPane.showMessageDialog(AssignShiftPanel.this, "Please Enter a Valid Employee ID", 
                                "ERROR", JOptionPane.ERROR_MESSAGE);
						clearFields();
					}
				}
				// If the clearButton was clicked it will call the clearFields method
				else{
					clearFields();
				}
			}

	
	}
		
		
		public void clearFields() {
			employeeIdField.setText("");
			viewEligibleEmployeesAreaText = ("");
			
			//viewEligibleEmployeesArea.setText();
			
			for(Employee selectedEmployee: assigner.determineEligibleEmployeesList(allEmployees, allShifts.peek())) {
				viewEligibleEmployeesAreaText += selectedEmployee.toString() + "\n";
			}
			
			viewEligibleEmployeesArea.setText(viewEligibleEmployeesAreaText);
			}
	
}

