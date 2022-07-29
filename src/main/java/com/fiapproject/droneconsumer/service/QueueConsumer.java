package com.fiapproject.droneconsumer.service;

import com.fiapproject.droneconsumer.model.DroneData;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;


@Component
public class QueueConsumer {

    @RabbitListener(queues = {"${queue.name}"})
    public void receive(@Payload String fileBody) {
        System.out.println("Message " + fileBody);
    }

//    @RabbitListener(queues = {"${queue.name}"})
//    public void receive(@Payload DroneData droneData) {
//        System.out.println("Recebido! " + droneData);
//    }

}
