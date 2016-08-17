package com.niit.ShoppingCart.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.niit.ShoppingCart.model.Supplier;



public class SupplierDAOImpl implements SupplierDAO {
private SessionFactory sessionFactory;
public SupplierDAOImpl(SessionFactory sessionFactory){
	this.sessionFactory=sessionFactory;
}

public boolean save(Supplier supplier){
try {
	sessionFactory.getCurrentSession().save(supplier);
	return true;
} catch (HibernateException e) {
	
	e.printStackTrace();
return false;}

}
public boolean update(Supplier supplier){
	try {
		sessionFactory.getCurrentSession().update(supplier);
		return true;
	} catch (HibernateException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	
	return false;
	}	
}
public boolean delete(Supplier supplier){
	try {
		sessionFactory.getCurrentSession().delete(supplier);
		return true;
	} catch (HibernateException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	}
	

	
}
public Supplier get(String id){
	String hql="from Supplier where id="+"'"+id+"'";
	Query query=sessionFactory.getCurrentSession().createQuery(hql);
	List<Supplier> list=  query.list();
	if(list==null){
	return null;
	}else {
		return list.get(0);
	}	
}
public List<Supplier> list(){
	String hql="from Supplier";
	Query query=sessionFactory.getCurrentSession().createQuery(hql);
	return query.list();
}
}