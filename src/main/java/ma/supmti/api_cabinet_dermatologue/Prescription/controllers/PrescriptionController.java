package ma.supmti.api_cabinet_dermatologue.Prescription.controllers;

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

import ma.supmti.api_cabinet_dermatologue.Prescription.models.Prescription;
import ma.supmti.api_cabinet_dermatologue.Prescription.services.PrescriptionService;

@RestController
@RequestMapping("/prescription")
public class PrescriptionController {

  @Autowired
  private PrescriptionService prescriptionService;

  @GetMapping("/{id}")
  public ResponseEntity<Prescription> findPrescriptionById(@PathVariable Long id) {
    final Prescription prescription = prescriptionService.findPrescriptionById(id);

    if (prescription == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    return new ResponseEntity<Prescription>(prescription, HttpStatus.OK);
  }

  @GetMapping
  public ResponseEntity<List<Prescription>> findAllPrescriptions() {
    final List<Prescription> prescriptions = prescriptionService.findAllPrescriptions();

    return new ResponseEntity<List<Prescription>>(prescriptions, HttpStatus.OK);
  }

  @GetMapping("/patient/{id}")
  public ResponseEntity<List<Prescription>> findPrescriptionsByPatientId(@PathVariable Long id) {
    final List<Prescription> prescriptions = prescriptionService.findAllPrescriptionsByPatientId(id);

    return new ResponseEntity<List<Prescription>>(prescriptions, HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<String> createPrescription(@RequestBody Prescription prescription) {
    prescriptionService.savePrescription(prescription);

    return new ResponseEntity<String>("Prescription created successfully", HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<String> updatePrescription(@PathVariable Long id, @RequestBody Prescription prescription) {
    final boolean isPrescriptionUpdated = prescriptionService.updatePrescription(id, prescription);

    if (isPrescriptionUpdated) {
      return new ResponseEntity<String>("Prescription updated successfully", HttpStatus.OK);
    }

    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deletePrescription(@PathVariable Long id) {
    final boolean isPrescriptionDeleted = prescriptionService.deletePrescription(id);
    if (isPrescriptionDeleted) {
      return new ResponseEntity<String>("Prescription deleted successfully", HttpStatus.OK);
    }

    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }
}