package com.spring.security.restappsecurity.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    PasswordEncoder passwordEncoder ;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
       http
               // here we are telling that every request should be authenticated
               .authorizeRequests()
               .antMatchers("/","index","/css/*","/js/*").permitAll()
               .antMatchers("/api/**").hasRole(ApplicationUserRoles.STUDENT.name())
               .anyRequest()
               .authenticated()
               // here we are telling spring security to use basic auth as Authentication mechanism
               .and().httpBasic();
       http
               .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails annaUser =  User.builder()
                .username("anna")
                .password(passwordEncoder.encode("password"))
                .roles(ApplicationUserRoles.STUDENT.name()).build() ;

        UserDetails lindaUser  = User.builder()
                .username("linda")
                .password(passwordEncoder.encode("linda123"))
                .roles(ApplicationUserRoles.ADMIN.name()).build();

        return new InMemoryUserDetailsManager(annaUser,lindaUser);
    }
}
