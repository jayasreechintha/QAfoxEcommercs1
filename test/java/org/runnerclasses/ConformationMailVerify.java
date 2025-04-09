package org.runnerclasses;

import java.util.Properties;

import org.openqa.selenium.By;
import org.supportclasses.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

import jakarta.mail.BodyPart;
import jakarta.mail.Flags;
import jakarta.mail.Folder;
import jakarta.mail.Message;
import jakarta.mail.Session;
import jakarta.mail.Store;
import jakarta.mail.internet.MimeMultipart;
import jakarta.mail.search.FlagTerm;

public class ConformationMailVerify extends BaseClass{
//for email verification 
//IMAP-Enable or not have to check
//for 3rd party users like java/selenium passcode has to be there
//for that 2factor authentication should on	
	
	
	@Test
	private void tc1() throws InterruptedException {
		ChromeDriver();
		String url="https://www.linkedin.com/checkpoint/lg/sign-in-another-account";
		driver.get(url);
        
		Thread.sleep(3000);
     driver.findElement(By.linkText("Forgot password?")).click();
     driver.findElement(By.id("username")).sendKeys("jayasree.emvee@gmail.com");
      
       driver.findElement(By.id("reset-password-submit-button")).click();
       
       //setup-gmail-settings-all settings-Forwarding and POP/IMAP
       //2 step verification -on
       //app passcode-gmail-manage your ac-app password -App name-(javaEmailAccessPass)
       
       
      Thread.sleep(7000);
      String host = "imap.gmail.com";
      String username = "jayasree.emvee@gmail.com"; //mail id
      String appPassword = "twlu wrox nlnk aqes"; // App Password
      
      Thread.sleep(7000);
     
      try {
          // Set properties for IMAP
          Properties properties = new Properties();
          properties.put("mail.imap.host", host);
          properties.put("mail.imap.port", "993");
          properties.put("mail.imap.starttls.enable", "true");
          properties.put("mail.imap.ssl.enable", "true");

          // Create session
          Session emailSession = Session.getDefaultInstance(properties);
          Store store = emailSession.getStore("imap");
          store.connect(host, username, appPassword);

          // Open INBOX
          Folder inbox = store.getFolder("INBOX");
          inbox.open(Folder.READ_ONLY);

          // Fetch unread emails
          Message[] messages = inbox.search(new FlagTerm(new Flags(Flags.Flag.SEEN), false));

          if (messages.length > 0) {
              Message latestMessage = messages[messages.length - 1]; // Get latest email

              // Extract subject & body
              String subject = latestMessage.getSubject();
              String body = getTextFromMessage(latestMessage);

              System.out.println("Subject: " + subject);
              System.out.println("Body: " + body);

              //  Assertions
              Assert.assertTrue(subject.contains("jaya, here's your PIN"), "Subject does not match expected text!");
             Assert.assertTrue(body.contains("If you didn't request this pin, we recommend you change your LinkedIn password"), "Body does not contain expected text!");
              System.out.println("Email validation passed!");
          } else {
              System.out.println("No unread emails found.");
          }

          // Close connections
          inbox.close(false);
          store.close();

      } catch (Exception e) {
          e.printStackTrace();
      }
  }

  // Extracts text from an email (handles plain text & HTML)
  private static String getTextFromMessage(Message message) throws Exception {
      if (message.getContent() instanceof String) {
          return (String) message.getContent();
      } else if (message.getContent() instanceof MimeMultipart) {
          return getTextFromMimeMultipart((MimeMultipart) message.getContent());
      }
      return "Unsupported content";
  }

  // Extracts text from a Multipart email (handles HTML & plain text)
  private static String getTextFromMimeMultipart(MimeMultipart multipart) throws Exception {
      StringBuilder result = new StringBuilder();
      for (int i = 0; i < multipart.getCount(); i++) {
          BodyPart bodyPart = multipart.getBodyPart(i);
          if (bodyPart.isMimeType("text/plain")) {
              result.append(bodyPart.getContent().toString());
          } else if (bodyPart.isMimeType("text/html")) {
              result.append(bodyPart.getContent().toString());
          }
      }
      return result.toString();
  }
	}

	
	

