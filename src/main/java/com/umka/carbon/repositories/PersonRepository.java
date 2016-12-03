package com.umka.carbon.repositories;

import com.umka.carbon.model.Person;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by YSkakun on 12/3/2016.
 */
public interface PersonRepository extends CrudRepository<Person, Long> {
}
