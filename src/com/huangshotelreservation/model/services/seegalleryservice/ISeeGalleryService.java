package com.huangshotelreservation.model.services.seegalleryservice;

import java.io.IOException;
import java.util.ArrayList;

import com.huangshotelreservation.model.domain.City;
import com.huangshotelreservation.model.domain.Room;
import com.huangshotelreservation.model.services.IService;
import com.huangshotelreservation.model.services.exception.SeeGalleryException;

/**
 * 
 * @author zhijiehuang
 *
 */

public interface ISeeGalleryService extends IService{
	
	public final String NAME = "ISeeGalleryService";
	
	/*
	 * Declaration of retrievePicture
	 */
	public boolean retrievePicture(ArrayList<Room> availableRoomList) throws SeeGalleryException;
	
	/*
	 * Declaration of RetreiveRoom
	 */
	public boolean retrieveRoom(City city) 
			throws SeeGalleryException;
}
