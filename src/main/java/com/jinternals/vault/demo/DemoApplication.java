package com.jinternals.vault.demo.main;

import com.jinternals.vault.demo.config.DemoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import static org.springframework.boot.SpringApplication.run;

@SpringBootApplication
@Import({DemoConfiguration.class})
public class DemoApplication {

	public static void main(String[] args) {
		run(DemoApplication.class, args);
	}

}
