package ma.supmti.api_cabinet_dermatologue.Patient.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.supmti.api_cabinet_dermatologue.Patient.models.Patient;
import ma.supmti.api_cabinet_dermatologue.Patient.services.PatientService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/patient")
public class PatientController {

  @Autowired
  private PatientService patientService;

  @GetMapping("/{id}")
  public ResponseEntity<Patient> findPatientById(@PathVariable Long id) {
    final Patient patient = patientService.findPatientById(id);

    if (patient == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    return new ResponseEntity<Patient>(patient, HttpStatus.OK);
  }

  @GetMapping
  public ResponseEntity<List<Patient>> findAllPatient() {
    final List<Patient> patients = patientService.findAllPatients();

    return new ResponseEntity<List<Patient>>(patients, HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<String> savePatient(@RequestBody Patient patient) {
    patientService.savePatient(patient);
    return new ResponseEntity<>("Patient saved successfully", HttpStatus.CREATED);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deletePatient(@PathVariable Long id) {
    final boolean isPatientDeleted = patientService.deletePatient(id);

    if (!isPatientDeleted) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    return new ResponseEntity<String>("Patient deleted successfully", HttpStatus.OK);
  }

  @PutMapping("/{id}")
  public ResponseEntity<String> updatePatient(@PathVariable Long id, @RequestBody Patient patient) {
    final boolean isPatientUpdated = patientService.updatePatient(id, patient);

    if (!isPatientUpdated) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    return new ResponseEntity<String>("Patient updated successfully", HttpStatus.OK);

  }

}
