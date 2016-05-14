package com.dianzishangwu.yihunli.domain.dao;

import java.util.List;

import com.dianzishangwu.yihunli.domain.user.UserEntity;

public class UserEntityHibernate4 extends BaseDaoHibernate4<UserEntity>{

	public List<UserEntity> findUserEntityByPhone(String phone){
		return find("from UserEntity as en where en.phoneNumber = ?0",phone);
	}
	
	public List<UserEntity> findUserEntityByUserName(String userName){
		return find("from UserEntity as en  where en.userName = ?0",userName);
	}
}
