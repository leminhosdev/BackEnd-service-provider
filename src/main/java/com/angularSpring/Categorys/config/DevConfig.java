package com.angularSpring.Categorys.config;

import com.angularSpring.Categorys.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class DevConfig {
    @Autowired
    private DbService dbService;
    @Value("${    hibernate:\n" +
            "      ddl-auto:}")
    private String valid;
    @Bean
    public void instanciaBD(){
        this.dbService.instanciaDB();

    }
}
