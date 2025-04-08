/**
* @author Audrey Johnston
* @version 1.0
* @since 1.0
*/

package main;

import java.util.ArrayList;

public class AssignShiftToEmployee {

	public void determineEligibleEmployees(ArrayList<Employee> allEmployees, Shift selectedShift) {
		for(Employee selectedEmployee: allEmployees) {
			ifEmployeeWork(selectedShift, selectedEmployee);
		}
	}
	
	
	public void ifEmployeeWork(Shift enteredShift, Employee enteredEmployee) {
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
				if(enteredEmployee.getHoursAvailable().get(enteredDay+1)>=enteredShift.getEndTime())
			{
				System.out.println("This follows the rule for hours");

			}
			System.out.println("This follows the rule for day");
			
		}

		
		
		else {
			System.out.println("This isn't right");
		}
	}
	
	public void sortByTime() {
		
	}
			
		
}



