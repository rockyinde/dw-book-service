package com.mymovies.booker.dto;

import lombok.Data;

/**
 * DTO class to cancel a ticket
 * 
 * @author akshar
 *
 */
@Data
public class CancelTicketRequest {

	private String showID;
	private int seat;
}
