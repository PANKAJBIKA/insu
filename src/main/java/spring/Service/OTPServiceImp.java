package spring.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import spring.config.OTPTwilioConfig;

@Service
public class OTPServiceImp {
	
	@Autowired
	private OTPTwilioConfig otpTwilioConfig;
	
	Map<String,String> otpMap = new HashMap<>();
	
	//generate OTP
	public String generatedOTP() {
		
		int otp = (int)(Math.random()*1000000);
		System.out.println("otp genrated is"+otp);
		
		return String.format("%06d", otp);
	}
	
	//send OTP
	public String sendOTPToPhone(String mobileNumber) {
		String otp = generatedOTP();
		PhoneNumber receiverPhoneNumber = new PhoneNumber(mobileNumber);
		PhoneNumber senderPhoneNumber = new PhoneNumber(otpTwilioConfig.getPhoneNumber());
		String msgBody = "Your one time password (OTP) is : "+otp;
		Message.creator(receiverPhoneNumber, senderPhoneNumber, msgBody).create();
		System.out.println(otp);
		otpMap.put(msgBody, otp);
		return "OTP Send Successfully";
	}
	
	
	

	//validate OTP
	public String validateOTP(String otp) {
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
