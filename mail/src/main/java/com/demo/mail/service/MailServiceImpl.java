package com.demo.mail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class MailServiceImpl implements MailService{
	
	@Value("${spring.mail.username}")
	String myMailId;
	
	@Autowired
    private JavaMailSender emailSender;

	public void sendMail(String name, String email) throws Exception {
		MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        try {
            helper.setTo("tejasvaity29@gmail.com"); // Replace with your Gmail address
            helper.setSubject("Form Submission");
            helper.setText("Name: " + name + "\nEmail: " + email);
            emailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
//		SimpleMailMessage mailMessage = new SimpleMailMessage();
//		mailMessage.setTo(email);
//		mailMessage.setSubject("This is Test");
//		mailMessage.setText("testing 1...2...3...");
//		mailMessage.setFrom("tejasvaity29@gmail.com");
//		emailSender.send(mailMessage);
		
	}
}
