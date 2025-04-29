/**
* @author Audrey Johnston
* @version 1.0
* @since 1.0
*/

package model;

import java.util.ArrayList;

public class Employee {
	private int id;
	private int wantedHours;
	private int remainingWantedHours;
	private String name;
	private ArrayList<Integer> hoursAvailable;
	private ArrayList<Shift> shiftsTaken;
	
	private int numOfDaysCanWork;

	
	//When creating a new employee, they will automatically start out with the same wanted and remaining hours 
	public Employee(int id, String name, int wantedHours, ArrayList<Integer> hoursAvailable) {
		this.id = id;
		this.wantedHours = wantedHours;
		this.remainingWantedHours = wantedHours;
		this.name = name;
		this.hoursAvailable = hoursAvailable;
		this.shiftsTaken = new ArrayList<Shift>();
		
		int numOfDaysCanWorkCount = 0;
		for (Integer selectedSlot : hoursAvailable) {
		    if (!selectedSlot.equals(0)) {
		    	numOfDaysCanWorkCount++;
		    }
		}
		
		this.numOfDaysCanWork = numOfDaysCanWorkCount/2;
	}
	
	//Getter and Setter methods
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	int getWantedHours() {
		return wantedHours;
	}
	public void setWantedHours(int wantedHours) {
		this.wantedHours = wantedHours;
	}
	public int getRemainingWantedHours() {
		return remainingWantedHours;
	}
	public void setRemainingWantedHours(int remainingWantedHours) {
		this.remainingWantedHours = remainingWantedHours;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<Integer> getHoursAvailable() {
		return hoursAvailable;
	}
	public void setHoursAvailable(ArrayList<Integer> hoursAvailable) {
		this.hoursAvailable = hoursAvailable;
	}   
	
	public ArrayList<Shift> getShiftsTaken() {
		return shiftsTaken;
	}
	
	public String getShiftsTakenMessage() {
		String allShifts = "";
		for(int i = 0; i<shiftsTaken.size(); i++) {
			allShifts = allShifts + "Id: " + shiftsTaken.get(i).getId() + ", Day: " + shiftsTaken.get(i).getDay() + ", Start Time: " + shiftsTaken.get(i).getStartTime() + ", End Time: " + shiftsTaken.get(i).getEndTime() + " -- ";
		}
		return allShifts;
	}

	public void setShiftsTaken(ArrayList<Shift> shiftsTaken) {
		this.shiftsTaken = shiftsTaken;
	}	
	
	public int getNumOfDaysCanWork() {
		return numOfDaysCanWork;
	}


	public void setNumOfDaysCanWork(int numOfDaysCanWork) {
		this.numOfDaysCanWork = numOfDaysCanWork;
	}


	public void addShift(Shift enteredShift) {
		this.shiftsTaken.add(enteredShift);
		
		this.remainingWantedHours = this.remainingWantedHours - enteredShift.getShiftLength();
	}


	@Override
	public String toString() {
		return "Employee [id=" + id + ", wantedHours=" + wantedHours + ", remainingWantedHours=" + remainingWantedHours
				+ ", name=" + name + ", hoursAvailable=" + hoursAvailable + "]";
	}
	
	public String calendarText() {
		return "Employee [id=" + id + ", wantedHours=" + wantedHours + ", remainingWantedHours=" + remainingWantedHours
				+ ", name=" + name + ", hoursAvailable=" + hoursAvailable + ", shiftsTaken=" + shiftsTaken + "]";
	}
	
	
	
	
	
}

