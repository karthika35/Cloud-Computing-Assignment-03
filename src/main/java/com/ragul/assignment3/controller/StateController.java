package com.ragul.assignment3.controller;

import com.ragul.assignment3.model.State;
import com.ragul.assignment3.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/")
public class StateController {
    @Autowired
    StateService stateService;

    @GetMapping(path = "codeToState")
    public ResponseEntity<String> codeToState(@RequestParam String code) {
        State state = stateService.findFirstByAbbreviation(code);

        if (isEmpty(state)) return ResponseEntity.notFound().build();
        return ResponseEntity.ok().body(state.getName());
    }

    @GetMapping(path = "stateToCode")
    public ResponseEntity<String> stateToCode(@RequestParam String state) {
        State stateDb = stateService.findFirstByName(state);

        if (isEmpty(stateDb)) return ResponseEntity.notFound().build();
        return ResponseEntity.ok().body(stateDb.getAbbreviation());
    }

    @GetMapping(path = "/all")
    public ResponseEntity<Iterable<State>> getAll() {
        Iterable<State> dDtate = stateService.findAll();
        return ResponseEntity.ok().body(dDtate);
    }


    private boolean isEmpty(State state) {
        return state == null;
    }
}
