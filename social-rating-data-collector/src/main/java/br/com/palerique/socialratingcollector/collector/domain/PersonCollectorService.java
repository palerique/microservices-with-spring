package br.com.palerique.socialratingcollector.collector.domain;

import br.com.palerique.socialratingcollector.collector.infra.AppProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

/**
 * Service responsible for getting the base seed value, preparing person to be scheduled and
 * scheduling it.
 */
@Service
@Log4j2
@RequiredArgsConstructor
@SuppressFBWarnings("EI_EXPOSE_REP2")
public class PersonCollectorService {

  private final MessageProducer messageProducer;
  private final ObjectMapper objectMapper;
  private final AppProperties appProperties;

  /**
   * Fill person with base seed and schedule it to be calculated.
   *
   * @param person we want to schedule.
   * @return the scheduled person with filled seed.
   * @throws JsonProcessingException if not possible to convert to JSON.
   */
  public PersonDto schedule(PersonDto person) throws JsonProcessingException {
    final var result = person.toBuilder().seed(appProperties.getBaseSeed()).build();
    log.debug("Scheduling person {}", result);
    messageProducer.sendMessage(objectMapper.writeValueAsString(result));
    return result;
  }
}
