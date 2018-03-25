package com.huangshotelreservation.model.services.calendarservice;

import java.util.ArrayList;

import com.huangshotelreservation.model.domain.ReserveRoom;
import com.huangshotelreservation.model.domain.Room;
import com.huangshotelreservation.model.services.exception.CalendarException;
import org.apache.log4j.Logger;

/**
 * 
 * @author Zhijie Huang
 *
 */
public class CalendarServiceImpl implements ICalendarService{
	
    static Logger log = Logger.getLogger("com.huangshotelreservation");
    
	public boolean reserveRoomService(ArrayList<Room> availableRoomList,ReserveRoom reserveRoom) 
				throws CalendarException{
		boolean isReserved;
		try {
			if(availableRoomList.size()>0 && reserveRoom.isAvailable()) {
				log.info("There is room available.");
				//Since the duration already an int, it will always be positive integer,
				//no float.
				
				log.debug("Day:"+reserveRoom.getDay());
				log.debug("Duration:"+reserveRoom.getDuration());
				log.debug("Month"+reserveRoom.getMonth());
				log.debug("Year"+reserveRoom.getYear());
				
				if(reserveRoom.getDuration() > 0 && reserveRoom.getDay() > 0
						&& reserveRoom.getMonth() > 0 && reserveRoom.getYear()>0) {
					log.info("Information entered were valid");
					isReserved = true;
				
					
					
				}else {
					isReserved = false;
					log.error("Invalid information enter!!!");
					throw new CalendarException("Invalid Input");
				}
			}else {
				log.warn("There isn't any available room, please"
						+ "try again later.");
				isReserved = false;
			}
		}catch(Exception e) {
			throw new CalendarException("Calendar Service exception");
		}
		return isReserved;
	}
}
