package ma.supmti.api_cabinet_dermatologue.Cabinet;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;
import lombok.NoArgsConstructor;

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
}
