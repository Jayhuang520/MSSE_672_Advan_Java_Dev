/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.huangshotelreservation.model.domain;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Zhijie Huang
 */
@Entity
@Table(name = "location")
public class Location implements java.io.Serializable{

    /**
     * To uniquely identify this location.
     */
    
    private Integer locationId;
    
      /**
     * City name of this location
     */
    private String city;
    
     /**
     * Holds the cars that are available in this location As part of the
     * Hibernate mapping that there are one-to-many association between a
     * Location and a Car.
     *
     */
    private Set<Room> roomSet = new HashSet<>(0);
    private Integer locaitonId;
    
    public Location(){
    }

    public Location(String denver) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "idLOCATION", unique = true, nullable = false)
    public Integer getLocationId() {
        return this.locaitonId;
    }

    public void setLocaitonId(Integer locationId) {
        this.locaitonId = locationId;
    }
    
    @Column(name = "CITY", length = 20)
    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "location")
    public Set<Room> getRoomSet() {
        return roomSet;
    }

    public void setRoomSet(Set<Room> roomsSet) {
        this.roomSet = roomsSet;
    }
    
}
