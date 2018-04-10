package com.huangshotelreservation.model.domain;

import com.huangshotelreservation.model.domain.City;
import com.huangshotelreservation.model.domain.Hotel;
import com.huangshotelreservation.model.domain.Room;

import junit.framework.TestCase;
import org.junit.Test;

public class HotelTest extends TestCase{

	/**
	 * assume with a valid room passed in
	 */
         @Test
	public void testValidate() {
		/**
		 * SINGLE and DENVER is an enum defined in the Room class and
		 * city class.
		 */
		System.out.print("Start testing validate: ");
		Hotel hotel = new Hotel(1.22f,Room.SINGLE,City.DENVER);
		assertTrue("hotel validates",hotel.validate());
			System.out.println("testValidate for hotel PASSED!!!!");
	}
	
        @Test
	public void testNotValidate() {
		/*
		 * The default constructor without any parameter will do nothing.
		 * So this test should failed. Because there isn't a valid Hotel.
		 */
		System.out.print("Start testing Notvalidate: ");
		Hotel hotel = new Hotel();
		assertFalse("hotel does not validate",hotel.validate());
		System.out.println("testNotValidate for hotel class PASSED!!!");
	}
	
	public void testEquals() {
		System.out.println("Start testing test Equals");
		Hotel hotel1 = new Hotel(2.44f,Room.DOUBLE,City.DENVER);
		Hotel hotel2 = new Hotel(2.44f,Room.DOUBLE,City.DENVER);
		assertTrue(hotel1.equals(hotel2));
		System.out.println("Hotel1 equals to Hotel2,test PASSED!!");
	}
	
	public void testNotEquals1() {
		System.out.println("Start testing test NotEquals1");
		Hotel hotel1 = new Hotel(2.41f,Room.DOUBLE,City.DENVER);
		Hotel hotel2 = new Hotel(2.44f,Room.DOUBLE,City.DENVER);
		assertFalse(hotel1.equals(hotel2));
		System.out.println("Hotel1 not equals to Hotel2,test PASSED!!");
	}
}	
