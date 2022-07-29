package com.fiapproject.dronealert;

import com.fiapproject.dto.DroneDataDto;
import com.mailjet.client.ClientOptions;
import com.mailjet.client.MailjetClient;
import com.mailjet.client.MailjetRequest;
import com.mailjet.client.MailjetResponse;
import com.mailjet.client.resource.Emailv31;
import com.mailjet.client.transactional.SendContact;
import com.mailjet.client.transactional.SendEmailsRequest;
import com.mailjet.client.transactional.TrackOpens;
import com.mailjet.client.transactional.TransactionalEmail;
import com.mailjet.client.transactional.response.SendEmailsResponse;

import java.util.List;
import java.util.Properties;

public class DroneAlertRunnable implements Runnable{
    private final List<DroneDataDto> alertDrones;

    public DroneAlertRunnable(List<DroneDataDto> alertDrones) {
        this.alertDrones = alertDrones;
    }
    @Override
    public void run() {
        try {
            while (true) {
                synchronized (alertDrones) {
                    StringBuilder body = new StringBuilder();
                    for (DroneDataDto drone :
                            alertDrones) {
                        body.append(drone.toString());
                    }

//                    ClientOptions options = ClientOptions.builder()
//                            .apiKey(System.getenv("MJ_APIKEY_PUBLIC"))
//                            .apiSecretKey(System.getenv("MJ_APIKEY_PRIVATE"))
//                            .build();
//
//                    MailjetClient client = new MailjetClient(options);
//
//                    TransactionalEmail message1 = TransactionalEmail
//                            .builder()
//                            .to(new SendContact(senderEmail, "stanislav"))
//                            .from(new SendContact(senderEmail, "Mailjet integration test"))
//                            .htmlPart("<h1>This is the HTML content of the mail</h1>")
//                            .subject("This is the subject")
//                            .trackOpens(TrackOpens.ENABLED)
//                            .header("test-header-key", "test-value")
//                            .customID("custom-id-value")
//                            .build();
//
//                    SendEmailsRequest request = SendEmailsRequest
//                            .builder()
//                            .message(message1) // you can add up to 50 messages per request
//                            .build();
//
//                    // act
//                    SendEmailsResponse response = request.sendWith(client);
//                    System.out.println(response.getStatus());
//                    System.out.println(response.getData());

                    alertDrones.clear();
                }
            }
        } catch (Exception e) {
        }
    }
}
