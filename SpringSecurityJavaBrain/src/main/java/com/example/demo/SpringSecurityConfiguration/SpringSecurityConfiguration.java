package com.example.demo.SpringSecurityConfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@EnableWebSecurity
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {
    // tell spring security  how to connect to your db and get the user information for validation using the username
    @Autowired
    DataSource dataSource;

    @Override
    // method to config the Authentication manager interface
    // authentication method
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.jdbcAuthentication()
                // configuring spring security to point and collet to your db to get user info for authentication purposes
                .dataSource(dataSource);
//                .usersByUsernameQuery("SELECT  userID, password, accountType from users WHERE email = ?")
//                .authoritiesByUsernameQuery("SELECT  userID, authority FROM authorities Where email = ? ")
                // create the default spring security table schema




        // the type of authentication to use (in memory)
//        auth.inMemoryAuthentication()
//                .withUser("justmondris")
//                .password("12345")
//                .roles("USER")
//                .and()
//                .withUser("justmondris2")
//                .password("1234")
//                .roles("USERS")
//                .and()
//                .withUser("justmondris3")
//                .password("123")
//                .roles("ADMIN")
//                .and()
//                .withUser("none")
//                .password("none")
//                .roles("none");
    }

    @Bean
    // configure the password encoder that spring will use
    public PasswordEncoder getPasswordEncoder(){
        // this means do not use any password encoder
        return NoOpPasswordEncoder.getInstance();
    }

    // config routes authorization


    @Override
    //Authorization method
    protected void configure(HttpSecurity http) throws Exception {
          http.authorizeRequests()
                  // permits all users to access all none restricted routes e.g home page, signup, logout e.t.c
                  .antMatchers("/admin/**").hasRole("ADMIN")
                  .antMatchers("/user/**").hasAnyRole("ADMIN", "USER")
                  .antMatchers("/").permitAll()
                  .and()
                  .formLogin()
                  .defaultSuccessUrl("/dashboard")
                  .failureUrl("/invalidLogin");

    }
}
