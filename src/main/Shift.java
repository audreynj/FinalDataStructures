/**
* @author Audrey Johnston
* @version 1.0
* @since 1.0
*/

package main;

public class Shift {
	private int id;
	private String day;
	private int startTime;
	private int endTime;
	private String priority;
	
	
	
	public Shift(int id, String day, int startTime, int endTime, String priority) {
		super();
		this.id = id;
		this.day = day;
		this.startTime = startTime;
		this.endTime = endTime;
		this.priority = priority;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public int getStartTime() {
		return startTime;
	}
	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}
	public int getEndTime() {
		return endTime;
	}
	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	
	
	
}

