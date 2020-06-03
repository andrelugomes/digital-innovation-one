package com.github.andrelugomes.cities.service;

import static java.lang.Math.atan2;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static java.lang.Math.sqrt;
import static java.lang.Math.toRadians;


import com.github.andrelugomes.cities.entities.City;
import com.github.andrelugomes.cities.repositories.CityRepository;
import com.github.andrelugomes.utils.StringLocationUtils;
import java.util.Arrays;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;

@Service
public class DistanceService {

  private final CityRepository cityRepository;
  Logger log = LoggerFactory.getLogger(DistanceService.class);

  public DistanceService(final CityRepository cityRepository) {
    this.cityRepository = cityRepository;
  }

  /**
   * 1st option
   *
   * @param city1
   * @param city2
   * @param unit
   * @return
   */
  public Double distanceUsingMath(final Long city1, final Long city2, final EarthRadius unit) {
    log.info("distanceUsingMath({}, {}, {})", city1, city2, unit);
    final List<City> cities = cityRepository.findAllById((Arrays.asList(city1, city2)));

    final Double[] location1 = StringLocationUtils.transform(cities.get(0).getGeolocation());
    final Double[] location2 = StringLocationUtils.transform(cities.get(1).getGeolocation());

    return doCalculation(location1[0], location1[1], location2[0], location2[1], unit);
  }

  /**
   * 2nd option
   *
   * @param city1
   * @param city2
   * @return
   */
  public Double distanceByPointsInMiles(final Long city1, final Long city2) {
    log.info("nativePostgresInMiles({}, {})", city1, city2);
    return cityRepository.distanceByPoints(city1, city2);
  }

  /**
   * 3rd option
   *
   * @param city1
   * @param city2
   * @param unit
   * @return
   */
  public Double distanceUsingPoints(final Long city1, final Long city2, final EarthRadius unit) {
    log.info("distanceUsingPoints({}, {}, {})", city1, city2, unit);
    final List<City> cities = cityRepository.findAllById((Arrays.asList(city1, city2)));

    Point p1 = cities.get(0).getLocation();
    Point p2 = cities.get(1).getLocation();

    return doCalculation(p1.getX(), p1.getY(), p2.getX(), p2.getY(), unit);
  }

  /**
   * 4th option
   *
   * @param city1
   * @param city2
   * @return
   */
  public Double distanceByCubeInMeters(Long city1, Long city2) {
    log.info("distanceByCubeInMeters({}, {})", city1, city2);
    final List<City> cities = cityRepository.findAllById((Arrays.asList(city1, city2)));

    Point p1 = cities.get(0).getLocation();
    Point p2 = cities.get(1).getLocation();

    return cityRepository.distanceByCube(p1.getX(), p1.getY(), p2.getX(), p2.getY());
  }

  private double doCalculation(final double lat1, final double lon1, final double lat2,
                               final double lng2, final EarthRadius earthRadius) {
    double lat = toRadians(lat2 - lat1);
    double lon = toRadians(lng2 - lon1);
    double a = sin(lat / 2) * sin(lat / 2) +
        cos(toRadians(lat1)) * cos(toRadians(lat2)) * sin(lon / 2) * sin(lon / 2);
    double c = 2 * atan2(sqrt(a), sqrt(1 - a));

    return earthRadius.getValue() * c;
  }
}
