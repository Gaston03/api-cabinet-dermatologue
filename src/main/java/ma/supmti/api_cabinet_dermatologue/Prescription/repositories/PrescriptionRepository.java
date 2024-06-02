package ma.supmti.api_cabinet_dermatologue.Prescription.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import ma.supmti.api_cabinet_dermatologue.Prescription.models.Prescription;

public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {}
