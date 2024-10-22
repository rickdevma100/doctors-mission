package com.doctorsmission.domain;

import lombok.Data;

import java.util.Date;
@Data
public class PatientAppointment {
    private long patientId;
    private String patientName;
    private String appointmentDate;
    private String appointmentTimeslot;
    private String symptoms;
    private Slot slot;
}
