package com.email.services.impl;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.email.services.EmailService;

import ch.qos.logback.classic.Logger;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailServiceImpl implements EmailService {
     
	@Autowired
	private JavaMailSender mailSender;
	
	private Logger logger=(Logger) LoggerFactory.getLogger(EmailServiceImpl.class);

	
	// send email to single person
	@Override
	public void sendEmail(String to, String Subject, String Message) {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setTo(to);
		simpleMailMessage.setSubject(Subject);
		simpleMailMessage.setText(Message);
		simpleMailMessage.setFrom("gettormittal04@gmail.com");
		mailSender.send(simpleMailMessage);
		logger.info("Email has been sent...");
	}

	// send email to multiple persons
	@Override
	public void sendEmail(String[] to, String Subject, String Message) {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setTo(to);
		simpleMailMessage.setSubject(Subject);
		simpleMailMessage.setText(Message);
		simpleMailMessage.setFrom("gettormittal04@gmail.com");
		mailSender.send(simpleMailMessage);
		
	}

	// send email with html
	/*@Override
	public void sendEmailWithHtml(String to, String Subject, String Message) {
	MimeMessage simpleMailMessage=mailSender.createMimeMessage();
	
	try {
		MimeMessageHelper helper = new MimeMessageHelper(simpleMailMessage,true,"UTF-8");
		helper.setTo(to);
		helper.setSubject(Subject);
		helper.setText(htmlContent,true);
		helper.setFrom("m49494596@gmail.com");
		mailSender.send(simpleMailMessage);
		logger.info("Email has been sent...");
		
	} catch (MessagingException e) {
		throw new RuntimeException(e);
	}
	}
*/
	// send email with file
	@Override
	public void sendEmailWithFile(String to, String Subject, String Message, File file) {
		MimeMessage simpleMailMessage=mailSender.createMimeMessage();
		
		try {
			MimeMessageHelper helper = new MimeMessageHelper(simpleMailMessage,true);
			helper.setTo(to);
			helper.setSubject(Subject);
			helper.setText(Message);
			helper.setFrom("gettormittal04@gmail.com");
			FileSystemResource fileSystemResource=new FileSystemResource(file);
			helper.addAttachment(fileSystemResource.getFilename(), file);
			
			mailSender.send(simpleMailMessage);
			logger.info("Email has been sent...");
			
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}	
	}
	@Override
	public void sendEmailWithFileWithStream(String to, String Subject, String Message, InputStream inputStream) {
		MimeMessage simpleMailMessage=mailSender.createMimeMessage();
		
		try {
			MimeMessageHelper helper = new MimeMessageHelper(simpleMailMessage, true);
			helper.setFrom("m49494596@gmail.com");
			helper.setTo(to);
			helper.setSubject(Subject);
			helper.setText(Message);
			File file=new File("test.png");
			Files.copy(inputStream, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
			FileSystemResource fileSystemResource=new FileSystemResource(file);
			helper.addAttachment(fileSystemResource.getFilename(), file);
			
			mailSender.send(simpleMailMessage);
			logger.info("Email has been sent...");
			
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

}
