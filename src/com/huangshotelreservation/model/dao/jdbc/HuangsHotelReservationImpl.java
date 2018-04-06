/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.huangshotelreservation.model.dao.jdbc;

import com.huangshotelreservation.model.dao.IHuangsHotelDao;
import com.huangshotelreservation.model.domain.AvailableRoom;
import com.huangshotelreservation.model.domain.City;
import com.huangshotelreservation.model.domain.Hotel;
import com.huangshotelreservation.model.domain.ReserveRoom;
import com.huangshotelreservation.model.domain.Room;
import com.huangshotelreservation.model.services.manager.PropertyManager;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
/**
 *
 * @author Zhijie Huang
 */
public class HuangsHotelReservationImpl implements IHuangsHotelDao {
    
    static Logger log = Logger.getLogger("Enter HuangsHotelReservationImpl");
    
    private Connection fetchConnection()
    {
        log.info("Fetching Database connection");
        
        Connection conn = null;
        
	/*
	 Values come out of the ...JDBCDAOSample\config\application.properties
	 file
	*/
        String url = PropertyManager.getPropertyValue("jdbc.url");
        String userid = PropertyManager.getPropertyValue("jdbc.user");
        String password = PropertyManager.getPropertyValue("jdbc.password");
        
        //load and register JDBC driver then connect to database
        
        try{
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            conn = DriverManager.getConnection(url,userid,password);
        }
        catch(SQLException e){
            log.error("Could not load and register JDBC driver or connect"
                    + "to database.");
            log.error(e.getClass()+":"+e.getMessage(),e);
        }
        
        return conn;
        
    } //End fetchConnection
    
    @Override
    public boolean getAvailableRentals(ReserveRoom reserveroom) {
        boolean status = false;
        
        	log.info("-------------------------------");
                log.info("Using JDBC Implementation");
                log.info("-------------------------------");
                log.info ("Inside Get Available Rentals");
                
                AvailableRoom availableRoom = null;
        try {
            availableRoom = fetchAvailableRooms();
        } catch (SQLException ex) {
            log.error("An error occured when trying to get the "
                        +"available rentals",ex);
        }
                
                if(availableRoom != null){
                    //indicate that rentals are available for customer statment
                    //request
                    availableRoom.setAvailable(true);
                    
                    availableRoom.setStateTax(6.89f);
                    
                    reserveroom.setAvailable(true);
                    
                    status = true;
                
                }
                                
        return status;
    }

    /**
     * 
     * @return availableRoom
     * @throws SQLException 
     */
    private AvailableRoom fetchAvailableRooms() throws SQLException  {
        AvailableRoom availableRoom = null;
        ResultSet rset = null;
        Statement stmt = null;
        Connection conn = null;
        
        log.info("-------->> Inside AvailableRooms");
        
        try{
            //create a connection
            conn = fetchConnection();
            
            if(conn != null){
                
                //create a statement
                stmt = conn.createStatement();
                /*
                rset = stmt.executeQuery("select c.bed_type,c.rate,c.rented"
                        + "from location l,car c where (l.idlocaiton = "
                        + "c.LOCATION_FK) AND (c.rented = 'N')");
                */
                
                rset = stmt.executeQuery("select r.bed_type from rooms r where r.rented = 'N';");
                availableRoom = buildAvailableRentals(rset);
            }
        }catch(SQLException e){
            log.error(e.getClass()+": "+e.getMessage(),e);
        
        }
        finally//close the resource in the finally block
        {
            try{
                //check for null first before closing
                if(stmt != null){
                    stmt.close();
                }
                if(conn != null){
                    conn.close();
                }
                
            } catch(SQLException e){
                log.error(e.getClass()+": "+e.getMessage(),e);
            }finally{
                /*Adding a finally block after the try to close connection
                * This will prevent resources not being released when there
                * is an exception happened during the close connection operation.
                * If the connection already closed, closing the statement
                * and statement again will do nothing.
                */
                
                stmt.close();
                conn.close();
            }
        }
        return availableRoom;
    }//end of fetchavailableroom
    
 
    private AvailableRoom buildAvailableRentals(ResultSet rset) {
        log.info("Inside buildAvailableRentals!!!");
        AvailableRoom availableRoom = null;
        
        try{
            // Note: isBeforeFirst: true if the cursor is before the first row; false if 
            // the cursor is at any other position or the result set contains no rows 
	    // Create availableRentals, only if resultSet has data.
                if(rset.isBeforeFirst()){
                    availableRoom = new AvailableRoom();
                }
            
                while(rset.next()){
                    //Hotel mapping:
                    //hotel(float rate,Room room,City city)
                    Room room = null;
                    switch(rset.getString(1)){
                        case "DOUBLE":
                            room = Room.DOUBLE;
                            break;
                        case "QUEEN" :
                            room = Room.QUEEN;
                        case "KING" :
                            room = Room.KING;
                        default:
                            room = Room.DOUBLE;
                            break;
                    }
                    
                    log.info("The room in the database is "+rset.getString(1));
                    availableRoom.addRoom(room);
                }
            
            } catch (SQLException ex) {
                log.error(ex.getClass()+": "+ex.getMessage(),ex);
            }
        return availableRoom;
    }//end build availableRoom
    
        public boolean reserveRentalRoom(ReserveRoom reserveroom){
            boolean status = false;
            log.info("-------------------------------");
            log.info("Using JDBC Implemenm:");
            log.info("-------------------------------");
            log.info("\n Inside of reserveRentalRoom!!!");
            
        try {
            status = removeSelectedRoom(reserveroom);
        } catch (SQLException ex) {
            log.error("There is an error when trying to remove the reserved"
                        +"rooms out of the database",ex);
        }
            
            return status;
        }

    private boolean removeSelectedRoom(ReserveRoom reserveroom) throws SQLException {
        
        boolean status = false;
        
        ResultSet rset = null;
        Statement stmt = null;
        Connection conn = null;
        
        log.info("-------->> Inside AvailableRooms");
        
        try{
            //create a connection
            conn = fetchConnection();
            
            if(conn != null){
                
     
                log.info("---------Executing delete query!!!-----");
                String deleteSQL = "DELETE FROM rooms WHERE bed_type = ?";
                
                PreparedStatement prestat = conn.prepareStatement(deleteSQL);
                prestat.setString(1,reserveroom.getRoom().toString());
                prestat.executeUpdate();
                status = true;
                
                
            }
        }catch(SQLException e){
            log.error(e.getClass()+": "+e.getMessage(),e);
            status = false;
        }
        finally//close the resource in the finally block
        {
            try{
                //check for null first before closing
                if(stmt != null){
                    stmt.close();
                }
                if(conn != null){
                    conn.close();
                }
                
            } catch(SQLException e){
                log.error(e.getClass()+": "+e.getMessage(),e);
            }finally{
                /*Adding a finally block after the try to close connection
                * This will prevent resources not being released when there
                * is an exception happened during the close connection operation.
                * If the connection already closed, closing the statement
                * and statement again will do nothing.
                */
                
                stmt.close();
                conn.close();
            }
        }
        return status;
    }
    
    
        
   }//End huangsHotelReservationImpl
