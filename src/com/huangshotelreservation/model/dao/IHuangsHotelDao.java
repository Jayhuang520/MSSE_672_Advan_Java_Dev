/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.huangshotelreservation.model.dao;

import com.huangshotelreservation.model.domain.ReserveRoom;


/**
 *
 * @author JayHu
 */
public interface IHuangsHotelDao {
    
    public boolean getAvailableRentals(ReserveRoom reserveroom);
    
    public boolean reserveRentalRoom(ReserveRoom reserveroom);
    
}
