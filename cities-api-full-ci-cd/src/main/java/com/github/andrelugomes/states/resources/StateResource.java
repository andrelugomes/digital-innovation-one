package com.github.andrelugomes.states.resources;

import com.github.andrelugomes.states.entities.State;
import com.github.andrelugomes.states.repositories.StateRepository;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/states")
public class StateResource {

  private final StateRepository repository;

  public StateResource(final StateRepository repository) {
    this.repository = repository;
  }

  @GetMapping
  public List<State> states() {
    return repository.findAll();
  }
}
