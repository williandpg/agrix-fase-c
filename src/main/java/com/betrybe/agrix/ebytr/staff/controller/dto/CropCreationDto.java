package com.betrybe.agrix.ebytr.staff.controller.dto;

import com.betrybe.agrix.ebytr.staff.entity.Crop;
import java.time.LocalDate;

/**
 * Record Crop Creation DTO.
 *
 * @param name name
 * @param plantedArea plantedArea
 */
public record CropCreationDto(String name, Double plantedArea,
                              LocalDate plantedDate, LocalDate harvestDate) {

  /**
   * Crop to entity.
   *
   * @return return
   */
  public Crop toEntity() {
    Crop crop = new Crop();
    crop.setName(name);
    crop.setPlantedArea(plantedArea);
    crop.setPlantedDate(plantedDate);
    crop.setHarvestDate(harvestDate);
    return crop;
  }

  /**
   * Crop from entity.
   *
   * @param crop crop
   * @return return
   */
  public static CropDto fromEntity(Crop crop) {
    return new CropDto(
        crop.getId(),
        crop.getName(),
        crop.getPlantedArea(),
        crop.getFarm().getId(),
        crop.getPlantedDate(),
        crop.getHarvestDate()
    );
  }

}