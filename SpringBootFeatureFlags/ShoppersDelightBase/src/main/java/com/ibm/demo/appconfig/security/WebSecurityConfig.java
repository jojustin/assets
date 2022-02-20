package com.ibm.demo.appconfig.security;
import com.ibm.demo.appconfig.security.handlers.CustomLogoutHandler;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
	protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable();
		http
			.authorizeRequests()
				.antMatchers("/").permitAll()
				.and()
			    .formLogin()
				.loginPage("/login")
                .and()
			    .logout()
                .logoutUrl("/logout")
                .deleteCookies("JSESSIONID")
                .logoutSuccessHandler(logoutSuccessHandler());
	}

    @Bean
    public LogoutSuccessHandler logoutSuccessHandler() {
        return new CustomLogoutHandler();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user")
                .password("{noop}pass")
                .roles("USER")
                .and()
                .withUser("alice")
                .password("{noop}pass")
                .roles("MANAGER");
    }
}
