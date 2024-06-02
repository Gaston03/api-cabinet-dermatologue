package ma.supmti.api_cabinet_dermatologue.RDV.models;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.supmti.api_cabinet_dermatologue.Cabinet.models.Cabinet;
import ma.supmti.api_cabinet_dermatologue.Patient.models.Patient;

@Entity
@Table(name = "rendez-vous")
@NoArgsConstructor
@Data
public class RDV {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String motif;

  @Column(nullable = false)
  private LocalDate date;

  @Enumerated(EnumType.STRING)
  private RDVStatus status = RDVStatus.PENDING;

  @ManyToOne
  @JoinColumn(name = "patient_id", nullable = false, updatable = false)
  private Patient patient;

  @ManyToOne
  @JoinColumn(name = "cabinet_id", nullable = false, updatable = false)
  @JsonIgnoreProperties({ "prescriptions" })
  private Cabinet cabinet;

}

enum RDVStatus {
  PENDING,
  ACCEPTED,
  COMPLETED,
  CANCELED
}