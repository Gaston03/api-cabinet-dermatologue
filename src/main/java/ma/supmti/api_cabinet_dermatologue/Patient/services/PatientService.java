package ma.supmti.api_cabinet_dermatologue.Patient.services;

import java.util.List;

import ma.supmti.api_cabinet_dermatologue.Patient.Patient;

public interface PatientService {

  Patient findPatientById(Long id);
  List<Patient> findAllPatients();
  void savePatient(Patient patient);
  boolean deletePatient(Long id);
  boolean updatePatient(Long id, Patient patient);
  
}
