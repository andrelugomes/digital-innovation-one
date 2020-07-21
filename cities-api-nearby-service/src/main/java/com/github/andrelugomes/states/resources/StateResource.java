package com.github.andrelugomes.states.resources;

import com.github.andrelugomes.states.entities.State;
import com.github.andrelugomes.states.repositories.StateRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("states")
public class StateResource {

  private static Logger log = LoggerFactory.getLogger(StateResource.class);
  private final StateRepository repository;

  public StateResource(final StateRepository repository) {
    this.repository = repository;
  }

  @GetMapping
  public Page<State> states(final Pageable page) {
    log.info("states, {}", page);
    return repository.findAll(page);
  }
}
