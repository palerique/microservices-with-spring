package br.com.palerique.socialratingcalculator.calculator.domain;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.concurrent.atomic.AtomicReference;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class MessageConsumerTest {

  public static final String JSON = "{\"age\": 37, "
      + "\"first_name\": \"Paulo\", \"last_name\": \"Rodrigues\"}";
  public static final int SCORE = 123;

  @Mock
  private ObjectMapper objectMapper;

  @Mock
  private PeopleRepository peopleRepository;

  @Mock
  private SocialRatingScoreService socialRatingScoreService;

  @InjectMocks
  private MessageConsumer consumer;

  @Test
  @SuppressFBWarnings("RV_RETURN_VALUE_IGNORED_NO_SIDE_EFFECT")
  void consume() throws JsonProcessingException {

    final var dto = PersonDto.builder()
        .firstName("Paulo")
        .lastName("Rodrigues")
        .age(37)
        .build();

    when(objectMapper.readValue(JSON, PersonDto.class)).thenReturn(dto);
    when(socialRatingScoreService.getSocialRatingScore(dto)).thenReturn(SCORE);

    final var person = new AtomicReference<Person>();
    when(peopleRepository.save(any(Person.class))).thenAnswer(invocation -> {
      final Person argument = invocation.getArgument(0);
      person.set(argument);
      return argument;
    });

    consumer.consume(JSON);

    verify(objectMapper).readValue(JSON, PersonDto.class);
    verify(socialRatingScoreService).getSocialRatingScore(dto);
    verify(peopleRepository).save(person.get());
  }
}
