package com.mymovies.booker.service;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.flyppo.cb.exceptions.DBException;
import com.mymovies.booker.dao.ShowDao;
import com.mymovies.booker.dto.BookTicketRequest;
import com.mymovies.booker.dto.BookTicketResponse;
import com.mymovies.booker.dto.CancelTicketRequest;
import com.mymovies.booker.dto.CancelTicketResponse;
import com.mymovies.booker.model.Show;

import lombok.extern.slf4j.Slf4j;

@Singleton
@Slf4j
public class BookingService {
	
	@Inject
	ShowDao dao;

	/**
	 * book API implementation
	 * 
	 * @param request
	 * @return
	 */
	public synchronized BookTicketResponse book (BookTicketRequest request) {
		
		BookTicketResponse response = new BookTicketResponse();
		boolean success = false;
		
		// get show
		try {
			
			// fetch the document
			Show show = dao.getOrNull(request.getShowID());

			// book the seat
			success = show.bookSeat(request.getSeat());
			
			// persist the document
			dao.save(show);

		} catch (DBException e) {
			
			log.error("error while fetching the show document", request.getShowID(), e);
			response.setError("internal error");
		}
		
		if (success)
			response.setSuccess(true);
		else
			response.setError("seat unavailable");

		return response;
	}
	
	/**
	 * service implementation for cancellation of ticket
	 * 
	 * @param request
	 * @return
	 */
	public synchronized CancelTicketResponse cancel (CancelTicketRequest request) {
		
		CancelTicketResponse response = new CancelTicketResponse();

		boolean success = false;
		
		// get show
		try {
			
			// fetch the document
			Show show = dao.getOrNull(request.getShowID());

			// cancel the seat
			success = show.cancel(request.getSeat());
			
			// persist the document
			dao.save(show);

		} catch (DBException e) {
			
			log.error("error while fetching the show document", request.getShowID(), e);
			response.setError("internal error");
		}
		
		if (success)
			response.setSuccess(true);
		else
			response.setError("seat not booked");

		return response;
	}
}
