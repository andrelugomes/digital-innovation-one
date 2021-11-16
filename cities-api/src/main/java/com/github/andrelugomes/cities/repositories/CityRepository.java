package com.github.andrelugomes.cities.repositories;

import com.github.andrelugomes.cities.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CityRepository extends JpaRepository<City, Long> {

  @Query(value = "SELECT ((SELECT lat_lon FROM cidade WHERE id=?1) <@> (SELECT lat_lon FROM cidade WHERE id=?2)) as distance", nativeQuery = true)
  Double distanceByPoints(final Long cityId1, final Long cityId2);

  @Query(value = "SELECT earth_distance(ll_to_earth(?1,?2), ll_to_earth(?3,?4)) as distance", nativeQuery = true)
  Double distanceByCube(final Double lat1, final Double lon1, final Double lat2, final Double lon2);

  @Query(value = "select distinct c2.id, c2.nome, (c1.lat_lon <@> c2.lat_lon) as di\n" +
          "from public.cidade c1 \n" +
          "\tinner join public.cidade c2\n" +
          "\t\ton (c1.lat_lon <@> c2.lat_lon) < :raioDistancia\n" +
          "where c1.nome ilike :nomeCidadeFrom ;", nativeQuery = true)
  List<Object> retornaListaCidades_RaioDistancia_ByPoint(String nomeCidadeFrom, double raioDistancia);




}
