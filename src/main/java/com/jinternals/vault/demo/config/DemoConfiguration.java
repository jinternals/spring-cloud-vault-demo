package com.jinternals.vault.demo.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.SessionAttributes;

@Configuration
@SessionAttributes("authorizationRequest")
@ComponentScan(basePackages = {"com.jinternals.vault.demo.controllers"})
@EntityScan(basePackages = {"com.jinternals.vault.demo.entities"})
@EnableJpaRepositories(basePackages = {"com.jinternals.vault.demo.repositories"})
public class DemoConfiguration {


}
