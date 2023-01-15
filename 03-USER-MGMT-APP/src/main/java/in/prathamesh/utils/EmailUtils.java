package in.prathamesh.utils;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailUtils {

	@Autowired
	private JavaMailSender mailSender;

	public boolean sendEmail(String to, String subject, String body) {
		boolean isMailSent = false;
		try {
			MimeMessage mimeMessage = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
			helper.setTo(to);
			// helper.setCc(cc);
			// helper.setBcc(bcc);
			helper.setSubject(subject);
			helper.setText(body, true);
			// helper.addAttachment(attachmentFilename, dataSource);
			mailSender.send(mimeMessage);
			
			isMailSent = true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return isMailSent;

	}
}
