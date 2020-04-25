package com.github.andrelugomes.cities.repositories;

import com.github.andrelugomes.cities.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {
}
