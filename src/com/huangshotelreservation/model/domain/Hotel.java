package com.huangshotelreservation.model.domain;

import java.io.*;

public class Hotel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5538770477273119572L;

	/**
	 * Domain Hotel class that holds the rental rate of the hotel room,
	 * room types
	 */
	
	/** Daily rate */
	private float rate;
	
	/**room type*/
	private Room room;
	
	/** city */
	private City city;
	

	
	/**
	 * @return Returns the rate.
	 */
	public float getRate() {
		return rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}
	
	public Hotel() {
		//Does nothing now
	}

	/**
	 * 
	 * @param rate
	 * @param room
	 */
	public Hotel(float rate,Room room) {
		super();
		this.rate = rate;
		this.room = room;
	}
	
	/**
	 * 
	 * @param rate
	 * @param room
	 * @param city
	 */
	public Hotel(float rate,Room room,City city) {
		super();
		this.rate = rate;
		this.room = room;
		this.city = city;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}
	
	public boolean validate () 
	{
		if(rate == 0.0) return false;
		if(room == null) return false;
		if(city == null) return false;
		return true;
	}
	
	/**
	 * 
	 * @param hotel
	 * @return
	 */
	public boolean equals(Hotel hotel) 
	{
		if(rate != hotel.rate) return false;
		if(room != hotel.room) return false;
		if(city != hotel.city) return false;
		
		return true;
	}
	
	/**
	 *  toString method useful for logging
	 *  
	 */
	public String toString() 
	{
		StringBuffer strBuf = new StringBuffer();
		strBuf.append("Rate: ");
		strBuf.append(rate+"\n");
		strBuf.append("Room type is:");
		strBuf.append(room + "\n");
		strBuf.append("In City:");
		strBuf.append(city + "\n");
		
		return strBuf.toString();
	}
	
	
}//end of Hotel

