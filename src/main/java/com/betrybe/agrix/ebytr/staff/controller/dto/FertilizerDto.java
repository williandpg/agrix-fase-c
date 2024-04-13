package com.betrybe.agrix.ebytr.staff.controller.dto;

import com.betrybe.agrix.ebytr.staff.entity.Fertilizer;

/**
 * Record Fertilizer Creation DTO.
 *
 * @param id id
 * @param name name
 * @param brand brand
 * @param composition composition
 */
public record FertilizerDto(Long id, String name, String brand, String composition) {

  /**
   * Fertilizer DTO.
   *
   * @param fertilizer fertilizer
   * @return return
   */
  public static FertilizerDto fromEntity(Fertilizer fertilizer) {
    return new FertilizerDto(
        fertilizer.getId(),
        fertilizer.getName(),
        fertilizer.getBrand(),
        fertilizer.getComposition()
    );
  }

  public Fertilizer toEntity() {
    return new Fertilizer(name, brand, composition);
  }

}