package com.postgres.flyway.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class SecurityConfiguration extends ResourceServerConfigurerAdapter{

    @Override
    public void configure(final HttpSecurity httpSecurity) throws Exception{
        httpSecurity.authorizeRequests().anyRequest().permitAll();
    }

}
