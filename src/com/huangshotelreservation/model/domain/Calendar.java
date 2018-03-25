package com.huangshotelreservation.model.domain;

import java.io.Serializable;

public class Calendar implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9007472626741875315L;

	private int year;
	private int month;
	private int day;
	
	public Calendar(int month,int day,int year) {
		this.setMonth(month);
		this.setDay(day);
		this.setYear(year);
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}
	
	
}
