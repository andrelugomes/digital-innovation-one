package com.github.andrelugomes.countries.resources;

import com.github.andrelugomes.cities.resources.CityResource;
import com.github.andrelugomes.countries.entities.Country;
import com.github.andrelugomes.countries.repositories.CountryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("countries")
public class CountryResource {

  private static Logger log = LoggerFactory.getLogger(CityResource.class);
  private final CountryRepository repository;

  public CountryResource(final CountryRepository repository) {
    this.repository = repository;
  }

  @GetMapping
  public Page<Country> countries(final Pageable page) {
    log.info("countries, {}", page);
    return repository.findAll(page);
  }
}
