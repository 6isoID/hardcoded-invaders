package com.epam.game.conf;

import com.epam.game.constants.ViewsEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.web.authentication.ExceptionMappingAuthenticationFailureHandler;

/**
 * @author Igor_Petrov@epam.com
 * Created at 1/14/2019
 */
@Configuration
public class SecurityConf extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .anyRequest().authenticated()
                    .and()
                .formLogin()
                    .loginPage("/" + ViewsEnum.LOGIN + ViewsEnum.EXTENSION)
                        .usernameParameter("userName")
                        .passwordParameter("password")
                        .loginProcessingUrl("/login.html")
                        .failureHandler(new ExceptionMappingAuthenticationFailureHandler() {
                            
                        })
                    .permitAll()
                .and();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(new DelegatingPasswordEncoder())
    }
}
