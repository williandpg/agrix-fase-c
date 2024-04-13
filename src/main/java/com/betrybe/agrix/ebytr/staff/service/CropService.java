package com.betrybe.agrix.ebytr.staff.service;

import com.betrybe.agrix.ebytr.staff.entity.Crop;
import com.betrybe.agrix.ebytr.staff.entity.Farm;
import com.betrybe.agrix.ebytr.staff.entity.Fertilizer;
import com.betrybe.agrix.ebytr.staff.repository.CropRepository;
import com.betrybe.agrix.ebytr.staff.service.exception.CropNotFoundException;
import com.betrybe.agrix.ebytr.staff.service.exception.FarmNotFoundException;
import com.betrybe.agrix.ebytr.staff.service.exception.FertilizerNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Classe Crop Service.
 *
 */
@Service
public class CropService {

  private final CropRepository cropRepository;
  private final FarmService farmService;
  private final FertilizerService fertilizerService;

  /**
   * Crop Service.
   *
   * @param cropRepository cropRepository
   * @param farmService farmService
   * @param fertilizerService fertilizerService
   */
  @Autowired
  public CropService(
      CropRepository cropRepository,
      FarmService farmService,
      FertilizerService fertilizerService
  ) {
    this.cropRepository = cropRepository;
    this.farmService = farmService;
    this.fertilizerService = fertilizerService;
  }

  /**
   * Create Crop.
   *
   * @param crop crop
   * @param farmId farmId
   * @return return
   * @throws FarmNotFoundException FarmNotFoundException
   */
  public Crop create(Crop crop, Long farmId) throws FarmNotFoundException {
    Farm farm = farmService.findById(farmId);
    crop.setFarm(farm);
    return cropRepository.save(crop);
  }

  public List<Crop> findAll() {
    return cropRepository.findAll();
  }

  /**
   * Crop by farmId.
   *
   * @param farmId farmId
   * @return return
   * @throws FarmNotFoundException FarmNotFoundException
   */
  public List<Crop> findCropByFarmId(Long farmId) throws FarmNotFoundException {
    Farm farm = farmService.findById(farmId);
    return farm.getCrops();
  }

  public Crop findById(Long id) throws CropNotFoundException {
    return cropRepository.findById(id).orElseThrow(CropNotFoundException::new);
  }

  /**
   * Crop and Fertilizer Associate.
   *
   * @param cropId cropId
   * @param fertilizerId fertilizerId
   * @throws CropNotFoundException CropNotFoundException
   * @throws FertilizerNotFoundException FertilizerNotFoundException
   */
  public void cropAndFertilizer(
      Long cropId, Long fertilizerId
  ) throws CropNotFoundException, FertilizerNotFoundException {
    Crop crop = findById(cropId);
    crop.getFertilizers().add(fertilizerService.findById(fertilizerId));
    cropRepository.save(crop);
  }

  public List<Fertilizer> fertilizersByCropId(Long cropId) throws CropNotFoundException {
    Crop crop = findById(cropId);
    return crop.getFertilizers();
  }

}