package com.fiapproject.droneconsumer.service;

import com.fiapproject.dto.DroneDataDto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;


@Component
public class QueueConsumer {

    @RabbitListener(queues = {"${queue.name}"})
    public void receive(@Payload DroneDataDto droneDataDto) {
        System.out.println("Recebido! " + droneDataDto);
    }

}
