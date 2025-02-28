package spring.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table
public class Nominee {
	   @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long Na_id;
	    private String name;
	    private String relationship;
	    private String phone;
	    private String email;
	    @ManyToOne
	    @JoinColumn(name = "IB_id", nullable = false)
	    @JsonBackReference
	    private InsuranceBooking insuranceBooking;

		public Nominee() {
			super();
		}

		public Nominee(Long na_id, String name, String relationship, String phone, String email,
				InsuranceBooking insuranceBooking) {
			super();
			Na_id = na_id;
			this.name = name;
			this.relationship = relationship;
			this.phone = phone;
			this.email = email;
			this.insuranceBooking = insuranceBooking;
		}

		public Long getNa_id() {
			return Na_id;
		}

		public void setNa_id(Long na_id) {
			Na_id = na_id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getRelationship() {
			return relationship;
		}

		public void setRelationship(String relationship) {
			this.relationship = relationship;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public InsuranceBooking getInsuranceBooking() {
			return insuranceBooking;
		}

		public void setInsuranceBooking(InsuranceBooking insuranceBooking) {
			this.insuranceBooking = insuranceBooking;
		}

		@Override
		public String toString() {
			return "Nominee [Na_id=" + Na_id + ", name=" + name + ", relationship=" + relationship + ", phone=" + phone
					+ ", email=" + email + ", insuranceBooking=" + insuranceBooking + "]";
		}
		
	    
}
