package com.github.andrelugomes.countries.resources;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CountryResourceTest {

  public static final String URL = "http://localhost:";

  @LocalServerPort
  private int port;

  @Autowired
  private TestRestTemplate restTemplate;

  @Test
  public void shouldReturnCountries() {
    String response = restTemplate.getForObject(URL + port + "/countries", String.class);

    assertThat(response).contains("Brasil");
    assertThat(response).contains("Brazil");
  }
}