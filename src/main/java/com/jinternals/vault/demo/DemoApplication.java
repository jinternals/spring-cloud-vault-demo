package com.jinternals.vault.demo;

import com.jinternals.vault.demo.configuration.SomeProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	@Autowired
	SomeProperties someProperties;
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) {
		System.out.println(someProperties.getUsername());
		System.out.println(someProperties.getPassword());
	}
}
