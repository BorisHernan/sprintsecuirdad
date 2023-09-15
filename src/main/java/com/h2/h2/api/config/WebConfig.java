package com.h2.h2.api.config;

;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;




@EnableWebSecurity
public class WebConfig {

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder){

        UserDetails user1 = User.withUsername("admin")
                .password(passwordEncoder.encode("admin123"))
                .roles("ADMIN", "USER")
                .build();

        UserDetails user2 = User.withUsername("Sri")
                .password(passwordEncoder.encode("sri123"))
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(user1,user2);
    }

    @Bean
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }


//    @Bean
//    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
    //        return http.authorizeHttpRequests((authorizeRequests)->{
    //            authorizeRequests.requestMatchers("/").permitAll();
    //            authorizeRequests.requestMatchers("/user/**").hasAnyRole("ADMIN", "USER");
    //            authorizeRequests.requestMatchers("/admin/**").hasRole("ADMIN");
//         }).formLogin().and().build();
        //    }


}
