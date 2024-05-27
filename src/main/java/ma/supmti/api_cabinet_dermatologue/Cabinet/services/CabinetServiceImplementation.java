package ma.supmti.api_cabinet_dermatologue.Cabinet.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.supmti.api_cabinet_dermatologue.Cabinet.models.Cabinet;
import ma.supmti.api_cabinet_dermatologue.Cabinet.repositories.CabinetRepository;

@Service
public class CabinetServiceImplementation implements CabinetService{

  @Autowired
  CabinetRepository cabinetRepository;

  /**
   * Finds a cabinet by its ID.
   *
   * @param  id  the ID of the cabinet to find
   * @return     the cabinet with the given ID, or null if it does not exist
   */
  @Override
  public Cabinet findCabinetById(Long id) {
    return cabinetRepository.findById(id).orElse(null);
  }

  /**
   * Finds all the cabinets in the database.
   *
   * @return a list of Cabinet objects representing all the cabinets in the repository.
   */
  @Override
  public List<Cabinet> findAllCabinets() {
    return cabinetRepository.findAll();
  }

  /**
   * Saves a cabinet to the database.
   *
   * @param  cabinet  the cabinet object to be saved
   */
  @Override
  public void saveCabinet(Cabinet cabinet) {
    cabinetRepository.save(cabinet);
  }

  /**
   * Deletes a cabinet with the given ID.
   *
   * @param  id  the ID of the cabinet to delete
   * @return     true if the cabinet was successfully deleted, false otherwise
   */
  @Override
  public boolean deleteCabinet(Long id) {
    if (cabinetRepository.findById(id).isPresent()) {
      cabinetRepository.deleteById(id);
      return true;
    }

    return false;
  }

  /**
   * Updates a cabinet with the given ID using the provided Cabinet object.
   *
   * @param  id       the ID of the cabinet to update
   * @param  cabinet the Cabinet object containing the updated information
   * @return          true if the cabinet was successfully updated, false otherwise
   */
  @Override
  public boolean updateCabinet(Long id, Cabinet cabinet) {
    final Optional<Cabinet> optionalCabinet = cabinetRepository.findById(id);

    if (optionalCabinet.isPresent()) {
      final Cabinet oldCabinet = optionalCabinet.get();

      oldCabinet.setNom(cabinet.getNom());
      oldCabinet.setAddresse(cabinet.getAddresse());
      oldCabinet.setVille(cabinet.getVille());
      oldCabinet.setTelephone(cabinet.getTelephone());

      cabinetRepository.save(oldCabinet);
      return true;
    }

    return false;
  }
  
}
