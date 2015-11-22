package com.rodriguez.unai.ejerciciofinde;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class PilotDAO implements PilotDAOInterface {

	/* 
	 * selects one country by Id
	 * @param id
	 * @return Country
	 */
	public Pilot selectById(Long id) {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();
	 
	    Pilot pilot = (Pilot) session.get(Pilot.class, id);
	    
	    session.close();
	    return pilot;
	}

	/*
	 * retrieves all aircrafts from db
	 * @return List of pilots
	 */
	public List<Pilot> selectAll() {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();
	 
	    List<Pilot> pilots = session.createQuery("from Aircraft").list();
	    
	    session.close();
	    return pilots;
	}
	

	/*
	 * inserts a new country in database
	 * country must come with the id set 
	 * @param new country
	 */
	public void insert(Pilot pilot) {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();
	    session.beginTransaction();
	 
	    session.persist(pilot);    
	    
	    session.getTransaction().commit();	         
	    session.close();

	}

	/*
	 * updates country
	 * @param country to update
	 */
	public void update(Pilot pilot) {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		    Session session = sessionFactory.openSession();	 
		    session.beginTransaction();
		 
		    session.merge(pilot); 
		    
		    session.getTransaction().commit();		 
		    session.close();
	}
	

	/*
	 * delete given country
	 * @param country to delete
	 */
	public void delete(Pilot pilot) {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();	    
	    session.beginTransaction();
	    
	    session.delete(pilot);
	 
	    session.getTransaction().commit();
	    session.close();
	}

}