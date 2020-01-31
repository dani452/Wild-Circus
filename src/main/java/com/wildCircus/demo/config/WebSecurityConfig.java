package com.wildCircus.demo.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	    http
	    	.authorizeRequests()
	        .antMatchers("/login1/**").permitAll()
	        .antMatchers("/admin/**","/adminAbout_edit/**","/adminAbout/**","/adminCardAbout_add/**","/adminCardAbout-edit/**","/adminHome_edit/**","/adminHome/**","/adminPrice/**","/adminPriceEdit/**").hasAnyRole("ADMIN","USER")
	            .and()
	        .formLogin()
	        .loginPage("/login1")
	        .defaultSuccessUrl("/admin", true)
	            .and()
	        .logout()
	        .logoutSuccessUrl("/")
	        .logoutUrl("/logout")
	        	.and()
	        .httpBasic();
    }
		
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		auth.inMemoryAuthentication()
	    .withUser("admin")
	        .password(encoder.encode("admin"))
	        .roles("ADMIN")
	        .and()
	    .withUser("user")
	        .password(encoder.encode("user"))
	        .roles("USER");
	}
}
