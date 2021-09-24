package br.com.palerique.socialratingcollector.collector.domain;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * Sends messages to Kafka broker.
 */
@Log4j2
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MessageProducer {

  public static final String TOPIC = "people";

  private final KafkaTemplate<String, String> kafkaTemplate;

  public void sendMessage(String message) {
    log.debug("Producing message -> {}", message);
    this.kafkaTemplate.send(TOPIC, message);
  }
}
