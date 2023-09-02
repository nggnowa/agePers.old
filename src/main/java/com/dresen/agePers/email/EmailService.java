package com.dresen.agePers.email;

import lombok.AllArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class EmailService {

    JavaMailSender javaMailSender;

    public void envoyer(EmailDetails emailDetails) {

        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setFrom(emailDetails.from());
        mailMessage.setTo(emailDetails.to());
        mailMessage.setSubject(emailDetails.subject());
        mailMessage.setText(emailDetails.body());

        javaMailSender.send(mailMessage);

    }

}
