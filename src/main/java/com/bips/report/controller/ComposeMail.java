package com.bips.report.controller;

/**
 * Servlet implementation class ComposeMail
 */

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;

import java.io.*;

@WebServlet("/composemail/*")
public class ComposeMail extends GenericServlet
{
public void service(ServletRequest req,ServletResponse res)throws ServletException,IOException
{
res.setContentType("text/html");
PrintWriter out= res.getWriter();
String to=req.getParameter("to");
final String from=req.getParameter("from");
String subject=req.getParameter("subject");
String msgbody=req.getParameter("msgbody");
String attach=req.getParameter("attach");
System.out.println(req.getParameter("attach"));

Properties props = new Properties();
  props.put("mail.smtp.host", "smtp.gmail.com");
  props.put("mail.smtp.socketFactory.port", "465");
  props.put("mail.smtp.socketFactory.class",
        	"javax.net.ssl.SSLSocketFactory");
  props.put("mail.smtp.auth", "true");
  props.put("mail.smtp.port", "465");
 
  Session session = Session.getDefaultInstance(props,
   new javax.mail.Authenticator() {
   protected PasswordAuthentication getPasswordAuthentication() {
   return new PasswordAuthentication(from,"Aa@1abcde");
   
}
  });
try
 {
   MimeMessage message = new MimeMessage(session);
   message.setFrom(new InternetAddress(from));//change accordingly
   message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
   message.setSubject(subject);
   message.setText(msgbody);
 
// Create the message part
   BodyPart messageBodyPart = new MimeBodyPart();

   // Now set the actual message
   messageBodyPart.setText("This is message body");
   
// Create a multipar message
   Multipart multipart = new MimeMultipart();

   // Set text message part
   multipart.addBodyPart(messageBodyPart);

   // Part two is attachment
   messageBodyPart = new MimeBodyPart();
   String filename = "/home/syadav/git/bips_stone_crusher_erp/WebContent/BIPSreport.pdf";
   DataSource source = new FileDataSource(filename);
   messageBodyPart.setDataHandler(new DataHandler(source));
   messageBodyPart.setFileName(filename);
   multipart.addBodyPart(messageBodyPart);

   // Send the complete message parts
   message.setContent(multipart);
   
   Transport.send(message);

out.println("Send mail successfully");
    
} 
 catch (MessagingException e) 
 {
   throw new RuntimeException(e);
 }
}
}
