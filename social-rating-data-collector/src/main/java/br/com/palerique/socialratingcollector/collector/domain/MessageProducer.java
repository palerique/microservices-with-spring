package br.com.palerique.socialratingcollector.collector.domain;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * Sends messages to Kafka broker.
 */
@Log4j2
@Service
@RequiredArgsConstructor
@SuppressFBWarnings("EI_EXPOSE_REP2")
public class MessageProducer {

  public static final String TOPIC = "people";

  private final KafkaTemplate<String, String> kafkaTemplate;

  public void sendMessage(String message) {
    log.debug("Producing message -> {}", message);
    this.kafkaTemplate.send(TOPIC, message);
  }
}
