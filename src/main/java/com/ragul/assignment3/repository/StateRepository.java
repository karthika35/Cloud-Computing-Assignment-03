package com.ragul.assignment3.repository;

import com.ragul.assignment3.model.State;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository extends CrudRepository<State, Long> {
    State findFirstByName(String state);

    State findFirstByAbbreviation(String code);
}