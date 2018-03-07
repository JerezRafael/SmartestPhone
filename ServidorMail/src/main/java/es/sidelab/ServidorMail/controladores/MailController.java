package es.sidelab.ServidorMail.controladores;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import es.sidelab.ServidorMail.clases.Noticia;
import es.sidelab.ServidorMail.clases.Smartphone;
import es.sidelab.ServidorMail.clases.Usuario;

@RestController
@RequestMapping("/mail")
public class MailController {

	private final String username = "smartestphoneweb@gmail.com";
	private final String password = "smartphone";
	private final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
	private List<Usuario> usuarios = new ArrayList<Usuario>();

//	@PostMapping(value = "/usuarios/init")
//	@ResponseStatus(HttpStatus.CREATED)
//	public List<Usuario> crearUsuarios(@RequestBody List<Usuario> usuarios) {
//
//		this.usuarios = new ArrayList<Usuario>();
//		for (Usuario usuario : usuarios) {
//			this.usuarios.add(usuario);
//		}
//		return usuarios;
//	}

	@PutMapping(value = "/usuario")
	public ResponseEntity<Usuario> nuevoUsuario(@RequestBody Usuario usuario) {

		this.usuarios.add(usuario);
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}

	@DeleteMapping(value = "/usuario/init")
	public ResponseEntity<List<Usuario>> initUsuario() {

		usuarios = new ArrayList<Usuario>();
		return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK);
	}

	@PostMapping(value = "/smartphone")
	@ResponseStatus(HttpStatus.CREATED)
	public Smartphone mailSmartphone(@RequestBody Smartphone smartphone) {

		Properties props = iniciarMail();
		
		try {
			Session session = Session.getDefaultInstance(props, new Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, password);
				}
			});

			Message mensaje = new MimeMessage(session);

			mensaje.setFrom(new InternetAddress(username));
			// for (Usuario usuario : usuarios) {
			// mensaje.addRecipients(Message.RecipientType.TO,
			// InternetAddress.parse(usuario.getMail()));
			// }
			mensaje.addRecipients(Message.RecipientType.TO, InternetAddress.parse("rafa.jerez4@gmail.com"));
			mensaje.setSubject("¡Nuevo smartphone en SmartestPhone!");
			mensaje.setText("¡Se ha registrado un nuevo smartphone en nuestra web!\n" + smartphone.getMarca() + " "
					+ smartphone.getModelo() + "\n\n¡Entra a nuestra web y descubre los detalles!\n"
					+ "https://127.0.0.1:9090/SmartestPhone/detalles?idSmartphone=" + smartphone.getIdSmartPhone());
			mensaje.setSentDate(new Date());
			Transport.send(mensaje);
			Address[] addresses = mensaje.getAllRecipients();
			String[] direcciones = new String[addresses.length];
			for (int i = 0; i < addresses.length; i++) {
				direcciones[i] = addresses[i].toString();
			}
			System.out.println("Mensaje enviado a:\n");
			for (int i = 0; i < direcciones.length; i++) {
				System.out.println(direcciones[i]);
			}
		} catch (MessagingException e) {
			System.out.println("ERROR" + e);
		}
		return smartphone;
	}

	@PostMapping(value = "/noticia")
	@ResponseStatus(HttpStatus.CREATED)
	public Noticia mailNoticia(@RequestBody Noticia noticia) {

		Properties props = iniciarMail();
		
		try {
			Session session = Session.getDefaultInstance(props, new Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, password);
				}
			});

			Message mensaje = new MimeMessage(session);

			mensaje.setFrom(new InternetAddress(username));
			// for (Usuario usuario : usuarios) {
			// mensaje.addRecipients(Message.RecipientType.TO,
			// InternetAddress.parse(usuario.getMail()));
			// }
			mensaje.addRecipients(Message.RecipientType.TO, InternetAddress.parse("rafa.jerez4@gmail.com"));
			mensaje.setSubject("¡Nueva noticia en SmartestPhone!");
			mensaje.setText("¡Se ha introducido una nueva noticia en nuestra web!\n" + noticia.getTitulo() + "\n"
					+ noticia.getUrl() + "\n\n¡Entra a nuestra web y descubre los detalles!\n"
					+ "https://127.0.0.1:9090/SmartestPhone/noticias");
			mensaje.setSentDate(new Date());
			Transport.send(mensaje);
			Address[] addresses = mensaje.getAllRecipients();
			String[] direcciones = new String[addresses.length];
			for (int i = 0; i < addresses.length; i++) {
				direcciones[i] = addresses[i].toString();
			}

			System.out.println("Mensaje enviado a:\n");
			for (int i = 0; i < direcciones.length; i++) {
				System.out.println(direcciones[i]);
			}
		} catch (MessagingException e) {
			System.out.println("ERROR" + e);
		}

		return noticia;
	}
	
	private Properties iniciarMail() {
		
		Properties props = System.getProperties();
		props.setProperty("mail.smtp.host", "smtp.gmail.com");
		props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
		props.setProperty("mail.smtp.socketFactory.fallback", "false");
		props.setProperty("mail.smtp.port", "465");
		props.setProperty("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.auth", "true");
		props.put("mail.debug", "true");
		props.put("mail.store.protocol", "pop3");
		props.put("mail.transport.protocol", "smtp");
		
		return props;
	}

}
