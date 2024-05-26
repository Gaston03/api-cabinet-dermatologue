package ma.supmti.api_cabinet_dermatologue.Patient;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

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

}
