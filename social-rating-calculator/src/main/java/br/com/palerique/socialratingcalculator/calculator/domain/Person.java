package br.com.palerique.socialratingcalculator.calculator.domain;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.ToString;
import lombok.Value;
import org.springframework.data.redis.core.RedisHash;

/**
 * Person domain class.
 */
@RedisHash("People")
@Value
@Builder
@ToString
@AllArgsConstructor
public class Person {

  UUID id;
  String firstName;
  String lastName;
  Integer age;
  Integer socialRatingScore;
}
