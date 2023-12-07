package com.example.demo1.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(NoOpPasswordEncoder.getInstance()/*getPasswordEncoder()*/)
                .usersByUsernameQuery("SELECT username, password, 'true' FROM Personal WHERE username=?")
                .authoritiesByUsernameQuery("SELECT username, password FROM Personal WHERE username=?");

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/login","/registration").permitAll()
                .antMatchers("/Tasks","/main").hasRole("User")
                .antMatchers("/main","/Comments","/Projects","/Task_priorities","/Task_statuses","/Task","/Type").hasRole("Manager")
                .antMatchers("/**").hasRole("Admin")
                .anyRequest().authenticated().and().formLogin().loginPage("/login")
                .defaultSuccessUrl("/main").permitAll().and().logout().permitAll()
                .and().csrf().disable().cors().disable();
    }
}