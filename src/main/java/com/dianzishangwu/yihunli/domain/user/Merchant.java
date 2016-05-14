package com.dianzishangwu.yihunli.domain.user;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="merchant_inf",indexes=@Index(columnList="phoneNumber",name="phone_index"))
public class Merchant extends UserEntity{

	private String tradeMark;
	private String companyName;
	private String companyIntroduce;
	private String accountSubject;
	
	public String getAccountSubject() {
		return accountSubject;
	}
	public void setAccountSubject(String accountSubject) {
		this.accountSubject = accountSubject;
	}
	@Enumerated(EnumType.ORDINAL)
	private WEDDTYPE merchantType;
	
    public WEDDTYPE getMerchantType() {
		return merchantType;
	}
	public void setMerchantType(WEDDTYPE merchantType) {
		this.merchantType = merchantType;
	}
	
	public enum WEDDTYPE{	 
   	 WEDDING_PLANNER,//婚礼策划
   	 WEDDING_SHOTOS,//摄像师
   	 WEDDING_CAMERAMAN,//摄影师
   	 WEDDING_DRESSER,//化妆师
   	 WEDDING_COMPERE,//主持人
   	 WEDDING_STORY,//故事
   	 WEDDING_DRESSES //婚礼礼服
    }
    
	@Transient
	private String businessScope;
	
	private String serviceTel;
	public String getTradeMark() {
		return tradeMark;
	}
	public void setTradeMark(String tradeMark) {
		this.tradeMark = tradeMark;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyIntroduce() {
		return companyIntroduce;
	}
	public void setCompanyIntroduce(String companyIntroduce) {
		this.companyIntroduce = companyIntroduce;
	}
	public String getBusinessScope() {
		return businessScope;
	}
	public void setBusinessScope(String businessScope) {	
		this.businessScope = businessScope;
		if(businessScope != "" && businessScope != null)
		setMerchantType(Enum.valueOf(WEDDTYPE.class,businessScope));
	}
	public String getServiceTel() {
		return serviceTel;
	}
	public void setServiceTel(String serviceTel) {
		this.serviceTel = serviceTel;
	}
	
}
