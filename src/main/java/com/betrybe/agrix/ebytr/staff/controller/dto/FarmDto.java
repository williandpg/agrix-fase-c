package com.betrybe.agrix.ebytr.staff.controller.dto;

import com.betrybe.agrix.ebytr.staff.entity.Farm;

/**
 * Record Farm DTO.
 *
 * @param id id
 * @param name name
 * @param size size
 */
public record FarmDto(Long id, String name, Double size) {

  /**
   * Farm DTO.
   *
   * @param farm farm
   * @return return
   */
  public static FarmDto fromEntity(Farm farm) {
    return new FarmDto(
        farm.getId(),
        farm.getName(),
        farm.getSize()
    );
  }

}