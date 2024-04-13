package com.betrybe.agrix.ebytr.staff.controller;

import com.betrybe.agrix.ebytr.staff.controller.dto.CropCreationDto;
import com.betrybe.agrix.ebytr.staff.controller.dto.CropDto;
import com.betrybe.agrix.ebytr.staff.controller.dto.FarmCreationDto;
import com.betrybe.agrix.ebytr.staff.controller.dto.FarmDto;
import com.betrybe.agrix.ebytr.staff.entity.Crop;
import com.betrybe.agrix.ebytr.staff.entity.Farm;
import com.betrybe.agrix.ebytr.staff.service.CropService;
import com.betrybe.agrix.ebytr.staff.service.FarmService;
import com.betrybe.agrix.ebytr.staff.service.exception.FarmNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Classe Farm Controller.
 *
 */
@RestController
@RequestMapping(value = "/farms")
public class FarmController {
  private final FarmService farmService;
  private final CropService cropService;

  @Autowired
  public FarmController(FarmService farmService, CropService cropService) {
    this.farmService = farmService;
    this.cropService = cropService;
  }

  /**
   * Farm DTO.
   *
   * @param farmCreationDto farmCreationDto
   * @return return
   */
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public FarmDto createFarm(@RequestBody FarmCreationDto farmCreationDto) {
    return FarmDto.fromEntity(
        farmService.create(farmCreationDto.toEntity())
    );
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<FarmDto> findAll() {
    List<Farm> listFarms = farmService.findAll();
    return listFarms.stream().map(FarmDto::fromEntity).toList();
  }

  @GetMapping("/{id}")
  public FarmDto getFarmById(@PathVariable("id") Long id) throws FarmNotFoundException {
    return FarmDto.fromEntity(farmService.findById(id));
  }

  @PostMapping("/{farmId}/crops")
  @ResponseStatus(HttpStatus.CREATED)
  public CropDto createCrop(@PathVariable("farmId") Long farmId,
      @RequestBody CropCreationDto cropCreationDto) throws FarmNotFoundException {
    Crop crop = cropService.create(cropCreationDto.toEntity(), farmId);
    return CropDto.fromEntity(crop, farmId);
  }

  @GetMapping("/{farmId}/crops")
  public List<CropDto> findCropByFarmId(@PathVariable("farmId")
  Long farmId) throws FarmNotFoundException {
    return cropService.findCropByFarmId(farmId)
        .stream().map(crop -> CropDto.fromEntity(crop, farmId)).toList();
  }

}