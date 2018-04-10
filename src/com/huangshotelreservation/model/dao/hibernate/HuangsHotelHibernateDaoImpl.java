package com.huangshotelreservation.model.dao.hibernate;

import com.huangshotelreservation.model.dao.IHuangsHotelDao;
import com.huangshotelreservation.model.domain.AvailableRoom;
import com.huangshotelreservation.model.domain.ReserveRoom;
import com.huangshotelreservation.model.services.factory.HibernateSessionFactory;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * This is where the Hibernate Code goes into.
 *
 * To this DAO, need to make sure the data is setup as discussed in the slides.
 *
 * Exceptions are not handled here and are left as a student exercise.
 *
 * Any exception(s) that happen here are to be propagated appropriately to the
 * calling tiers.
 *
 * @author JayHu
 *
 *
 */

/**
 *
 * @author JayHu
 */
public class HuangsHotelHibernateDaoImpl implements IHuangsHotelDao{
    /*
     * Category set in config/log4j.properties as
     * log4j.category.com.classexercise=DEBUG, A1
     */
    static Logger log = Logger.getLogger("com.fleetrentalhibernatedaosample");

    
    @Override
    public boolean getAvailableRentals(ReserveRoom reserveroom) {
        boolean status = false;

        log.info("-------------------------------");
        log.info("Using Hibernate Implementation");
        log.info("-------------------------------");

        log.info("Available Rentals");
        AvailableRoom availableRoom = null;

        //Session session = fetchSession();
        availableRoom = fetchAvailableRooms();

        if (availableRoom != null) {
            // indicate that rentals are available for customer's request
            
            availableRoom.setAvailable(true);
                    
            availableRoom.setStateTax(6.89f);
                    
            reserveroom.setAvailable(true);
            
            // set the return status
            status = true;
        }
        return status;
    }

    @Override
    public boolean reserveRentalRoom(ReserveRoom reserveroom) {
        boolean status = false;
        log.error("\n Reservation Implementation not complete");
        return status;
    }
    
    /**
     * Gets a hibernate session from HibernateSessionFactory
     *
     * @return org.hibernate.Session
     *
     */
    private Session fetchSession() {
        log.info("******Fetching Hibernate Session");

        Session session = HibernateSessionFactory.currentSession();

        return session;

    } //end fetchConnection

    private AvailableRoom fetchAvailableRooms() {
        AvailableRoom availableRoom = null;
        Transaction tx = null;
        List<ReserveRoom> reserveRoomList = null;
        try{
            Session session = fetchSession();
            tx = session.beginTransaction();
            
            Query query = session.createQuery("select room from location l join reserveRoomSet where room.rented = :rented");
            query.setString("rented", "N");
            
        }catch(Exception e){
            if(tx!= null){
                tx.rollback();
            }
            log.error(e.getClass() + ": "+e.getMessage(),e);
            
        }finally{
            HibernateSessionFactory.closeSessionAndFactory();
        }
        return availableRoom;
    }
    
}