package com.dianzishangwu.yihunli.domain.user;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Index;

@Entity
@Table(name="individual_inf",indexes=@Index(columnList="phoneNumber",name="phone_index"))
public class Individual extends UserEntity{

	private String image;
	
	public Individual(){}
	public void setImage(String image){
		this.image = image;
	}
	public String getImage(){
		return image;
	}
	
}
