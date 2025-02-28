package spring.entity;


import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Data
@Getter
@Setter
@ToString
@Entity
@Table(name="Applicant")
public class Applicant {
	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	   private int appid;
	   @Enumerated(EnumType.STRING)
	   private toWhom f4; 
	   private String appliname;  
	   @Size(min = 4, max = 4,message= "size shoud be 4 digit only ")
	   private String nric;
	  // @Pattern(regexp = "\\d{10}", message = "Phone Number must be exactly 10 digits")
	   private String phone;
	   @Email
	   private String email;
	   @Column(name = "MemeberPassword", unique = true)
		private String mpassword;
	   @Enumerated(EnumType.STRING)   
	   private Gender gen;
	   
	   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	   private Date dob;
	   @Pattern(regexp = "^(1[0-2]|0?[1-9])(AM|PM)-((1[0-2]|0?[1-9])(AM|PM))$", message = "Time must be in the format '2AM-3AM' or '2PM-3PM'")
	   private String ptoc; 
	    private Boolean hasRefCode;
	    private String referralCode;
	    private String heardAboutUs;
	    private String residencyStatus;
	    @OneToMany(mappedBy = "applicant", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	    @JsonManagedReference
	    private List<MedicalHistory> medicalHistories;


		public Applicant() {
			super();
		}


		public Applicant(int appid, toWhom f4, String appliname,
				@Size(min = 4, max = 4, message = "size shoud be 4 digit only ") String nric, String phone,
				@Email String email, String mpassword, Gender gen, Date dob,
				@Pattern(regexp = "^(1[0-2]|0?[1-9])(AM|PM)-((1[0-2]|0?[1-9])(AM|PM))$", message = "Time must be in the format '2AM-3AM' or '2PM-3PM'") String ptoc,
				Boolean hasRefCode, String referralCode, String heardAboutUs, String residencyStatus,
				List<MedicalHistory> medicalHistories) {
			super();
			this.appid = appid;
			this.f4 = f4;
			this.appliname = appliname;
			this.nric = nric;
			this.phone = phone;
			this.email = email;
			this.mpassword = mpassword;
			this.gen = gen;
			this.dob = dob;
			this.ptoc = ptoc;
			this.hasRefCode = hasRefCode;
			this.referralCode = referralCode;
			this.heardAboutUs = heardAboutUs;
			this.residencyStatus = residencyStatus;
			this.medicalHistories = medicalHistories;
		}


		public int getAppid() {
			return appid;
		}


		public void setAppid(int appid) {
			this.appid = appid;
		}


		public toWhom getF4() {
			return f4;
		}


		public void setF4(toWhom f4) {
			this.f4 = f4;
		}


		public String getAppliname() {
			return appliname;
		}


		public void setAppliname(String appliname) {
			this.appliname = appliname;
		}


		public String getnric() {
			return nric;
		}


		public void setnric(String nric) {
			this.nric = nric;
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


		public String getMpassword() {
			return mpassword;
		}


		public void setMpassword(String mpassword) {
			this.mpassword = mpassword;
		}


		public Gender getGen() {
			return gen;
		}


		public void setGen(Gender gen) {
			this.gen = gen;
		}


		public Date getDob() {
			return dob;
		}


		public void setDob(Date dob) {
			this.dob = dob;
		}


		public String getPtoc() {
			return ptoc;
		}


		public void setPtoc(String ptoc) {
			this.ptoc = ptoc;
		}


		public Boolean getHasRefCode() {
			return hasRefCode;
		}


		public void setHasRefCode(Boolean hasRefCode) {
			this.hasRefCode = hasRefCode;
		}


		public String getReferralCode() {
			return referralCode;
		}


		public void setReferralCode(String referralCode) {
			this.referralCode = referralCode;
		}


		public String getHeardAboutUs() {
			return heardAboutUs;
		}


		public void setHeardAboutUs(String heardAboutUs) {
			this.heardAboutUs = heardAboutUs;
		}


		public String getResidencyStatus() {
			return residencyStatus;
		}


		public void setResidencyStatus(String residencyStatus) {
			this.residencyStatus = residencyStatus;
		}


		public List<MedicalHistory> getMedicalHistories() {
			return medicalHistories;
		}


		public void setMedicalHistories(List<MedicalHistory> medicalHistories) {
			this.medicalHistories = medicalHistories;
		}


	


		@Override
		public String toString() {
			return "Applicant [appid=" + appid + ", f4=" + f4 + ", appliname=" + appliname + ", Nric=" + nric
					+ ", phone=" + phone + ", email=" + email + ", mpassword=" + mpassword + ", gen=" + gen + ", dob="
					+ dob + ", ptoc=" + ptoc + ", hasRefCode=" + hasRefCode + ", referralCode=" + referralCode
					+ ", heardAboutUs=" + heardAboutUs + ", residencyStatus=" + residencyStatus + ", medicalHistories="
					+ medicalHistories + "]";
		}
		
		
		
		
		
		
		
}
