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

    /**
     * Finds a patient by their ID.
     *
     * @param  id  the ID of the patient to find
     * @return     the patient with the given ID, or null if not found
     */
  @Override
  public Patient findPatientById(Long id) {
    return patientRepository.findById(id).orElse(null);
  }

  /**
   * Retrieves a list of all patients from the database.
   *
   * @return  a list of Patient objects representing all patients
   */
  @Override
  public List<Patient> findAllPatients() {
    return patientRepository.findAll();
  }

    /**
     * Saves a patient into the database.
     *
     * @param  patient  the patient object to be saved
     */
  @Override
  public void savePatient(Patient patient) {
    patientRepository.save(patient);
  }

  /**
   * Deletes a patient with the given ID from the database.
   *
   * @param  id  the ID of the patient to delete
   * @return     true if the patient was successfully deleted, false otherwise
   */
  @Override
  public boolean deletePatient(Long id) {
    if (patientRepository.findById(id).isPresent()) {
      patientRepository.deleteById(id);
      return true;
    }

    return false;
  }

  /**
   * Updates a patient with the given ID in the database.
   *
   * @param  id      the ID of the patient to update
   * @param  patient the updated patient object
   * @return         true if the patient was successfully updated, false otherwise
   */
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
