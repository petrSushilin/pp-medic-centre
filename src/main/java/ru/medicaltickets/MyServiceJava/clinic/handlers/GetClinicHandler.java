package ru.medicaltickets.MyServiceJava.clinic.handlers;

import ru.medicaltickets.MyServiceJava.clinic.ClinicService;

public class GetClinicHandler {
    private final ClinicService clinicService;

    public GetClinicHandler(ClinicService clinicService) {
        this.clinicService = clinicService;
    }
}
