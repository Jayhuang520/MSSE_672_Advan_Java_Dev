package com.huangshotelreservation.model.services.factory;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.huangshotelreservation.model.business.exception.ServiceLoadException;
import com.huangshotelreservation.model.services.calendarservice.CalendarServiceImpl;
import com.huangshotelreservation.model.services.calendarservice.ICalendarService;
import com.huangshotelreservation.model.services.factory.ServiceFactory;
import com.huangshotelreservation.model.services.manager.PropertyManager;
import com.huangshotelreservation.model.services.seegalleryservice.ISeeGalleryService;

public class ServiceFactoryTest {
	
	ServiceFactory serviceFactory;
	
	@Before
	public void setUp() throws Exception{
             String propertyFileLocation = System.getProperty("propLocation");
             
             PropertyManager propertyManager = new PropertyManager();
            propertyManager.loadProperties(propertyFileLocation);
		serviceFactory = ServiceFactory.getInstance();
	}
	
	/**
	 * Test factory to return the seeGalleryService and assert it by
	 * checking it is an instance of seeGalleryService.
	 */
	@Test
	public void testGetSeeGallerySerivce() {
		ISeeGalleryService seeGalleryService;
		try {
			seeGalleryService = (ISeeGalleryService)serviceFactory.getService(ISeeGalleryService.NAME);
			assertTrue(seeGalleryService instanceof ISeeGalleryService);
		}catch (ServiceLoadException sle) {
			sle.printStackTrace();
			fail("ServiceLoadException");
		}

	}
	
	@Test
	public void testGetCalendarService() {
		ICalendarService calendarService;
		try {
			calendarService = (ICalendarService)serviceFactory.getService(ICalendarService.NAME);
			assertTrue(calendarService instanceof CalendarServiceImpl);
		}catch (ServiceLoadException sle) {
			sle.printStackTrace();
			fail("ServiceLoadException");
		}
	}
}
