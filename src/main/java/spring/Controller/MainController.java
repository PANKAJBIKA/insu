package spring.Controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import spring.Service.ApplicantService;
import spring.Service.OTPEmailServiceImpl;
import spring.Service.OTPServiceImp;
import spring.entity.Applicant;

@RestController
public class MainController {
	@Autowired
	private ApplicantService memberService;
	@Autowired
	private OTPServiceImp otpService;
	@Autowired
	private OTPEmailServiceImpl otpEmailService;

	@PostMapping("/register")
	public String openRegisterPage(HttpSession session, @RequestBody Applicant member, HttpServletRequest req) {
		String status = "OTP has been sent to your phone and email";
		session.setAttribute("memberData", member);
		otpService.sendOTPToPhone(member.getPhone());
		otpEmailService.sendOTPToMailService(member.getEmail());
		LocalDateTime ldt = LocalDateTime.now();
		req.setAttribute("timeStartNow", ldt);
		return status;
	}

	// Validate OTP
	@PostMapping("/verifyOtpPhone")
	public String verifyOTPInPhone(@RequestParam("otp") String otp) {
		String status = "Phone OTP Verified";
		String validate = otpService.validateOTP(otp);
		if (validate.equalsIgnoreCase("Validation Successful"))
			return status;
		else
			return "OTP For Phone Verification Failed";
	}

	@PostMapping("/verifyOtpEmail")
	public String verifyOTPInEmail(@RequestParam("otp") String otp, HttpSession session) {
		String status = "Member Inserted Successfully";
		String message = otpEmailService.verifyOtpForEmail(otp);
		Applicant member = (Applicant) session.getAttribute("memberData");
		if (message.equalsIgnoreCase("Validation Successful")) {
			memberService.saveappli(member);                                            
		} else
			return "Program Failed";
		return status;
	}

	@PostMapping("/memberLogin")
	public String memberLogin(@RequestParam("myEmail") String email, @RequestParam("myPass") String password) {
		Applicant member = memberService.authenticate(email);
		
		System.out.println(member.getAppliname());
		if (email == null && password == null) 
			return "Email or Password is Empty";
		else if(email.equals(member.getEmail()) && password.equals(member.getMpassword()))
			return "Hey ! "+member.getAppliname();
		else if (email != member.getEmail() && password != member.getMpassword())
			return "Email or Password is Incorrect";
		else
			return "Program Failed";
	}  
	   @DeleteMapping("/deleteapp")
	   public String delete(@PathVariable String email) {
		    Applicant existapp =  memberService.authenticate(email);
		    if(existapp==null) {
		    	return "no pplicant exist";
		    }
		  memberService.deleapp(existapp);
		  return "Applicant deleted";
	   }
	   @PutMapping("updte/{email}")
	   public String update(@PathVariable("email") String email, HttpSession session, @RequestBody Applicant member, HttpServletRequest req) {
			String status = "OTP has been sent to your phone";
			session.setAttribute("email1",email);
			session.setAttribute("memberData1", member);
			otpService.sendOTPToPhone(member.getPhone());
			return status;
			}
	   @PostMapping("/verifyforupdate")
		public String verifyInPhone(@RequestParam("otp") String otp,HttpSession session) {
			String status = "Phone OTP Verified";
			String email =(String) session.getAttribute("email1");
			Applicant member1 = (Applicant) session.getAttribute("memberData1");
			String validate = otpService.validateOTP(otp);
			if (validate.equalsIgnoreCase("Validation Successful")) {
				memberService.updateApp(email,member1); 
				return status;
			}
			else
				return "OTP For Phone Verification Failed";
		}

	
	   
	  
}
