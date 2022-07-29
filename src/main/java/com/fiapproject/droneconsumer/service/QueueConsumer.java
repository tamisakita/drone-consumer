package com.fiapproject.droneconsumer.service;

import com.fiapproject.droneconsumer.DroneConsumerApplication;
import com.fiapproject.dto.DroneDataDto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;


@Component
public class QueueConsumer {

    @RabbitListener(queues = {"${queue.name}"})
    public void receive(@Payload DroneDataDto drone) {
        if( drone.getTemperatura() >= 35
            || drone.getTemperatura() <= 0
            || drone.getUmidade() >= 0.15) {
            synchronized (DroneConsumerApplication.alertDrones) {
                DroneConsumerApplication.alertDrones.add(drone);
                System.out.println("Alerta de Drone!\n");
                System.out.println(drone);
            }
        }
        System.out.println("Recebido! " + drone.getId());
    }

}
