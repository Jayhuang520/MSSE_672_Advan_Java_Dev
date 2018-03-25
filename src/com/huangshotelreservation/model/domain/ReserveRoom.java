package com.huangshotelreservation.model.domain;

import java.io.Serializable;

public class ReserveRoom implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9160808925788577958L;

	private boolean available;
	private int month;
	private int day;
	private int year;
	private int duration;
	private Room room;
	
	//Empty constructor
	public ReserveRoom() {
	}
	
	/**
	 * 
	 * @param available
	 * @param month
	 * @param day
	 * @param year
	 */
	public ReserveRoom(boolean available,int month,int day,int year,int duration,Room room) {
		this.setAvailable(available);
		this.setMonth(month);
		this.setDay(day);
		this.setYear(year);
		this.setDuration(duration);
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
	 * @return month
	 */
	public int getMonth() {
		return month;
	}

	/**
	 * 
	 * @param month
	 */
	public void setMonth(int month) {
		this.month = month;
	}

	/**
	 * 
	 * @return year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * 
	 * @param year
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * 
	 * @return day
	 */
	public int getDay() {
		return day;
	}

	/**
	 * 
	 * @param day
	 */
	public void setDay(int day) {
		this.day = day;
	}

	/**
	 * 
	 * @return room tyoe
	 */
	public Room getRoom() {
		return room;
	}

	/**
	 * 
	 * @param room
	 */
	public void setRoom(Room room) {
		this.room = room;
	}

	/**
	 * 
	 * @return duration of the stay
	 */
	public int getDuration() {
		return duration;
	}

	/**
	 * 
	 * @param duration
	 */
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	@Override
	public String toString() {
		StringBuffer strBuffer = new StringBuffer();
		if(available) {
			strBuffer.append("Room type:" + room + "\n");
			strBuffer.append("Duration" + duration + "\n");
			strBuffer.append("Check in time: " + month + 
					"/" + day + "/"+ year + "/" + "\n");
		}else
			strBuffer.append("No Room available for rental.\n");
		
		return strBuffer.toString();
		
	}
}
