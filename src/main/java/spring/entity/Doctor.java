package spring.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Doctor {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	 @NotBlank
	private String name;
	 @NotBlank
	private String region;	
	@NotBlank
	private String specialty;
	public Doctor() {
		super();
	}
	public Doctor(long id, @NotBlank String name, @NotBlank String region,@NotBlank String specialty) {
		super();
		this.id = id;
		this.name = name;
		this.region = region;
		this.specialty = specialty;
		}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSpecialty() {
		return specialty;
	}
	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	@Override
	public String toString() {
		return "Doctor [id=" + id + ", name=" + name + ", specialty=" + specialty + "region"+region+"]";
	}
	
   
}
