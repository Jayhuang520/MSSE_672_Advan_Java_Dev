package com.huangshotelreservation.model.domain;
import java.io.Serializable;


/**
 * 
 * @author Jay Huang
 *
 */

public class Customer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5083099771658862389L;

	/**customer last name*/
	private String lastName;
	
	/**customer first name*/
	private String firstName;
	
	/**customer username*/
	private String userName;
	
	/**customer password*/
	private String password;
	
	/**customer address*/
	private String address;
	
	/**customer phone number*/
	private String phoneNumber;
	
	private String ID;
	
	/**
	 * 
	 * @param lastName
	 * @param firstName
	 * @param userName
	 * @param passWord
	 * @param address
	 * @param phoneNumber
	 * @param ID
	 */
	public Customer(String lastName,String firstName,String userName,
			String password, String address, String phoneNumber,
			String ID) 
	{
		this.lastName = lastName;
		this.firstName = firstName;
		this.userName = userName;
		this.password = password;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.ID = ID;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}
	
	public boolean validate() {
		if(lastName == null) 
			return false;
		if(firstName == null) 
			return false;
		if(userName == null) 
			return false;
		if(password == null) 
			return false;
		if(address == null) 
			return false;
		if(phoneNumber == null) 
			return false;
		if(ID == null) 
			return false;
		
		return true;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) return false;
		if(obj == null) return false;
		if(getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		
		String returnString;
		returnString="Customer name: "+lastName+","+firstName+"\n"
				+"User name: "+ userName
				+"\npassword: "+password
				+"\nAddress: " +address 
				+"\nphone number"+phoneNumber;
		return returnString;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result
				+ ((userName == null) ? 0 : userName.hashCode());
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result
				+ ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		return result;
	}
	
}
