package com.eduacsp.cv.util;

import java.util.Date;
import java.util.Properties;
/*
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;*/

import com.eduacsp.cv.modelo.Guest;
/*

public class SendMail {

	public void sendEmail(Guest guest) {
		 // SUBSTITUTE YOUR EMAIL ADDRESSES HERE!
	     String to = "eduacsp@gmail.com";
	     String from = "eduardo@eduacsp.com";
	     // SUBSTITUTE YOUR ISP'S MAIL SERVER HERE!
	     String host = "localhost";

	     // Create properties, get Session
	     Properties props = new Properties();

	     //http://docs.oracle.com/javaee/6/api/javax/mail/Session.html
	     // If using static Transport.send(),
	     // need to specify which host to send it to
	     props.put("mail.smtp.host", host);
	     // To see what is going on behind the scene
	     props.put("mail.debug", "true");
	     Session session = Session.getInstance(props);

	     try {
	         // Instantiate a message
	         Message msg = new MimeMessage(session);

	         //Set message attributes
	         msg.setFrom(new InternetAddress(from));
	         InternetAddress[] address = {new InternetAddress(to)};
	         msg.setRecipients(Message.RecipientType.TO, address);
	         msg.setSubject("A new record was just added.");
	         msg.setSentDate(new Date());

	         // Set message content
	         msg.setText("This is a test of sending a " +
	                     "plain text e-mail through Java.\n" +
	                     "Here is line 2.");

	         //Send the message
	         Transport.send(msg);
	     }catch (MessagingException mex) {
	         // Prints all nested (chained) exceptions as well
	         mex.printStackTrace();
	     }
	}
	
}
*/