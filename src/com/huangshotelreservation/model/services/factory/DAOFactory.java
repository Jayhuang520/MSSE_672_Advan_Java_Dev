/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.huangshotelreservation.model.services.factory;

import com.huangshotelreservation.model.services.exception.DaoLoadException;
import com.huangshotelreservation.model.dao.IHuangsHotelDao;
import com.huangshotelreservation.model.services.manager.PropertyManager;

/**
 *
 * @author JayHu
 */
public class DAOFactory {
    public static IHuangsHotelDao getDao() throws DaoLoadException{
        Class  c;
        Object o = null;
        
        	try
                {
		// lets get the concrete service from the property file
		// and assign (reuse) to serviceString
		//
		// This property value is set in config/application.properties
		String daoImplString = PropertyManager.
                            getPropertyValue("IHuangsHotelDao");

        	// using the fully qualified service name,
            	// lets create and instance of the class
            	c = Class.forName(daoImplString);
		o = c.newInstance();

                } catch (ClassNotFoundException e) {
		  throw new DaoLoadException("Class not found", e);
		} catch (InstantiationException e) {
		  throw new DaoLoadException("Instantiation Issue", e);
		} catch (IllegalAccessException e) {
		  throw new DaoLoadException("Illegal Access Issue", e);
		}
        return (IHuangsHotelDao)o;
   } //end getService
}//end ServiceFactory
