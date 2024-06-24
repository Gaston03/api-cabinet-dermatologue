package ma.supmti.api_cabinet_dermatologue.RDV.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ma.supmti.api_cabinet_dermatologue.RDV.models.RDV;

public interface RDVRepository extends JpaRepository<RDV, Long> {

/**
 * Retrieves a list of RDV objects from the database based on the patient ID.
 *
 * @param  patientId  the ID of the patient to retrieve RDV objects for
 * @return            a list of RDV objects associated with the given patient ID
 */
  @Query(value = "SELECT * FROM \"rendez-vous\" r WHERE r.patient_id = :patientId", nativeQuery = true)
  public List<RDV> findRdvsByPatientId(@Param("patientId") Long patientId);

    /**
     * Retrieves a list of RDV objects from the database based on the cabinet ID.
     *
     * @param  cabinetId  the ID of the cabinet to retrieve RDV objects for
     * @return            a list of RDV objects associated with the given cabinet ID
     */
  @Query(value = "SELECT * FROM \"rendez-vous\" r WHERE r.cabinet_id = :cabinetId", nativeQuery = true)
  public List<RDV> findRdvsByCabinetId(@Param("cabinetId") Long cabinetId);
  
}
