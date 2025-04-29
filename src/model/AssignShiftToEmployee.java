/**
* @author Audrey Johnston
* @version 1.0
* @since 1.0
*/

package model;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class AssignShiftToEmployee {

	//Need to call this when looking at AssignShiftPanel
	public ArrayList<Employee> determineEligibleEmployeesList(ArrayList<Employee> allEmployees, Shift selectedShift) {
		
		
		ArrayList<Employee> eligibleEmployees = new ArrayList<Employee>();
		
		for(Employee selectedEmployee: allEmployees) {
			if(ifEmployeeWork(selectedShift, selectedEmployee)) {
				eligibleEmployees.add(selectedEmployee);
			}
		}
		
		return eligibleEmployees;
	}
	
	
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
	
	public ArrayList<Employee> sortByTime(Shift enteredShift, ArrayList<Employee> employeeList) {		
		
		ArrayList<Employee> sortedEmployeeList = new ArrayList<Employee>();
		int numOfWorkWeek = 0;
		ArrayList<Employee> employeesAvailable = new ArrayList<Employee>();
				
		//Adds all employees that do not have any hours filled to the top first, also ordered by number of days they can work
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
			/**			//START FROM HERE TO CONTINUE DEBUGGING
			//Sorts using a selection sort that looks to compare employees that have the same number of days available
			//by the number of hours they are currently signed up for
			for (int i = 0; i < employeeList.size() - 1; i++) {
	              
	            // Find the minimum element in unsorted array
	            int min_idx = i;
	          
	            for (int j = i + 1; j < employeeList.size(); j++) {
	                if ((employeeList.get(j).getWantedHours()-employeeList.get(j).getRemainingWantedHours()) < (employeesAvailable.get(min_idx).getWantedHours()-employeesAvailable.get(min_idx).getRemainingWantedHours()))
	                    min_idx = j;
	            }

	            // Swap the found minimum element with the first
	            // element
	            Employee temp = employeeList.get(min_idx);
	            employeeList.set(min_idx, employeeList.get(i));
	            employeeList.set(i, temp);
		
			}
			**/
			numOfWorkWeek++;
		}
		
		employeeList.removeAll(employeesAvailable);
		employeesAvailable.clear();
		
		
		//Less days are automatically at the top of the list
		
		//Check to see if a person has worked any hours, if not they are higher up
		
			//Check to see how many hours they want vs how many they have
			//Larger difference is higher than ones with almost all their hours 
			
		return sortedEmployeeList;
	}
	
	
	public void assignShift(Employee selectedEmployee, Shift selectedShift, PriorityQueue<Shift> allAvailableAShifts) {
		selectedEmployee.addShift(selectedShift);
		
		allAvailableAShifts.remove(selectedShift);
	}
			
		
}



