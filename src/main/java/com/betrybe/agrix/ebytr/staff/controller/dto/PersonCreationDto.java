package com.betrybe.agrix.ebytr.staff.controller.dto;

import com.betrybe.agrix.ebytr.staff.entity.Person;

/**
 *  Record Person Creation DTO.
 *
 * @param id id
 * @param username username
 * @param role role
 */
public record PersonCreationDto(Long id, String username, String role) {

  public Person toEntity() {
    return new Person(id, username, role);
  }

}
