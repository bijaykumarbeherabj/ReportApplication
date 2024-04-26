package in.bj.Generator;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import jakarta.mail.internet.MimeMessage;

@Component
public class GeneratorMail {

	@Autowired
	private JavaMailSender mailsender;
	
	public boolean sendEmail(String subject, String body ,String to, File f) {
		
		try {	
		MimeMessage	 mimeMsg=mailsender.createMimeMessage();
		
		MimeMessageHelper helper=new MimeMessageHelper(mimeMsg,true);
		
		helper.setSubject(subject);
		helper.setText(body,true);
		helper.setTo("bijaykumarbeherabj@gmail.com");
		 helper.addAttachment("plans-info",f );
		
		mailsender.send(mimeMsg);
		} catch(Exception e) {
			
			e.printStackTrace();
		}
	return true;	
	}
	
}
