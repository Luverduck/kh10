package select;

public class CustomerDto {

	// 필드
	int customerNum;
	String customerId;
	String customerTel;
	String customerRegistration;
	String customerPurchase;
	int customerPoint;
	String customerLv;
	
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
	public String getCustomerRegistration() {
		return customerRegistration;
	}
	public void setCustomerRegistration(String customerRegistration) {
		this.customerRegistration = customerRegistration;
	}
	public String getCustomerPurchase() {
		return customerPurchase;
	}
	public void setCustomerPurchase(String customerPurchase) {
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
