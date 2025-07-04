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

public class RemoveShiftPanel extends JPanel{

	//Create components for the panel
	private JButton removeShiftButton = new JButton("Remove Shift");
	private JButton clearButton = new JButton("Clear");
	private JButton updateViewButton = new JButton("Update Shift List");

	private JLabel removeLabel = new JLabel("Remove Shift: ");
	private JTextField removeShiftField = new JTextField(8);
	
	private JTextArea viewShiftsArea = new JTextArea(10, 70);
	private String viewShiftsAreaText = "";
	
	//Declare allEmployees, allShifts, and assigner
	private ArrayList<Employee> allEmployees;
	private PriorityQueue<Shift> allShifts;
	private AssignShiftToEmployee assigner = new AssignShiftToEmployee();

	
	//Getter and Setter method
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
	
	public RemoveShiftPanel(ArrayList<Employee> allEmployees, PriorityQueue<Shift> allShifts) {
		//Set up allEmployees and allShifts
		setAllEmployees(allEmployees);
		setAllShifts(allShifts);
		
		// Creates a ButtonListener
		ButtonListener bl = new ButtonListener();

		// Adds the ButtonListener to both JButtons
		removeShiftButton.addActionListener(bl);
		clearButton.addActionListener(bl);
		updateViewButton.addActionListener(bl);

		
		//Use JScrollPane for JTextArea and setEditable(false)
		for(Shift selectedShift:allShifts) {
			if(!selectedShift.isShiftTaken()) {
				viewShiftsAreaText = viewShiftsAreaText + selectedShift.toString() + "\n";
			}
		}
		viewShiftsArea.setText(viewShiftsAreaText);	
		
		viewShiftsArea.setEnabled(false);
		viewShiftsArea.setDisabledTextColor(Color.BLACK);
				
		JScrollPane scroll = new JScrollPane(viewShiftsArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
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
        				.addComponent(removeShiftField, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
				.addGroup(layout.createSequentialGroup()
        				.addComponent(removeShiftButton)
        				.addComponent(clearButton)
						.addComponent(updateViewButton)));
				
        
        layout.setVerticalGroup(layout.createSequentialGroup()
        		.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
        				.addComponent(scroll))
        		.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(removeLabel)
						.addComponent(removeShiftField))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
        				.addComponent(removeShiftButton)
        				.addComponent(clearButton)
						.addComponent(updateViewButton)));
	}
	
	
	class ButtonListener implements ActionListener {

		//ButtonListener will remove a shift or clear the input
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == removeShiftButton) {
				conditions:
				try {
					for(Shift selectedShift: allShifts) {
						if(!selectedShift.isShiftTaken()) {
							if(selectedShift.getId() == Integer.parseInt(removeShiftField.getText()))
							{
								assigner.removeShift(selectedShift, allShifts);
								clearInput();
								break conditions;
							}
						}
					}
					JOptionPane.showMessageDialog(RemoveShiftPanel.this, "Please Enter a Valid Value", 
                            "ERROR", JOptionPane.ERROR_MESSAGE);
					clearInput();
											
				} catch (Exception exception) {
					JOptionPane.showMessageDialog(RemoveShiftPanel.this, "Please Enter a Valid Value", 
                            "ERROR", JOptionPane.ERROR_MESSAGE);
					clearInput();
				}
			}
			// If the clearButton was clicked it will call the clearFields method
			else{
				clearInput();
			}
		}	
	}
	
	/**
	 * This method will set the different components back to what they
	 * were when first run 
	 */
	public void clearInput() {
		removeShiftField.setText("");
		viewShiftsAreaText = ("");

		
		for(Shift selectedShift:allShifts) {
			if(!selectedShift.isShiftTaken()) {
				viewShiftsAreaText = viewShiftsAreaText + selectedShift.toString() + "\n";
			}
		}
		
		viewShiftsArea.setText(viewShiftsAreaText);	

		}

}

