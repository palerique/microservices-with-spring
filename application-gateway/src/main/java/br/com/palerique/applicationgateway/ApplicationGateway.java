package br.com.palerique.applicationgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Application Gateway main class.
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ApplicationGateway {

  public static void main(String[] args) {
    SpringApplication.run(ApplicationGateway.class, args);
  }

}
