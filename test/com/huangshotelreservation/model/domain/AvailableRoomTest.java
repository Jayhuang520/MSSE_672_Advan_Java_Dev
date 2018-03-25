package com.huangshotelreservation.model.domain;

import com.huangshotelreservation.model.domain.AvailableRoom;

import junit.framework.TestCase;
import org.junit.Test;

public class AvailableRoomTest extends TestCase{

	/**
	 * @author Jay Huang
	 */
	private AvailableRoom avaRoom1,avaRoom2;

        @Test
	public void testEqualAvailableRoom() {
		System.out.println("Start the testEqualAvailableRoom: ");
		/*
		 * Validate method from avaRoom1 should assert true because all
		 * variable being passed to create a new AvailableRoom is valid.
		 */
		avaRoom1 = new AvailableRoom(80.0f,true);
		avaRoom2 = new AvailableRoom(80.0f,true);
		assertTrue(avaRoom1.equals(avaRoom2));
		System.out.println("testEqualAvailableRoom PASSED!!!!!");
	}
}
