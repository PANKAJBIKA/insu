package spring.entity;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Entity
@Table(name="InsurBook")
public class InsuranceBooking {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long IB_id;
	    @ManyToOne
	    @JoinColumn(name = "appid", nullable = false)
	    private Applicant applicant;
	    @ManyToOne
	    @JoinColumn(name = "plan_id", nullable = false)
	    private plan plan;
	    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	    private Date bookingDate;	    
	    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	    private Date bookingEndDate;
	    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "insuranceBooking")
	    private List<Nominee> nominees;

		public InsuranceBooking() {
			super();
			// TODO Auto-generated constructor stub
		}

		public InsuranceBooking(Long iB_id, Applicant applicant, spring.entity.plan plan, Date bookingDate,
				Date bookingEndDate, List<Nominee> nominees) {
			super();
			IB_id = iB_id;
			this.applicant = applicant;
			this.plan = plan;
			this.bookingDate = bookingDate;
			this.bookingEndDate = bookingEndDate;
			this.nominees = nominees;
		}

		public Long getIB_id() {
			return IB_id;
		}

		public void setIB_id(Long iB_id) {
			IB_id = iB_id;
		}

		public Applicant getApplicant() {
			return applicant;
		}

		public void setApplicant(Applicant applicant) {
			this.applicant = applicant;
		}

		public plan getPlan() {
			return plan;
		}

		public void setPlan(plan plan) {
			this.plan = plan;
		}

		public Date getBookingDate() {
			return bookingDate;
		}

		public void setBookingDate(Date bookingDate) {
			this.bookingDate = bookingDate;
		}

		public Date getBookingEndDate() {
			return bookingEndDate;
		}

		public void setBookingEndDate(Date bookingEndDate) {
			this.bookingEndDate = bookingEndDate;
		}

		public List<Nominee> getNominees() {
			return nominees;
		}

		public void setNominees(List<Nominee> nominees) {
			this.nominees = nominees;
		}

		@Override
		public String toString() {
			return "InsuranceBooking [IB_id=" + IB_id + ", applicant=" + applicant + ", plan=" + plan + ", bookingDate="
					+ bookingDate + ", bookingEndDate=" + bookingEndDate + ", nominees=" + nominees + "]";
		}

	
	
		
	    
	    
}
