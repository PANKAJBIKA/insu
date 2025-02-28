package spring.entity;


import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@Entity
@Table(name="MedicalHistory")
public class MedicalHistory {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @ManyToOne
	    @JoinColumn(name = "appid", nullable = false)
	    @JsonBackReference
	    private Applicant applicant;
	    @Column(name = "medical_condition")
	    private String condition;
	    private String treatment;
	    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	    private Date startDate;
	    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	    private Date endDate;
	    private String notes;
		public MedicalHistory() {
			super();
		}
		public MedicalHistory(Long id, Applicant applicant, String condition, String treatment, Date startDate,
				Date endDate, String notes) {
			super();
			this.id = id;
			this.applicant = applicant;
			this.condition = condition;
			this.treatment = treatment;
			this.startDate = startDate;
			this.endDate = endDate;
			this.notes = notes;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public Applicant getApplicant() {
			return applicant;
		}
		public void setApplicant(Applicant applicant) {
			this.applicant = applicant;
		}
		public String getCondition() {
			return condition;
		}
		public void setCondition(String condition) {
			this.condition = condition;
		}
		public String getTreatment() {
			return treatment;
		}
		public void setTreatment(String treatment) {
			this.treatment = treatment;
		}
		public Date getStartDate() {
			return startDate;
		}
		public void setStartDate(Date startDate) {
			this.startDate = startDate;
		}
		public Date getEndDate() {
			return endDate;
		}
		public void setEndDate(Date endDate) {
			this.endDate = endDate;
		}
		public String getNotes() {
			return notes;
		}
		public void setNotes(String notes) {
			this.notes = notes;
		}
		@Override
		public String toString() {
			return "MedicalHistory [id=" + id + ", applicant=" + applicant + ", condition=" + condition + ", treatment="
					+ treatment + ", startDate=" + startDate + ", endDate=" + endDate + ", notes=" + notes + "]";
		}
	    
  
}
