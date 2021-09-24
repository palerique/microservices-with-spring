package br.com.palerique.socialratingcalculator.calculator.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * Sends messages to Kafka broker.
 */
@Log4j2
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MessageConsumer {

  private static final String TOPIC = "people";

  private final ObjectMapper objectMapper;
  private final PeopleRepository peopleRepository;
  private final SocialRatingScoreService socialRatingScoreService;

  /**
   * Consume messages from Kafka topic.
   *
   * @param message received from Kafka.
   * @throws JsonProcessingException if not possible to convert the message to an object.
   */
  @KafkaListener(topics = TOPIC, groupId = "br.com.palerique")
  public void consume(String message) throws JsonProcessingException {
    log.debug("Consumed message -> {}", message);
    PersonDto person = objectMapper.readValue(message, PersonDto.class);
    Integer socialRatingScore = socialRatingScoreService.getSocialRatingScore(person);

    log.info(String.format("%s %s has %d score",
        person.getFirstName(),
        person.getLastName(),
        socialRatingScore));

    peopleRepository.save(Person.builder()
        .id(UUID.randomUUID())
        .age(person.getAge())
        .firstName(person.getFirstName())
        .lastName(person.getLastName())
        .socialRatingScore(socialRatingScore)
        .build());
  }
}
