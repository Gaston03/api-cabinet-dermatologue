package ma.supmti.api_cabinet_dermatologue.RDV.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.supmti.api_cabinet_dermatologue.RDV.models.RDV;
import ma.supmti.api_cabinet_dermatologue.RDV.repositories.RDVRepository;

@Service
public class RDVServiceImplementation implements RDVService {

  @Autowired
  private RDVRepository rdvRepository;

  /**
   * Finds a RDV object by its ID.
   *
   * @param  id  the ID of the RDV object to find
   * @return     the RDV object with the given ID, or null if not found
   */
  @Override
  public RDV findRdvById(Long id) {
    return rdvRepository.findById(id).orElse(null);
  }

  /**
   * Finds all RDV objects in the repository.
   *
   * @return a list of RDV objects
   */
  @Override
  public List<RDV> findAllRdvs() {
    return rdvRepository.findAll();
  }

  /**
   * Finds a list of RDV objects by the given patient ID.
   *
   * @param  patientId  the ID of the patient
   * @return            a list of RDV objects associated with the patient ID
   */
  @Override
  public List<RDV> findRdvsByPatientId(Long patientId) {
    return rdvRepository.findRdvsByPatientId(patientId);
  }

  /**
   * Finds a list of RDV objects by the given cabinet ID.
   *
   * @param  cabinetId  the ID of the cabinet
   * @return             a list of RDV objects associated with the cabinet ID
   */
  @Override
  public List<RDV> findRdvsByCabinetId(Long cabinetId) {
    return rdvRepository.findRdvsByCabinetId(cabinetId);
  }

    /**
     * Saves the given RDV object to the repository.
     *
     * @param  rdv  the RDV object to be saved
     */
  @Override
  public void saveRdv(RDV rdv) {
    rdvRepository.save(rdv);
  }

  /**
   * Updates an existing RDV object with the given ID.
   *
   * @param  id  the ID of the RDV object to be updated
   * @param  rdv the updated RDV object
   * @return     true if the RDV object was successfully updated, false otherwise
   */
  @Override
  public boolean updateRdv(Long id, RDV rdv) {
    final Optional<RDV> optionalRdv = rdvRepository.findById(id);

    if (optionalRdv.isPresent()) {
      final RDV olRdv = optionalRdv.get();

      olRdv.setMotif(rdv.getMotif());
      olRdv.setDescription(rdv.getDescription());
      olRdv.setDate(rdv.getDate());
      olRdv.setStatus(rdv.getStatus());

      rdvRepository.save(olRdv);
      return true;
    }

    return false;
  }

  /**
   * Deletes an RDV object with the given ID.
   *
   * @param  id  the ID of the RDV object to be deleted
   * @return     true if the RDV object was successfully deleted, false otherwise
   */
  @Override
  public boolean deleteRdv(Long id) {
    if (rdvRepository.findById(id).isPresent()) {
      rdvRepository.deleteById(id);
      return true;
    }

    return false;
  }
  
}
