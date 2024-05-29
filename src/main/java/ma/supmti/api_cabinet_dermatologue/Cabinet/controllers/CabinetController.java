package ma.supmti.api_cabinet_dermatologue.Cabinet.controllers;

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

import ma.supmti.api_cabinet_dermatologue.Cabinet.models.Cabinet;
import ma.supmti.api_cabinet_dermatologue.Cabinet.services.CabinetService;

@RestController
@RequestMapping("/api/v1/cabinet")
public class CabinetController {

  @Autowired
  CabinetService cabinetService;

  /**
   * Retrieves a cabinet by its ID.
   *
   * @param  id  the ID of the cabinet to retrieve
   * @return     a ResponseEntity containing the cabinet if found, or a 404 NOT_FOUND status if not found
   */
  @GetMapping("/{id}")
  public ResponseEntity<Cabinet> findCabinetById(@PathVariable Long id) {
    final Cabinet cabinet = cabinetService.findCabinetById(id);

    if (cabinet == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    return new ResponseEntity<Cabinet>(cabinet, HttpStatus.OK);
  }

  /**
   * Retrieves all cabinets from the cabinet service and returns them as a ResponseEntity
   * with a list of Cabinet objects and an HTTP status of OK.
   *
   * @return          a ResponseEntity containing a list of Cabinet objects and an HTTP status of OK
   */
  @GetMapping
  public ResponseEntity<List<Cabinet>> findAllCabinets() {
    final List<Cabinet> cabinets = cabinetService.findAllCabinets();

    return new ResponseEntity<List<Cabinet>>(cabinets, HttpStatus.OK);
  }

  /**
   * Saves a cabinet to the database.
   *
   * @param  cabinet  the cabinet object to be saved
   * @return          a ResponseEntity containing a string message and an HTTP status of CREATED
   */
  @PostMapping
  public ResponseEntity<String> saveCabinet(@RequestBody Cabinet cabinet) {
    cabinetService.saveCabinet(cabinet);

    return new ResponseEntity<String>("Cabinet saved sucessfully", HttpStatus.CREATED);
  }

  /**
   * Deletes a cabinet with the given ID.
   *
   * @param  id  the ID of the cabinet to delete
   * @return     a ResponseEntity containing a string message and an HTTP status code. If the cabinet is deleted successfully,
   *             the message is "Cabinet deleted successfully" and the HTTP status code is OK (200). If the cabinet is not found,
   *             the HTTP status code is NOT_FOUND (404).
   */
  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteCabinet(@PathVariable Long id) {
    final boolean isCabinetDeleted = cabinetService.deleteCabinet(id);

    if (!isCabinetDeleted) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    return new ResponseEntity<String>("Cabinet deleted successfully", HttpStatus.OK);
  }

  /**
   * Updates a cabinet with the given ID.
   *
   * @param  id        the ID of the cabinet to update
   * @param  cabinet   the updated cabinet object
   * @return           a ResponseEntity containing a string message and an HTTP status code. If the cabinet is updated successfully,
   *                   the message is "Cabinet updated successfully" and the HTTP status code is OK (200). If the cabinet is not found,
   *                   the HTTP status code is NOT_FOUND (404).
   */
  @PutMapping("/{id}")
  public ResponseEntity<String> updateCabinet(@PathVariable Long id, @RequestBody Cabinet cabinet) {
    final boolean isCabinetUpdated = cabinetService.updateCabinet(id, cabinet);

    if (!isCabinetUpdated) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    return new ResponseEntity<String>("Cabinet updated successfully", HttpStatus.OK);

  }

}
