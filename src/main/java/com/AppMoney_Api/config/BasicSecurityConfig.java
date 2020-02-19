package com.AppMoney_Api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Profile("basic-security")
@Configuration
@EnableWebSecurity
public class BasicSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private UserDetailsService userDetailsService;
	
		
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http											//.cors()
														//.and()
			.authorizeRequests()
			.anyRequest().authenticated()
			.and()
			.httpBasic()
			.and()
			.antMatcher( "/**")
			.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
			.csrf().disable();
	}
	
//	@Bean
//	CorsConfigurationSource corsConfigurationSource() {
//		
//		 final CorsConfiguration configuration = new CorsConfiguration();
//		 configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
//		 configuration.setAllowedMethods(Arrays.asList("HEAD", "GET", 
//                 "POST", "PUT", "DELETE", "PATCH", "OPTIONS"));
//// setAllowCredentials(true) is important, otherwise:
//// The value of the 'Access-Control-Allow-Origin' header in the response must not be the wildcard '*' when the request's credentials mode is 'include'.
//configuration.setAllowCredentials(true);
//// setAllowedHeaders is important! Without it, OPTIONS preflight request
//// will fail with 403 Invalid CORS request
//configuration.setAllowedHeaders(Arrays.asList("Authorization", "Cache-Control", "Content-Type"));
//final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//source.registerCorsConfiguration("/**", configuration);
//return source;
//	}
//	
//	@SuppressWarnings("deprecation")
//	@Bean
//    public WebMvcConfigurer corsConfigurer() {
//        return new WebMvcConfigurerAdapter() {
//        	
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/**").allowedOrigins("http://localhost:4200");
//            }
//        };
//	}
//	
	
}
