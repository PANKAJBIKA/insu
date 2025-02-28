package spring.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class OTPForEmailConfig {
	
	@Value("${spring.mail.host}")
	private String mailHost;
	@Value("${spring.mail.port}")
	private String mailPort;
	@Value("${spring.mail.username}")
	private String mailUsername;
	@Value("${spring.mail.password}")
	private String mailPassword;


    @Bean
    public JavaMailSender getJavaMailSender() {
		JavaMailSenderImpl senderImpl = new JavaMailSenderImpl();
		senderImpl.setHost(mailHost);
		senderImpl.setPort(Integer.parseInt(mailPort));
		senderImpl.setUsername(mailUsername);
		senderImpl.setPassword(mailPassword);
		Properties props = senderImpl.getJavaMailProperties();
		props.put("mail.smtp.starttls.enable", "true");
		return senderImpl;
	}
}
