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

public class AssignShiftPanel extends JPanel{
	//Create components for the panel
	private JButton assignButton = new JButton("Assign");
	private JButton clearButton = new JButton("Clear");
	private JButton updateViewButton = new JButton("Update Employees List");
	
	private JLabel viewSelectedShiftLabel = new JLabel();
	private JLabel assignLabel = new JLabel("Assign to Employee(Use ID): ");
	private String viewEligibleEmployeesAreaText = "";
	private JTextField employeeIdField;
	private JTextArea viewEligibleEmployeesArea = new JTextArea(10, 70);
	
	//Declare allEmployees, allShifts, and assigner
	private ArrayList<Employee> allEmployees;
	private PriorityQueue<Shift> allShifts;
	private AssignShiftToEmployee assigner = new AssignShiftToEmployee();

	//This shift will be the shift assigned to the employee
	private Shift selectedShiftToDisplay = new Shift();
	
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
	
	public AssignShiftPanel(ArrayList<Employee> allEmployees, PriorityQueue<Shift> allShifts) {
		//Set up allEmployees and allShifts
		setAllEmployees(allEmployees);
		setAllShifts(allShifts);
		
		// Creates a ButtonListener
		ButtonListener bl = new ButtonListener();
		
		// Adds the ButtonListener to all JButtons
		clearButton.addActionListener(bl);
		assignButton.addActionListener(bl);
		updateViewButton.addActionListener(bl);
		
		//Use JScrollPane for JTextArea and setEditable(false)
		setviewEligibleEmployeesAreaText();
		
		
		viewEligibleEmployeesArea.setEnabled(false);
		viewEligibleEmployeesArea.setDisabledTextColor(Color.BLACK);
		
		employeeIdField = new JTextField(16);
		
		JScrollPane scroll = new JScrollPane(viewEligibleEmployeesArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		add(scroll);
		
		
		// Adds the components to the panel by using GroupLayout
		GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        

        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        				.addComponent(viewSelectedShiftLabel))
        		.addGroup(layout.createSequentialGroup()
        				.addComponent(scroll))
        		.addGroup(layout.createSequentialGroup()
        				.addComponent(assignLabel)
            	        .addComponent(employeeIdField, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
				.addGroup(layout.createSequentialGroup()
        				.addComponent(assignButton)
        				.addComponent(clearButton)
        				.addComponent(updateViewButton)));
        
        layout.setVerticalGroup(layout.createSequentialGroup()
        		.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
        				.addComponent(viewSelectedShiftLabel))        		.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
        				.addComponent(scroll))
        		.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
        				.addComponent(assignLabel)
        				.addComponent(employeeIdField))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
        				.addComponent(assignButton)
        				.addComponent(clearButton)
        				.addComponent(updateViewButton)));
	}
		
	class ButtonListener implements ActionListener {
		//ButtonListener will assign a shift, update the employee list, or clear the input depending on the selected button
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == assignButton) {
				conditions:
				try {
					
					for(Employee selectedEmployee: allEmployees) {
						
						if(selectedEmployee.getId() == Integer.parseInt(employeeIdField.getText()))
						{
							assigner.assignShift(selectedEmployee, selectedShiftToDisplay, allShifts);
							clearInput();
							break conditions;
						}
					}
					JOptionPane.showMessageDialog(AssignShiftPanel.this, "Please Enter a Valid Employee ID",
	                           "ERROR", JOptionPane.ERROR_MESSAGE);
				} catch (Exception exception) {
					JOptionPane.showMessageDialog(AssignShiftPanel.this, "Please Enter a Valid Employee ID",
                           "ERROR", JOptionPane.ERROR_MESSAGE);
					clearInput();
				}
			}
			else if (e.getSource() == updateViewButton) {
				setviewEligibleEmployeesAreaText();	
			}
			else{
				clearInput();
			}
		}
	}
	
	/**
	 * This method will check for which employees to display by using assigner.determineEligibleEmployeesList method
	 */
	public void checkEmployeesForShift() {
		
		PriorityQueue<Shift> shifts = new PriorityQueue<>(allShifts);
		int shiftsSkipped = 0;
		
		selectedShiftToDisplay = null;
		for(int i = 0;i < allShifts.size(); i++) {
			if(shifts.peek().isShiftTaken() == false) {
				if (!assigner.determineEligibleEmployeesList(allEmployees, shifts.peek()).isEmpty()) {
					
					if(shiftsSkipped!=0) {
						JOptionPane.showMessageDialog(AssignShiftPanel.this, "IMPORTANT: Had to skip " + shiftsSkipped + " shifts because they could not be filled",
		                           "ERROR", JOptionPane.ERROR_MESSAGE);
					}
					selectedShiftToDisplay = shifts.peek();
					viewSelectedShiftLabel.setText("Shift to Fill: " + selectedShiftToDisplay.toString());
					break;
				}
				else {
					shiftsSkipped++;
					shifts.poll();
				}	
			}
			else {
				shifts.poll();
				}
		}
		
		if(selectedShiftToDisplay == null) {
		JOptionPane.showMessageDialog(AssignShiftPanel.this, "IMPORTANT: all of " + shiftsSkipped + " shifts can not be filled",
                "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}
		
	
	/**
	 * This method set the text for viewEligibleEmployeesArea based on the shift that is next to be filled
	 */
	public void setviewEligibleEmployeesAreaText() {
		viewEligibleEmployeesAreaText = ("");

		checkEmployeesForShift();
		
		if(selectedShiftToDisplay != null) {
			for(Employee selectedEmployee: assigner.determineEligibleEmployeesList(allEmployees, selectedShiftToDisplay)) {
				viewEligibleEmployeesAreaText += selectedEmployee.toString() + "\n";
			}
			
			viewEligibleEmployeesArea.setText(viewEligibleEmployeesAreaText);	
		}
	}
	
	
	/**
	 * This method will set the different components back to what they
	 * were when first run 
	 */
	public void clearInput() 
	{
		employeeIdField.setText("");
		
		//viewEligibleEmployeesArea.setText();
		if(allShifts.peek() != null) {
			setviewEligibleEmployeesAreaText();
		}
		else {
			viewEligibleEmployeesAreaText = ("");
			JOptionPane.showMessageDialog(AssignShiftPanel.this, "There are no more shifts to fill",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
			
		}
		
		viewEligibleEmployeesArea.setText(viewEligibleEmployeesAreaText);
		
	}
}