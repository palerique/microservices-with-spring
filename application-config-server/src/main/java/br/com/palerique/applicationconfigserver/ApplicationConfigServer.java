package br.com.palerique.applicationconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Application Config Server main class.
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableConfigServer
public class ApplicationConfigServer {

  public static void main(String[] args) {
    SpringApplication.run(ApplicationConfigServer.class, args);
  }
}
