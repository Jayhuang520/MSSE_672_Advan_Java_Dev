package com.huangshotelreservation.model.business.manager;

import java.util.ArrayList;

import com.huangshotelreservation.model.business.manager.HuangsHotelReservationManager;
import com.huangshotelreservation.model.domain.City;
import com.huangshotelreservation.model.domain.ReserveRoom;
import com.huangshotelreservation.model.domain.Room;
import com.huangshotelreservation.model.services.exception.CalendarException;
import com.huangshotelreservation.model.services.exception.SeeGalleryException;
import com.huangshotelreservation.model.services.seegalleryservice.ISeeGalleryService;

import junit.framework.TestCase;

/**
 * This unit test tests the HuangsHotelReservationManager class.
 * This unit test only test the happy path.
 * Should consider include more comprehensive negativee testing.
 * 
 */
public class HuangsHotelReservationManagerTest extends TestCase{

	private HuangsHotelReservationManager huangsHotelReservationManager;
	ArrayList<Room> availableRoom = null;
	private ReserveRoom reserveRoom;
	
	protected void setUp() throws Exception{
		super.setUp();
		
		huangsHotelReservationManager = HuangsHotelReservationManager.getInstance();
		
		availableRoom = new ArrayList<Room>(2);
		availableRoom.add(Room.DOUBLE);
		availableRoom.add(Room.KING);
		
		reserveRoom = new ReserveRoom();
	}
	
	/**
	 * Test performAction method for seeGalleryService
	 * @throws CalendarException 
	 * @throws SeeGalleryException 
	 */
	public final void testPerformAcionOnSeeGalleryService() throws SeeGalleryException, CalendarException
	{
		
		boolean action = huangsHotelReservationManager.performAction("seeGalleryService", 
				availableRoom, City.DENVER, Room.DOUBLE,reserveRoom);
		assertTrue(action);
	}
	
	public final void testSeeGallery() {
		boolean seeGallery = huangsHotelReservationManager.seeGalleryService(ISeeGalleryService.NAME, availableRoom);
		assertTrue(seeGallery);
	}
		
}//End HuangsHotelReservationManagerTests
