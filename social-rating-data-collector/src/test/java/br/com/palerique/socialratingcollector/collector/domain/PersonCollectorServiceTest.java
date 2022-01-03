package br.com.palerique.socialratingcollector.collector.domain;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import br.com.palerique.socialratingcollector.collector.infra.AppProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PersonCollectorServiceTest {

  public static final String JSON = "{}";
  public static final int BASE_SEED = 1;

  @Mock
  private MessageProducer messageProducer;

  @Mock
  private ObjectMapper objectMapper;

  @Mock
  private AppProperties appProperties;

  @InjectMocks
  private PersonCollectorService service;

  @Test
  @SuppressFBWarnings("RV_RETURN_VALUE_IGNORED_NO_SIDE_EFFECT")
  void schedule() throws JsonProcessingException {

    final var dto = PersonDto.builder().build();
    final var dtoWithSeed = dto.toBuilder().seed(BASE_SEED).build();

    when(objectMapper.writeValueAsString(dtoWithSeed)).thenReturn(JSON);
    when(appProperties.getBaseSeed()).thenReturn(BASE_SEED);

    final var result = service.schedule(dto);

    assertThat(result.getSeed(), is(equalTo(BASE_SEED)));
    verify(appProperties).getBaseSeed();
    verify(objectMapper).writeValueAsString(dtoWithSeed);
    verify(messageProducer).sendMessage(JSON);
  }
}
