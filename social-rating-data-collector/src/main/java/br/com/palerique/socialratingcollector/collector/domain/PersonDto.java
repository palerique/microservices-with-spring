package br.com.palerique.socialratingcollector.collector.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.ToString;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

/**
 * DTO used to represent the object we should receive from clients.
 */
@Value
@Builder(toBuilder = true)
@ToString
@AllArgsConstructor
@Jacksonized
public class PersonDto {

  @JsonProperty("first_name")
  String firstName;

  @JsonProperty("last_name")
  String lastName;

  Integer age;
  Integer seed;
}
