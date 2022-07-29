package com.fiapproject.dronealert;

import com.fiapproject.dto.DroneDataDto;
import com.mailjet.client.ClientOptions;
import com.mailjet.client.MailjetClient;
import com.mailjet.client.transactional.SendContact;
import com.mailjet.client.transactional.SendEmailsRequest;
import com.mailjet.client.transactional.TrackOpens;
import com.mailjet.client.transactional.TransactionalEmail;
import com.mailjet.client.transactional.response.MessageResult;
import com.mailjet.client.transactional.response.SendEmailsResponse;
import org.apache.commons.configuration.PropertiesConfiguration;
import java.util.List;

public class DroneAlertRunnable implements Runnable{
    private final List<DroneDataDto> alertDrones;

    public DroneAlertRunnable(List<DroneDataDto> alertDrones) {
        this.alertDrones = alertDrones;
    }
    @Override
    public void run() {
        try {
            PropertiesConfiguration config = new PropertiesConfiguration();
            config.load("application.properties");
            String apiKey = config.getString("mailjeft.apikey");
            String secretKey = config.getString("mailjeft.secretkey");
            String senderEmail = config.getString("mailjeft.sender");
            String receiverEmail = config.getString("mailjeft.receiver");
            String senderName = config.getString("mailjeft.sendername");
            String receiverName = config.getString("mailjeft.receivername");
            while (true) {
                synchronized (alertDrones) {
                    if(alertDrones.size() > 0) {
                        StringBuilder body = new StringBuilder();
                        for (DroneDataDto drone :
                                alertDrones) {
                            body.append(drone.toString());
                        }
                        System.out.println("Sending E-mail:");
                        System.out.println(body);

                        ClientOptions options = ClientOptions.builder()
                                .apiKey(apiKey)
                                .apiSecretKey(secretKey)
                                .build();

                        MailjetClient client = new MailjetClient(options);

                        TransactionalEmail message = TransactionalEmail
                                .builder()
                                .to(new SendContact(senderEmail, senderName))
                                .from(new SendContact(receiverEmail, receiverName))
                                .htmlPart(body.toString())
                                .subject("Alerta de Drone!")
                                .trackOpens(TrackOpens.ENABLED)
                                .build();

                        SendEmailsRequest request = SendEmailsRequest
                                .builder()
                                .message(message)
                                .build();

                        SendEmailsResponse response = request.sendWith(client);
                        for (MessageResult result :
                                response.getMessages()) {
                            System.out.println(result);
                        }
                        alertDrones.clear();
                    }
                }
                Thread.sleep(1*60*1000);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
