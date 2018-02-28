package es.sidelab;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		// Public pages
		http.authorizeRequests().antMatchers("/SmartestPhone").permitAll();
		http.authorizeRequests().antMatchers("/SmartestPhone/buscar/**").permitAll();
		http.authorizeRequests().antMatchers("/SmartestPhone/detalles").permitAll();
		http.authorizeRequests().antMatchers("/SmartestPhone/noticias").permitAll();
		
		http.authorizeRequests().antMatchers("/SmartestPhone/acceder").permitAll();
		http.authorizeRequests().antMatchers("/SmartestPhone/erroracceder").permitAll();
		http.authorizeRequests().antMatchers("/SmartestPhone/salir").permitAll();

		// Private pages (all other pages)
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

		// Disable CSRF at the moment
		http.csrf().disable();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// Usuario
		auth.inMemoryAuthentication().withUser("smartphone").password("smart").roles("USER");
		// Administrador
		//auth.inMemoryAuthentication().withUser("smartestphone").password("smartest").roles("ADMIN");
	}
}