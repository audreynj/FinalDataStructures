/**
* @author Audrey Johnston
* @version 1.0
* @since 1.0
*/

package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.PriorityQueue;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import model.Employee;
import model.Shift;
import view.AssignShiftPanel.ButtonListener;

public class AddShiftPanel extends JPanel{


	//Spots to day, start hour, end hour, etc
	
	//Confirm button
	//Clear button
	//Back button

	//Will change this button
	private JButton addShiftButton = new JButton("Add Shift");
	private JButton clearButton = new JButton("Clear");

	private JLabel dayLabel = new JLabel("Day: ");
	private JLabel startTimeLabel = new JLabel("Start Time: ");
	private JLabel endTimeLabel = new JLabel("End Time: ");

	
	
	private JTextField dayField = new JTextField(8);
	private JTextField startTimeField = new JTextField(8);
	private JTextField endTimeField = new JTextField(8);
	
	
	private ButtonGroup priorityGroup = new ButtonGroup();
	
	private JRadioButton priorityImportant = new JRadioButton();
	private JRadioButton priorityHigh = new JRadioButton();
	private JRadioButton priorityLow = new JRadioButton();

	
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
	
	
	
	public AddShiftPanel(ArrayList<Employee> allEmployees, PriorityQueue<Shift> allShifts) {
		setAllEmployees(allEmployees);
		setAllShifts(allShifts);
		
		// Creates a ButtonListener
		ButtonListener bl = new ButtonListener();

		// Adds the ButtonListener to both JButtons
		addShiftButton.addActionListener(bl);
		clearButton.addActionListener(bl);

		
		//Radio button
		priorityImportant.setText("Important"); 
		priorityHigh.setText("High"); 
		priorityLow.setText("Low"); 		
		
		priorityGroup.add(priorityImportant); 
		priorityGroup.add(priorityHigh);
		priorityGroup.add(priorityLow);
	
		
		// Adds the components to the panel
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        

        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        				.addComponent(dayLabel)
            	        .addComponent(dayField, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
				.addGroup(layout.createSequentialGroup()
        				.addComponent(startTimeLabel)
        				.addComponent(startTimeField, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
				.addGroup(layout.createSequentialGroup()
        				.addComponent(endTimeLabel)
        				.addComponent(endTimeField, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
				.addGroup(layout.createSequentialGroup()
        				.addComponent(priorityImportant)
        				.addComponent(priorityHigh)
        				.addComponent(priorityLow))
				.addGroup(layout.createSequentialGroup()
        				.addComponent(addShiftButton)
        				.addComponent(clearButton)));
        
        layout.setVerticalGroup(layout.createSequentialGroup()
        		.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
        				.addComponent(dayLabel)
        				.addComponent(dayField))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
        				.addComponent(startTimeLabel)
        				.addComponent(startTimeField))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
        				.addComponent(endTimeLabel)
        				.addComponent(endTimeField))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
        				.addComponent(priorityImportant)
        				.addComponent(priorityHigh)
        				.addComponent(priorityLow))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
        				.addComponent(addShiftButton)
        				.addComponent(clearButton)));
        

	}
		
		class ButtonListener implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == addShiftButton) {
					try {
						String priority = "";
						if(priorityImportant.isSelected()) {
							priority = priorityImportant.getText();
						}
						else if(priorityHigh.isSelected()) {
							priority = priorityHigh.getText();

						}
						else if(priorityLow.isSelected()) {
							priority = priorityLow.getText();

						}
						else {
							//CREATE A VALIDATION HERE
						}
						//NEED TO CHECK IF THE DAY IS A DAY OF THE WEEK
						
						Shift newShift = new Shift(dayField.getText(), Integer.parseInt(startTimeField.getText()),
								Integer.parseInt(endTimeField.getText()),  priority);

						allShifts.add(newShift);

						clearFields();
												
					} catch (Exception exception) {
						JOptionPane.showMessageDialog(AddShiftPanel.this, "Please Enter All Valid Values", 
                                "ERROR", JOptionPane.ERROR_MESSAGE);
						clearFields();
					}
				}
				// If the clearButton was clicked it will call the clearFields method
				if (e.getSource() == clearButton) {
					clearFields();
				}
			}

	
	}
		
		
	public void clearFields() {
		dayField.setText("");
		startTimeField.setText("");
		endTimeField.setText("");
		priorityGroup.clearSelection();
		}
}

