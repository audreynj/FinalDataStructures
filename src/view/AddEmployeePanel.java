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
	
	private JTextField idField;
	private JTextField wantedHoursField;
	private JTextField nameField;
	
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
	
	private JTextField mStartField;
	private JTextField mEndField;
	private JTextField tuStartField;
	private JTextField tuEndField;
	private JTextField wStartField;
	private JTextField wEndField;
	private JTextField thStartField;
	private JTextField thEndField;
	private JTextField fStartField;
	private JTextField fEndField;
	private JTextField sStartField;
	private JTextField sEndField;

	
	
	
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


		//Textfields and Labels
		idField = new JTextField(4);
		wantedHoursField = new JTextField(4);
		nameField = new JTextField(16);
		
		mStartField = new JTextField(4);
		mEndField = new JTextField(4);
		tuStartField = new JTextField(4);
		tuEndField = new JTextField(4);
		wStartField = new JTextField(4);
		wEndField = new JTextField(4);
		thStartField = new JTextField(4);
		thEndField = new JTextField(4);
		fStartField = new JTextField(4);
		fEndField = new JTextField(4);
		sStartField = new JTextField(4);
		sEndField = new JTextField(4);
		
				
		add(idLabel);
		add(idField);
		add(wantedHoursLabel);
		add(wantedHoursField);
		add(nameLabel);
		add(nameField);
		
		add(mStartLabel);
		add(mStartField);
		
		add(mEndLabel);
		add(mEndField);
		
		add(tuStartLabel);
		add(tuStartField);
		
		add(tuEndLabel);
		add(tuEndField);

		add(wStartLabel);
		add(wStartField);

		add(wEndLabel);
		add(wEndField);

		add(thStartLabel);
		add(thStartField);

		add(thEndLabel);
		add(thEndField);

		add(fStartLabel);
		add(fStartField);

		add(fEndLabel);
		add(fEndField);

		add(sStartLabel);
		add(sStartField);

		add(sEndLabel);
		add(sEndField);

		
			
		// Adds the buttons to the panel
		add(addEmployeeButton);
		add(clearButton);


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
	


