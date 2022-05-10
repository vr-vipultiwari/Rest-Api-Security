package com.spring.security.restappsecurity.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRepository;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ApplicationSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    PasswordEncoder passwordEncoder ;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
       http
                .csrf().disable()

              /* .csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()) // This line says that the frontend application will be able to get the X-XSRF token from the header
                 .csrf().disable()
                  here we are telling that every request should be authenticated
                 .and()
               */
               .authorizeRequests()
               .antMatchers("/","index","/css/*","/js/*").permitAll()


               /*  .antMatchers("/api/**").hasRole(ApplicationUserRoles.STUDENT.name())
                  .antMatchers(HttpMethod.DELETE ,"/management/api/**").hasAuthority(ApplicationUserPermission.COURSE_WRITE.getPermission())
                  .antMatchers(HttpMethod.POST ,"/management/api/**").hasAuthority(ApplicationUserPermission.COURSE_WRITE.getPermission())
                  .antMatchers(HttpMethod.PUT ,"/management/api/**").hasAuthority(ApplicationUserPermission.COURSE_WRITE.getPermission())
                  .antMatchers("/management/api/**").hasAnyRole(
                   ApplicationUserRoles.ADMIN.name(),
                       ApplicationUserRoles.STUDENT.name(),
                       ApplicationUserRoles.ADMINTRAINNE.name()
                )*/
               .antMatchers("/login").permitAll()
               .anyRequest()
               .authenticated()
               // here we are telling spring security to use basic auth as Authentication mechanism
               .and()
               .formLogin()
               .loginPage("/login");
     //  http
     //          .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails annaUser =  User.builder()
                .username("anna")
                .password(passwordEncoder.encode("password"))
                // .roles(ApplicationUserRoles.STUDENT.name()).build() ;
                .authorities(ApplicationUserRoles.STUDENT.getGrantedAuthority())
                .build() ;

        UserDetails lindaUser  = User.builder()
                .username("linda")
                .password(passwordEncoder.encode("linda123"))
               // .roles(ApplicationUserRoles.ADMIN.name()).build();
                .authorities(ApplicationUserRoles.ADMIN.getGrantedAuthority())
                .build() ;

        UserDetails tomUser  =  User.builder().username("tom")
                .password(passwordEncoder.encode("password123"))
             // .roles(ApplicationUserRoles.ADMINTRAINNE.name()).build() ;
                .authorities(ApplicationUserRoles.ADMINTRAINNE.getGrantedAuthority())
                .build() ;

        return new InMemoryUserDetailsManager(annaUser,lindaUser,tomUser);
    }
}
