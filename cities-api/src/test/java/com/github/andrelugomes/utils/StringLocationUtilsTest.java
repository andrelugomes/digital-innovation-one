package com.github.andrelugomes.utils;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

class StringLocationUtilsTest {

  @Test
  public void shouldExtractGeoLocationsFormString() {
    String geoLocation = "(123, 321)";

    Double[] transform = StringLocationUtils.transform(geoLocation);

    assertEquals(123.0, transform[0], "Not equal");
    assertEquals(321, transform[1], "Not equal");
  }
}
