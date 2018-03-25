package com.huangshotelreservation.model.services;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.huangshotelreservation.model.services.calendarservice.CalendarServiceImplTest;
import com.huangshotelreservation.model.services.factory.ServiceFactoryTest;
import com.huangshotelreservation.model.services.seegalleryservice.SeeGalleryServiceImplTest;

@RunWith(Suite.class)
@SuiteClasses({ServiceFactoryTest.class,CalendarServiceImplTest.class,
	SeeGalleryServiceImplTest.class})
public class AllServiceTests {

}
