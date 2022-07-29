package com.fiapproject.droneconsumer;

import com.fiapproject.dronealert.DroneAlertRunnable;
import com.fiapproject.dto.DroneDataDto;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@EnableRabbit
@SpringBootApplication
public class DroneConsumerApplication {
	private static final List<DroneDataDto> alertDrones = Collections.synchronizedList(new ArrayList<>());
	public static void main(String[] args) {
		SpringApplication.run(DroneConsumerApplication.class, args);
		new Thread(new DroneAlertRunnable(alertDrones)).run();
	}

}
