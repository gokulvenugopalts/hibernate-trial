package com.mindtree.embeddedhibernate.dataInsertion;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import com.mindtree.embeddedhibernate.entity.Address;
import com.mindtree.embeddedhibernate.entity.UserDetails;

public class HibernateEmbeddedInsert {
	public static void main(String[] args) {
		UserDetails user1 = new UserDetails(); // create first user
		UserDetails user2 = new UserDetails(); // create second user

		user1.setUserName("Rahul Chandran");
		user2.setUserName("Cherian Roy");

		Address address1 = new Address(); // create first value type object for
											// entity type object user1
		address1.setStreet("ABC");
		address1.setCity("Bangalore");
		address1.setState("Karnataka");
		address1.setPincode("345678");
		user1.setAddress(address1);

		Address address2 = new Address();// create second value type object for
											// entity type object user2
		address2.setStreet("East");
		address2.setCity("Cochin");
		address2.setState("Kerala");
		address2.setPincode("670987");
		user2.setAddress(address2);

		user1.setDob(new Date());
		user1.setPhone("+91-9988776655");

		user2.setDob(new Date());
		user2.setPhone("+91-8989776655");

		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory(); // create
																											// a
																											// session
																											// factory
																											// object
		Session session = sessionFactory.openSession(); // create session object
														// from session factory
		session.beginTransaction(); // begin transaction for this session

		session.save(user1); // save the first user
		session.save(user2); // save the second user

		session.getTransaction().commit(); // commit the transaction the session
		session.close(); // close the session
	}
}
