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

public class UnassignShiftPanel extends JPanel{
	private JButton removeShiftButton = new JButton("Unassign Shift");
	private JButton clearButton = new JButton("Clear");
	private JButton updateViewButton = new JButton("Update Shift List");


	private JLabel removeLabel = new JLabel("Remove Shift: ");
	private JTextField removeShiftField = new JTextField(8);

	
	private JTextArea viewShiftsArea = new JTextArea(10, 70);
	private String viewShiftsAreaText = "";
	
	private AssignShiftToEmployee assigner = new AssignShiftToEmployee();

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
	
	public UnassignShiftPanel(ArrayList<Employee> allEmployees, PriorityQueue<Shift> allShifts) {
		setAllEmployees(allEmployees);
		setAllShifts(allShifts);
		
		// Creates a ButtonListener
		ButtonListener bl = new ButtonListener();

		// Adds the ButtonListener to both JButtons
		removeShiftButton.addActionListener(bl);
		clearButton.addActionListener(bl);
		updateViewButton.addActionListener(bl);

		
		for(Shift selectedShift:allShifts) {
			if(selectedShift.isShiftTaken()) {
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

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == removeShiftButton) {
				try {
					for(Shift selectedShift: allShifts) {
						if(selectedShift.isShiftTaken() && selectedShift.getId() == Integer.parseInt(removeShiftField.getText())) {	
							assigner.unassignShift(selectedShift, allEmployees);
							break;
							}
						}
					clearFields();
											
				} catch (Exception exception) {
					JOptionPane.showMessageDialog(UnassignShiftPanel.this, "Please Enter a Valid Value", 
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
		removeShiftField.setText("");
		viewShiftsAreaText = ("");

		
		for(Shift selectedShift:allShifts) {
			if(selectedShift.isShiftTaken()) {
				viewShiftsAreaText = viewShiftsAreaText + selectedShift.toString() + "\n";
			}
		}
		
		viewShiftsArea.setText(viewShiftsAreaText);	

		}

}

