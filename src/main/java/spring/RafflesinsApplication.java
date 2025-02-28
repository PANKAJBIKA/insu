package spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.twilio.Twilio;

import jakarta.annotation.PostConstruct;
import spring.config.OTPTwilioConfig;

@SpringBootApplication
public class RafflesinsApplication {

	@Autowired
	private OTPTwilioConfig otpTwilioConfig;

	@PostConstruct
	public void setUp() {
		System.out.println("Account SID: " + otpTwilioConfig.getAccountSID());
		System.out.println("Auth Token: " + otpTwilioConfig.getAuthToken());

		Twilio.init(otpTwilioConfig.getAccountSID(), otpTwilioConfig.getAuthToken());

	}

	public static void main(String[] args) {
		SpringApplication.run(RafflesinsApplication.class, args);
	}
}
