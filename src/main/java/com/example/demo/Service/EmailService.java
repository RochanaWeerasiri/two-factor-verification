package com.example.demo.Service;

import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Service
public class EmailService {

    private static final String username="rochanaweerasiri@gmail.com";
    private static final String password="junior13";

    public boolean sendEmail(String email_id, String twoFACode)throws AddressException, MessagingException {
        Properties props=new Properties();
        props.put("mail.smtp.auth","true");
        props.put("mail.smtp.starttls.enable","true");
        props.put("mail.smtp.host","smtp.gmail.com");
        props.put("mail.smtp.port","587");

        Session session=Session.getInstance(props,new javax.mail.Authenticator(){
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username,password);
            }
        });

        MimeMessage message=new MimeMessage(session);
        message.setFrom(new InternetAddress(username));
        message.addRecipient(Message.RecipientType.TO,new InternetAddress(email_id));

        message.setSubject("Verifying your email");
        message.setText("your Two Factor Authentication code is: "+twoFACode);

        Transport.send(message);
        return true;
    }
}
