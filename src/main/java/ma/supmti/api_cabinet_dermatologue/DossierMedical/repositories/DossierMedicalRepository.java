package ma.supmti.api_cabinet_dermatologue.DossierMedical.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.supmti.api_cabinet_dermatologue.DossierMedical.models.DossierMedical;

public interface DossierMedicalRepository extends JpaRepository<DossierMedical, Long>{
  
}
