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

	
	private JTextField idField;
	private JTextField wantedHoursField;
	private JTextField name;
	
	private JTextField mStart;
	private JTextField mEnd;
	private JTextField tuStart;
	private JTextField tuEnd;
	private JTextField wStart;
	private JTextField wEnd;
	private JTextField thStart;
	private JTextField thEnd;
	private JTextField fStart;
	private JTextField fEnd;
	private JTextField sStart;
	private JTextField sEnd;

	
	
	
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


		//Textfields
		idField = new JTextField(16);
		wantedHoursField = new JTextField(16);
		name = new JTextField(16);
		
		mStart = new JTextField(16);
		mEnd = new JTextField(16);
		tuStart = new JTextField(16);
		tuEnd = new JTextField(16);
		wStart = new JTextField(16);
		wEnd = new JTextField(16);
		thStart = new JTextField(16);
		thEnd = new JTextField(16);
		fStart = new JTextField(16);
		fEnd = new JTextField(16);
		sStart = new JTextField(16);
		sEnd = new JTextField(16);
		
				
		add(idField);
		add(wantedHoursField);
		add(name);
		
		add(mStart);
		add(mEnd);
		add(tuStart);
		add(tuEnd);
		add(wStart);
		add(wEnd);
		add(thStart);
		add(thEnd);
		add(fStart);
		add(fEnd);
		add(sStart);
		add(sEnd);

		
		
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
							add(Integer.parseInt(mStart.getText()));
							add(Integer.parseInt(mEnd.getText()));
							add(Integer.parseInt(tuStart.getText()));
							add(Integer.parseInt(tuEnd.getText()));
							add(Integer.parseInt(wStart.getText()));
							add(Integer.parseInt(wEnd.getText()));
							add(Integer.parseInt(thStart.getText()));
							add(Integer.parseInt(thEnd.getText()));
							add(Integer.parseInt(fStart.getText()));
							add(Integer.parseInt(fEnd.getText()));
							add(Integer.parseInt(sStart.getText()));
							add(Integer.parseInt(sEnd.getText()));

						}
					};
					
					Employee newEmployee = new Employee(Integer.parseInt(idField.getText()), name.getText(), Integer.parseInt(wantedHoursField.getText()), hoursAvailable);

					allEmployees.add(newEmployee);

					clearFields();
				}
				catch(Exception exception) {
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
			name.setText("");
			
			mStart.setText("");
			mEnd.setText("");
			tuStart.setText("");
			tuEnd.setText("");
			wStart.setText("");
			wEnd.setText("");
			thStart.setText("");
			thEnd.setText("");
			fStart.setText("");
			fEnd.setText("");
			sStart.setText("");
			sEnd.setText("");
	}
}
	


