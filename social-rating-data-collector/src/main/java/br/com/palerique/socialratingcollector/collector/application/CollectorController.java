package br.com.palerique.socialratingcollector.collector.application;

import br.com.palerique.socialratingcollector.collector.domain.PersonCollectorService;
import br.com.palerique.socialratingcollector.collector.domain.PersonDto;
import br.com.palerique.socialratingcollector.collector.domain.ResponseData;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller responsible for tackling Collector API calls.
 */
@Log4j2
@RestController
@RequiredArgsConstructor
public class CollectorController {

  private final PersonCollectorService service;

  /**
   * Collect the person information.
   *
   * @param person that should be processed/analyzed.
   * @return an useful message.
   * @throws JsonProcessingException if not possible to convert the object to a JSON string.
   */
  @PostMapping("/people")
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseData<Object> collect(@RequestBody PersonDto person)
      throws JsonProcessingException {

    final var response = service.schedule(person);

    return ResponseData.builder()
        .data(response)
        .message("Person successfully scheduled to be processed")
        .build();
  }
}
