//package com.lti.utility;
//
//import java.io.UnsupportedEncodingException;
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.net.URLEncoder;
//import java.util.Date;
//
//public class JavaSMSUtil {
//	
//	public static void sendSMS(String message,String number) throws UnsupportedEncodingException, MalformedURLException {
//		System.out.println(message);
//		System.out.println(number);
//		
//		String apiKey="ObVTJstRrgock8pDnfv9BhaLU0yXCwilGHZ5KmzE4732jWPNxeO3tT0Fri81adgNKPDWVjL5px7hIUyR";
//		String senderId="FSTSMS";
//		message=URLEncoder.encode(message, "UTF-8");
//		System.out.println(message);
//		
//		String language="english";
//		
//		String route="p";//promotional t transaction
//		
//		String myURL="https://www.fast2sms.com/dev/bulk?authorization="+apiKey+"&sender_id=FSTSMS&message="+message+"&language="+language+"&route="+route+"&numbers="+number;
//		System.out.println(myURL);
//		
//		//sending get request
//		URL url=new URL(myURL);
//		
//		
//	}
//	
//	public static void main(String[] args) throws UnsupportedEncodingException {
//		JavaSMSUtil.sendSMS("Hi, from WingBuy "+ new Date().toLocaleString(),"9893675236");
//	}
//}
