package ma.supmti.api_cabinet_dermatologue.Prescription.models;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.supmti.api_cabinet_dermatologue.Cabinet.models.Cabinet;
import ma.supmti.api_cabinet_dermatologue.DossierMedical.models.DossierMedical;

@Entity
@Table(name = "prescriptions")
@NoArgsConstructor
@Data
public class Prescription {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String description;

  @CreationTimestamp
  private LocalDateTime createdAt;

  @ManyToOne
  @JoinColumn(name = "dossier_id", nullable = false, updatable = false)
  private DossierMedical dossierMedical;

  @ManyToOne
  @JoinColumn(name = "cabinet_id", nullable = false, updatable = false)
  private Cabinet cabinet;
}
