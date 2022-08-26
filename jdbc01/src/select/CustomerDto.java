package select;

public class CustomerDto {

	// 필드
	int customer_num;
	String customer_id;
	String customer_tel;
	String customer_registration;
	String customer_purchase;
	int customer_point;
	String customer_lv;
	
	// getter & setter
	public int getCustomer_num() {
		return customer_num;
	}

	public void setCustomer_num(int customer_num) {
		this.customer_num = customer_num;
	}

	public String getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}

	public String getCustomer_tel() {
		return customer_tel;
	}

	public void setCustomer_tel(String customer_tel) {
		this.customer_tel = customer_tel;
	}

	public String getCustomer_registration() {
		return customer_registration;
	}

	public void setCustomer_registration(String customer_registration) {
		this.customer_registration = customer_registration;
	}

	public String getCustomer_purchase() {
		return customer_purchase;
	}

	public void setCustomer_purchase(String customer_purchase) {
		this.customer_purchase = customer_purchase;
	}

	public int getCustomer_point() {
		return customer_point;
	}

	public void setCustomer_point(int customer_point) {
		this.customer_point = customer_point;
	}

	public String getCustomer_lv() {
		return customer_lv;
	}

	public void setCustomer_lv(String customer_lv) {
		this.customer_lv = customer_lv;
	}

	// toString 오버라이딩
	@Override
	public String toString() {
		return "CustomerDto [customer_num=" + customer_num + ", customer_id=" + customer_id + ", customer_tel="
				+ customer_tel + ", customer_registration=" + customer_registration + ", customer_purchase="
				+ customer_purchase + ", customer_point=" + customer_point + ", customer_lv=" + customer_lv + "]";
	}
}
