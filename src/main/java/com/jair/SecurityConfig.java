package com.jair;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public InMemoryUserDetailsManager userDetailsManager() {

		UserDetails user1 = User.withUsername("user").password(passwordEncoder().encode("user")).roles("USER").build();
		UserDetails admin = User.withUsername("admin").password(passwordEncoder().encode("admin")).roles("ADMIN")
				.build();

		return new InMemoryUserDetailsManager(user1, admin);
	}

	@Bean
	protected SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
		// Http builder configurations for authorize requests and form login
		return httpSecurity.csrf(csrf -> csrf.disable()).httpBasic(Customizer.withDefaults())
				.authorizeHttpRequests(http -> {
					// Config EndPoints Publics
					// Autorizamos el login para todos
					http.requestMatchers(HttpMethod.GET, "/login/").permitAll();

					// Autorizamos los recursos por carpetas especificas para todos.
					http.requestMatchers("/images/**", "/css/**", "/js/**", "/libs/**", "/scss/**").permitAll();

					// Config EndPoints Privates
					// Asignamos la autoorizacion para la vista empleados exxclusivamente a los
					// roles de Admin y Users
					// Metodos GET
					http.requestMatchers(HttpMethod.GET, "/principal/").hasAnyRole("ADMIN", "USER");
					http.requestMatchers(HttpMethod.GET, "/producto/", "/producto/**").hasAnyRole("ADMIN", "USER");
					http.requestMatchers(HttpMethod.GET, "/venta/", "/venta/**").hasAnyRole("ADMIN", "USER");
					http.requestMatchers(HttpMethod.GET, "/detalle/", "/detalle/**").hasAnyRole("ADMIN", "USER");
					http.requestMatchers(HttpMethod.GET, "/categoria/", "/categoria/**").hasAnyRole("ADMIN", "USER");
					http.requestMatchers(HttpMethod.GET, "/unidadMedida/", "/unidadMedida/**").hasAnyRole("ADMIN", "USER");
					http.requestMatchers(HttpMethod.GET, "/rol/", "/rol/*").hasAnyRole("ADMIN", "USER");
					http.requestMatchers(HttpMethod.GET, "/cliente/", "/cliente/**").hasAnyRole("ADMIN", "USER");
					http.requestMatchers(HttpMethod.GET, "/profesional/", "/profesional/**").hasAnyRole("ADMIN", "USER");

					//Metodos POST
					http.requestMatchers(HttpMethod.POST, "/detalle/", "/detalle/**").hasAnyRole("ADMIN", "USER");
					http.requestMatchers(HttpMethod.POST, "/producto/", "/producto/**").hasAnyRole("ADMIN", "USER");
					http.requestMatchers(HttpMethod.POST, "/venta/", "/venta/**").hasAnyRole("ADMIN", "USER");
					http.requestMatchers(HttpMethod.POST, "/categoria/", "/categoria/**").hasAnyRole("ADMIN", "USER");
					http.requestMatchers(HttpMethod.POST, "/unidadMedida/", "/unidadMedida/**").hasAnyRole("ADMIN", "USER");
					http.requestMatchers(HttpMethod.POST, "/cliente/", "/cliente/**").hasAnyRole("ADMIN", "USER");
					http.requestMatchers(HttpMethod.GET, "/categoria/formActualizarCategoria/**").hasAnyRole("ADMIN", "USER");
					
					// Autorizacion Exclusiva para ADMINS
					http.requestMatchers(HttpMethod.POST, "/rol/", "/rol/**").hasAnyRole("ADMIN");
					http.requestMatchers(HttpMethod.POST, "/profesional/", "/profesional/**").hasAnyRole("ADMIN");

					
					// Config EndPoints Not Specified
					//	Denegamos cualquier peticion para todos.
					http.anyRequest().denyAll();

				}).build();
	}

}
