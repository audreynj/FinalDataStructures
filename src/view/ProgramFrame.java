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

	//Panels under View
	private StartPanel startPanel;
	private ViewAllEmployeesPanel viewAllEmployeesPanel;
	private ViewAllShiftsPanel viewAllShiftsPanel;
	private ViewCalendarPanel viewCalendarPanel;

	//Panels under Add or Assign
	private AddEmployeePanel addEmployeePanel;
	private AddShiftPanel addShiftPanel;
	private AssignShiftPanel assignShiftPanel;
	
	//Panels under Remove
	private RemoveShiftPanel removeShiftPanel;
	private RemoveEmployeePanel removeEmployeePanel;
	private UnassignShiftPanel unassignShiftPanel;

	//This panel will have the others added onto it
	private JPanel allPanels;
	
	//For the Menu Bar
	private JMenuBar menuBar;
	private JMenu addOrAssignMenu;
	private JMenu viewMenu;
	private JMenu removeMenu;

	
	
	public ProgramFrame(ArrayList<Employee> allEmployees, PriorityQueue<Shift> allShifts) {
		//Initialize all panels
		startPanel = new StartPanel(allEmployees, allShifts);
		viewAllEmployeesPanel = new ViewAllEmployeesPanel(allEmployees, allShifts);
		viewAllShiftsPanel = new ViewAllShiftsPanel(allEmployees, allShifts);
		viewCalendarPanel = new ViewCalendarPanel(allEmployees, allShifts);
		
		
		addEmployeePanel = new AddEmployeePanel(allEmployees, allShifts);
		addShiftPanel = new AddShiftPanel(allEmployees, allShifts);
		assignShiftPanel = new AssignShiftPanel(allEmployees, allShifts);
		
		removeShiftPanel = new RemoveShiftPanel(allEmployees, allShifts);
		removeEmployeePanel = new RemoveEmployeePanel(allEmployees, allShifts);
		unassignShiftPanel = new UnassignShiftPanel(allEmployees, allShifts);

		//Create a new CardLayout
		allPanels = new JPanel(new CardLayout());
		
		setUpMenu();
		setUpFrame();
	}
	
	
	private void setUpMenu(){
		//Create menu bar and menus
		menuBar = new JMenuBar();
		addOrAssignMenu = new JMenu("Add or Assign");
		viewMenu = new JMenu("Views");
		removeMenu = new JMenu("Remove or Unassign");

		
		//Create menu items for each panel
		JMenuItem start = new JMenuItem("Start");
		JMenuItem viewAllEmployees = new JMenuItem("View All Employees");
		JMenuItem viewAllShifts = new JMenuItem("View All Shifts");
		JMenuItem viewCalendar = new JMenuItem("View calendar");

		JMenuItem addEmployee = new JMenuItem("Add Employee");
		JMenuItem addShift = new JMenuItem("Add Shift");
		JMenuItem assignShifts = new JMenuItem("Assign Shifts");
		
		JMenuItem removeShift = new JMenuItem("Remove Shift");
		JMenuItem removeEmployee = new JMenuItem("Remove Employee");
		JMenuItem unassignShift = new JMenuItem("Unassign Shift");


		//Add all to the frame
		menuBar.add(viewMenu);
		menuBar.add(addOrAssignMenu);
		menuBar.add(removeMenu);

		
		viewMenu.add(start);
		viewMenu.add(viewAllEmployees);
		viewMenu.add(viewAllShifts);
		viewMenu.add(viewCalendar);
		
		addOrAssignMenu.add(addEmployee);
		addOrAssignMenu.add(addShift);
		addOrAssignMenu.add(assignShifts);
		
		removeMenu.add(removeShift);
		removeMenu.add(removeEmployee);
		removeMenu.add(unassignShift);
		//Action listeners to change the screen
		start.addActionListener(select->changeScreen("1"));
		viewAllEmployees.addActionListener(select->changeScreen("2"));
		viewAllShifts.addActionListener(select->changeScreen("3"));
		viewCalendar.addActionListener(select->changeScreen("4"));

		addEmployee.addActionListener(select->changeScreen("5"));
		addShift.addActionListener(select->changeScreen("6"));
		assignShifts.addActionListener(select->changeScreen("7"));
		
		removeShift.addActionListener(select->changeScreen("8"));
		removeEmployee.addActionListener(select->changeScreen("9"));
		unassignShift.addActionListener(select->changeScreen("10"));

	}
	
	private void setUpFrame() {
		//All properties of the frame
		this.setTitle("Assign Shifts with Calendar");
		this.setVisible(true);
		this.setPreferredSize(new Dimension(800,500));
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//Adding View panels
		allPanels.add(startPanel, "1");
		allPanels.add(viewAllEmployeesPanel, "2");
		allPanels.add(viewAllShiftsPanel, "3");
		allPanels.add(viewCalendarPanel, "4");
		
		//Adding Add or Assign panels
		allPanels.add(addEmployeePanel, "5");
		allPanels.add(addShiftPanel, "6");
		allPanels.add(assignShiftPanel, "7");
		
		
		//Adding Remove panels
		allPanels.add(removeShiftPanel, "8");
		allPanels.add(removeEmployeePanel, "9");
		allPanels.add(unassignShiftPanel, "10");


		
		//Add the panels and menubar to the frame
		this.add(allPanels);
		this.setJMenuBar(menuBar);
		
		this.pack();
	}
	
	//Will will change the view when something on the menu bar is selected
	private void changeScreen(String screen) {
		((CardLayout)allPanels.getLayout()).show(allPanels, screen);
	}
}