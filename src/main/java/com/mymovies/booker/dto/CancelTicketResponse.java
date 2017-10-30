package com.mymovies.booker.dto;

import lombok.Data;

/**
 * DTO class for ticket cancellation response
 * 
 * @author akshar
 *
 */
@Data
public class CancelTicketResponse {

	private String error;
	private boolean success;
}
