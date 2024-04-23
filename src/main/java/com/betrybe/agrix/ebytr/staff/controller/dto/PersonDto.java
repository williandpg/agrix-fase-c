package com.betrybe.agrix.ebytr.staff.controller.dto;

import com.betrybe.agrix.ebytr.staff.entity.Person;

/**
 * Record Person DTO.
 *
 * @param id id
 * @param username username
 * @param role role
 */
public record PersonDto(Long id, String username, String role) {

  /**
   * Person DTO.
   *
   * @param person person
   * @return return
   */
  public static PersonDto fromEntity(Person person) {
    return new PersonDto(
        person.getId(),
        person.getUsername(),
        person.getRole().name()
    );
  }

}
