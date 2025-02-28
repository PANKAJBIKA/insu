package spring.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import spring.Service.OTPServiceImp;



@RestController
public class OTPController {
	@Autowired
	private OTPServiceImp otpService;
	
	//Send OTP
	@PostMapping("/sendOtp")
	public String sendOTP(@RequestParam String mobileNumber) {
		return otpService.sendOTPToPhone(mobileNumber);
	}
	
	//Validate OTP
	@PostMapping("/verifyOtp")
	public String verifyOTP(@RequestParam String otp) {
		return otpService.validateOTP(otp);
	}
}
