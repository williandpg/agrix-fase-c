package com.betrybe.agrix.ebytr.staff.advice;

import com.betrybe.agrix.ebytr.staff.exception.PersonNotFoundException;
import com.betrybe.agrix.ebytr.staff.service.exception.CropNotFoundException;
import com.betrybe.agrix.ebytr.staff.service.exception.FarmNotFoundException;
import com.betrybe.agrix.ebytr.staff.service.exception.FertilizerNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Classe Global Controller Advice.
 *
 */
@ControllerAdvice
public class GlobalControllerAdvice {
  @ExceptionHandler(FarmNotFoundException.class)
  public ResponseEntity<String> handleNotFound(FarmNotFoundException exception) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND)
        .body("Fazenda não encontrada!");
  }

  @ExceptionHandler(CropNotFoundException.class)
  public ResponseEntity<String> handleNotFound(CropNotFoundException exception) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND)
        .body("Plantação não encontrada!");
  }

  @ExceptionHandler(FertilizerNotFoundException.class)
  public ResponseEntity<String> handleNotFound(FertilizerNotFoundException exception) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND)
        .body("Fertilizante não encontrado!");
  }

  @ExceptionHandler(PersonNotFoundException.class)
  public ResponseEntity<String> handleNotFound(PersonNotFoundException exception) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND)
        .body("Pessoa não encontrada!");
  }

}