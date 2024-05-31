package ma.supmti.api_cabinet_dermatologue.DossierMedical.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.supmti.api_cabinet_dermatologue.DossierMedical.models.DossierMedical;
import ma.supmti.api_cabinet_dermatologue.DossierMedical.services.DossierMedicalService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v1/dossier")
public class DossierMedicalController {
  
  @Autowired
  private DossierMedicalService service;

  @PostMapping
  public ResponseEntity<String> createDossierMedical(@RequestBody DossierMedical dossier) {
      service.createDossierMedical(dossier);

      return new ResponseEntity<String>("Dossier created successfully",  HttpStatus.CREATED);
  }

  @GetMapping("/{id}")
  public ResponseEntity<DossierMedical> getDossierMedical(@PathVariable Long id) {
    final DossierMedical dossier = service.findDossierMedicalById(id);

    if (dossier == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<DossierMedical>(dossier, HttpStatus.OK);
  }
  
}
