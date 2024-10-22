package com.doctorsmission.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.doctorsmission.domain.PatientAppointment;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;

/**
 * Handler for requests to Lambda function.
 */
@Log4j2
public class BookDoctorsAppointmentService {
    private final ObjectMapper objectMapper = new ObjectMapper();
    public APIGatewayProxyResponseEvent addPatients(final APIGatewayProxyRequestEvent request, final Context context) {

        APIGatewayProxyResponseEvent response = new APIGatewayProxyResponseEvent();
        try {
            PatientAppointment patientAppointment = objectMapper.readValue(request.getBody(), PatientAppointment.class);
            String json = objectMapper.writeValueAsString(patientAppointment);
            return response
                    .withStatusCode(200)
                    .withBody(json);
        } catch (IOException e) {
            return response
                    .withBody("{}")
                    .withStatusCode(500);
        }
    }
}
