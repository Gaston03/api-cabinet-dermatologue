package ma.supmti.api_cabinet_dermatologue.RDV.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.supmti.api_cabinet_dermatologue.RDV.models.RDV;
import ma.supmti.api_cabinet_dermatologue.RDV.services.RDVService;

@RestController
@RequestMapping("/rdv")
public class RDVController {

  @Autowired
  private RDVService rdvService;

  @GetMapping("/{id}")
  public ResponseEntity<RDV> findRdvById(@PathVariable Long id) {
    final RDV rdv = rdvService.findRdvById(id);

    if (rdv == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    return new ResponseEntity<RDV>(rdv, HttpStatus.OK);
  }

  @GetMapping("/patient/{id}")
  public ResponseEntity<List<RDV>> findRdvsByPatientId(@PathVariable Long id) {
    final List<RDV> rdvs = rdvService.findRdvsByPatientId(id);

    return new ResponseEntity<List<RDV>>(rdvs, HttpStatus.OK);
  }

  @GetMapping("/cabinet/{id}")
  public ResponseEntity<List<RDV>> findRdvsByCabinetId(@PathVariable Long id) {
    final List<RDV> rdvs = rdvService.findRdvsByCabinetId(id);
  
    return new ResponseEntity<List<RDV>>(rdvs, HttpStatus.OK);
  }

  @GetMapping
  public ResponseEntity<List<RDV>> findAllRdvs() {
    final List<RDV> rdvs = rdvService.findAllRdvs();
  
    return new ResponseEntity<List<RDV>>(rdvs, HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<String> saveRdv(@RequestBody RDV rdv) {
    rdvService.saveRdv(rdv);
  
    return new ResponseEntity<String>("Rdv saved sucessfully", HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<String> updateRdv(@PathVariable Long id, @RequestBody RDV rdv) {
    final boolean isRdvUpdated = rdvService.updateRdv(id, rdv);
  
    if (isRdvUpdated) {
      return new ResponseEntity<String>("Rdv updated successfully", HttpStatus.OK);
    }
  
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteRdv(@PathVariable Long id) {
    final boolean isRdvDeleted = rdvService.deleteRdv(id);
  
    if (isRdvDeleted) {
      return new ResponseEntity<String>("Rdv deleted successfully", HttpStatus.OK);
    }
  
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }
  
}
