package com.betrybe.agrix.ebytr.staff.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Classe Token Service.
 *
 */
@Service
public class TokenService {

  private final Algorithm algorithm;

  /**
   * Token Service.
   *
   * @param secret secret
   */
  public TokenService(@Value("${api.security.token.secret}") String secret) {
    this.algorithm = Algorithm.HMAC256(secret);
  }

  /**
   * Generate Token.
   *
   * @param username username
   * @return return
   */
  public String generateToken(String username) {
    return JWT.create().withSubject(username).withExpiresAt(expiration()).sign(algorithm);
  }

  private Instant expiration() {
    return Instant.now().plus(120, ChronoUnit.MINUTES);
  }

  /**
   * Validate Token.
   *
   * @param token token
   * @return return
   */
  public String validateToken(String token) {
    return JWT.require(algorithm).build().verify(token).getSubject();
  }

}