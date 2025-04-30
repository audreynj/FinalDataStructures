/**
* @author Audrey Johnston
* @version 1.0
* @since 1.0
*/

package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Employee;
import model.Shift;
import view.AssignShiftPanel.ButtonListener;

public class AddEmployeePanel extends JPanel{

	
	//Spots to add id number, name, etc
	
	//Confirm button
	//Clear button
	//Back button
	
	//Will change this button
	private JButton addEmployeeButton = new JButton("Add employee");
	private JButton clearButton = new JButton("Clear");

	private JLabel idLabel = new JLabel("ID: ");
	private JLabel wantedHoursLabel = new JLabel("Wanted Hours: ");
	private JLabel nameLabel = new JLabel("Name: ");
	
	private JTextField idField = new JTextField(4);
	private JTextField wantedHoursField = new JTextField(4);
	private JTextField nameField = new JTextField(4);
	
	private JLabel mStartLabel = new JLabel("Monday Start Time: ");
	private JLabel mEndLabel = new JLabel("Monday End Time: ");
	private JLabel tuStartLabel = new JLabel("Tuesday Start Time: ");
	private JLabel tuEndLabel = new JLabel("Tuesday End Time: ");
	private JLabel wStartLabel = new JLabel("Wednesday Start Time: ");
	private JLabel wEndLabel = new JLabel("Wednesday End Time: ");
	private JLabel thStartLabel = new JLabel("Thursday Start Time: ");
	private JLabel thEndLabel = new JLabel("Thursday End Time: ");
	private JLabel fStartLabel = new JLabel("Friday Start Time");
	private JLabel fEndLabel = new JLabel("Friday End Time: ");
	private JLabel sStartLabel = new JLabel("Saturday Start Time: ");
	private JLabel sEndLabel = new JLabel("Saturday End Time");
	
	private JTextField mStartField = new JTextField(4);
	private JTextField mEndField = new JTextField(4);
	private JTextField tuStartField = new JTextField(4);
	private JTextField tuEndField = new JTextField(4);
	private JTextField wStartField = new JTextField(4);
	private JTextField wEndField = new JTextField(4);
	private JTextField thStartField = new JTextField(4);
	private JTextField thEndField = new JTextField(4);
	private JTextField fStartField = new JTextField(4);
	private JTextField fEndField = new JTextField(4);
	private JTextField sStartField = new JTextField(4);
	private JTextField sEndField = new JTextField(4);

	
	
	
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
	

