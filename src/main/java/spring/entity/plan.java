package spring.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
@Entity
public class plan {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long plan_id;

	    private String name;
	    private String description;
	    private double premium;
	    @ManyToOne
	    @JoinColumn(name = "insurance_id")
	    @JsonBackReference
	    private Insurance insurance;
		public Long getId() {
			return plan_id;
		}
		public void setId(Long id) {
			this.plan_id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public double getPremium() {
			return premium;
		}
		public void setPremium(double premium) {
			this.premium = premium;
		}
		public Insurance getInsurance() {
			return insurance;
		}
		public void setInsurance(Insurance insurance) {
			this.insurance = insurance;
		}
	    
}
