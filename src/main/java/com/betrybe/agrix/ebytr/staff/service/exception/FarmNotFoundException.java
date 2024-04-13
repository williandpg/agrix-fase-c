package com.betrybe.agrix.ebytr.staff.service.exception;

/**
 * Classe Not Found Exception.
 *
 */
public class FarmNotFoundException extends Exception {
  public FarmNotFoundException() {
    super("Fazenda não encontrada!");
  }

}