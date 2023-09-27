package com.example.employeerestapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager(){
        UserDetails quan = User.builder()
                .username("quan")
                .password("{noop}bui")
                .roles("admin")
                .build();
        UserDetails tuan = User.builder()
                .username("tuan")
                .password("{noop}dao")
                .roles("manager")
                .build();
        UserDetails tuan2 = User.builder()
                .username("tuan2")
                .password("{noop}tran")
                .roles("employee")
                .build();
        return new InMemoryUserDetailsManager(quan,tuan,tuan2);
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(configure ->{
          configure.requestMatchers(HttpMethod.DELETE,"/employees/**")
                    .hasRole("admin");
          configure.requestMatchers(HttpMethod.GET,"/employees")
                  .permitAll();
          configure.requestMatchers(HttpMethod.GET,"/employees/**")
                  .permitAll();
          configure.requestMatchers(HttpMethod.PUT,"/employees/**")
                  .hasAnyRole("admin","manager");
          configure.requestMatchers(HttpMethod.POST,"/employees")
                  .hasAnyRole("admin","manager");
        });
        http.httpBasic(Customizer.withDefaults());
        http.csrf().disable();
        return http.build();
    }
}
