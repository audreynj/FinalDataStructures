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
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;

import model.Employee;
import model.Shift;

public class AddShiftPanel extends JPanel{	
	//List with values for spinners
	private Integer[] hoursOfDay = {0, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23};

	//Create components for the panel
	private JButton addShiftButton = new JButton("Add Shift");
	private JButton clearButton = new JButton("Clear");

	private JLabel dayLabel = new JLabel("Day: ");
	private JLabel startTimeLabel = new JLabel("Start Time: ");
	private JLabel endTimeLabel = new JLabel("End Time: ");
	private JLabel priorityLabel = new JLabel("Priority: ");
	
	private JSpinner startTimeSpinner = new JSpinner(new SpinnerListModel(hoursOfDay));
	private JSpinner endTimeSpinner = new JSpinner(new SpinnerListModel(hoursOfDay));


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
	

	//Declare allEmployees and allShifts
	private ArrayList<Employee> allEmployees;
	private PriorityQueue<Shift> allShifts;

	
	//Getter and setter methods
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
		//Set up allEmployees and allShifts
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
		
		
		//Restrict editing the number to pressing the arrow keys 
		restrictSpinnerToArrows(startTimeSpinner);
		restrictSpinnerToArrows(endTimeSpinner);
		
		
		// Adds the components to the panel by using GroupLayout
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
        				.addComponent(startTimeSpinner, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
				.addGroup(layout.createSequentialGroup()
        				.addComponent(endTimeLabel)
        				.addComponent(endTimeSpinner, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
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
        				.addComponent(startTimeSpinner))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
        				.addComponent(endTimeLabel)
        				.addComponent(endTimeSpinner))
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
			//ButtonListener will add a new shift or clear in input depending on which button is selected
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == addShiftButton) {
					conditions:
					try {
						//This if, else if chain figures out which day is selected
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
						else if(dayS.isSelected()) {
							day = dayS.getText();
						}
						else {
							JOptionPane.showMessageDialog(AddShiftPanel.this, "Make Sure to Select a Day", 
	                                "ERROR", JOptionPane.ERROR_MESSAGE);
							break conditions;
						}
						
						//This if, else if chain figures out which priority is selected
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
							JOptionPane.showMessageDialog(AddShiftPanel.this, "Make Sure to Select a Priority", 
	                                "ERROR", JOptionPane.ERROR_MESSAGE);
							break conditions;						
							}
						
						//If the inputed hours are valid it will add the shift to the queue
						if((Integer)startTimeSpinner.getValue() < (Integer)endTimeSpinner.getValue()) {
							if((Integer)startTimeSpinner.getValue() != 0) {
								Shift newShift = new Shift(day, (Integer)startTimeSpinner.getValue(),
										(Integer)endTimeSpinner.getValue(),  priority, allShifts);

								allShifts.add(newShift);
								clearInput();
							}
							else{
								JOptionPane.showMessageDialog(AddShiftPanel.this, "Make Sure to Put in Correct Hours", 
		                                "ERROR", JOptionPane.ERROR_MESSAGE);
							}
						}
						else{
							JOptionPane.showMessageDialog(AddShiftPanel.this, "Make Sure to Put in Correct Hours", 
	                                "ERROR", JOptionPane.ERROR_MESSAGE);
						}												
					} catch (Exception exception) {
						JOptionPane.showMessageDialog(AddShiftPanel.this, "Please Enter All Valid Values", 
                                "ERROR", JOptionPane.ERROR_MESSAGE);
					}
				}
				else {
					clearInput();
				}
			}	
	}
	
	/**
	 * This method restricts the spinner components to be changed by the arrows only
	 */	
	public void restrictSpinnerToArrows(JSpinner selectedSpinner) {
		if (selectedSpinner.getEditor() instanceof JSpinner.DefaultEditor ) {
			   JSpinner.DefaultEditor editor = ( JSpinner.DefaultEditor ) selectedSpinner.getEditor();
			   editor.getTextField().setEnabled( true );
			   editor.getTextField().setEditable( false );
		}	
	}
	
	
	/**
	 * This method will set the different components back to what they
	 * were when first run 
	 */
	public void clearInput() {
		startTimeSpinner.setValue(0);
		endTimeSpinner.setValue(0);
		priorityGroup.clearSelection();
		dayGroup.clearSelection();
	}
}