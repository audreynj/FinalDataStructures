/**
* @author Audrey Johnston
* @version 1.0
* @since 1.0
*/

package view;

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

public class AddShiftPanel extends JPanel{

	private JButton addShiftButton = new JButton("Add Shift");
	private JButton clearButton = new JButton("Clear");

	private JLabel dayLabel = new JLabel("Day: ");
	private JLabel startTimeLabel = new JLabel("Start Time: ");
	private JLabel endTimeLabel = new JLabel("End Time: ");
	private JLabel priorityLabel = new JLabel("Priority: ");


	//Radio button and groups initialized for the day of the week and priority 
	private ButtonGroup dayGroup = new ButtonGroup();
	
	private JRadioButton dayM = new JRadioButton("Monday");
	private JRadioButton dayTu = new JRadioButton("Tuesday");
	private JRadioButton dayW = new JRadioButton("Wednesday");
	private JRadioButton dayTh = new JRadioButton("Thursday");
	private JRadioButton dayF = new JRadioButton("Friday");
	private JRadioButton dayS = new JRadioButton("Saturday");

	private ButtonGroup priorityGroup = new ButtonGroup();
	
	private JRadioButton priorityImportant = new JRadioButton("Important");
	private JRadioButton priorityHigh = new JRadioButton("High");
	private JRadioButton priorityLow = new JRadioButton("Low");
	
	
	private JTextField startTimeField = new JTextField(8);
	private JTextField endTimeField = new JTextField(8);
	
	
	
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

		
		//Radio buttons
		priorityGroup.add(priorityImportant); 
		priorityGroup.add(priorityHigh);
		priorityGroup.add(priorityLow);
	
		dayGroup.add(dayM); 
		dayGroup.add(dayTu);
		dayGroup.add(dayW);
		dayGroup.add(dayTh); 
		dayGroup.add(dayF);
		dayGroup.add(dayS);
		
		// Adds the components to the panel
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        

        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        				.addComponent(dayLabel)
        				.addComponent(dayM)
        				.addComponent(dayTu)
        				.addComponent(dayW)
        				.addComponent(dayTh)
        				.addComponent(dayF)
        				.addComponent(dayS))			
        		.addGroup(layout.createSequentialGroup()
        				.addComponent(startTimeLabel)
        				.addComponent(startTimeField, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
				.addGroup(layout.createSequentialGroup()
        				.addComponent(endTimeLabel)
        				.addComponent(endTimeField, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
				.addGroup(layout.createSequentialGroup()
						.addComponent(priorityLabel)
        				.addComponent(priorityImportant)
        				.addComponent(priorityHigh)
        				.addComponent(priorityLow))
				.addGroup(layout.createSequentialGroup()
        				.addComponent(addShiftButton)
        				.addComponent(clearButton)));
        
        layout.setVerticalGroup(layout.createSequentialGroup()
        		.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
        				.addComponent(dayLabel)
        				.addComponent(dayM)
        				.addComponent(dayTu)
        				.addComponent(dayW)
        				.addComponent(dayTh)
        				.addComponent(dayF)
        				.addComponent(dayS))			
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
        				.addComponent(startTimeLabel)
        				.addComponent(startTimeField))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
        				.addComponent(endTimeLabel)
        				.addComponent(endTimeField))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(priorityLabel)
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
						else {
							priority = priorityLow.getText();
						}
						
						String day = "";
						if(dayM.isSelected()) {
							day = dayM.getText();
						}
						else if(dayTu.isSelected()) {
							day = dayTu.getText();
						}
						else if(dayW.isSelected()) {
							day = dayW.getText();
						}
						else if(dayTh.isSelected()) {
							day = dayTh.getText();
						}
						else if(dayF.isSelected()) {
							day = dayF.getText();
						}
						else {
							day = dayS.getText();
						}
						
						Shift newShift = new Shift(day, Integer.parseInt(startTimeField.getText()),
								Integer.parseInt(endTimeField.getText()),  priority, allShifts);

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
		startTimeField.setText("");
		endTimeField.setText("");
		priorityGroup.clearSelection();
		dayGroup.clearSelection();
		}
}