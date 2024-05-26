package ma.supmti.api_cabinet_dermatologue.Cabinet.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.supmti.api_cabinet_dermatologue.Cabinet.Cabinet;
import ma.supmti.api_cabinet_dermatologue.Cabinet.repositories.CabinetRepository;

@Service
public class CabinetServiceImplementation implements CabinetService{

  @Autowired
  CabinetRepository cabinetRepository;

  @Override
  public Cabinet findCabinetById(Long id) {
    return cabinetRepository.findById(id).orElse(null);
  }

  @Override
  public List<Cabinet> findAllCabinets() {
    return cabinetRepository.findAll();
  }

  @Override
  public void saveCabinet(Cabinet cabinet) {
    cabinetRepository.save(cabinet);
  }

  @Override
  public boolean deleteCabinet(Long id) {
    if (cabinetRepository.findById(id).isPresent()) {
      cabinetRepository.deleteById(id);
      return true;
    }

    return false;
  }

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
