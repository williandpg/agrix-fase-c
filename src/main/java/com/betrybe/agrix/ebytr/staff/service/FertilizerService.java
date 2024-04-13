package com.betrybe.agrix.ebytr.staff.service;

import com.betrybe.agrix.ebytr.staff.controller.dto.FertilizerDto;
import com.betrybe.agrix.ebytr.staff.entity.Fertilizer;
import com.betrybe.agrix.ebytr.staff.repository.FertilizerRepository;
import com.betrybe.agrix.ebytr.staff.service.exception.FertilizerNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Classe Fertilizer Service.
 *
 */
@Service
public class FertilizerService {

  private final FertilizerRepository fertilizerRepository;

  @Autowired
  public FertilizerService(FertilizerRepository fertilizerRepository) {
    this.fertilizerRepository = fertilizerRepository;
  }

  /**
   * Fertilizer DTO.
   *
   * @param fertilizerDto fertilizer
   * @return return
   */
  public FertilizerDto create(FertilizerDto fertilizerDto) {
    Fertilizer fertilizer = fertilizerDto.toEntity();
    fertilizerRepository.save(fertilizer);
    return FertilizerDto.fromEntity(fertilizer);
  }

  public List<Fertilizer> getAll() {
    return fertilizerRepository.findAll();
  }

  public Fertilizer findById(Long id) throws FertilizerNotFoundException {
    return fertilizerRepository.findById(id).orElseThrow(FertilizerNotFoundException::new);
  }

}