package spring.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class StudentOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderId;
	private String name;
	private String Email;

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	private Integer amount;
	private String orderStatus;
	private String razorPayOrderId;

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getRazorPayOrderId() {
		return razorPayOrderId;
	}

	public void setRazorPayOrderId(String razorPayOrderId) {
		this.razorPayOrderId = razorPayOrderId;
	}

	
}
