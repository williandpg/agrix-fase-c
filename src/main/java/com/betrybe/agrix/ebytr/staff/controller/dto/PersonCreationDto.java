package com.betrybe.agrix.ebytr.staff.controller.dto;

import com.betrybe.agrix.ebytr.staff.entity.Person;

/**
 *  Record Person Creation DTO.
 *
 * @param id id
 * @param username username
 * @param password password
 * @param role role
 */
public record PersonCreationDto(Long id, String username, String password, String role) {

  public Person toEntity() {
    return new Person(id, username, password, role);
  }

}
