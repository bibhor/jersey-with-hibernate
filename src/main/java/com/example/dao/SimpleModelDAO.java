package com.example.dao;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.example.model.SimpleModel;

public class SimpleModelDAO {
	
	private Session getCurrentSession() {		
		return HibernateUtil.getSessionFactory().getCurrentSession();
	}
	
	public SimpleModelDAO() {}
	
	public List<SimpleModel> getResults() {
		// TODO Auto-generated constructor stub
		Session s = getCurrentSession();
		Transaction tx = s.beginTransaction();
		Criteria cr = s.createCriteria(SimpleModel.class);		
		// If testtype is not 5 then it is regular segment export		
		return cr.list();
	}
}
