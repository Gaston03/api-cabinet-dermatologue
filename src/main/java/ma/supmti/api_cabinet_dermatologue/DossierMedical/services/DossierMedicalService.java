package ma.supmti.api_cabinet_dermatologue.DossierMedical.services;

import ma.supmti.api_cabinet_dermatologue.DossierMedical.models.DossierMedical;

public interface DossierMedicalService {

  void createDossierMedical(DossierMedical dossier);

  DossierMedical findDossierMedicalById(Long id);
}
