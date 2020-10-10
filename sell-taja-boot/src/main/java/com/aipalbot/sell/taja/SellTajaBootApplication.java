package com.aipalbot.sell.taja;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class SellTajaBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SellTajaBootApplication.class, args);
	}

}
