/**
* @author Audrey Johnston
* @version 1.0
* @since 1.0
*/

package model;

import java.util.PriorityQueue;

public class Shift implements Comparable<Shift>{
	//Declaring properties of Shift 
	private int id;
	private String day;
	private int startTime;
	private int endTime;
	private String priority;
	private int shiftLength;
	private boolean shiftTaken;
	
	
	//Constructors
	public Shift(int id, String day, int startTime, int endTime, String priority) {
		this.id = id;
		this.day = day;
		this.startTime = startTime;
		this.endTime = endTime;
		this.priority = priority;
		this.shiftLength = endTime - startTime;
		this.shiftTaken = false;
	}
	
	public Shift(String day, int startTime, int endTime, String priority, PriorityQueue<Shift> allShifts) {
		this.id = determineId(allShifts);	
		this.day = day;
		this.startTime = startTime;
		this.endTime = endTime;
		this.priority = priority;
		this.shiftLength = endTime - startTime;
		this.shiftTaken = false;
	}

	public Shift() {
	}
   
   //Getter and Setter methods
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
	public boolean isShiftTaken() {
		return shiftTaken;
	}
	public void setShiftTaken(boolean shiftTaken) {
		this.shiftTaken = shiftTaken;
	}
	
	
	/**
	 * @param allShifts, a priority queue of all the shifts
	 * @return int that is after the last id number used
	 */
	public int determineId(PriorityQueue<Shift> allShifts) {
		
		int lastUsedId = 0;
		
		for(Shift selectedShift:allShifts) {
			if(selectedShift.getId() > lastUsedId) {
				lastUsedId = selectedShift.getId();
			}
		}
		
		return lastUsedId+1;
	}
	
	
	
	/**
	 * @param other, a shift that is being compared
	 * @return int depending on the difference between two priorities
	 */
    @Override
    public int compareTo(Shift other) {
        // Define the priority order
        String[] priorityOrder = {"Important", "High", "Low"};
        int thisPriority = indexOf(priorityOrder, this.priority);
        int otherPriority = indexOf(priorityOrder, other.priority);
        return Integer.compare(thisPriority, otherPriority);
    }
    
    /**
	 * @param array, value
	 * @return int at the index of the param given
	 */
    private int indexOf(String[] array, String value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    /**
	 * @return String of all properties of Shift
	 */
	@Override
	public String toString() {
		return "Shift [id=" + id + ", day=" + day + ", startTime=" + startTime + ", endTime=" + endTime + ", priority="
				+ priority + ", shiftLength=" + shiftLength + ", shiftTaken=" + shiftTaken + "]";
	}


}