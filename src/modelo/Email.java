package modelo;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import javax.swing.JOptionPane;

public class Email {
	
	public static void send(String from, String password, String to, String sub, String msg) {
		
		//Propiedades
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		//Inicializa sesion gmail
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, password);
			}
		});

		// Mensaje
		try {
			MimeMessage message = new MimeMessage(session);
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject(sub);
			message.setText(msg);
			// send message
			Transport.send(message);
			JOptionPane.showMessageDialog(null, "Recibirá un correo electrónico con su usuario y contraseña");
		
		} catch (MessagingException e) {
			JOptionPane.showMessageDialog(null,
					"Se ha dado de alta pero no hemos podido enviarle los datos. Pongase en contacto con el hotel");
			{
				throw new RuntimeException(e);
			}
		}
	}
}
