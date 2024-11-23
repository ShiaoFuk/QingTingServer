package com.example.qingtingserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = {"com.example.qingtingserver"})
public class QingTingServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(QingTingServerApplication.class, args);
	}

}
