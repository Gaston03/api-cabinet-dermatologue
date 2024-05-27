package ma.supmti.api_cabinet_dermatologue.Prescription.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.supmti.api_cabinet_dermatologue.Prescription.models.Prescription;
import ma.supmti.api_cabinet_dermatologue.Prescription.repositories.PrescriptionRepository;

@Service
public class PrescriptionServiceImplementation implements PrescriptionService {

  @Autowired
  private PrescriptionRepository prescriptionRepository;

  /**
   * Finds a prescription by its ID.
   *
   * @param  id  the ID of the prescription to find
   * @return     the prescription with the given ID, or null if not found
   */
  @Override
  public Prescription findPrescriptionById(Long id) {
    return prescriptionRepository.findById(id).orElse(null);

  }

  /**
   * Finds all prescriptions.
   *
   * @return  a list of all prescriptions
   */
  @Override
  public List<Prescription> findAllPrescriptions() {
    return prescriptionRepository.findAll();
  }

    /**
     * Finds all prescriptions by the given patient ID.
     *
     * @param  patientId  the ID of the patient
     * @return            a list of prescriptions associated with the patient
     */
  @Override
  public List<Prescription> findAllPrescriptionsByPatientId(Long patientId) {
    return prescriptionRepository.findAllByPatientId(patientId);
  }

    /**
     * Saves a prescription in the database.
     *
     * @param  prescription  the prescription to be saved
     */
  @Override
  public void savePrescription(Prescription prescription) {
    prescriptionRepository.save(prescription);
  }

  /**
   * Updates a prescription with the given ID in the database with the provided prescription object.
   *
   * @param  id            the ID of the prescription to update
   * @param  prescription  the updated prescription object
   * @return               true if the prescription was successfully updated, false otherwise
   */
  @Override
  public boolean updatePrescription(Long id, Prescription prescription) {
    final Optional<Prescription> optionalPrescription = prescriptionRepository.findById(id);
    if (optionalPrescription.isPresent()) {
      final Prescription oldPrescription = optionalPrescription.get();

      oldPrescription.setDescription(prescription.getDescription());

      prescriptionRepository.save(oldPrescription);
      return true;
    }

    return false;
  }

    /**
     * Deletes a prescription with the given ID from the database.
     *
     * @param  id  the ID of the prescription to delete
     * @return     true if the prescription was successfully deleted, false otherwise
     */
  @Override
  public boolean deletePrescription(Long id) {
    if (prescriptionRepository.findById(id).isPresent()) {
      prescriptionRepository.deleteById(id);
      return true;
    }

    return false;
  }
}
