package ru.yura.web.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import ru.yura.web.app.handler.MySimpleUrlAuthenticationSuccessHandler;
import ru.yura.web.model.User;
import ru.yura.web.service.UserService;

import javax.naming.AuthenticationException;
import java.util.Map;


/*
 *
 *@Data 10.03.2020
 *@autor Fedorov Yuri
 *@project spring_mvc
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/hello/**").permitAll()
                .antMatchers("/admin/**","/bootstrap/**").hasAuthority("ADMIN")
                .antMatchers("/user/**").authenticated()
                .and()
                .formLogin()
                .usernameParameter("email")
                .successHandler(new MySimpleUrlAuthenticationSuccessHandler())
                .and()
                .oauth2Login()
                .successHandler(new MySimpleUrlAuthenticationSuccessHandler());
        http.csrf().disable();
    }
}
