package com.angularSpring.Categorys.config;

import com.angularSpring.Categorys.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig {

    @Autowired
    private DbService dbService;
    @Bean
    public void instanciaBasedeDados(){
        this.dbService.instanciaDB();
    }

}
