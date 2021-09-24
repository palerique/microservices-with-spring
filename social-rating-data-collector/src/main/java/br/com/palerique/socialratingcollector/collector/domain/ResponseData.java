package br.com.palerique.socialratingcollector.collector.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.ToString;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

/**
 * Represents the default response for the API.
 */
@Value
@Builder
@ToString
@AllArgsConstructor
@Jacksonized
public class ResponseData<T> {

  String message;
  T data;
}
