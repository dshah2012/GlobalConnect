package com.ge.tps.util;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendEmailUsingGMailSMTP {
	public static void main(String[] args) {
		System.out.println(sendMail("amadeusjava2016@gmail.com", "Subject",
				"<h1> Hi </h1> Hi bro..........", "Files/Chandra-profile.pdf"));
	}

	/**
	 * 
	 * @param to
	 * @param subject
	 * @param body
	 * @param attachment
	 *            should be in (Project) and it should be preceeded by folder
	 *            name. Ex: "Files/resume1.pdf" where "Files is a folder in the
	 *            root project hierarchy
	 * @return
	 */
	public static boolean sendMail(String to, String subject, String body,
			String attachment) {
		String staticLocation = "D:\\Chandra\\Clients\\Amadeus\\Jan 2016\\Java\\Project\\TPS-v1.01\\TPS_BACKEND_INTEGRATED";

		// The file location should be external
		boolean response = false;

		// Sender's email ID needs to be mentioned
		String from = "amadeusjava2016@gmail.com";
		final String username = "amadeusjava2016@gmail.com";
		final String password = "amadeus_01";

		String host = "smtp.gmail.com";
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", true);
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "587");
		props.put("mail.user", username);
		props.put("mail.password", password);

		// Get the Session object.
		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username, password);
					}
				});
		// session.setDebug(true);
		try {
			// Create a default MimeMessage object.
			Message message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(from));

			// Set To: header field of the header.
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(to));

			// Set Subject: header field
			message.setSubject(subject);

			// Create the message part
			BodyPart messageBodyPart = new MimeBodyPart();

			// Now set the actual message
			messageBodyPart.setContent(body, "text/html; charset=utf-8");

			// Create a multipart message
			Multipart multipart = new MimeMultipart();

			// Set text message part
			multipart.addBodyPart(messageBodyPart);

			// Part two is attachment
			if (attachment != null && attachment != "") {
				attachment = staticLocation + attachment;
				messageBodyPart = new MimeBodyPart();
				String filename = attachment;
				DataSource source = new FileDataSource(filename);
				messageBodyPart.setDataHandler(new DataHandler(source));
				String[] sendFileName = filename.split("/");
				messageBodyPart
						.setFileName(sendFileName[sendFileName.length - 1]);
				multipart.addBodyPart(messageBodyPart);
			}

			// Send the complete message parts
			message.setContent(multipart);

			// Send message
			Transport transport = session.getTransport("smtps");
			transport.send(message);

			response = true;

		} catch (MessagingException e) {
			// throw new RuntimeException(e);
			e.printStackTrace();
		}
		return response;
	}

	public static boolean sendMail(String to, String subject, String body) {
		return sendMail(to, subject, body, null);
	}
}