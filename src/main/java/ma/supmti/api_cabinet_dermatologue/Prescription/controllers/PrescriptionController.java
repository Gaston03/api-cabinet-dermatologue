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
@RequestMapping("/api/v1/prescription")
public class PrescriptionController {

  @Autowired
  private PrescriptionService prescriptionService;

  /**
   * Retrieves a prescription by its ID.
   *
   * @param  id  the ID of the prescription to retrieve
   * @return     the prescription with the given ID, or a 404 response if not found
   */
  @GetMapping("/{id}")
  public ResponseEntity<Prescription> findPrescriptionById(@PathVariable Long id) {
    final Prescription prescription = prescriptionService.findPrescriptionById(id);

    if (prescription == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    return new ResponseEntity<Prescription>(prescription, HttpStatus.OK);
  }

    /**
     * Retrieves all prescriptions from the prescription service and returns them as a response entity.
     *
     * @return          A response entity containing a list of prescriptions and an HTTP status of OK.
     */
  @GetMapping
  public ResponseEntity<List<Prescription>> findAllPrescriptions() {
    final List<Prescription> prescriptions = prescriptionService.findAllPrescriptions();

    return new ResponseEntity<List<Prescription>>(prescriptions, HttpStatus.OK);
  }

  /**
   * Creates a new prescription using the provided data.
   *
   * @param  prescription  the prescription object containing the data for the new prescription
   * @return               a response entity with a success message and the HTTP status code CREATED
   */
  @PostMapping
  public ResponseEntity<String> createPrescription(@RequestBody Prescription prescription) {
    prescriptionService.savePrescription(prescription);

    return new ResponseEntity<String>("Prescription created successfully", HttpStatus.CREATED);
  }

  /**
   * Updates a prescription with the given ID using the provided data.
   *
   * @param  id            the ID of the prescription to update
   * @param  prescription  the updated prescription object
   * @return               a response entity with a success message and the HTTP status code OK if the prescription was updated successfully, or the HTTP status code NOT_FOUND if the prescription was not found
   */
  @PutMapping("/{id}")
  public ResponseEntity<String> updatePrescription(@PathVariable Long id, @RequestBody Prescription prescription) {
    final boolean isPrescriptionUpdated = prescriptionService.updatePrescription(id, prescription);

    if (isPrescriptionUpdated) {
      return new ResponseEntity<String>("Prescription updated successfully", HttpStatus.OK);
    }

    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

  /**
   * Deletes a prescription with the given ID.
   *
   * @param  id  the ID of the prescription to delete
   * @return     a response entity with a success message and the HTTP status code OK if the prescription was deleted successfully, or the HTTP status code NOT_FOUND if the prescription was not found
   */
  @DeleteMapping("/{id}")
  public ResponseEntity<String> deletePrescription(@PathVariable Long id) {
    final boolean isPrescriptionDeleted = prescriptionService.deletePrescription(id);
    if (isPrescriptionDeleted) {
      return new ResponseEntity<String>("Prescription deleted successfully", HttpStatus.OK);
    }

    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }
}