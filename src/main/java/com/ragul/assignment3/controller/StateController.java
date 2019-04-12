package com.ragul.assignment3.controller;

import com.ragul.assignment3.model.State;
import com.ragul.assignment3.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/")
public class StateController {
    @Autowired
    StateRepository stateRepository;

    @GetMapping(path = "codeToState")
    public ResponseEntity<State> codeToState(@RequestParam String code) {
        State state = stateRepository.findFirstByAbbreviation(code);

        if (isEmpty(state)) return ResponseEntity.notFound().build();
        return ResponseEntity.ok().body(state);
    }

    @GetMapping(path = "stateToCode")
    public ResponseEntity<State> stateToCode(@RequestParam String state) {
        State dDtate = stateRepository.findFirstByName(state);

        if (isEmpty(dDtate)) return ResponseEntity.notFound().build();
        return ResponseEntity.ok().body(dDtate);
    }

    @GetMapping(path = "/")
    public ResponseEntity<Iterable<State>> getAll() {
        Iterable<State> dDtate = stateRepository.findAll();
        return ResponseEntity.ok().body(dDtate);
    }


    private boolean isEmpty(State state) {
        return state == null;
    }
}
