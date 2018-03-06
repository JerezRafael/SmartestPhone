package es.sidelab.configuracion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	public UserRepositoryAuthenticationProvider authenticationProvider;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		// Public pages
		http.authorizeRequests().antMatchers("/SmartestPhone").permitAll();
		http.authorizeRequests().antMatchers("/SmartestPhone/buscar/**").permitAll();
		http.authorizeRequests().antMatchers("/SmartestPhone/detalles").permitAll();
		http.authorizeRequests().antMatchers("/SmartestPhone/noticias").permitAll();

		http.authorizeRequests().antMatchers("/SmartestPhone/acceder").permitAll();
		http.authorizeRequests().antMatchers("/SmartestPhone/registrarse/**").permitAll();
		http.authorizeRequests().antMatchers("/SmartestPhone/erroracceder").permitAll();

		// Private pages (all other pages)
		http.authorizeRequests().antMatchers("/SmartestPhone/gestion").hasAnyRole("ADMIN");
		http.authorizeRequests().anyRequest().authenticated();

		// Login form
		http.formLogin().loginPage("/SmartestPhone/acceder");
		http.formLogin().defaultSuccessUrl("/SmartestPhone");
		http.formLogin().failureUrl("/SmartestPhone/erroracceder");

		http.formLogin().usernameParameter("usuario");
		http.formLogin().passwordParameter("contraseña");

		// Logout
		http.logout().logoutUrl("/SmartestPhone/salir");
		http.logout().logoutSuccessUrl("/SmartestPhone");

	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		// Database authentication provider
		auth.authenticationProvider(authenticationProvider);
		
	}
}