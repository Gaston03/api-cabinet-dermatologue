package ma.supmti.api_cabinet_dermatologue.Cabinet.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.supmti.api_cabinet_dermatologue.Prescription.models.Prescription;

@Entity
@Table(name = "cabinets", uniqueConstraints = @UniqueConstraint(columnNames = { "nom", "ville" }))
@Data
@NoArgsConstructor
public class Cabinet {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String nom;

  @Column(nullable = false)
  private String addresse;

  @Column(nullable = false)
  private String ville;

  @Column(nullable = false)
  private String telephone;

  @OneToMany(mappedBy = "cabinet", cascade = CascadeType.ALL)
  @JsonIgnoreProperties({ "patient", "cabinet" })
  private List<Prescription> prescriptions;
}
