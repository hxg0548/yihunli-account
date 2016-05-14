package com.dianzishangwu.yihunli.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.dianzishangwu.yihunli.domain.dao.UserEntityHibernate4;
import com.dianzishangwu.yihunli.domain.user.Merchant;
import com.dianzishangwu.yihunli.domain.user.UserEntity;

public class UserEntityService {

	private UserEntityHibernate4 userEntityDao;
	
	public void setUserEntityDao(UserEntityHibernate4 userEntityDao){
		this.userEntityDao = userEntityDao;
	}
	
	@SuppressWarnings("unchecked")
	public Serializable save(UserEntity userEntiry){
		return userEntityDao.save(userEntiry);
	}
	
	public UserEntity get(Serializable id){
		return userEntityDao.get(UserEntity.class, id);
	}
	
	public void delete(UserEntity userEntity){
		userEntityDao.delete(userEntity);
	}
	
	public void update(UserEntity userEntity){
		userEntityDao.update(userEntity);
	}
	
	public UserEntity findByPhone(String phone){
		List<UserEntity> userEntities = userEntityDao.findUserEntityByPhone(phone);
		if(userEntities == null || userEntities.size() == 0) return null;
		return userEntities.get(0);	
	}
	
	public UserEntity findByUserName(String userName){
		List<UserEntity> userEntitys = userEntityDao.findUserEntityByUserName(userName);
		if(userEntitys == null || userEntitys.size() == 0) return null;
		return userEntitys.get(0);
	}
	
	@SuppressWarnings("unchecked")
	public List<Merchant> findMerchants(){		
		List<Merchant> merchants = new ArrayList<Merchant>();
		List<UserEntity> userEntities = (List<UserEntity>) userEntityDao.findAll(Merchant.class);	
		for(UserEntity entity : userEntities){
			merchants.add((Merchant)entity);
		}
		return merchants;
	}
	
}
