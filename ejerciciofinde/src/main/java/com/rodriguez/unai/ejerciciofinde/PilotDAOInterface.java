package com.rodriguez.unai.ejerciciofinde;

import java.util.List;

public interface PilotDAOInterface {
	
	public Pilot selectById(Long id);
	public List<Pilot> selectAll ();
	public void insert (Pilot pilot);
	public void update (Pilot pilot);
	public void delete (Pilot pilot);

}

