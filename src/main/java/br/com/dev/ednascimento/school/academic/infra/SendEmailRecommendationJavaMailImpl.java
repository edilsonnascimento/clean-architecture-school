package br.com.dev.ednascimento.school.academic.infra;

import br.com.dev.ednascimento.school.academic.domain.student.*;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

public class SendEmailRecommendationJavaMailImpl implements SendEmailRecommendation {

    @Override
    public void send(Student indicated) {

        // Configurações do servidor SMTP do Gmail
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        // Cria uma sessão com autenticação
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(indicated.getEmail().getAddress(), indicated.getPassword());
            }
        });

        try {
            // Cria uma mensagem
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("seu_email@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("destinatario@example.com"));
            message.setSubject("Assunto do E-mail");
            message.setText("Olá,\n\nEste é um exemplo de e-mail enviado via JavaMail.");

            // Envia a mensagem
            Transport.send(message);

            System.out.println("E-mail enviado com sucesso!");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
