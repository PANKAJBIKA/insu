package spring.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import jakarta.annotation.PostConstruct;
import lombok.Data;
import lombok.NoArgsConstructor;

@Configuration
@ConfigurationProperties(prefix = "twilio")
@Data
@NoArgsConstructor
public class OTPTwilioConfig {
	private String accountSID; 
	private String authToken;
	private String phoneNumber; 
	
	

	
	@Override
	public String toString() {
		return "OTPTwilioConfig [accountSID=" + accountSID + ", authToken=" + authToken + ", phoneNumber=" + phoneNumber
				+ "]";
	}

	//getter and setter
	public String getAccountSID() {
		return accountSID;
	}

	public void setAccountSID(String accountSID) {
		this.accountSID = accountSID;
	}

	public String getAuthToken() {
		return authToken;
	}

	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	@PostConstruct
	public void init() {
	    System.out.println("Loaded Twilio configuration: " + this);
	}
}
