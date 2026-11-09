package com.example.baitapsession11.controller;

import com.example.baitapsession11.dto.PatientDTO;
import com.example.baitapsession11.service.PatientService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/patients")
@Slf4j
public class PatientController {
    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PatientDTO> addPatient(@Valid @RequestBody PatientDTO patient) {
        log.info("Nhận yêu cầu thêm bệnh nhân: {}", patient.getName());
        return ResponseEntity.ok(patientService.addPatient(patient));
    }
}
