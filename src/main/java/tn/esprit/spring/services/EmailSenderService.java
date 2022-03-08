package tn.esprit.spring.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
 import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class EmailSenderService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendMailWithAttachment(String toEmail,
            String body,
            String subject,
            String attachment) throws MessagingException {

MimeMessage mimeMessage=mailSender.createMimeMessage();
MimeMessageHelper mimeMessageHelper=new MimeMessageHelper(mimeMessage,true);
mimeMessageHelper.setFrom("sahargharad@gmail.com");
mimeMessageHelper.setTo(toEmail);
mimeMessageHelper.setText(body);
mimeMessageHelper.setSubject(subject);

FileSystemResource fileSystemResource=
new FileSystemResource(new File(attachment));
mimeMessageHelper.addAttachment(fileSystemResource.getFilename(),fileSystemResource);
mailSender.send(mimeMessage);
System.out.println("Mail with attachment sent successfully..");



}
}