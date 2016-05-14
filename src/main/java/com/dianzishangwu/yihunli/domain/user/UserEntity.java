package com.dianzishangwu.yihunli.domain.user;

import javax.persistence.AttributeOverrides;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;



@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name="userentity_inf")
public class UserEntity 
{
	
	@Id @Column(name="entity_id")
	@GenericGenerator(name="entity_hilo",strategy="hilo")
	@GeneratedValue(generator="entity_hilo")
	private Integer entityId;
	
	private String userName;
	private String password;
	private String email;
	private String phoneNumber;
	private String realName;
	private String logo;
	
	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="province",column=@Column(name="address_province")),
		@AttributeOverride(name="city",column=@Column(name="address_city")),
		@AttributeOverride(name="district",column=@Column(name="address_district")),
		@AttributeOverride(name="detailAddress",column=@Column(name="address_detailAddress"))
	})
	private Address address;

	@Enumerated(EnumType.ORDINAL)
	private ENTITY entityType;
	
	public enum ENTITY {
		INDIVIDUAL("individual"),MERCHANT("merchant");
				
		private String entity;
	    ENTITY(String entityType){
	    	this.entity = entityType;
	    }
	    
	    public String toString(){
	    	return entity;
	    }	    
	}
	
	public UserEntity(){ }
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}											
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Integer getEntityId() {
		return entityId;
	}
	protected void setEntityId(Integer entityId) {
		this.entityId = entityId;
	}
	public ENTITY getEntityType() {
		return entityType;
	}
	public void setEntityType(ENTITY entityType) {
		this.entityType = entityType;
	}
	
	
}
