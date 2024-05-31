package ma.supmti.api_cabinet_dermatologue.Patient.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.supmti.api_cabinet_dermatologue.DossierMedical.models.DossierMedical;

@Entity
@Table(name = "patients")
@NoArgsConstructor
@Data
public class Patient {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String nom;

  @Column(nullable = false)
  private String prenom;

  @Column(nullable = false)
  private String dateDeNaissance;

  @Column(nullable = false)
  private String telephone;

  @OneToOne(mappedBy = "patient", cascade = CascadeType.ALL)
  @JsonIgnoreProperties({ "patient" })
  private DossierMedical dossierMedical;

  // @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
  // @JsonIgnoreProperties({ "patient" })
  // private List<RDV> rdvs;

}
