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
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;

import model.Employee;
import model.Shift;
import view.AssignShiftPanel.ButtonListener;

public class AddEmployeePanel extends JPanel{

	private JButton addEmployeeButton = new JButton("Add employee");
	private JButton clearButton = new JButton("Clear");

	private JLabel idLabel = new JLabel("ID: ");
	private JLabel wantedHoursLabel = new JLabel("Wanted Hours: ");
	private JLabel nameLabel = new JLabel("Name: ");
	
	private JTextField idField = new JTextField(4);
	private JTextField wantedHoursField = new JTextField(4);
	private JTextField nameField = new JTextField(4);
	
	//List with values for spinners
	private Integer[] hoursOfDay = {0, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23};

	
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
	
	private JSpinner mStartSpinner = new JSpinner(new SpinnerListModel(hoursOfDay));
	private JSpinner mEndSpinner = new JSpinner(new SpinnerListModel(hoursOfDay));
	private JSpinner tuStartSpinner = new JSpinner(new SpinnerListModel(hoursOfDay));
	private JSpinner tuEndSpinner = new JSpinner(new SpinnerListModel(hoursOfDay));
	private JSpinner wStartSpinner = new JSpinner(new SpinnerListModel(hoursOfDay));
	private JSpinner wEndSpinner = new JSpinner(new SpinnerListModel(hoursOfDay));
	private JSpinner thStartSpinner = new JSpinner(new SpinnerListModel(hoursOfDay));
	private JSpinner thEndSpinner = new JSpinner(new SpinnerListModel(hoursOfDay));
	private JSpinner fStartSpinner = new JSpinner(new SpinnerListModel(hoursOfDay));
	private JSpinner fEndSpinner = new JSpinner(new SpinnerListModel(hoursOfDay));
	private JSpinner sStartSpinner = new JSpinner(new SpinnerListModel(hoursOfDay));
	private JSpinner sEndSpinner = new JSpinner(new SpinnerListModel(hoursOfDay));

	
	
	
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
	

	public AddEmployeePanel(ArrayList<Employee> allEmployees, PriorityQueue<Shift> allShifts) {
		setAllEmployees(allEmployees);
		setAllShifts(allShifts);
		
		// Creates a ButtonListener
		ButtonListener bl = new ButtonListener();

		// Adds the ButtonListener to both JButtons
		addEmployeeButton.addActionListener(bl);
		clearButton.addActionListener(bl);
				
		
		//Restrict editing the number to pressing the arrow keys 
		restrictSpinnerToArrows(mStartSpinner);
		restrictSpinnerToArrows(mEndSpinner);
		restrictSpinnerToArrows(tuStartSpinner);
		restrictSpinnerToArrows(tuEndSpinner);
		restrictSpinnerToArrows(wStartSpinner);
		restrictSpinnerToArrows(wEndSpinner);
		restrictSpinnerToArrows(thStartSpinner);
		restrictSpinnerToArrows(thEndSpinner);
		restrictSpinnerToArrows(fStartSpinner);
		restrictSpinnerToArrows(fEndSpinner);
		restrictSpinnerToArrows(sStartSpinner);
		restrictSpinnerToArrows(sEndSpinner);
		
		
		
		// Adds the components to the panel by using GroupLayout
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
						.addComponent(mStartSpinner, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
				.addGroup(layout.createSequentialGroup()
						.addComponent(mEndLabel)
						.addComponent(mEndSpinner, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
				.addGroup(layout.createSequentialGroup()
						.addComponent(tuStartLabel)
						.addComponent(tuStartSpinner, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
				.addGroup(layout.createSequentialGroup()
						.addComponent(tuEndLabel)
						.addComponent(tuEndSpinner, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
				.addGroup(layout.createSequentialGroup()
						.addComponent(wStartLabel)
						.addComponent(wStartSpinner, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
				.addGroup(layout.createSequentialGroup()
						.addComponent(wEndLabel)
						.addComponent(wEndSpinner, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
				.addGroup(layout.createSequentialGroup()
						.addComponent(thStartLabel)
						.addComponent(thStartSpinner, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
				.addGroup(layout.createSequentialGroup()
						.addComponent(thEndLabel)
						.addComponent(thEndSpinner, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
				.addGroup(layout.createSequentialGroup()
						.addComponent(fStartLabel)
						.addComponent(fStartSpinner, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
				.addGroup(layout.createSequentialGroup()
						.addComponent(fEndLabel)
						.addComponent(fEndSpinner, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
				.addGroup(layout.createSequentialGroup()
						.addComponent(sStartLabel)
						.addComponent(sStartSpinner, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
				.addGroup(layout.createSequentialGroup()
						.addComponent(sEndLabel)
						.addComponent(sEndSpinner, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
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
						.addComponent(mStartSpinner))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(mEndLabel)
						.addComponent(mEndSpinner))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(tuStartLabel)
						.addComponent(tuStartSpinner))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(tuEndLabel)
						.addComponent(tuEndSpinner))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(wStartLabel)
						.addComponent(wStartSpinner))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(wEndLabel)
						.addComponent(wEndSpinner))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(thStartLabel)
						.addComponent(thStartSpinner))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(thEndLabel)
						.addComponent(thEndSpinner))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(fStartLabel)
						.addComponent(fStartSpinner))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(fEndLabel)
						.addComponent(fEndSpinner))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(sStartLabel)
						.addComponent(sStartSpinner))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(sEndLabel)
						.addComponent(sEndSpinner))
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
							add((Integer)(mStartSpinner.getValue()));
							add((Integer)(mEndSpinner.getValue()));
							add((Integer)(tuStartSpinner.getValue()));
							add((Integer)(tuEndSpinner.getValue()));
							add((Integer)(wStartSpinner.getValue()));
							add((Integer)(wEndSpinner.getValue()));
							add((Integer)(thStartSpinner.getValue()));
							add((Integer)(thEndSpinner.getValue()));
							add((Integer)(fStartSpinner.getValue()));
							add((Integer)(fEndSpinner.getValue()));
							add((Integer)(sStartSpinner.getValue()));
							add((Integer)(sEndSpinner.getValue()));

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
			
			mStartSpinner.setValue(0);
			mEndSpinner.setValue(0);
			tuStartSpinner.setValue(0);
			tuEndSpinner.setValue(0);
			wStartSpinner.setValue(0);
			wEndSpinner.setValue(0);
			thStartSpinner.setValue(0);
			thEndSpinner.setValue(0);
			fStartSpinner.setValue(0);
			fEndSpinner.setValue(0);
			sStartSpinner.setValue(0);
			sEndSpinner.setValue(0);
	}
		
		public void restrictSpinnerToArrows(JSpinner selectedSpinner) {
			if (selectedSpinner.getEditor() instanceof JSpinner.DefaultEditor ) {
				   JSpinner.DefaultEditor editor = ( JSpinner.DefaultEditor ) selectedSpinner.getEditor();
				   editor.getTextField().setEnabled( true );
				   editor.getTextField().setEditable( false );
			}	
		}
}