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
@RequestMapping("/cabinet")
public class CabinetController {

  @Autowired
  CabinetService cabinetService;

  @GetMapping("/{id}")
  public ResponseEntity<Cabinet> findCabinetById(@PathVariable Long id) {
    final Cabinet cabinet = cabinetService.findCabinetById(id);

    if (cabinet == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    return new ResponseEntity<Cabinet>(cabinet, HttpStatus.OK);
  }

  @GetMapping
  public ResponseEntity<List<Cabinet>> findAllCabinets() {
    final List<Cabinet> cabinets = cabinetService.findAllCabinets();

    return new ResponseEntity<List<Cabinet>>(cabinets, HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<String> saveCabinet(@RequestBody Cabinet cabinet) {
    cabinetService.saveCabinet(cabinet);

    return new ResponseEntity<String>("Cabinet saved sucessfully", HttpStatus.CREATED);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteCabinet(@PathVariable Long id) {
    final boolean isCabinetDeleted = cabinetService.deleteCabinet(id);

    if (!isCabinetDeleted) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    return new ResponseEntity<String>("Cabinet deleted successfully", HttpStatus.OK);
  }

  @PutMapping("/{id}")
  public ResponseEntity<String> updateCabinet(@PathVariable Long id, @RequestBody Cabinet cabinet) {
    final boolean isCabinetUpdated = cabinetService.updateCabinet(id, cabinet);

    if (!isCabinetUpdated) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    return new ResponseEntity<String>("Cabinet updated successfully", HttpStatus.OK);

  }

}
