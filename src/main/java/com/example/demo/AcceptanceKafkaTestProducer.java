package com.example.demo;

import org.example.demo.presubmissioncheck.AcceptancePreSubmissionCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Component;

@Component
public class AcceptanceKafkaTestProducer {

    @Autowired
    private StreamBridge template;

    public void sendAcceptanceResponse() {
        AcceptancePreSubmissionCheck acceptanceCallback = AcceptancePreSubmissionCheck.newBuilder()
                                                                                      .setBusinessCaseId("temp")
                                                                                      .setSourceSystem("Sails")
                                                                                      .build();

        template.send("acceptanceOutput", acceptanceCallback);
    }
}
