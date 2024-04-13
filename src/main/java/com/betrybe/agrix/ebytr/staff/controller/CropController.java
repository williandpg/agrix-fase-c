package com.betrybe.agrix.ebytr.staff.controller;

import com.betrybe.agrix.ebytr.staff.controller.dto.CropCreationDto;
import com.betrybe.agrix.ebytr.staff.controller.dto.CropDto;
import com.betrybe.agrix.ebytr.staff.controller.dto.FertilizerDto;
import com.betrybe.agrix.ebytr.staff.entity.Crop;
import com.betrybe.agrix.ebytr.staff.entity.Fertilizer;
import com.betrybe.agrix.ebytr.staff.service.CropService;
import com.betrybe.agrix.ebytr.staff.service.exception.CropNotFoundException;
import com.betrybe.agrix.ebytr.staff.service.exception.FertilizerNotFoundException;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Classe Crop Controller.
 *
 */
@RestController
@RequestMapping("/crops")
public class CropController {

  private final CropService cropService;

  @Autowired
  public CropController(CropService cropService) {
    this.cropService = cropService;
  }

  /**
   * Find all Crops.
   *
   */
  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<CropDto> findAll() {
    List<Crop> crops = cropService.findAll();
    return crops.stream()
        .map(CropCreationDto::fromEntity)
        .toList();
  }

  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public CropDto findById(@PathVariable("id") Long id) throws CropNotFoundException {
    Crop crop = cropService.findById(id);
    return CropCreationDto.fromEntity(crop);
  }

  /**
   * Search Crops.
   *
   * @param startDate startDate
   * @param endDate endDate
   * @return return
   */
  @GetMapping("/search")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<List<CropDto>> searchCrop(
      @RequestParam(name = "start") LocalDate startDate,
      @RequestParam(name = "end") LocalDate endDate) {
    List<Crop> findCrop = cropService.findAll();
    return ResponseEntity.ok(findCrop.stream().filter(
            crop -> crop.getHarvestDate().isAfter(startDate)
                && crop.getHarvestDate().isBefore(endDate)
        ).map(CropCreationDto::fromEntity).toList()
    );
  }

  @PostMapping("/{cropId}/fertilizers/{fertilizerId}")
  @ResponseStatus(HttpStatus.CREATED)
  public String cropAndFertilizer(
      @PathVariable Long cropId, @PathVariable Long fertilizerId
  ) throws CropNotFoundException, FertilizerNotFoundException {
    cropService.cropAndFertilizer(cropId, fertilizerId);
    return "Fertilizante e plantação associados com sucesso!";
  }

  @GetMapping("/{cropId}/fertilizers")
  @ResponseStatus(HttpStatus.OK)
  public List<FertilizerDto> cropFertilizers(
      @PathVariable Long cropId
  ) throws CropNotFoundException {
    List<Fertilizer> fertilizers = cropService.fertilizersByCropId(cropId);
    return fertilizers.stream().map(FertilizerDto::fromEntity).toList();
  }

}