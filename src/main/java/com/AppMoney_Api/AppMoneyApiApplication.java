package com.AppMoney_Api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.AppMoney_Api.config.property.AppMoneyApiProperty;

@SpringBootApplication
@EnableConfigurationProperties(AppMoneyApiProperty.class)
public class AppMoneyApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppMoneyApiApplication.class, args);
	}

}
