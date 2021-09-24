package br.com.palerique.socialratingcollector;

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
public class SocialRatingDataCollectorApplication {

  public static void main(String[] args) {
    SpringApplication.run(SocialRatingDataCollectorApplication.class, args);
  }
}
