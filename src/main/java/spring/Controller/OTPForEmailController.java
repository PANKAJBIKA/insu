package spring.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import spring.Service.OTPEmailServiceImpl;



@RestController
public class OTPForEmailController {

	@Autowired
	private OTPEmailServiceImpl emailService;
	
	@PostMapping("/emailotp")
	public String sendOTPInEmail(@RequestParam String email) {
		emailService.sendOTPToMailService(email);
		return "OTP Send Successfully";
	}
}
