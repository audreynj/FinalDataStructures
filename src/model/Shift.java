/**
* @author Audrey Johnston
* @version 1.0
* @since 1.0
*/

package model;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Shift implements Comparable<Shift>{
	
	private int id;
	private String day;
	private int startTime;
	private int endTime;
	private String priority;
	private int shiftLength;
	
	public Shift(int id, String day, int startTime, int endTime, String priority) {
		this.id = id;
		this.day = day;
		this.startTime = startTime;
		this.endTime = endTime;
		this.priority = priority;
		this.shiftLength = endTime - startTime;
	}
	
	
	public Shift(String day, int startTime, int endTime, String priority, PriorityQueue<Shift> allShifts) {
		this.id = determineId(allShifts);	
		this.day = day;
		this.startTime = startTime;
		this.endTime = endTime;
		this.priority = priority;
		this.shiftLength = endTime - startTime;
	}
	
	public int determineId(PriorityQueue<Shift> allShifts) {
		
		int lastUsedId = 0;
		
		for(Shift selectedShift:allShifts) {
			if(selectedShift.getId() > lastUsedId) {
				lastUsedId = selectedShift.getId();
			}
		}
		
		return lastUsedId+1;
	}
	
	
	
	//Overridden compareTo method
    @Override
    public int compareTo(Shift other) {
        // Define the priority order
        String[] priorityOrder = {"Important", "High", "Low"};
        int thisPriority = indexOf(priorityOrder, this.priority);
        int otherPriority = indexOf(priorityOrder, other.priority);
        return Integer.compare(thisPriority, otherPriority);
    }
    //Method to find the index of an element in the queue
    private int indexOf(String[] array, String value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(value)) {
                return i;
            }
        }
        return -1;
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
	public int getShiftLength() {
		return shiftLength;
	}
	public void setShiftLength(int shiftLength) {
		this.shiftLength = shiftLength;
	}
	
	
	@Override
	public String toString() {
		return "Shift [id=" + id + ", day=" + day + ", startTime=" + startTime + ", endTime=" + endTime + ", priority="
				+ priority + ", shiftLength=" + shiftLength + "]";
	}
	
	
	
}

