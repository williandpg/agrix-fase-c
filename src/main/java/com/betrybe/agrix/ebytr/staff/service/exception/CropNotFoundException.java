package com.betrybe.agrix.ebytr.staff.service.exception;

/**
 * Classe Not Found Exception.
 *
 */
public class CropNotFoundException extends Exception {

  public CropNotFoundException() {
    super("Plantação não encontrada!");
  }

}