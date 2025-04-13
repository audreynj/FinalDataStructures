/**
* @author Audrey Johnston
* @version 1.0
* @since 1.0
*/

package model;

import java.util.ArrayList;

public class Employee {
	private int wantedHours;
	private int remainingWantedHours;
	private String name;
	private ArrayList<Integer> hoursAvailable;
	
	//When creating a new employee, they will automatically start out with the same wanted and remaining hours 
	public Employee( String name, int wantedHours, ArrayList<Integer> hoursAvailable) {
		super();
		this.wantedHours = wantedHours;
		this.remainingWantedHours = wantedHours;
		this.name = name;
		this.hoursAvailable = hoursAvailable;
	}
	
	
	public int getWantedHours() {
		return wantedHours;
	}
	public void setWantedHours(int wantedHours) {
		wantedHours = wantedHours;
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
	
	
}

