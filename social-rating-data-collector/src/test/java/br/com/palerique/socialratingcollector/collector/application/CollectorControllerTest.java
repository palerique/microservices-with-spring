package br.com.palerique.socialratingcollector.collector.application;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import br.com.palerique.socialratingcollector.collector.domain.PersonCollectorService;
import br.com.palerique.socialratingcollector.collector.domain.PersonDto;
import br.com.palerique.socialratingcollector.collector.domain.ResponseData;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CollectorControllerTest {

  @Mock
  private PersonCollectorService service;

  @InjectMocks
  private CollectorController controller;

  @Test
  void collect() throws JsonProcessingException {
    PersonDto person = PersonDto.builder()
        .firstName("Paulo")
        .lastName("Rodrigues")
        .age(37)
        .build();

    PersonDto personDtoWithSeed = person.toBuilder().seed(1).build();
    when(service.schedule(person)).thenReturn(personDtoWithSeed);
    ResponseData<Object> responseData = controller.collect(person);

    assertThat(responseData.getData(), is(equalTo(personDtoWithSeed)));
    assertThat(responseData.getMessage(),
        is(equalTo("Person successfully scheduled to be processed")));
    verify(service).schedule(person);
  }
}
