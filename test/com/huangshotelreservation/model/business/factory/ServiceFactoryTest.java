package com.huangshotelreservation.model.business.factory;

import com.huangshotelreservation.model.business.exception.ServiceLoadException;
import com.huangshotelreservation.model.services.factory.ServiceFactory;
import com.huangshotelreservation.model.services.seegalleryservice.ISeeGalleryService;
import com.huangshotelreservation.model.services.seegalleryservice.SeeGalleryServiceImpl;

import junit.framework.TestCase;

public class ServiceFactoryTest extends TestCase{

	ServiceFactory serviceFactory;
	
	public void setUp() throws Exception{
		serviceFactory = ServiceFactory.getInstance();
	}
	
	public void testGetInstance() {
		assertNotNull(serviceFactory);
	}
	
	public void testGetSeeGalleryService() {
		ISeeGalleryService seeGalleryService;
		try {
			seeGalleryService = (ISeeGalleryService)serviceFactory.getService(
					ISeeGalleryService.NAME);
			assertTrue(seeGalleryService instanceof SeeGalleryServiceImpl);		}
                catch(ServiceLoadException sle) {
			sle.printStackTrace();
			fail("ServiceLoadException");
                }
        }
	
}
