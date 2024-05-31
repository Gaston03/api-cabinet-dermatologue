package ma.supmti.api_cabinet_dermatologue.DossierMedical.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.supmti.api_cabinet_dermatologue.DossierMedical.models.DossierMedical;
import ma.supmti.api_cabinet_dermatologue.DossierMedical.repositories.DossierMedicalRepository;

@Service
public class DossierMedicalServiceImplementation implements DossierMedicalService {
  
  @Autowired
  private DossierMedicalRepository repository;

  @Override
  public void createDossierMedical(DossierMedical dossier) {
    repository.save(dossier);
  }

  @Override
  public DossierMedical findDossierMedicalById(Long id) {
    return repository.findById(id).orElse(null);
  }
}
