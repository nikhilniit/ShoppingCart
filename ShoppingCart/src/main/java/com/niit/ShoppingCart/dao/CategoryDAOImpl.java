package com.niit.ShoppingCart.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.ShoppingCart.model.Category;


@EnableTransactionManagement
@Repository("CategoryDAO")
public class CategoryDAOImpl implements CategoryDAO {
	@Autowired
private SessionFactory sessionFactory;
public CategoryDAOImpl(SessionFactory sessionFactory){
	this.sessionFactory=sessionFactory;
}
@Transactional
public boolean save(Category category){
try {
	sessionFactory.getCurrentSession().save(category);
	return true;
} catch (HibernateException e) {
	
	e.printStackTrace();
return false;}

}
public boolean update(Category category){
	try {
		sessionFactory.getCurrentSession().update(category);
		return true;
	} catch (HibernateException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	
	return false;
	}	
}
public boolean delete(Category category){
	try {
		sessionFactory.getCurrentSession().delete(category);
		return true;
	} catch (HibernateException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	}
	

	
}
public Category get(String id){
	String hql="from Category where id="+"'"+id+"'";
	Query query=sessionFactory.getCurrentSession().createQuery(hql);
	List<Category> list=  query.list();
	if(list==null){
	return null;
	}else {
		return list.get(0);
	}	
}
public List<Category> list(){
	String hql="from Category";
	Query query=sessionFactory.getCurrentSession().createQuery(hql);
	return query.list();
}
}