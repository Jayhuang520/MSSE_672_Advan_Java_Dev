package com.huangshotelreservation.model.business.manager;

import java.util.ArrayList;

import com.huangshotelreservation.model.business.exception.PropertyFileNotFoundException;
import static com.huangshotelreservation.model.business.manager.DAOManager.log;
import com.huangshotelreservation.model.domain.City;
import com.huangshotelreservation.model.domain.ReserveRoom;
import com.huangshotelreservation.model.domain.Room;
import com.huangshotelreservation.model.services.manager.PropertyManager;
import org.apache.log4j.Logger;

/**
 * Applying manager for best practice.
 * @author Zhijie Huang
 *
 */
public abstract class ManagerSuperType {

	/**
	 * static initializer block
	 * This get executed at the time when the class that contains it or extends it\
	 * referenced.
	 */
    static Logger log = Logger.getLogger("com.huangshotelreservation");
	static
	{
		try 
		{
			ManagerSuperType.loadProperties();
		}catch(PropertyFileNotFoundException pfnfe) {
			log.error("Application properties failed to loaded.\n"
					+ "Application existing.");
		}
	}
	
	/**
	 * Generic method that all clients of this class can call to perform certain actions.
	 * @param commandString
	 * @param availableRoomList
	 * @param city
	 * @param room
         * @param reserveRoom
	 * @return 
	 * 			false 
	 * 				 if action failed
	 * 			true
	 * 				 if action is successful
	 * 				
	 */
	
	public abstract boolean performAction(String commandString,
    			ArrayList<Room> availableRoomList,City city,Room room,ReserveRoom reserveRoom);

	/**
	 * Loads the property file into memory.
	 * @throws PropertyFileNotFoundException
	 */
	public static void loadProperties() throws PropertyFileNotFoundException{
//		String propertyFileLocation = System.getProperty("propLocation");
//		if(propertyFileLocation != null) {
//			//Now we have successfully loaded the property file,
//			//use propertyManager class to load it up.
//			PropertyManager.loadProperties(propertyFileLocation);
//		}else {
//			System.out.println("Property file location not set.\n"
//					+ "Passed in value is "+ propertyFileLocation + ".");
//			throw new PropertyFileNotFoundException("Property file locaiton"
//					+ "not set",null);
//		}
		
		
		log.info("--------->Inside ManagerSuperType: load Properties\n");
				
                String propertyFileLocation = System.getProperty("propLocation");
                
                if(propertyFileLocation!=null){
                    //Load the property file locaiton:
                    PropertyManager.loadProperties(propertyFileLocation);
                }else
                {
                    log.error("Property file location not set. Passed in value is: " + propertyFileLocation + ".");
                    throw new PropertyFileNotFoundException ("Property file location not set", null);         
                }
		
	}// end loadProperties
	
}
