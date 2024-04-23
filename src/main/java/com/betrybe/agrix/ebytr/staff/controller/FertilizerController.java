package com.betrybe.agrix.ebytr.staff.controller;

import com.betrybe.agrix.ebytr.staff.controller.dto.FertilizerDto;
import com.betrybe.agrix.ebytr.staff.entity.Fertilizer;
import com.betrybe.agrix.ebytr.staff.service.FertilizerService;
import com.betrybe.agrix.ebytr.staff.service.exception.FertilizerNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Classe Fertilizer Controller.
 *
 */
@RestController
@RequestMapping(value = "/fertilizers")
public class FertilizerController {

  private final FertilizerService fertilizerService;

  @Autowired
  public FertilizerController(FertilizerService fertilizerService) {
    this.fertilizerService = fertilizerService;
  }

  /**
   * Post Mapping Fertilizer.
   *
   * @param fertilizerDto fertilizerDto
   * @return return
   */
  @PostMapping()
  public ResponseEntity<FertilizerDto> newFertilizer(@RequestBody FertilizerDto fertilizerDto) {
    FertilizerDto fertilizer = fertilizerService.create(fertilizerDto);
    return ResponseEntity.status(HttpStatus.CREATED).body(fertilizer);
  }

  /**
   * Get Mapping Fertilizer.
   *
   * @return return
   */
  @GetMapping()
  @PreAuthorize("hasAuthority('ROLE_ADMIN')")
  public ResponseEntity<List<FertilizerDto>> getAll(@AuthenticationPrincipal Fertilizer fertilizer) {
    List<Fertilizer> fertilizers = fertilizerService.getAll();
    List<FertilizerDto> listFertilizer = fertilizers.stream()
        .map(FertilizerDto::fromEntity).toList();
    return ResponseEntity.status(HttpStatus.OK).body(listFertilizer);
  }

  @GetMapping("/{id}")
  public ResponseEntity<FertilizerDto> findById(@PathVariable("id") Long id)
      throws FertilizerNotFoundException {
    Fertilizer fertilizer = fertilizerService.findById(id);
    return ResponseEntity.ok(FertilizerDto.fromEntity(fertilizer));
  }

}