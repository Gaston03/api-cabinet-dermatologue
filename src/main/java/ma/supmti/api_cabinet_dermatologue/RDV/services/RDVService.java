package ma.supmti.api_cabinet_dermatologue.RDV.services;

import java.util.List;

import ma.supmti.api_cabinet_dermatologue.RDV.models.RDV;

public interface RDVService {

  RDV findRdvById(Long id);

  List<RDV> findAllRdvs();

  List<RDV> findRdvsByPatientId(Long patientId);

  List<RDV> findRdvsByCabinetId(Long cabinetId);

  void saveRdv(RDV rdv);

  boolean updateRdv(Long id, RDV rdv);

  boolean deleteRdv(Long id);

}
