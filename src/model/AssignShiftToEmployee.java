/**
* @author Audrey Johnston
* @version 1.0
* @since 1.0
*/

package model;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class AssignShiftToEmployee {

    /**
     * @param allEmployees, selectedShift
	 * @return ArrayList<Employee> of eligible employees based on the selected shift
	 */
	public ArrayList<Employee> determineEligibleEmployeesList(ArrayList<Employee> allEmployees, Shift selectedShift) {
		
		
		ArrayList<Employee> eligibleEmployees = new ArrayList<Employee>();
		
		for(Employee selectedEmployee: allEmployees) {
			if(ifEmployeeWork(selectedShift, selectedEmployee)) {
				eligibleEmployees.add(selectedEmployee);
			}
		}
		
		return eligibleEmployees;
	}
	
	
	/**
     * @param enteredShift, enteredEmployee
	 * @return boolean depending if an employee can cover the entered shift
	 */
	public boolean ifEmployeeWork(Shift enteredShift, Employee enteredEmployee) {
		if(enteredEmployee.getRemainingWantedHours()>0)
		{
			int enteredDay = 0;
			switch(enteredShift.getDay()) 
			{
			case "Monday": enteredDay = 0;
					break;
			case "Tuesday": enteredDay = 2;
					break;
			case "Wednesday": enteredDay = 4;
					break;
			case "Thursday": enteredDay = 6;
				break;
			case "Friday": enteredDay = 8;
				break;
			case "Saturday": enteredDay = 10;
				break;
			}
			
			if(enteredEmployee.getHoursAvailable().get(enteredDay)<=enteredShift.getStartTime())
			{
				if(enteredEmployee.getHoursAvailable().get(enteredDay+1)>=enteredShift.getEndTime())
				{
					//If the employee has a shift for that day and time
					for(Shift selectedShift: enteredEmployee.getShiftsTaken()) 
					{
						if(selectedShift.getDay() == enteredShift.getDay()) {
							if(selectedShift.getStartTime()<=enteredShift.getStartTime())
							{
								if(selectedShift.getEndTime()>=enteredShift.getEndTime()) 
								{
									return false;
								}
							}
						}	
					}
					return true;
					
					
				}	
			}
		}
		return false;
	}
	
	/**
     * @param enteredShift, employeeList
	 * @return ArrayList<Employee> of the employee list sorted
	 */
	public ArrayList<Employee> sortByTime(Shift enteredShift, ArrayList<Employee> employeeList) {		
		
		ArrayList<Employee> sortedEmployeeList = new ArrayList<Employee>();
		int numOfWorkWeek = 0;
		ArrayList<Employee> employeesAvailable = new ArrayList<Employee>();
				
		while(numOfWorkWeek < 7) {
			for(Employee selectedEmployee: employeeList) {
				if(selectedEmployee.getNumOfDaysCanWork() == numOfWorkWeek) {
					if(selectedEmployee.getRemainingWantedHours() == selectedEmployee.getWantedHours()) {
						sortedEmployeeList.add(selectedEmployee);
						employeesAvailable.add(selectedEmployee);
					}
				}
			}
			numOfWorkWeek++;
		}
		employeeList.removeAll(employeesAvailable);
		employeesAvailable.clear();
		
		numOfWorkWeek = 0;
		

		while(numOfWorkWeek < 7) {
			for(Employee selectedEmployee: employeeList) {
				if(selectedEmployee.getNumOfDaysCanWork() == numOfWorkWeek) 
				{
					sortedEmployeeList.add(selectedEmployee);
					employeesAvailable.add(selectedEmployee);
			        }		
			}
			numOfWorkWeek++;
		}
		
		employeeList.removeAll(employeesAvailable);
		employeesAvailable.clear();
			
		return sortedEmployeeList;
	}
	
	/**Assigns a shift to an employee
     * @param selectedEmployee, selectedShift, allAvailableAShifts
	 */
	public void assignShift(Employee selectedEmployee, Shift selectedShift, PriorityQueue<Shift> allAvailableAShifts) {
		selectedEmployee.addShift(selectedShift);
		
		selectedShift.setShiftTaken(true);
		}	
	
	/**Removes the selected shift from the queue
     * @param selectedShift, allAvailableAShifts
	 */
	public void removeShift(Shift selectedShift, PriorityQueue<Shift> allAvailableAShifts) {		
		allAvailableAShifts.remove(selectedShift);
		}	
	
	/**Remove the selected employee from the arraylist
     * @param selectedEmployee, allEmployees
	 */
	public void removeEmployee(Employee selectedEmployee, ArrayList<Employee> allEmployees) {		
		allEmployees.remove(selectedEmployee);
		}	
	
	/**Unassigns the selected shift from the employee
     * @param selectedShift, allEmployees
	 */
	public void unassignShift(Shift selectedShift, ArrayList<Employee> allEmployees) {
		for(Employee selectedEmployee:allEmployees) {
			for(Shift selectedEmployeeShift:selectedEmployee.getShiftsTaken()) {
				if(selectedEmployeeShift.getId() == selectedShift.getId()) {
					selectedEmployeeShift.setShiftTaken(false);
					selectedEmployee.getShiftsTaken().remove(selectedEmployeeShift);
					selectedEmployee.setRemainingWantedHours(selectedEmployee.getRemainingWantedHours() + selectedEmployeeShift.getShiftLength());
					break;
				}
			}
		}
	}
}
