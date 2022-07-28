package com.fiapproject.droneconsumer;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
public class DroneConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DroneConsumerApplication.class, args);
	}

}