	public AddEmployeePanel(ArrayList<Employee> allEmployees, PriorityQueue<Shift> allShifts) {
		setAllEmployees(allEmployees);
		setAllShifts(allShifts);
		
		// Creates a ButtonListener
		ButtonListener bl = new ButtonListener();

		// Adds the ButtonListener to both JButtons
		addEmployeeButton.addActionListener(bl);
		clearButton.addActionListener(bl);
				
		// Adds the components to the panel
		GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        

        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        				.addComponent(idLabel)
						.addComponent(idField, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
				.addGroup(layout.createSequentialGroup()
						.addComponent(wantedHoursLabel)
						.addComponent(wantedHoursField, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
				.addGroup(layout.createSequentialGroup()
						.addComponent(nameLabel)
						.addComponent(nameField, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
				.addGroup(layout.createSequentialGroup()
						.addComponent(mStartLabel)
						.addComponent(mStartField, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
				.addGroup(layout.createSequentialGroup()
						.addComponent(mEndLabel)
						.addComponent(mEndField, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
				.addGroup(layout.createSequentialGroup()
						.addComponent(tuStartLabel)
						.addComponent(tuStartField, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
				.addGroup(layout.createSequentialGroup()
						.addComponent(tuEndLabel)
						.addComponent(tuEndField, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
				.addGroup(layout.createSequentialGroup()
						.addComponent(wStartLabel)
						.addComponent(wStartField, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
				.addGroup(layout.createSequentialGroup()
						.addComponent(wEndLabel)
						.addComponent(wEndField, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
				.addGroup(layout.createSequentialGroup()
						.addComponent(thStartLabel)
						.addComponent(thStartField, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
				.addGroup(layout.createSequentialGroup()
						.addComponent(thEndLabel)
						.addComponent(thEndField, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
				.addGroup(layout.createSequentialGroup()
						.addComponent(fStartLabel)
						.addComponent(fStartField, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
				.addGroup(layout.createSequentialGroup()
						.addComponent(fEndLabel)
						.addComponent(fEndField, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
				.addGroup(layout.createSequentialGroup()
						.addComponent(sStartLabel)
						.addComponent(sStartField, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
				.addGroup(layout.createSequentialGroup()
						.addComponent(sEndLabel)
						.addComponent(sEndField, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
				.addGroup(layout.createSequentialGroup()
						.addComponent(addEmployeeButton)
						.addComponent(clearButton)));

        
        layout.setVerticalGroup(layout.createSequentialGroup()
        		.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
        				.addComponent(idLabel)
        				.addComponent(idField))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
        				.addComponent(wantedHoursLabel)
        				.addComponent(wantedHoursField))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
        				.addComponent(nameLabel)
        				.addComponent(nameField))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(mStartLabel)
						.addComponent(mStartField))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(mEndLabel)
						.addComponent(mEndField))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(tuStartLabel)
						.addComponent(tuStartField))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(tuEndLabel)
						.addComponent(tuEndField))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(wStartLabel)
						.addComponent(wStartField))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(wEndLabel)
						.addComponent(wEndField))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(thStartLabel)
						.addComponent(thStartField))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(thEndLabel)
						.addComponent(thEndField))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(fStartLabel)
						.addComponent(fStartField))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(fEndLabel)
						.addComponent(fEndField))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(sStartLabel)
						.addComponent(sStartField))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(sEndLabel)
						.addComponent(sEndField))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(addEmployeeButton)
						.addComponent(clearButton)));

	}
	
		class ButtonListener implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == addEmployeeButton) {
				try {
					ArrayList<Integer> hoursAvailable =  new ArrayList<>() {
						{
							add(Integer.parseInt(mStartField.getText()));
							add(Integer.parseInt(mEndField.getText()));
							add(Integer.parseInt(tuStartField.getText()));
							add(Integer.parseInt(tuEndField.getText()));
							add(Integer.parseInt(wStartField.getText()));
							add(Integer.parseInt(wEndField.getText()));
							add(Integer.parseInt(thStartField.getText()));
							add(Integer.parseInt(thEndField.getText()));
							add(Integer.parseInt(fStartField.getText()));
							add(Integer.parseInt(fEndField.getText()));
							add(Integer.parseInt(sStartField.getText()));
							add(Integer.parseInt(sEndField.getText()));

						}
					};
					
					Employee newEmployee = new Employee(Integer.parseInt(idField.getText()), nameField.getText(), Integer.parseInt(wantedHoursField.getText()), hoursAvailable);

					allEmployees.add(newEmployee);

					clearFields();
				}
				catch(Exception exception) {
					JOptionPane.showMessageDialog(AddEmployeePanel.this, "Please Enter All Valid Values", 
                            "ERROR", JOptionPane.ERROR_MESSAGE);
					clearFields();
				}
			}
				
		if (e.getSource() == clearButton) {
			clearFields();
		}
	}
}		
		public void clearFields() {
			idField.setText("");
			wantedHoursField.setText("");
			nameField.setText("");
			
			mStartField.setText("");
			mEndField.setText("");
			tuStartField.setText("");
			tuEndField.setText("");
			wStartField.setText("");
			wEndField.setText("");
			thStartField.setText("");
			thEndField.setText("");
			fStartField.setText("");
			fEndField.setText("");
			sStartField.setText("");
			sEndField.setText("");
	}
}