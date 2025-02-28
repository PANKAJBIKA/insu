package spring.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class insorder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderId;
	private String name;
	private String email;
	private Integer amount;
	private String orderStatus;
	private String razorPayOrderId;
}
