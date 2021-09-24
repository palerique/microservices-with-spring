package br.com.palerique.socialratingcollector.collector.infra;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * Holds application settings.
 */
@Configuration
@Data
public class AppProperties {

  /**
   * social-rating-calculator.base-seed: 1
   */
  @Value("${social-rating-calculator.base-seed}")
  private Integer baseSeed;
}
