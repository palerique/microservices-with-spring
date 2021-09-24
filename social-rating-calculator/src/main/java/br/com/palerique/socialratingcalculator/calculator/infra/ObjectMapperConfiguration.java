package br.com.palerique.socialratingcalculator.calculator.infra;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Produces the Jackson Object Mapper.
 */
@Configuration
public class ObjectMapperConfiguration {

  @Bean
  public ObjectMapper getObjectMapper() {
    return new ObjectMapper();
  }
}
