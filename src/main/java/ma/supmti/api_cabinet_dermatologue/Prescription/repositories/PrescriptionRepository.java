package ma.supmti.api_cabinet_dermatologue.Prescription.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ma.supmti.api_cabinet_dermatologue.Prescription.models.Prescription;

public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {

    /**
     * Retrieves all prescriptions associated with the given patient ID.
     *
     * @param  patientId  the ID of the patient
     * @return            a list of prescriptions associated with the patient
     */
  @Query(value = "SELECT * FROM prescriptions p WHERE p.patient_id = :patientId", nativeQuery = true)
  public List<Prescription> findAllByPatientId(@Param("patientId") Long patientId);

}
