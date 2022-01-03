package br.com.palerique.socialratingcalculator.calculator.domain;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SocialRatingScoreServiceTest {

  @InjectMocks
  private SocialRatingScoreService service;

  @SuppressFBWarnings("RV_RETURN_VALUE_IGNORED_NO_SIDE_EFFECT")
  @ParameterizedTest
  @CsvFileSource(resources = "/age-seed.csv", numLinesToSkip = 1)
  void shouldCorrectlyCalculateTheSocialRatingScore(Integer age, Integer seed) {

    final var socialRatingScore = service.getSocialRatingScore(PersonDto.builder()
        .age(age)
        .seed(seed)
        .build());
    Assertions.assertEquals(age * seed, socialRatingScore);
  }
}
