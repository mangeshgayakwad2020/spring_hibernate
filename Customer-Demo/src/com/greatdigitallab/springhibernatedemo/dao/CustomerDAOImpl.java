package com.greatdigitallab.springhibernatedemo.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.greatdigitallab.springhibernatedemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	// Get the Hibernate Session Factory
	@Autowired
	private SessionFactory sessionFactory;
	
	// Retrieve the Customer List from database
	@Override
	public List<Customer> getCustomerList() {
		
		// Get the Hibernate Session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// Create Query
		Query fetchQuery = currentSession.createQuery("from Customer order by lastName", Customer.class);
		
		// Get the result set
		List<Customer> customerList = fetchQuery.getResultList();
		
		return customerList;
	}

	@Override
	public void saveCustomer(Customer customer) {

		// Get the Hibernate current session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// Save/Update the Customer
		currentSession.saveOrUpdate(customer);
	}

	@Override
	public Customer getCustomer(int id) {

		// Get the current Hibernate Session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// Retrieve the customer using primary key i.e. id
		Customer customer = currentSession.get(Customer.class, id);
		
		return customer;
	}

	@Override
	public void deleteCustomer(int id) {

		// Get the Hibernate Session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// Delete object with primary key
		Query query = currentSession.createQuery("delete from Customer where id=:customerId");
		
		query.setParameter("customerId", id);
		
		query.executeUpdate();
	}
}