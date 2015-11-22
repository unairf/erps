package com.rodriguez.unai.ejerciciofinde;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class AircraftDAO implements AircraftDAOInterface {

	/* 
	 * selects one country by Id
	 * @param id
	 * @return Country
	 */
	public Aircraft selectById(Long id) {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();
	 
	    Aircraft aircraft = (Aircraft) session.get(Aircraft.class, id);
	    
	    session.close();
	    return aircraft;
	}

	/*
	 * retrieves all aircrafts from db
	 * @return List of countrys
	 */
	public List<Aircraft> selectAll() {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();
	 
	    List<Aircraft> aircrafts = session.createQuery("from Aircraft").list();
	    
	    session.close();
	    return aircrafts;
	}
	

	/*
	 * inserts a new country in database
	 * country must come with the id set 
	 * @param new country
	 */
	public void insert(Aircraft aircraft) {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();
	    session.beginTransaction();
	 
	    session.persist(aircraft);    
	    
	    session.getTransaction().commit();	         
	    session.close();

	}

	/*
	 * updates country
	 * @param country to update
	 */
	public void update(Aircraft aircraft) {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		    Session session = sessionFactory.openSession();	 
		    session.beginTransaction();
		 
		    session.merge(aircraft); 
		    
		    session.getTransaction().commit();		 
		    session.close();
	}
	

	/*
	 * delete given country
	 * @param country to delete
	 */
	public void delete(Aircraft aircraft) {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();	    
	    session.beginTransaction();
	    
	    session.delete(aircraft);
	 
	    session.getTransaction().commit();
	    session.close();
	}

}
