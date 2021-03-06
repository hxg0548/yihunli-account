package com.dianzishangwu.yihunli.domain.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;


public class BaseDaoHibernate4<T> implements BaseDao<T>{

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	public SessionFactory getSessionFactory(){
		return sessionFactory;
	}
	
	@SuppressWarnings("unchecked")
	public T get(Class<T> entityClazz, Serializable id) {
		return (T)getSessionFactory().getCurrentSession().get(entityClazz, id);
	}

	public Serializable save(T entity) {
		return getSessionFactory().getCurrentSession().save(entity);
	}
	
	public void update(T entity){
		getSessionFactory().getCurrentSession().update(entity);
	}

	public void delete(T entity) {
		getSessionFactory().getCurrentSession().delete(entity);
	}

	public void delete(Class<T> entityClazz, Serializable id) {
        getSessionFactory().getCurrentSession()
                .createQuery("delete " + entityClazz.getSimpleName()
                		+ " en where en.id = ?0")
                .setParameter("0", id)
                .executeUpdate();              
	}

	public List<T> findAll(Class<? extends T> entityClazz) {
		return find("select en from " + entityClazz.getSimpleName() + " en");
	}

	public long findCount(Class<T> entityClazz) {
		List<?> l = find("select count(*) from " + entityClazz.getSimpleName());
		if(l != null && l.size() == 1){
			return (Long)l.get(0);
		}
		return 0;
	}
	
	public long findCountByCondition(Class<T> entityClazz,String columnName,Object coumnValue,String symbol) {
		List<?> l = find("select count(*) from " + entityClazz.getSimpleName() + " en where en." + columnName + symbol + coumnValue);
		if(l != null && l.size() == 1){
			return (Long)l.get(0);
		}
		return 0;
	}
	
	@SuppressWarnings("unchecked")
    protected List<T> find(String hql){
		return (List<T>)getSessionFactory().getCurrentSession()
				 .createQuery(hql)
				 .list();
	}
	
	@SuppressWarnings("unchecked")
	protected List<T> find(String hql,Object... params){
		Query query = getSessionFactory().getCurrentSession()
				.createQuery(hql);
		for(int i = 0;i < params.length;i++){
			query.setParameter(i + "", params[i]);
		}
		return (List<T>)query.list();
	}
	
	@SuppressWarnings("unchecked")
	protected List<T> findByPage(String hql,int pageNo,int pageSize){
		return getSessionFactory().getCurrentSession()
				.createQuery(hql)
				.setFirstResult((pageNo - 1) * pageSize)
				.setMaxResults(pageSize)
				.list();
	}
	
	@SuppressWarnings("unchecked")
	protected List<T> findByPage(String hql,int pageNo,int pageSize,Object... params){
		Query query = getSessionFactory().getCurrentSession()
				.createQuery(hql);
		for(int i = 0 , len = params.length; i < len; i ++){
			query.setParameter(i + "", params[i]);
		}
		return query.setFirstResult((pageNo - 1) * pageSize)
				.setMaxResults(pageSize)
				.list();
	}
}
