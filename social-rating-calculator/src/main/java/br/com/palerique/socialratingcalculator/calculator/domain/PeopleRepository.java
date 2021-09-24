package br.com.palerique.socialratingcalculator.calculator.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository of People domain entities.
 */
@Repository
public interface PeopleRepository extends CrudRepository<Person, String> {

}
