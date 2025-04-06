/**
* @author Audrey Johnston
* @version 1.0
* @since 1.0
*/

package main;

public class Employee {
	private int wantedHours;
	private int remainingWantedHours;
	private String name;
	private int [] hoursAvailable;
	
	
	public Employee(int wantedHours, int remainingWantedHours, String name, int[] hoursAvailable) {
		super();
		this.wantedHours = wantedHours;
		this.remainingWantedHours = remainingWantedHours;
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
	public int[] getHoursAvailable() {
		return hoursAvailable;
	}
	public void setHoursAvailable(int[] hoursAvailable) {
		this.hoursAvailable = hoursAvailable;
	}   
	
	
}

