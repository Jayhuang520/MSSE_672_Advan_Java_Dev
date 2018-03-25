package com.huangshotelreservation.model.services.seegalleryservice;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;

import com.huangshotelreservation.model.business.exception.ServiceLoadException;
import com.huangshotelreservation.model.domain.City;
import com.huangshotelreservation.model.domain.Room;
import com.huangshotelreservation.model.services.exception.SeeGalleryException;
import com.huangshotelreservation.model.services.factory.ServiceFactory;
import com.huangshotelreservation.model.services.manager.PropertyManager;
import com.huangshotelreservation.model.services.seegalleryservice.ISeeGalleryService;

import junit.framework.TestCase;

public class SeeGalleryServiceImplTest extends TestCase{

	private ServiceFactory serviceFactory;
	private ArrayList<Room> availableRoom = null;
	
	@Override
	protected void setUp() throws Exception{
             String propertyFileLocation = System.getProperty("propLocation");
             
             PropertyManager propertyManager = new PropertyManager();
            propertyManager.loadProperties(propertyFileLocation);
                     
		availableRoom = new ArrayList<>(2);
		availableRoom.add(Room.DOUBLE);
		availableRoom.add(Room.KING);
                
                
		serviceFactory = ServiceFactory.getInstance(); 
		
	}
	
	@Test
	public final void testRetrievePicture() throws SeeGalleryException {
		
		ISeeGalleryService seeGalleryService;
		try {
			
			seeGalleryService = (ISeeGalleryService) serviceFactory
					.getService(ISeeGalleryService.NAME);
			assertTrue(seeGalleryService.retrievePicture(availableRoom));
			System.out.println("testRetrievePicture PASSED");
		}catch (ServiceLoadException e) {
			e.printStackTrace();
			fail("ServiceLoadException");
		}
	}
	
	@Test
	public final void testRetrieveRoom() throws IOException, SeeGalleryException {
		ISeeGalleryService seeGalleryService;
		try {
			seeGalleryService = (ISeeGalleryService) serviceFactory
					.getService(ISeeGalleryService.NAME);
			assertTrue(seeGalleryService.retrieveRoom(City.DENVER));
			System.out.println("testRetrieveRoom PASSED");
		}catch (ServiceLoadException e) {
			e.printStackTrace();
			fail("ServiceLoadException");
		}
	}
}
