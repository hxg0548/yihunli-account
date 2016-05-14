package com.dianzishangwu.yihunli.domain.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T> {

	T get(Class<T> entityClazz,Serializable id) throws Exception;
	Serializable save(T entity) throws Exception;
	void delete(T entity) throws Exception;
	void delete(Class<T> entityClazz,Serializable id) throws Exception;
	List<T> findAll(Class<? extends T> entityClazz) throws Exception;
	long findCount(Class<T> entityClazz) throws Exception;
	
}
