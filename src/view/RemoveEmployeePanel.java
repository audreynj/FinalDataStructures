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

import javax.swing.GroupLayout;
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
import view.RemoveShiftPanel.ButtonListener;

public class RemoveEmployeePanel extends JPanel{
	//Create components for the panel
	private JButton removeEmployeeButton = new JButton("Remove employee");
	private JButton clearButton = new JButton("Clear");
	private JButton updateViewButton = new JButton("Update Employee List");

	private JLabel removeLabel = new JLabel("Remove Employee: ");
	private JTextField removeEmployeeField = new JTextField(8);
	
	private JTextArea viewEmployeesArea = new JTextArea(10, 70);
	private String viewEmployeesAreaText = "";
	
	//Declare allEmployees, allShifts, and assigner
	private ArrayList<Employee> allEmployees;
	private PriorityQueue<Shift> allShifts;
	private AssignShiftToEmployee assigner = new AssignShiftToEmployee();

	//Getter and Setter methods
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
	
	public RemoveEmployeePanel(ArrayList<Employee> allEmployees, PriorityQueue<Shift> allShifts) {
		setAllEmployees(allEmployees);
		setAllShifts(allShifts);
		
		// Creates a ButtonListener
		ButtonListener bl = new ButtonListener();

		// Adds the ButtonListener to both JButtons
		removeEmployeeButton.addActionListener(bl);
		clearButton.addActionListener(bl);
		updateViewButton.addActionListener(bl);

		
		for(Employee selectedEmployee:allEmployees) {
			viewEmployeesAreaText = viewEmployeesAreaText + selectedEmployee.toString() + "\n";
		}
		viewEmployeesArea.setText(viewEmployeesAreaText);	
		
		viewEmployeesArea.setEnabled(false);
		viewEmployeesArea.setDisabledTextColor(Color.BLACK);
				
		JScrollPane scroll = new JScrollPane(viewEmployeesArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		add(scroll);
		
		// Adds the components to the panel by using GroupLayout
		GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
		
		
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        				.addComponent(scroll))
        		.addGroup(layout.createSequentialGroup()
        				.addComponent(removeLabel)
        				.addComponent(removeEmployeeField, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
				.addGroup(layout.createSequentialGroup()
        				.addComponent(removeEmployeeButton)
        				.addComponent(clearButton)
						.addComponent(updateViewButton)));
				
        
        layout.setVerticalGroup(layout.createSequentialGroup()
        		.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
        				.addComponent(scroll))
        		.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(removeLabel)
						.addComponent(removeEmployeeField))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
        				.addComponent(removeEmployeeButton)
        				.addComponent(clearButton)
						.addComponent(updateViewButton)));
		
	}
	
	
	class ButtonListener implements ActionListener {
		
		//ButtonListener will remove an employee or clear the input
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == removeEmployeeButton) {
				conditions:
				try {
					for(Employee selectedEmployee: allEmployees) {
						if(selectedEmployee.getId() == Integer.parseInt(removeEmployeeField.getText()))
						{
							assigner.removeEmployee(selectedEmployee, allEmployees);
							clearInput();
							break conditions;
						}
					}
					JOptionPane.showMessageDialog(RemoveEmployeePanel.this, "Please Enter a Valid Value", 
                            "ERROR", JOptionPane.ERROR_MESSAGE);
					clearInput();
											
				} catch (Exception exception) {
					JOptionPane.showMessageDialog(RemoveEmployeePanel.this, "Please Enter a Valid Value", 
                            "ERROR", JOptionPane.ERROR_MESSAGE);
					clearInput();
				}
			}
			// If the clearButton was clicked it will call the clearFields method
			else {
				clearInput();
			}
		}	
	}
	
	/**
	 * This method will set the different components back to what they
	 * were when first run 
	 */
	public void clearInput() {
		removeEmployeeField.setText("");
		viewEmployeesAreaText = ("");

		
		for(Employee selectedEmployee:allEmployees) {
			viewEmployeesAreaText = viewEmployeesAreaText + selectedEmployee.toString() + "\n";
		}
		
		viewEmployeesArea.setText(viewEmployeesAreaText);	

	}
}