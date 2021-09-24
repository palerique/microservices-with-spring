package br.com.palerique.socialratingcalculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;

/**
 * Main application class.
 */
@SpringBootApplication
@Configuration
@EnableDiscoveryClient
public class SocialRatingCalculatorApplication {

  public static void main(String[] args) {
    SpringApplication.run(SocialRatingCalculatorApplication.class, args);
  }
}
