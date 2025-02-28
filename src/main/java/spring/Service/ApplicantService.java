package spring.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import spring.entity.Applicant;
import spring.entity.MedicalHistory;
import spring.repo.appRepo;

@Service
public class ApplicantService {
	   @Autowired
	   private  appRepo apre;
	        
	   public Applicant saveappli(Applicant appli){
		   for(MedicalHistory mg : appli.getMedicalHistories()) {  
				  mg.setApplicant(appli);
                    } 
	       return apre.save(appli);	 
	       }
	    public List<Applicant> getApplicant(){
	    	return apre.findAll();
	    }	    
	  public  Object getApplicantById(int id){
	    	return apre.findById(id);
	    }	    
	   public List<Applicant>  getAppByphone(String phone){
	   return apre.findByPhone(phone);
	    }
	   public  Object getAppByemail(String email){
	    return apre.findByemail(email); 
	     }
	     public Applicant authenticate(String email) {
	      return (Applicant) apre.findByemail(email);
	     }
	     
	    public void deleapp(Applicant app) {
	    	apre.delete(app);
	    }
	     
	    
		   public String updateApp( String email ,Applicant app ) {
			     Applicant existapp= (Applicant) apre.findByemail(email);
			     if(existapp==null) {
			    	 return "no applicant found";
			     }
			    
			     existapp.setDob(app.getDob());
			        existapp.setPhone(app.getPhone());
			        existapp.setF4(app.getF4());
			        existapp.setGen(app.getGen());
			        existapp.setHasRefCode(app.getHasRefCode());
			        existapp.setHeardAboutUs(app.getHeardAboutUs());
			        existapp.setMpassword(app.getMpassword());
			        existapp.setPtoc(app.getPtoc());
			        existapp.setReferralCode(app.getReferralCode());
			        existapp.setResidencyStatus(app.getResidencyStatus());
			        apre.save(existapp);

			   return "Applicant added";
			   
		   }
}
