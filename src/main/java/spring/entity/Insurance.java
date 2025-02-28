package spring.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Insurance {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String name;

	    @Enumerated(EnumType.STRING)
	    private InsuranceType type;

	    @OneToMany(mappedBy = "insurance", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	    @JsonManagedReference
	    private List<plan> plans;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public InsuranceType getType() {
			return type;
		}

		public void setType(InsuranceType type) {
			this.type = type;
		}

		public List<plan> getPlans() {
			return plans;
		}

		public void setPlans(List<plan> plans) {
			this.plans = plans;
		}

		@Override
		public String toString() {
			return "Insurance [id=" + id + ", name=" + name + ", type=" + type + ", plans=" + plans + "]";
		}
	    

}
