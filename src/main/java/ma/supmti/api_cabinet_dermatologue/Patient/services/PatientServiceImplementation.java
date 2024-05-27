package ma.supmti.api_cabinet_dermatologue.Patient.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.supmti.api_cabinet_dermatologue.Patient.models.Patient;
import ma.supmti.api_cabinet_dermatologue.Patient.repositories.PatientRepository;

@Service
public class PatientServiceImplementation implements PatientService {
  @Autowired
  PatientRepository patientRepository;

  @Override
  public Patient findPatientById(Long id) {
    return patientRepository.findById(id).orElse(null);
  }

  @Override
  public List<Patient> findAllPatients() {
    return patientRepository.findAll();
  }

  @Override
  public void savePatient(Patient patient) {
    patientRepository.save(patient);
  }

  @Override
  public boolean deletePatient(Long id) {
    if (patientRepository.findById(id).isPresent()) {
      patientRepository.deleteById(id);
      return true;
    }

    return false;
  }

  @Override
  public boolean updatePatient(Long id, Patient patient) {
    final Optional<Patient> optionalPatient = patientRepository.findById(id);

    if (optionalPatient.isPresent()) {
      final Patient oldPatient = optionalPatient.get();

      oldPatient.setNom(patient.getNom());
      oldPatient.setPrenom(patient.getPrenom());
      oldPatient.setDateDeNaissance(patient.getDateDeNaissance());
      oldPatient.setTelephone(patient.getTelephone());

      patientRepository.save(oldPatient);
      return true;
    }

    return false;
  }
}
