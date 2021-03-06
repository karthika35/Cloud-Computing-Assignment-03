package com.ragul.assignment3.service;

import com.ragul.assignment3.model.State;
import com.ragul.assignment3.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StateService {
    @Autowired
    private StateRepository stateRepository;

    public void save(List<State> stateList) {
        stateRepository.saveAll(stateList);
    }

    public State findFirstByAbbreviation(String code) {
        return stateRepository.findFirstByAbbreviation(code);
    }

    public State findFirstByName(String stateName) {
        return stateRepository.findFirstByName(stateName);
    }

    public Iterable<State> findAll() {
        return stateRepository.findAll();
    }
}
