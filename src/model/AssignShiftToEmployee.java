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
			case "Thrusday": enteredDay = 6;
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
	
	public void sortByTime() {
		
		//Check to see how many days the work
		//Less days are automatically at the top of the list
		
		//Check to see if a person has worked any hours, if not they are higher up
		
			//Check to see how many hours they want vs how many they have
			//Larger difference is higher than ones with almost all their hours 
	}
	
	
	public void assignShift(Employee selectedEmployee, Shift selectedShift, PriorityQueue<Shift> allAvailableAShifts) {
		selectedEmployee.addShift(selectedShift);
		
		allAvailableAShifts.remove(selectedShift);
	}
			
		
}



