package com.betrybe.agrix.ebytr.staff.controller.dto;

import com.betrybe.agrix.ebytr.staff.entity.Crop;
import java.time.LocalDate;

/**
 * Record Crop DTO.
 *
 * @param id id
 * @param name name
 * @param plantedArea plantedArea
 * @param farmId farmId
 */
public record CropDto(Long id, String name, Double plantedArea,
                      Long farmId, LocalDate plantedDate, LocalDate harvestDate) {

  /**
   * Crop DTO.
   *
   * @param crop crop
   * @param farmId farmId
   * @return return
   */
  public static CropDto fromEntity(Crop crop, Long farmId) {
    return new CropDto(
        crop.getId(),
        crop.getName(),
        crop.getPlantedArea(),
        farmId,
        crop.getPlantedDate(),
        crop.getHarvestDate()
    );
  }

}