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
@RequestMapping("/api/v1/patient")
public class PatientController {

  @Autowired
  private PatientService patientService;

  /**
   * Retrieves a patient by their ID.
   *
   * @param id the ID of the patient to find
   * @return a ResponseEntity containing the patient with the given ID, or a
   *         ResponseEntity with a NOT_FOUND status if not found
   */
  @GetMapping("/{id}")
  public ResponseEntity<Patient> findPatientById(@PathVariable Long id) {
    final Patient patient = patientService.findPatientById(id);

    if (patient == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    return new ResponseEntity<Patient>(patient, HttpStatus.OK);
  }

  /**
   * Retrieves a list of all patients from the patient service and returns it as a
   * ResponseEntity.
   *
   * @return a ResponseEntity containing a list of Patient objects representing
   *         all patients, or a ResponseEntity with a NOT_FOUND status if no
   *         patients are found
   */
  @GetMapping
  public ResponseEntity<List<Patient>> findAllPatient() {
    final List<Patient> patients = patientService.findAllPatients();

    return new ResponseEntity<List<Patient>>(patients, HttpStatus.OK);
  }

  /**
   * Saves a patient by calling the patient service to save the patient and returns a ResponseEntity
   * with a success message and HTTP status code 201 (CREATED).
   *
   * @param  patient  the patient object to be saved
   * @return          a ResponseEntity with a success message and HTTP status code 201 (CREATED)
   */
  @PostMapping
  public ResponseEntity<String> savePatient(@RequestBody Patient patient) {
    patientService.savePatient(patient);
    return new ResponseEntity<>("Patient saved successfully", HttpStatus.CREATED);
  }

  /**
   * Deletes a patient with the given ID.
   *
   * @param  id  the ID of the patient to delete
   * @return     a ResponseEntity with a success message and HTTP status code 200 (OK) if the patient is deleted,
   *             or a ResponseEntity with a NOT_FOUND status if the patient is not found
   */
  @DeleteMapping("/{id}")
  public ResponseEntity<String> deletePatient(@PathVariable Long id) {
    final boolean isPatientDeleted = patientService.deletePatient(id);

    if (!isPatientDeleted) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    return new ResponseEntity<String>("Patient deleted successfully", HttpStatus.OK);
  }

  /**
   * Updates a patient with the given ID using the provided patient object.
   *
   * @param  id      the ID of the patient to update
   * @param  patient the updated patient object
   * @return         a ResponseEntity with a success message and HTTP status code 200 (OK) if the patient is updated,
   *                 or a ResponseEntity with a NOT_FOUND status if the patient is not found
   */
  @PutMapping("/{id}")
  public ResponseEntity<String> updatePatient(@PathVariable Long id, @RequestBody Patient patient) {
    final boolean isPatientUpdated = patientService.updatePatient(id, patient);

    if (!isPatientUpdated) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    return new ResponseEntity<String>("Patient updated successfully", HttpStatus.OK);

  }

}
