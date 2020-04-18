package com.labinvent.task.web.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final VerifyTokenFilter verifyTokenFilter;

    public SecurityConfig(VerifyTokenFilter verifyTokenFilter) {
        this.verifyTokenFilter = verifyTokenFilter;
    }

    @Override
    protected void configure(HttpSecurity security) throws Exception {
        security.sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .csrf()
                .disable()
                .addFilterBefore(verifyTokenFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
