package ma.supmti.api_cabinet_dermatologue.DossierMedical.models;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.CurrentTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.supmti.api_cabinet_dermatologue.Patient.models.Patient;
import ma.supmti.api_cabinet_dermatologue.Prescription.models.Prescription;

@Entity
@Table(name = "dossier-medical")
@NoArgsConstructor
@Data
public class DossierMedical {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String alergies;
  private String chronicIllnesses;

  @CurrentTimestamp
  private LocalDate createdAt;

  @OneToOne
  @JoinColumn(name = "patient_id", nullable = false, updatable = false)
  @JsonIgnoreProperties({ "dossierMedical" })
  private Patient patient;

  @OneToMany(mappedBy = "dossierMedical", cascade = CascadeType.ALL)
  @JsonIgnoreProperties({ "cabinet", "dossierMedical" })
  private List<Prescription> prescriptions;
}
