package ma.supmti.api_cabinet_dermatologue.Cabinet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.supmti.api_cabinet_dermatologue.Cabinet.models.Cabinet;

public interface CabinetRepository extends JpaRepository<Cabinet, Long> {
}
