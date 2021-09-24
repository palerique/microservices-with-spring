package br.com.palerique.socialratingcalculator.calculator.domain;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

/**
 * Service responsible to calculate the Social Rating Score.
 */
@Log4j2
@Service
public class SocialRatingScoreService {

  public int getSocialRatingScore(PersonDto person) {
    return person.getSeed() * person.getAge();
  }
}
