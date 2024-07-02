package com.email.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.email.reqres.CustomResponse;
import com.email.reqres.EmailRequest;
import com.email.services.EmailService;
@RestController
@RequestMapping("/api/email")
public class EmailController {
	
	@Autowired
	private EmailService emailService;


	@PostMapping("/send")
	public ResponseEntity<?> sendEmail(@ModelAttribute EmailRequest request) {
		emailService.sendEmail(request.getTo(), request.getSubject(), request.getMessage());
		CustomResponse builder = CustomResponse.builder();
		builder.setMessage("Email Send Successfully!!");
		builder.setHttpStatus(HttpStatus.OK);
		builder.setSuccess(true);
		
		var ok = ResponseEntity.ok(builder);
		return ok;
	}

	@PostMapping("/send-email-with-file")
	public ResponseEntity<CustomResponse> sendEmailWithFile(@RequestParam EmailRequest request,
			@RequestParam MultipartFile file) throws IOException {
		emailService.sendEmailWithFileWithStream(request.getTo(), request.getSubject(), request.getMessage(),
				file.getInputStream());
		CustomResponse builder = CustomResponse.builder();
		builder.setMessage("Email Send Successfully!!");
		builder.setHttpStatus(HttpStatus.OK);
		builder.setSuccess(true);
		
		var ok = ResponseEntity.ok(builder);
		return ok;
	}

}
