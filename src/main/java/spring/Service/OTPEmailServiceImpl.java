package spring.Service;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class OTPEmailServiceImpl {
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	Map<String, String> otpMap = new HashMap<>();
	
	//Generate a 6-digit OTP
	public String generateOTPForEmail() {
		SecureRandom random = new SecureRandom();
		int otp = 100000+random.nextInt(900000);
		return String.valueOf(otp);
	}
	
	public String sendOTPToMailService(String email) {
		String otp = generateOTPForEmail();
		System.out.println(otp);
		try {
			sendOtpToMail(email, otp);
		}catch (MessagingException e) {
			throw new RuntimeException(otp);
		}
		return "OTP has been sent to email successfully";
	}
	
	public void sendOtpToMail(String email, String otp) throws MessagingException {
		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		helper.setTo(email);
		helper.setSubject("Please verify the OTP");
		helper.setText("Here is your one time password "+otp);
		otpMap.put("OTP Message", otp);
		javaMailSender.send(message);
	}
	
	public String verifyOtpForEmail(String otp) {
		Set<String> keys = otpMap.keySet();
		String value = null;
		for(String key : keys ) 
			value = otpMap.get(key);
		if(value.equals(otp)) 
			return "Validation Successful";
		else 
			return "Invalid OTP";
	}
}
