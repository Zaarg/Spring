package be.vdab.mail;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
@ComponentScan
@EnableAsync
@PropertySource("classpath:/mail.properties")
public class CreateMailBeans {
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	@Bean
	@Autowired
	public JavaMailSenderImpl javaMailSenderImpl(@Value("${mailserver.host}") String host,
			@Value("${mailserver.port}") int port, @Value("${mailserver.protocol}") String protocol,
			@Value("${mailserver.username}") String username, @Value("${mailserver.password}") String password) {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		//Properties props = new Properties();
		//props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		//mailSender.setJavaMailProperties(props);
		mailSender.setHost(host);
		mailSender.setPort(port);
		mailSender.setProtocol(protocol);
		mailSender.setUsername(username);
		mailSender.setPassword(password);
		return mailSender;
	}
}