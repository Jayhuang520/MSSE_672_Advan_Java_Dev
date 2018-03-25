package com.huangshotelreservation.model.services.calendarservice;

import com.huangshotelreservation.model.business.exception.ServiceLoadException;
import org.junit.Test;

import com.huangshotelreservation.model.domain.City;
import com.huangshotelreservation.model.domain.Hotel;
import com.huangshotelreservation.model.domain.ReserveRoom;
import com.huangshotelreservation.model.domain.Room;
import com.huangshotelreservation.model.services.exception.CalendarException;
import com.huangshotelreservation.model.services.factory.ServiceFactory;
import com.huangshotelreservation.model.services.manager.PropertyManager;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import junit.framework.TestCase;

public class CalendarServiceImplTest extends TestCase{
	private ServiceFactory serviceFactory;
        private ArrayList<Room> availableRoom = null;
        private ReserveRoom reserveRoom;
	
	@Override
	protected void setUp() throws Exception{
		super.setUp();
                String propertyFileLocation = System.getProperty("propLocation");
		 PropertyManager propertyManager = new PropertyManager();
            propertyManager.loadProperties(propertyFileLocation);
            availableRoom = new ArrayList<>(2);
		availableRoom.add(Room.DOUBLE);
		availableRoom.add(Room.KING);
            reserveRoom = new ReserveRoom(true,1,1,1,1,Room.SINGLE);
		serviceFactory = ServiceFactory.getInstance();
		
		
	}
	
	@Test
        public final void testReserveRoomService()throws CalendarException{
            ICalendarService calendarService;
            
            try{
                calendarService = (ICalendarService) serviceFactory
                        .getService(ICalendarService.NAME);
                assertTrue(calendarService.reserveRoomService(availableRoom, reserveRoom));
                
            } catch (ServiceLoadException ex) {
               ex.printStackTrace();
               fail("CalendarLoadException");
            }
        
        }

}
