package com.github.andrelugomes.cities.resources;

import com.github.andrelugomes.cities.entities.City;
import com.github.andrelugomes.cities.service.DistanceService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/nearby")
public class NearbyResource {

  private static Logger log = LoggerFactory.getLogger(NearbyResource.class);
  private final DistanceService service;

  public NearbyResource(DistanceService service) {
    this.service = service;
  }

  @GetMapping
  public List<City> nearby(@RequestParam(name = "city_id") final Long cityId,
                           @RequestParam(name = "radius") final Double radius) {
    log.info("nearby, city_id={}, radius={}", cityId, radius);
    return service.nearby(cityId, radius);
  }
}
