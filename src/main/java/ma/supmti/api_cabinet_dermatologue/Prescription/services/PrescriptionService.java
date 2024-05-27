package ma.supmti.api_cabinet_dermatologue.Prescription.services;

import java.util.List;

import ma.supmti.api_cabinet_dermatologue.Prescription.models.Prescription;

public interface PrescriptionService {

  Prescription findPrescriptionById(Long id);

  List<Prescription> findAllPrescriptions();

  List<Prescription> findAllPrescriptionsByPatientId(Long patientId);

  void savePrescription(Prescription prescription);

  boolean updatePrescription(Long id, Prescription prescription);

  boolean deletePrescription(Long id);

}
