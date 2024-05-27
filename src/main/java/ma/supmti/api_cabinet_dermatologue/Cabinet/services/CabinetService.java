package ma.supmti.api_cabinet_dermatologue.Cabinet.services;

import java.util.List;

import ma.supmti.api_cabinet_dermatologue.Cabinet.models.Cabinet;

public interface CabinetService {

  Cabinet findCabinetById(Long id);

  List<Cabinet> findAllCabinets();

  void saveCabinet(Cabinet cabinet);

  boolean deleteCabinet(Long id);

  boolean updateCabinet(Long id, Cabinet cabinet);

}
