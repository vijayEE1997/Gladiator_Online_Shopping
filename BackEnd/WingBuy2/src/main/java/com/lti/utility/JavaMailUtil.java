package com.lti.utility;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class JavaMailUtil {
	public static int OTP;
	public static int sendMail(String recepient) {
		System.out.println("sending");
		Properties properties=new Properties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host","smtp.gmail.com");
		properties.put("mail.smtp.port","587");
		
		String myAccountEmail ="no.reply.wingbuy@gmail.com";
		String myPassword ="WingBuy123";
		
		Session session =Session.getInstance(properties,new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(myAccountEmail, myPassword);
			}
		});
		
		Message message = prepareMessage(session,myAccountEmail,recepient);
		System.out.println(message);
		try {
			Transport.send(message);
		}
		catch(MessagingException e)
		{
			return -2;
		}
		System.out.println("sent");
		return OTP;
	}
	
	private static Message prepareMessage(Session session,String myAccountEmail,String recepient) {
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(myAccountEmail));
			message.setRecipient(Message.RecipientType.TO,new InternetAddress(recepient));
			message.setSubject("MY");
			int otp=(int)Math.ceil(Math.random()*1000000);
			OTP=otp;
			message.setText(recepient);
			String htmlCode = "<div>" + 
					"   <h2>Dont Worry!</h2>" + 
					"   <h4>We are here to help you.</h4><br>" + 
					"   <p>Your one time OTP is "+otp+"</p>" + 
					"</div>";
			System.out.println(otp);
			message.setContent(htmlCode, "text/html");
			return message;
		}catch(Exception e) {
			Logger.getLogger(JavaMailUtil.class.getName()).log(Level.SEVERE,null,e);
		}
		return null;
	}
	public static void main(String[] args){
		System.out.println(JavaMailUtil.sendMail("vijad@gmail.com"));
	}
}

