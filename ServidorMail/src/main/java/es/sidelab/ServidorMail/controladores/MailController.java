package es.sidelab.ServidorMail.controladores;

import java.util.Date;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import es.sidelab.ServidorMail.clases.Noticia;
import es.sidelab.ServidorMail.clases.Smartphone;
import es.sidelab.ServidorMail.clases.Usuario;
import es.sidelab.ServidorMail.repositorios.UsuarioRepository;

@RestController
@RequestMapping("/mail")
public class MailController {

	@Value("${contrasena}")
	private String contrasena;
	
	@Autowired
	private UsuarioRepository repositorioUsuario;

	private final String usuario = "smartestphoneweb@gmail.com";
	private final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";

	@PostMapping(value = "/smartphone")
	@ResponseStatus(HttpStatus.CREATED)
	public Smartphone mailSmartphone(@RequestBody Smartphone smartphone) {

		Properties propiedades = iniciarMail();

		try {
			Session session = Session.getDefaultInstance(propiedades, new Authenticator() {
				private final String springContraseña = System.getProperty("contrasena");
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(usuario, springContraseña);
				}
			});

			Set<Usuario> usuarios = new HashSet<>(); // Recoger todos los usuarios
			for (Usuario usuario : repositorioUsuario.findAll()) {
				usuarios.add(usuario);
			}

			Message mensaje = new MimeMessage(session);
			mensaje.setFrom(new InternetAddress(usuario));

			for (Usuario usuario : usuarios) { // Añadimos las direcciones al mensaje
				mensaje.addRecipients(Message.RecipientType.BCC, InternetAddress.parse(usuario.getMail()));
			}

			mensaje.setSubject("¡Nuevo smartphone en SmartestPhone!");
			mensaje.setText("¡Se ha registrado un nuevo smartphone en nuestra web!\n" + smartphone.getMarca() + " "
					+ smartphone.getModelo() + "\n\n¡Entra a nuestra web y descubre los detalles!\n"
					+ "https://127.0.0.1:9090/SmartestPhone/detalles?idSmartphone=" + smartphone.getIdSmartPhone());
			mensaje.setSentDate(new Date());
			Transport.send(mensaje);
			// Mensaje enviado

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

		Properties propiedades = iniciarMail();

		try {
			Session session = Session.getDefaultInstance(propiedades, new Authenticator() {
				private final String contraseña = System.getProperty("contraseña", "mi contraseña");
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(usuario, contraseña);
				}
			});

			Set<Usuario> usuarios = new HashSet<>(); // Recoger todos los usuarios
			for (Usuario usuario : repositorioUsuario.findAll()) {
				usuarios.add(usuario);
			}

			Message mensaje = new MimeMessage(session);
			mensaje.setFrom(new InternetAddress(usuario));

			for (Usuario usuario : usuarios) {
				mensaje.addRecipients(Message.RecipientType.TO, InternetAddress.parse(usuario.getMail()));
			}
			mensaje.setSubject("¡Nueva noticia en SmartestPhone!");
			mensaje.setText("¡Se ha introducido una nueva noticia en nuestra web!\n" + noticia.getTitulo() + "\n"
					+ noticia.getUrl() + "\n\n¡Entra a nuestra web y descubre los detalles!\n"
					+ "https://127.0.0.1:9090/SmartestPhone/noticias");
			mensaje.setSentDate(new Date());
			Transport.send(mensaje);
			// Mensaje enviado
			
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

		Properties propiedades = System.getProperties();
		propiedades.setProperty("mail.smtp.host", "smtp.gmail.com");
		propiedades.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
		propiedades.setProperty("mail.smtp.socketFactory.fallback", "false");
		propiedades.setProperty("mail.smtp.port", "465");
		propiedades.setProperty("mail.smtp.socketFactory.port", "465");
		propiedades.put("mail.smtp.auth", "true");
		propiedades.put("mail.debug", "true");
		propiedades.put("mail.store.protocol", "pop3");
		propiedades.put("mail.transport.protocol", "smtp");

		return propiedades;
	}

}
