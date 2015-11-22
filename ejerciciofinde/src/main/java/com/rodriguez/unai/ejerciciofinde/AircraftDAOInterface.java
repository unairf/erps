package com.rodriguez.unai.ejerciciofinde;

import java.util.List;


/**
 * interface for AircraftDAO class
 * @author Unai Rodríguez
 */
public interface AircraftDAOInterface {
	
	public Aircraft selectById(Long id);
	public List<Aircraft> selectAll ();
	public void insert (Aircraft aircraft);
	public void update (Aircraft aircraft);
	public void delete (Aircraft aircraft);

}

