package com.mymovies.booker.resources;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.mymovies.booker.dto.BookTicketRequest;
import com.mymovies.booker.dto.BookTicketResponse;
import com.mymovies.booker.dto.CancelTicketRequest;
import com.mymovies.booker.dto.CancelTicketResponse;
import com.mymovies.booker.service.BookingService;

import lombok.Data;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/booker")
@Data
public class BookingResource {

	@Inject
	private BookingService service;
	
	@POST
	@Path("/book")
	public BookTicketResponse book(BookTicketRequest request) {
		
		return service.book(request);
	}
	
	@POST
	@Path("/cancel")
	public CancelTicketResponse cancel (CancelTicketRequest request) {
		
		return service.cancel(request);
	}
}
