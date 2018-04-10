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
     * Holds the rooms that are available in this location As part of the
     * Hibernate mapping that there are one-to-many association between a
     * Location and a Room.
     *
     */
    private Set<Hotel> hotelRoomSet = new HashSet<>(0);
   
    public Location(){
    }

    public Location(String city) {
        this.city = city;
    }

       @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "idLOCATION", unique = true, nullable = false)
    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    
    @Column(name="CITY",length=20)
    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "location")
    public Set<Hotel> getHotelRoomSet() {
        return hotelRoomSet;
    }

    public void setHotelRoomSet(Set<Hotel> hotelRoomSet) {
        this.hotelRoomSet = hotelRoomSet;
    }
 
        
    
    public void addRoom(Hotel hotel){
        hotel.setLocation(this);
        hotelRoomSet.add(hotel);
    }
    
    public String toString() {
	StringBuffer buffer = new StringBuffer();
	buffer.append("\n\nLocation[");
	buffer.append("\t\ncity = ").append(city);
	buffer.append("\t\nlocationId = ").append(locationId);
	for (Hotel h : hotelRoomSet)
	{
		buffer.append(h);
	}
	buffer.append("\t\n]");
			
	 return buffer.toString();
    }
    
}
