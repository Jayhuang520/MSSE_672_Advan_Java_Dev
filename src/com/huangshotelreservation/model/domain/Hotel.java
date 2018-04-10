package com.huangshotelreservation.model.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="rooms")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        name="discriminator",
        discriminatorType=DiscriminatorType.STRING
)
@DiscriminatorValue(value="R")
public class Hotel extends SuperRoom implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5538770477273119572L;

	/**
	 * Domain Hotel class that holds the rental rate of the hotel room,
	 * room types
	 */
    
	/** Daily rate */
	private float rate;
	
	/**room type*/
	//private Room room;
	
	/** city */
	//private City city;
	
        /**
        * Y/N : Rented/Not Rented
        */
        private String rented;
        
        /**
        * Location where this car is available
        */
        private Location location;
        
        public Hotel() {
		//Does nothing now
	}

	/**
	 * 
	 * @param rate
	 * @param room
	 */
	public Hotel(float rate,Room room) {
		super();
		this.rate = rate;
		//this.room = room;
	}
	
	/**
	 * 
	 * @param rate
	 * @param room
	 * @param city
	 */
	public Hotel(float rate,Room room,City city) {
		super();
		this.rate = rate;
		//this.room = room;
		//this.city = city;
	}
        
        public Hotel(String bedType,float rate,Room room,City city,String rented){
            super(bedType);
            
            this.rate = rate;
            //this.room = room;
            //this.city = city;
            this.rented = rented;
        }
        
        

        @Column(name = "rented", length = 1)
        public String getRented() {
            return rented;
        }

        public void setRented(String rented) {
            this.rented = rented;
        }

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "LOCATION_FK", nullable = false)
        public Location getLocation() {
            return location;
        }

        public void setLocation(Location location) {
            this.location = location;
        }

	/**
	 * @return Returns the rate.
	 */
        @Column(name = "rate", precision = 12)
	public float getRate() {
		return rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}

        /*
	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}
        */
	
        /*
	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}
        */
	
	public boolean validate () 
	{
		if(rate == 0.0) return false;
		//if(room == null) return false;
		//if(city == null) return false;
		return true;
	}
	
	/**
	 * 
	 * @param hotel
	 * @return
	 */
	public boolean equals(Hotel hotel) 
	{
		if(rate != hotel.rate) return false;
		//if(room != hotel.room) return false;
		//if(city != hotel.city) return false;
		
		return true;
	}
	
	/**
	 *  toString method useful for logging
	 *  
	 */
	public String toString() 
	{
		StringBuffer strBuf = new StringBuffer();
                strBuf.append("\t\n\nRoom[");
		strBuf.append("\nRate: ");
		strBuf.append(rate+"\n");
                strBuf.append("rented = ");
                strBuf.append(rented);
		//strBuf.append("Room type is:");
		//strBuf.append(room + "\n");
		//strBuf.append("In City:");
		//strBuf.append(city + "\n");
                strBuf.append("]\n");
		
		return strBuf.toString();
	}
	
	
}//end of Hotel

