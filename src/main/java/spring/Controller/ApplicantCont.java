package spring.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import spring.Service.ApplicantService;
import spring.entity.Applicant;

@RestController
@RequestMapping("/applicant")
public class ApplicantCont {
	@Autowired
     private ApplicantService appserv;
	  @PostMapping
	  public Applicant  addApplicant(@RequestBody Applicant  applicant){
	    	return appserv.saveappli( applicant);
	    }
	  @GetMapping
	   public List<Applicant> getApplicant(){
		   return appserv. getApplicant();
	   }
	  @GetMapping("/applicantid/{id}")
	  Object getapplicById(@PathVariable int id){
		  return appserv.getApplicantById(id);
	                          }
	    @GetMapping("/phone/{phone}")
	    List<Applicant> getByphone(@PathVariable String phone){
	    return appserv.getAppByphone(phone);
        }
	   @GetMapping("/email/{email}")
	   Object getByEmail(@PathVariable String email){
		   return appserv.getAppByemail(email);
	   }
	   
}
