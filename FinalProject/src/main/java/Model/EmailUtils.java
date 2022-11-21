package Model;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailUtils {
	public static void send(Email email) throws Exception {
		Properties props = new Properties();
		props.put("mail.smtp.host", MailConfig.HOST_NAME); // SMTP Host
		props.put("mail.smtp.port", MailConfig.TSL_PORT); // TLS Port
		props.put("mail.smtp.auth", "true"); // enable authentication
		props.put("mail.smtp.starttls.enable", "true"); // enable

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(MailConfig.FROM_EMAIL, MailConfig.FROM_PASSWORD);
			}
		});
		try {
			Message message = new MimeMessage(session);
			
			message.setFrom(new InternetAddress(MailConfig.FROM_EMAIL));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email.getTo()));
			message.setSubject(email.getSubject());
			message.setContent(email.getContent(), "text/html; charset=utf-8"); 
			
			Transport.send(message);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}
