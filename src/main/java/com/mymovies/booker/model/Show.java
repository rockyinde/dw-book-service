package com.mymovies.booker.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import lombok.Data;

@Data
public class Show {

	private int screen;
	private Date date;
	private Set<Integer> bookedSeats = new HashSet<>();
	
	/**
	 * returns a unique id for the show/screening
	 * @return
	 */
	public String getID() {
		
		return "show"+screen+date.toString();
	}
	
	/**
	 * tries to book a seat
	 * 
	 * @param seat
	 * @return
	 */
	public boolean bookSeat (int seat) {
		
		if (bookedSeats.contains(seat))
			return false;
		
		bookedSeats.add(seat);
		
		return true;
	}
	
	/**
	 * cancels the seat
	 * 
	 * @param seat
	 * @return
	 */
	public boolean cancel (int seat) {
		
		if (!bookedSeats.contains(seat))
			return false;
		
		bookedSeats.remove(seat);
		
		return true;
	}
}
