
package com.huangshotelreservation.driver;

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
            ReserveRoom reserveRoom1 = new ReserveRoom(true,1,1,2018,1,Room.QUEEN);
            ReserveRoom reserveRoom2 = new ReserveRoom(true,1,1,2018,1,Room.KING);
            ReserveRoom reserveRoom3 = new ReserveRoom(true,1,1,2018,1,Room.DOUBLE);
            
            Location location = new Location("DENVER");
            
            log.info("About to save the created Cars and its Location!");
            session.save(location);
            tx.commit();
            log.info("Location with its Rooms saved. Check database for data!");
            log.info("---------------------------");
            
            // Lets retrieve all the cars at DENVER Location
            log.info("---------------------------");
            log.info("About to retrieve all rooms at DENVER Location!");

            log.info("About to create Query");
            
            /**
             * Note: The reference to Location in the query is the object
             * Location not the table location
             */
            Query q = session.createQuery("from Location l where l.locationId = 1");
            q.setString("rented", "N");
            
            log.info("About to display the queried list");
            List roomList = q.list();
            for(Object o:roomList){
                log.info((Room) o);
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
