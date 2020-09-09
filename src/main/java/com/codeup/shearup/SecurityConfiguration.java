package com.codeup.shearup;

import com.codeup.shearup.services.UserDetailsLoader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	private UserDetailsLoader usersLoader;

	public SecurityConfiguration(UserDetailsLoader usersLoader) {
		this.usersLoader = usersLoader;
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
				.userDetailsService(usersLoader) // How to find users by their username
				.passwordEncoder(passwordEncoder()) // How to encode and verify passwords
		;
	}

	// change these as we create new pages
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				/* Login configuration */
				.formLogin()
				.loginPage("/login")
				//======WHEN USER LOGS IN IT PINGS DASHBOARD====//
				.defaultSuccessUrl("/dashboard") // user's home page, it can be any URL
				.permitAll() // Anyone can go to the login page
				/* Logout configuration */
				.and()
				.logout()
				.logoutSuccessUrl("/login?logout") // append a query string value
				/* Pages that can be viewed without having to log in */
				.and()
				.authorizeRequests()
				.antMatchers("/",
				             "login",
				             "/sign-up",
				             "/about") // anyone can visit these pages
				.permitAll()
				/* Pages that require authentication */
				.and()
				.authorizeRequests()
				.antMatchers(
						 // only authenticated users can visit these pages
						 "/dashboard",
						 "/profile",
						 "/profile/edit/{id}",
						 "/appointments",
						 "/appointments/{id}",
						 "/appointments/create/{id}",
						 "/appointment/create",
						 "/appointments/{id}/delete",
						 "/barber/profile",
						 "/barber/profile/{id}",
						 "/barber/service-delete",
						 "/barber/{id}/edit-service",
						 "/barber/edit-service",
						 "/barber/add-service",
						 "/barbers",
						 "/barber/barber-details/bio",
						 "/barber/edit-barber-details",
						 "/barber/barber-details/location",
						 "/barber/edit-barber-location",
						 "/filestack",
						 "/map",
						 "/maps",
						 "/mapbox-map",
						 "/mapbox/barbers",
						 "/reviews",
						 "/reviews/{id}",
						 "/reviews/create",
						 "/reviews/create/{id}",
						 "/reviews/{id}/edit",
						 "/reviews/{id}/delete",
						 "/services",
						 "/services/{id}",
						 "/services/create",
						 "/services/{id}/edit",
						 "/services/{id}/delete",
						 "/upload-page")
				.authenticated()
		;
	}
}
