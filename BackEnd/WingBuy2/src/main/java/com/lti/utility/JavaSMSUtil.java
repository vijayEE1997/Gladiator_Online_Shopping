//package com.lti.utility;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.net.URL;
//import java.net.URLEncoder;
//import java.util.Date;
//
//import javax.net.ssl.HttpsURLConnection;
//
//public class JavaSMSUtil {
//	
//	public static void sendSMS(String message,String number) throws IOException {
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
//		HttpsURLConnection conn=(HttpsURLConnection)url.openConnection();
//		
//		conn.setRequestMethod("GET");
//		conn.setRequestProperty("User-Agent", "Mozilla/5.0");
//		conn.setRequestProperty("cache-control", "no-cache");
//		
//		System.out.println("wait");
//		
//		int code=conn.getResponseCode();
//				
//		System.out.println(code);
//		
//		StringBuffer response=new StringBuffer();
//		BufferedReader br=new BufferedReader(new InputStreamReader(conn.getInputStream()));
//		while(true)
//		{
//			String line=br.readLine();
//			if(line==null)
//				break;
//			response.append(line);
//		}
//		System.out.println(response);
//	}
//	
//	public static void main(String[] args) throws IOException {
//		String message="Dont Worry!!!"+"\nWe are here to help you\n"+"Your OTP is "+(int)Math.ceil(Math.random()*1000000)+"\n";
//		JavaSMSUtil.sendSMS(message+"\n"+ new Date().toLocaleString(),"8305940684");
//	}
//}
