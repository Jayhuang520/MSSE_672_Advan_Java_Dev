
package com.huangshotelreservation.driver;

import com.huangshotelreservation.model.domain.City;
import com.huangshotelreservation.model.domain.Hotel;
import com.huangshotelreservation.model.domain.Location;
import com.huangshotelreservation.model.domain.ReserveRoom;
import com.huangshotelreservation.model.domain.Room;
import com.huangshotelreservation.model.services.factory.HibernateSessionFactory;

import java.util.List;
import org.apache.log4j.Logger;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * This class is mean to be a quick standalone class
 * that tests Hibernate functionality.
 * @author Zhijie Huang
 */
public class HibernateDriver {
    /*
     * Category set in config/log4j.properties as
     * log4j.category.com.classexercise=DEBUG, A1
     */
    
    static Logger log = Logger.getLogger("Entering HibernateDriver!!!");
    
    
    public static void main(String[] args){
        Transaction tx = null;
        try{
            //initialize log4j
            Log4JInit.initializeLog4J();
            
            log.info("About to create a Hibernate Session");
            Session session = HibernateSessionFactory.currentSession();
            tx = session.beginTransaction(); //begin transaction
            
            /*
             * Create couple of Rooms and add it to a locaiton
            */
            log.info("---------------------------");
            log.info("Creating a couple of Rooms and adding"
                    +"to a locaiton.");
           
            
            Hotel hotel1 = new Hotel(500.00f,Room.DOUBLE,City.DENVER);
            Hotel hotel2 = new Hotel(1000.00f,Room.QUEEN,City.DENVER);
            Hotel hotel3 = new Hotel(1500.00f,Room.KING,City.DENVER);
            
            Location location = new Location("DENVER");
            
            location.addRoom(hotel1);
            location.addRoom(hotel2);
            location.addRoom(hotel3);
            
             log.info("About to save the created Rooms and its Location!");
            session.save(location);
            tx.commit();
            log.info("Location with its Rooms saved. Check database for data!");
            log.info("---------------------------");

            // Lets retrieve all the rooms at DENVER Location
            log.info("---------------------------");
            log.info("About to retrieve all rooms at Devnver Location!");

            log.info("About to create Query");
            /**
             * Note: The reference to Location in the query is the object
             * Location not the table location
             */
            Query q = session.createQuery("from Location l where l.locationId = 1");

            log.info("About to display the queried list");

            List locList = q.list();
            
            for (Object o : locList) {
                log.info((Location) o);
            }
            
            log.info("---------------------------");

            // Lets retrieve all the rooms at San DENVER Location which are not rented
            log.info("---------------------------");
            log.info("About to retrieve all ROOMs at Denver Location that are not rented!");

            log.info("About to create Query");
            /**
             * Note: The reference to Location in the query is the object
             * Location not the table location
             */
            
            q = session.createQuery("select room from Location l join l.hotelRoomSet room where room.rented= :rented ");
            q.setString("rented", "N");
          
            log.info("About to display the queried list");
                   
            List roomList = q.list();
            for (Object o : roomList) {
                log.info((Hotel) o);
            }
            
            log.info("---------------------------");
        }catch(Exception e){
            if (tx != null) {
                tx.rollback();
            }
            log.error(e.getClass() + ": " + e.getMessage(), e);
            
        }finally {
            HibernateSessionFactory.closeSessionAndFactory();
        }
    } //end main
}
