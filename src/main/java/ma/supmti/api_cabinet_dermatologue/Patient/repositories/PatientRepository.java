package ma.supmti.api_cabinet_dermatologue.Patient.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.supmti.api_cabinet_dermatologue.Patient.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {
  
}
