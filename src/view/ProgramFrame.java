/**
* @author Audrey Johnston
* @version 1.0
* @since 1.0
*/




package view;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.PriorityQueue;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import model.Employee;
import model.Shift;

public class ProgramFrame extends JFrame{

	private StartPanel startPanel;
	private ViewAllEmployeesPanel viewAllEmployeesPanel;
	private ViewAllRemainingShiftsPanel viewAllShiftsPanel;
	private ViewCalendarPanel viewCalendarPanel;

	private AddEmployeePanel addEmployeePanel;
	private AddShiftPanel addShiftPanel;
	private AssignShiftPanel assignShiftPanel;

	
	private JPanel allPanels;
	
	
	private JMenuBar menuBar;
	private JMenu addOrAssignMenu;
	private JMenu viewMenu;
	
	public ProgramFrame(ArrayList<Employee> allEmployees, PriorityQueue<Shift> allShifts) {
		
		startPanel = new StartPanel(allEmployees, allShifts);
		viewAllEmployeesPanel = new ViewAllEmployeesPanel(allEmployees, allShifts);
		viewAllShiftsPanel = new ViewAllRemainingShiftsPanel(allEmployees, allShifts);
		viewCalendarPanel = new ViewCalendarPanel(allEmployees, allShifts);
		
		
		addEmployeePanel = new AddEmployeePanel(allEmployees, allShifts);
		addShiftPanel = new AddShiftPanel(allEmployees, allShifts);
		assignShiftPanel = new AssignShiftPanel(allEmployees, allShifts);
		
		
		allPanels = new JPanel(new CardLayout());
		
		setUpMenu();
		setUpFrame();
	}
	
	
	
	private void setUpMenu(){
		menuBar = new JMenuBar();
		
		addOrAssignMenu = new JMenu("Add or Assign");
		viewMenu = new JMenu("Views");

		menuBar.add(viewMenu);
		menuBar.add(addOrAssignMenu);
		
		JMenuItem start = new JMenuItem("Start");
		JMenuItem viewAllEmployees = new JMenuItem("View All Employees");
		JMenuItem viewAllShifts = new JMenuItem("View All Shifts");
		JMenuItem viewCalendar = new JMenuItem("View calendar");

		JMenuItem addEmployee = new JMenuItem("Add Employee");
		JMenuItem addShift = new JMenuItem("Add Shift");
		JMenuItem assignShifts = new JMenuItem("Assign Shifts");


		viewMenu.add(start);
		viewMenu.add(viewAllEmployees);
		viewMenu.add(viewAllShifts);
		viewMenu.add(viewCalendar);


		addOrAssignMenu.add(addEmployee);
		addOrAssignMenu.add(addShift);
		addOrAssignMenu.add(assignShifts);

		
		
		
		start.addActionListener(select->changeScreen("1"));
		viewAllEmployees.addActionListener(select->changeScreen("2"));
		viewAllShifts.addActionListener(select->changeScreen("3"));
		viewCalendar.addActionListener(select->changeScreen("4"));

		addEmployee.addActionListener(select->changeScreen("5"));
		addShift.addActionListener(select->changeScreen("6"));
		assignShifts.addActionListener(select->changeScreen("7"));
	}
	
	
	private void setUpFrame() {
		this.setTitle("Assign Shifts with Calendar");
		this.setVisible(true);
		this.setPreferredSize(new Dimension(800,600));
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		allPanels.add(startPanel, "1");
		allPanels.add(viewAllEmployeesPanel, "2");
		allPanels.add(viewAllShiftsPanel, "3");
		allPanels.add(viewCalendarPanel, "4");
		
		
		allPanels.add(addEmployeePanel, "5");
		allPanels.add(addShiftPanel, "6");
		allPanels.add(assignShiftPanel, "7");
		
		this.add(allPanels);
		this.setJMenuBar(menuBar);
		
		this.pack();
	}
	
	
	private void changeScreen(String screen) {
		((CardLayout)allPanels.getLayout()).show(allPanels, screen);
	}
}

