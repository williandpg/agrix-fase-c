package com.betrybe.agrix.ebytr.staff.service.exception;

/**
 * Classe Not Found Exception.
 *
 */
public class FertilizerNotFoundException extends Exception {

  public FertilizerNotFoundException() {
    super("Fertilizante não encontrado!");
  }

}