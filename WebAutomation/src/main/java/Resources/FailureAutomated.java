package Resources;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

public class FailureAutomated {
	
	static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
    static Date date = new Date();  
   
		public static  void sendemail() throws IOException {

			Properties props = new Properties();
			 
			// this will set host of server- you can change based on your requirement 
			props.put("mail.smtp.host", "smtp.gmail.com");
	 
			// set the port of socket factory 
			props.put("mail.smtp.socketFactory.port", "465");
	 
			// set socket factory
			props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
	 
			// set the authentication to true
			props.put("mail.smtp.auth", "true");
	 
			// set the port of SMTP server
			props.put("mail.smtp.port", "465");
	 
			// This will handle the complete authentication
			Session session = Session.getDefaultInstance(props,
	 
					new javax.mail.Authenticator() {
	 
						protected PasswordAuthentication getPasswordAuthentication() {
	 
						return new PasswordAuthentication("sameer.g@contus.in", "Ayesha@1996");
	 
						}
	 
					});
	 
			try {
	 
				// Create object of MimeMessage class
				Message message = new MimeMessage(session);
	 
				// Set the from address
				message.setFrom(new InternetAddress("sameer.g@contus.in"));
	 
				// Set the recipient address
				message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("gracediana.s@contus.in,rajagopal.n@contus.in,shankar.e@contus.in"));
				//message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("gracediana.s@contus.in,rajagopal.n@contus.in,shankar.e@contus.in"));
				message.setRecipients(Message.RecipientType.CC,InternetAddress.parse("sameer.g@contus.in,gudsho@contus.in"));
				
	            
	            // Add the subject link
				message.setSubject("GudSho Web: Automation Test Report");
	 
				// Create object to add multimedia type content
				BodyPart messageBodyPart1 = new MimeBodyPart();
				String msg="Note: Download & open the attached reports using Firefox browser.";
				// Set the body of email
				messageBodyPart1.setText("Hi Team,\t\n\n\nPlease find the attached Failed Scenarios results on previous run GudSho Web Automation Report.\t\n\n"
						+ msg+".\t\n\n\nThanks");
				
	 
				// Create another object to add another content
				MimeBodyPart messageBodyPart2 = new MimeBodyPart();
				MimeBodyPart messageBodyPart3 = new MimeBodyPart();
				MimeBodyPart messageBodyPart4 = new MimeBodyPart();
				
	 
				// Mention the file which you want to send
				String filename = System.getProperty("user.dir")+"/AllReports/ExtentReport/Spark.html";
				String filename1 = System.getProperty("user.dir")+"/target/cucumber-reports/htmlreports.html";
				String PdfReport=System.getProperty("user.dir")+"/AllReports/PdfReports/ExtentPdf.pdf"; 
				// Create data source and pass the filename
				DataSource source = new FileDataSource(filename);
				DataSource source1 = new FileDataSource(filename1);
				DataSource source2 = new FileDataSource(PdfReport);
				
	 
				// set the handler
				messageBodyPart2.setDataHandler(new DataHandler(source));
				messageBodyPart3.setDataHandler(new DataHandler(source1));
				messageBodyPart4.setDataHandler(new DataHandler(source2));
				
	 
				// set the file
				messageBodyPart2.setFileName("GudSho_Web_Automation "+formatter.format(date));
				messageBodyPart3.setFileName("GudSho_Web_Html_Reports "+formatter.format(date));
				messageBodyPart4.setFileName("GudSho_Web_PDF_Reports "+formatter.format(date));
			
	 
				// Create object of MimeMultipart class
				Multipart multipart = new MimeMultipart();
				
	 
				// add body part 1
				multipart.addBodyPart(messageBodyPart2);
				multipart.addBodyPart(messageBodyPart3);
				multipart.addBodyPart(messageBodyPart4);
				
	 
				// add body part 2
				multipart.addBodyPart(messageBodyPart1);
				multipart.addBodyPart(messageBodyPart3);
				multipart.addBodyPart(messageBodyPart4);
				//messageBodyPart3.attachFile(filename1);
				
	 
				// set the content
				message.setContent(multipart);
				
	 
				// finally send the email
				Transport.send(message);
				
	 
				System.out.println("=====Email Sent=====");
	 
			} catch (MessagingException e) {
	 
				throw new RuntimeException(e);
	 
			}
	 
		}

}
