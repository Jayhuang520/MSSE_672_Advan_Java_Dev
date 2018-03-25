package com.huangshotelreservation.model.domain;

import java.io.Serializable;
import java.util.ArrayList;

public class AvailableRoom implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8540510908779711003L;
	
	/** Holds the state of rental room */
	private boolean available;
	
	/** state tax associated with this rental */
	private float stateTax;
	
	/**holds room objects*/
	//Intial size of the room is 2
	private ArrayList<Room> availableRoomList = new ArrayList<Room>(2);
	
	public AvailableRoom() {
	}
	
	/**
	 * 
	 * @param stateTax
	 */
	public AvailableRoom(float stateTax) {
		this.setStateTax(stateTax);
	}
	
	/**
	 * 
	 * @param available
	 */
	public AvailableRoom(boolean available) {
		this.setAvailable(available);
	}
	
	/**
	 * 
	 * @param stateTax
	 * @param available
	 */
	public AvailableRoom(float stateTax,boolean available) {
		this.setStateTax(stateTax);
		this.setAvailable(available);
	}

	/**
	 * 
	 * @return available
	 */
	public boolean isAvailable() {
		return available;
	}

	/**
	 * 
	 * @param available
	 */
	public void setAvailable(boolean available) {
		this.available = available;
	}

	/**
	 * 
	 * @return stateTax
	 */
	public float getStateTax() {
		return stateTax;
	}

	/**
	 * 
	 * @param stateTax
	 */
	public void setStateTax(float stateTax) {
		this.stateTax = stateTax;
	}

	/**
	 * 
	 * @return availableRoomList
	 */
	public ArrayList<Room> getAvailableRoomList() {
		return availableRoomList;
	}

	/**
	 * 
	 * @param room
	 */
	public void addRoom(Room room) {
		availableRoomList.add(room);
	}
	
	/**
	 * 
	 * @param availableRoomList
	 */
	public void setAvailableRoomList(ArrayList<Room> availableRoomList) {
		this.availableRoomList = availableRoomList;
	}
	
	/**
	 * Add each available room into the ArrayList
	 * @param room
	 * 
	 */
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (available? 100 : 106);
		result = prime * result + ((availableRoomList == null) ? 0
				:availableRoomList.hashCode());
		result = prime * result + Float.floatToIntBits(stateTax);
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(!(obj instanceof AvailableRoom))
			return false;
		AvailableRoom other = (AvailableRoom) obj;
		if(available != other.available)
			return false;
		if (availableRoomList == null) {
			if (other.availableRoomList != null)
				return false;
		}else if(!availableRoomList.equals(other.availableRoomList))
				return false;
		if (Float.floatToIntBits(stateTax) != Float
				.floatToIntBits(other.stateTax))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		StringBuffer strBuffer = new StringBuffer();
		if(available) {
			strBuffer.append("Room is available\n");
			strBuffer.append("State tax is:\n");
			strBuffer.append(stateTax+"\n");
			strBuffer.append("Available Room List: \n");
			
			for(Room room : availableRoomList) {
				strBuffer.append(room);
			}
		}else 
			strBuffer.append("No room is available for rental\n");
		
		return strBuffer.toString();
	}
}
