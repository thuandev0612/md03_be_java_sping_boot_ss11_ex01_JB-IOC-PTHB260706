package com.example.baitapsession11.service;

import com.example.baitapsession11.dto.PatientDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PatientService {
    public PatientDTO addPatient(PatientDTO patient) {
        if (patient.getAge() > 120) {
            log.warn("Tuổi bệnh nhân quá cao: name={}, age={}", patient.getName(), patient.getAge());
        }
        log.info("Đã tiếp nhận bệnh nhân: {}", patient.getName());
        return patient;
    }
}
