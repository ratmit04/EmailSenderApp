package com.email.services;

import java.io.File;
import java.io.InputStream;

public interface EmailService {
	//send email to single person
	void sendEmail(String to, String Subject, String Message);
	
	//send email to multiple persons
	void sendEmail(String[] to, String Subject, String Message);
	
	//send email with html
	//void sendEmailWithHtml(String to, String Subject, String Message);
	
	//send email with file
	void sendEmailWithFile(String to, String Subject, String Message, File file);
	
	void sendEmailWithFileWithStream(String to, String Subject, String Message, InputStream inputStream);
	
}
