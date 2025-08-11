package result_service.service.util;

import jakarta.mail.MessagingException;
import lombok.AllArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class MailService {

        private final JavaMailSender mailSender;

        public void sendMail(String to, String studentName, String UEUname) throws MessagingException {

            String objectMail = "Publication des cotes";
            String messageMail = "Bonjour cher.e "+studentName+", une nouvelle cote dans le cours de "+UEUname+" a été rendue disponible !";

            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(to);
            message.setSubject(objectMail);
            message.setText(messageMail);
            mailSender.send(message);

    }
}
