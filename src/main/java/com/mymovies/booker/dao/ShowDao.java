package com.mymovies.booker.dao;

import com.flyppo.cb.dao.CouchbaseGenericDAO;
import com.mymovies.booker.model.Show;

/**
 * Database wrapper layer
 * 
 * @author akshar
 *
 */
public class ShowDao extends CouchbaseGenericDAO<Show> {

	public ShowDao(Class<Show> clazz) {
		super(clazz);
	}

	@Override
	public String getDocumentID(Show t) {
		
		return t.getID();
	}
}
