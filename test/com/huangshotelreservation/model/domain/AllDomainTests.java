package com.huangshotelreservation.model.domain;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

//public class AllDomainTests {
//	
//	public static Test suite() {
//	TestSuite suite = new TestSuite("Test for com.HuangsHotelReservation.model.domain");
//	//$JUnit begins$
//	suite.addTestSuite(AvailableRoomTest.class);
//	suite.addTestSuite(CustomerTest.class);
//	suite.addTestSuite(HotelTest.class);
//	//$JUnit end$
//	return suite;
//	}
//	
//}
@RunWith(Suite.class)
@SuiteClasses({AvailableRoomTest.class,CustomerTest.class,
	HotelTest.class})
public class AllDomainTests {

}
