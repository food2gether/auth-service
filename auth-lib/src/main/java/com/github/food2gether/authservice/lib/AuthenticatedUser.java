package com.github.food2gether.authservice.lib;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class AuthenticatedUser {

  @Id
  private Long id;

}
