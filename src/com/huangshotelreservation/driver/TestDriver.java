/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.huangshotelreservation.driver;

import com.huangshotelreservation.model.business.manager.DAOManager;
import com.huangshotelreservation.model.domain.City;
import com.huangshotelreservation.model.domain.ReserveRoom;
import com.huangshotelreservation.model.domain.Room;
import java.util.ArrayList;
import org.apache.log4j.Logger;

/**
 *
 * @author Zhijie Huang
 */
public class TestDriver {
    /*
    Category set in config/log4j.properties as
    log4j.category.com.classexercise=debug,Al
    */
    static Logger log = Logger.getLogger("Enter Test Driver!!!");
    
    /**
     *
     * @param args
     */
    public static void main(String[] args){
        Log4JInit.initializeLog4J();
                                      
        ReserveRoom reserveRoom = new ReserveRoom(true,1,1,2018,1,Room.QUEEN);
        
        log.info("\n----------------");
        log.info("\n-->Checking room availability for rental: \n\n"
                +reserveRoom.isAvailable());
        
        DAOManager manager = DAOManager.getInstance();
        ArrayList<Room> availableRoom = new ArrayList<Room>(2);
			availableRoom.add(Room.QUEEN);
			availableRoom.add(Room.DOUBLE);
        
        boolean status = manager.performAction("calendarService", availableRoom, 
                City.DENVER, Room.KING, reserveRoom);
        
        if(status)//if true request processed successfully
        {
            if(reserveRoom != null){
                if(availableRoom.size() >0)
                {
                    //Cool, we have a room available to rent.
                    //Lets get Customer info.
                    log.info("\n-->There are "+ availableRoom.size()+ 
                            " Rooms available for rent\n");
                    
                        manager.performAction("seeGalleryService", availableRoom,
                                City.MIAMI, Room.KING, reserveRoom);
                    
                }
                else
                { 
                    log.info("There are no room available!");

                }
            }
             else
            {
                log.error("We experiencing techinical difficulty,"
                        + "please try back later!!!");
            }        
        }
        else
        {
            log.error("We experiencing techinical difficulty,\n"
                        + "please try back later!!!");
        }
    }//end main
    
}//end class TestDriver
