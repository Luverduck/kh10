package com.kh.spring10.entity;

import java.sql.Date;

public class CustomerDto {
	
	// 필드
	int customerNum;
	String customerId;
	String customerTel;
	Date customerRegistration;
	Date customerPurchase;
	int customerPoint;
	String customerLv;
	
	// 생성자
	public CustomerDto() {
		super();
	}
	
	// getter & setter
	public int getCustomerNum() {
		return customerNum;
	}

	public void setCustomerNum(int customerNum) {
		this.customerNum = customerNum;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerTel() {
		return customerTel;
	}

	public void setCustomerTel(String customerTel) {
		this.customerTel = customerTel;
	}

	public Date getCustomerRegistration() {
		return customerRegistration;
	}

	public void setCustomerRegistration(Date customerRegistration) {
		this.customerRegistration = customerRegistration;
	}

	public Date getCustomerPurchase() {
		return customerPurchase;
	}

	public void setCustomerPurchase(Date customerPurchase) {
		this.customerPurchase = customerPurchase;
	}

	public int getCustomerPoint() {
		return customerPoint;
	}

	public void setCustomerPoint(int customerPoint) {
		this.customerPoint = customerPoint;
	}

	public String getCustomerLv() {
		return customerLv;
	}

	public void setCustomerLv(String customerLv) {
		this.customerLv = customerLv;
	}

	// toString 오버라이딩
	@Override
	public String toString() {
		return "CustomerDto [customerNum=" + customerNum + ", customerId=" + customerId + ", customerTel=" + customerTel
				+ ", customerRegistration=" + customerRegistration + ", customerPurchase=" + customerPurchase
				+ ", customerPoint=" + customerPoint + ", customerLv=" + customerLv + "]";
	}
	
}
